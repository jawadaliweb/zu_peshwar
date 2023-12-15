package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.FactoryTransformer;

public class LazyMap<K, V> extends AbstractMapDecorator<K, V> implements Serializable {
    private static final long serialVersionUID = 7990956402564206740L;
    protected final Transformer<? super K, ? extends V> factory;

    public static <K, V> LazyMap<K, V> lazyMap(Map<K, V> map, Factory<? extends V> factory2) {
        return new LazyMap<>(map, factory2);
    }

    public static <V, K> LazyMap<K, V> lazyMap(Map<K, V> map, Transformer<? super K, ? extends V> transformer) {
        return new LazyMap<>(map, transformer);
    }

    protected LazyMap(Map<K, V> map, Factory<? extends V> factory2) {
        super(map);
        Objects.requireNonNull(factory2, "Factory must not be null");
        this.factory = FactoryTransformer.factoryTransformer(factory2);
    }

    protected LazyMap(Map<K, V> map, Transformer<? super K, ? extends V> transformer) {
        super(map);
        Objects.requireNonNull(transformer, "Factory must not be null");
        this.factory = transformer;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    public V get(Object obj) {
        if (this.map.containsKey(obj)) {
            return this.map.get(obj);
        }
        V transform = this.factory.transform(obj);
        this.map.put(obj, transform);
        return transform;
    }
}
