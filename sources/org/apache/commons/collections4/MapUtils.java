package org.apache.commons.collections4;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.ortiz.touchview.BuildConfig;
import java.io.PrintStream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.collections4.map.AbstractMapDecorator;
import org.apache.commons.collections4.map.AbstractSortedMapDecorator;
import org.apache.commons.collections4.map.FixedSizeMap;
import org.apache.commons.collections4.map.FixedSizeSortedMap;
import org.apache.commons.collections4.map.LazyMap;
import org.apache.commons.collections4.map.LazySortedMap;
import org.apache.commons.collections4.map.ListOrderedMap;
import org.apache.commons.collections4.map.MultiValueMap;
import org.apache.commons.collections4.map.PredicatedMap;
import org.apache.commons.collections4.map.PredicatedSortedMap;
import org.apache.commons.collections4.map.TransformedMap;
import org.apache.commons.collections4.map.TransformedSortedMap;
import org.apache.commons.collections4.map.UnmodifiableMap;
import org.apache.commons.collections4.map.UnmodifiableSortedMap;

public class MapUtils {
    public static final SortedMap EMPTY_SORTED_MAP = UnmodifiableSortedMap.unmodifiableSortedMap(new TreeMap());
    private static final String INDENT_STRING = "    ";

    private MapUtils() {
    }

    public static <K, V> V getObject(Map<? super K, V> map, K k) {
        if (map != null) {
            return map.get(k);
        }
        return null;
    }

    public static <K> String getString(Map<? super K, ?> map, K k) {
        Object obj;
        if (map == null || (obj = map.get(k)) == null) {
            return null;
        }
        return obj.toString();
    }

    public static <K> Boolean getBoolean(Map<? super K, ?> map, K k) {
        Object obj;
        if (map == null || (obj = map.get(k)) == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            return Boolean.valueOf((String) obj);
        }
        if (obj instanceof Number) {
            return ((Number) obj).intValue() != 0 ? Boolean.TRUE : Boolean.FALSE;
        }
        return null;
    }

    public static <K> Number getNumber(Map<? super K, ?> map, K k) {
        Object obj;
        if (map == null || (obj = map.get(k)) == null) {
            return null;
        }
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (!(obj instanceof String)) {
            return null;
        }
        try {
            return NumberFormat.getInstance().parse((String) obj);
        } catch (ParseException unused) {
            return null;
        }
    }

    public static <K> Byte getByte(Map<? super K, ?> map, K k) {
        Number number = getNumber(map, k);
        if (number == null) {
            return null;
        }
        if (number instanceof Byte) {
            return (Byte) number;
        }
        return Byte.valueOf(number.byteValue());
    }

    public static <K> Short getShort(Map<? super K, ?> map, K k) {
        Number number = getNumber(map, k);
        if (number == null) {
            return null;
        }
        if (number instanceof Short) {
            return (Short) number;
        }
        return Short.valueOf(number.shortValue());
    }

    public static <K> Integer getInteger(Map<? super K, ?> map, K k) {
        Number number = getNumber(map, k);
        if (number == null) {
            return null;
        }
        if (number instanceof Integer) {
            return (Integer) number;
        }
        return Integer.valueOf(number.intValue());
    }

    public static <K> Long getLong(Map<? super K, ?> map, K k) {
        Number number = getNumber(map, k);
        if (number == null) {
            return null;
        }
        if (number instanceof Long) {
            return (Long) number;
        }
        return Long.valueOf(number.longValue());
    }

    public static <K> Float getFloat(Map<? super K, ?> map, K k) {
        Number number = getNumber(map, k);
        if (number == null) {
            return null;
        }
        if (number instanceof Float) {
            return (Float) number;
        }
        return Float.valueOf(number.floatValue());
    }

    public static <K> Double getDouble(Map<? super K, ?> map, K k) {
        Number number = getNumber(map, k);
        if (number == null) {
            return null;
        }
        if (number instanceof Double) {
            return (Double) number;
        }
        return Double.valueOf(number.doubleValue());
    }

    public static <K> Map<?, ?> getMap(Map<? super K, ?> map, K k) {
        Object obj;
        if (map == null || (obj = map.get(k)) == null || !(obj instanceof Map)) {
            return null;
        }
        return (Map) obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r0.get(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <K, V> V getObject(java.util.Map<K, V> r0, K r1, V r2) {
        /*
            if (r0 == 0) goto L_0x0009
            java.lang.Object r0 = r0.get(r1)
            if (r0 == 0) goto L_0x0009
            return r0
        L_0x0009:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections4.MapUtils.getObject(java.util.Map, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public static <K> String getString(Map<? super K, ?> map, K k, String str) {
        String string = getString(map, k);
        return string == null ? str : string;
    }

    public static <K> Boolean getBoolean(Map<? super K, ?> map, K k, Boolean bool) {
        Boolean bool2 = getBoolean(map, k);
        return bool2 == null ? bool : bool2;
    }

    public static <K> Number getNumber(Map<? super K, ?> map, K k, Number number) {
        Number number2 = getNumber(map, k);
        return number2 == null ? number : number2;
    }

    public static <K> Byte getByte(Map<? super K, ?> map, K k, Byte b) {
        Byte b2 = getByte(map, k);
        return b2 == null ? b : b2;
    }

    public static <K> Short getShort(Map<? super K, ?> map, K k, Short sh) {
        Short sh2 = getShort(map, k);
        return sh2 == null ? sh : sh2;
    }

    public static <K> Integer getInteger(Map<? super K, ?> map, K k, Integer num) {
        Integer integer = getInteger(map, k);
        return integer == null ? num : integer;
    }

    public static <K> Long getLong(Map<? super K, ?> map, K k, Long l) {
        Long l2 = getLong(map, k);
        return l2 == null ? l : l2;
    }

    public static <K> Float getFloat(Map<? super K, ?> map, K k, Float f) {
        Float f2 = getFloat(map, k);
        return f2 == null ? f : f2;
    }

    public static <K> Double getDouble(Map<? super K, ?> map, K k, Double d) {
        Double d2 = getDouble(map, k);
        return d2 == null ? d : d2;
    }

    public static <K> Map<?, ?> getMap(Map<? super K, ?> map, K k, Map<?, ?> map2) {
        Map<?, ?> map3 = getMap(map, k);
        return map3 == null ? map2 : map3;
    }

    public static <K> boolean getBooleanValue(Map<? super K, ?> map, K k) {
        return Boolean.TRUE.equals(getBoolean(map, k));
    }

    public static <K> byte getByteValue(Map<? super K, ?> map, K k) {
        Byte b = getByte(map, k);
        if (b == null) {
            return 0;
        }
        return b.byteValue();
    }

    public static <K> short getShortValue(Map<? super K, ?> map, K k) {
        Short sh = getShort(map, k);
        if (sh == null) {
            return 0;
        }
        return sh.shortValue();
    }

    public static <K> int getIntValue(Map<? super K, ?> map, K k) {
        Integer integer = getInteger(map, k);
        if (integer == null) {
            return 0;
        }
        return integer.intValue();
    }

    public static <K> long getLongValue(Map<? super K, ?> map, K k) {
        Long l = getLong(map, k);
        if (l == null) {
            return 0;
        }
        return l.longValue();
    }

    public static <K> float getFloatValue(Map<? super K, ?> map, K k) {
        Float f = getFloat(map, k);
        if (f == null) {
            return 0.0f;
        }
        return f.floatValue();
    }

    public static <K> double getDoubleValue(Map<? super K, ?> map, K k) {
        Double d = getDouble(map, k);
        if (d == null) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        return d.doubleValue();
    }

    public static <K> boolean getBooleanValue(Map<? super K, ?> map, K k, boolean z) {
        Boolean bool = getBoolean(map, k);
        if (bool == null) {
            return z;
        }
        return bool.booleanValue();
    }

    public static <K> byte getByteValue(Map<? super K, ?> map, K k, byte b) {
        Byte b2 = getByte(map, k);
        if (b2 == null) {
            return b;
        }
        return b2.byteValue();
    }

    public static <K> short getShortValue(Map<? super K, ?> map, K k, short s) {
        Short sh = getShort(map, k);
        if (sh == null) {
            return s;
        }
        return sh.shortValue();
    }

    public static <K> int getIntValue(Map<? super K, ?> map, K k, int i) {
        Integer integer = getInteger(map, k);
        if (integer == null) {
            return i;
        }
        return integer.intValue();
    }

    public static <K> long getLongValue(Map<? super K, ?> map, K k, long j) {
        Long l = getLong(map, k);
        if (l == null) {
            return j;
        }
        return l.longValue();
    }

    public static <K> float getFloatValue(Map<? super K, ?> map, K k, float f) {
        Float f2 = getFloat(map, k);
        if (f2 == null) {
            return f;
        }
        return f2.floatValue();
    }

    public static <K> double getDoubleValue(Map<? super K, ?> map, K k, double d) {
        Double d2 = getDouble(map, k);
        if (d2 == null) {
            return d;
        }
        return d2.doubleValue();
    }

    public static <K, V> Properties toProperties(Map<K, V> map) {
        Properties properties = new Properties();
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                properties.put(next.getKey(), next.getValue());
            }
        }
        return properties;
    }

    public static Map<String, Object> toMap(ResourceBundle resourceBundle) {
        Enumeration<String> keys = resourceBundle.getKeys();
        HashMap hashMap = new HashMap();
        while (keys.hasMoreElements()) {
            String nextElement = keys.nextElement();
            hashMap.put(nextElement, resourceBundle.getObject(nextElement));
        }
        return hashMap;
    }

    public static void verbosePrint(PrintStream printStream, Object obj, Map<?, ?> map) {
        verbosePrintInternal(printStream, obj, map, new ArrayDeque(), false);
    }

    public static void debugPrint(PrintStream printStream, Object obj, Map<?, ?> map) {
        verbosePrintInternal(printStream, obj, map, new ArrayDeque(), true);
    }

    private static void verbosePrintInternal(PrintStream printStream, Object obj, Map<?, ?> map, Deque<Map<?, ?>> deque, boolean z) {
        String str;
        printIndent(printStream, deque.size());
        if (map == null) {
            if (obj != null) {
                printStream.print(obj);
                printStream.print(" = ");
            }
            printStream.println(BuildConfig.VERSION);
            return;
        }
        if (obj != null) {
            printStream.print(obj);
            printStream.println(" = ");
        }
        printIndent(printStream, deque.size());
        printStream.println("{");
        deque.addLast(map);
        for (Map.Entry next : map.entrySet()) {
            Object key = next.getKey();
            Object value = next.getValue();
            if (!(value instanceof Map) || deque.contains(value)) {
                printIndent(printStream, deque.size());
                printStream.print(key);
                printStream.print(" = ");
                int indexOf = IterableUtils.indexOf(deque, PredicateUtils.equalPredicate(value));
                if (indexOf == -1) {
                    printStream.print(value);
                } else if (deque.size() - 1 == indexOf) {
                    printStream.print("(this Map)");
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("(ancestor[");
                    sb.append(((deque.size() - 1) - indexOf) - 1);
                    sb.append("] Map)");
                    printStream.print(sb.toString());
                }
                if (!z || value == null) {
                    printStream.println();
                } else {
                    printStream.print(' ');
                    printStream.println(value.getClass().getName());
                }
            } else {
                if (key == null) {
                    key = BuildConfig.VERSION;
                }
                verbosePrintInternal(printStream, key, (Map) value, deque, z);
            }
        }
        deque.removeLast();
        printIndent(printStream, deque.size());
        if (z) {
            str = "} " + map.getClass().getName();
        } else {
            str = "}";
        }
        printStream.println(str);
    }

    private static void printIndent(PrintStream printStream, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            printStream.print(INDENT_STRING);
        }
    }

    public static <K, V> Map<V, K> invertMap(Map<K, V> map) {
        HashMap hashMap = new HashMap(map.size());
        for (Map.Entry next : map.entrySet()) {
            hashMap.put(next.getValue(), next.getKey());
        }
        return hashMap;
    }

    public static <K> void safeAddToMap(Map<? super K, Object> map, K k, Object obj) throws NullPointerException {
        if (obj == null) {
            obj = "";
        }
        map.put(k, obj);
    }

    public static <K, V> Map<K, V> putAll(Map<K, V> map, Object[] objArr) {
        Objects.requireNonNull(map, "The map must not be null");
        if (!(objArr == null || objArr.length == 0)) {
            int i = 0;
            Object obj = objArr[0];
            if (obj instanceof Map.Entry) {
                int length = objArr.length;
                while (i < length) {
                    Map.Entry entry = objArr[i];
                    map.put(entry.getKey(), entry.getValue());
                    i++;
                }
            } else if (obj instanceof KeyValue) {
                int length2 = objArr.length;
                while (i < length2) {
                    KeyValue keyValue = objArr[i];
                    map.put(keyValue.getKey(), keyValue.getValue());
                    i++;
                }
            } else if (obj instanceof Object[]) {
                for (int i2 = 0; i2 < objArr.length; i2++) {
                    Object[] objArr2 = objArr[i2];
                    if (objArr2 == null || objArr2.length < 2) {
                        throw new IllegalArgumentException("Invalid array element: " + i2);
                    }
                    map.put(objArr2[0], objArr2[1]);
                }
            } else {
                while (i < objArr.length - 1) {
                    int i3 = i + 1;
                    map.put(objArr[i], objArr[i3]);
                    i = i3 + 1;
                }
            }
        }
        return map;
    }

    public static <K, V> Map<K, V> emptyIfNull(Map<K, V> map) {
        return map == null ? Collections.emptyMap() : map;
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    public static <K, V> Map<K, V> synchronizedMap(Map<K, V> map) {
        return Collections.synchronizedMap(map);
    }

    public static <K, V> Map<K, V> unmodifiableMap(Map<? extends K, ? extends V> map) {
        return UnmodifiableMap.unmodifiableMap(map);
    }

    public static <K, V> IterableMap<K, V> predicatedMap(Map<K, V> map, Predicate<? super K> predicate, Predicate<? super V> predicate2) {
        return PredicatedMap.predicatedMap(map, predicate, predicate2);
    }

    public static <K, V> IterableMap<K, V> transformedMap(Map<K, V> map, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        return TransformedMap.transformingMap(map, transformer, transformer2);
    }

    public static <K, V> IterableMap<K, V> fixedSizeMap(Map<K, V> map) {
        return FixedSizeMap.fixedSizeMap(map);
    }

    public static <K, V> IterableMap<K, V> lazyMap(Map<K, V> map, Factory<? extends V> factory) {
        return LazyMap.lazyMap(map, factory);
    }

    public static <K, V> IterableMap<K, V> lazyMap(Map<K, V> map, Transformer<? super K, ? extends V> transformer) {
        return LazyMap.lazyMap(map, transformer);
    }

    public static <K, V> OrderedMap<K, V> orderedMap(Map<K, V> map) {
        return ListOrderedMap.listOrderedMap(map);
    }

    @Deprecated
    public static <K, V> MultiValueMap<K, V> multiValueMap(Map<K, ? super Collection<V>> map) {
        return MultiValueMap.multiValueMap(map);
    }

    @Deprecated
    public static <K, V, C extends Collection<V>> MultiValueMap<K, V> multiValueMap(Map<K, C> map, Class<C> cls) {
        return MultiValueMap.multiValueMap(map, cls);
    }

    @Deprecated
    public static <K, V, C extends Collection<V>> MultiValueMap<K, V> multiValueMap(Map<K, C> map, Factory<C> factory) {
        return MultiValueMap.multiValueMap(map, factory);
    }

    public static <K, V> SortedMap<K, V> synchronizedSortedMap(SortedMap<K, V> sortedMap) {
        return Collections.synchronizedSortedMap(sortedMap);
    }

    public static <K, V> SortedMap<K, V> unmodifiableSortedMap(SortedMap<K, ? extends V> sortedMap) {
        return UnmodifiableSortedMap.unmodifiableSortedMap(sortedMap);
    }

    public static <K, V> SortedMap<K, V> predicatedSortedMap(SortedMap<K, V> sortedMap, Predicate<? super K> predicate, Predicate<? super V> predicate2) {
        return PredicatedSortedMap.predicatedSortedMap(sortedMap, predicate, predicate2);
    }

    public static <K, V> SortedMap<K, V> transformedSortedMap(SortedMap<K, V> sortedMap, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        return TransformedSortedMap.transformingSortedMap(sortedMap, transformer, transformer2);
    }

    public static <K, V> SortedMap<K, V> fixedSizeSortedMap(SortedMap<K, V> sortedMap) {
        return FixedSizeSortedMap.fixedSizeSortedMap(sortedMap);
    }

    public static <K, V> SortedMap<K, V> lazySortedMap(SortedMap<K, V> sortedMap, Factory<? extends V> factory) {
        return LazySortedMap.lazySortedMap(sortedMap, factory);
    }

    public static <K, V> SortedMap<K, V> lazySortedMap(SortedMap<K, V> sortedMap, Transformer<? super K, ? extends V> transformer) {
        return LazySortedMap.lazySortedMap(sortedMap, transformer);
    }

    public static <K, V> void populateMap(Map<K, V> map, Iterable<? extends V> iterable, Transformer<V, K> transformer) {
        populateMap(map, iterable, transformer, TransformerUtils.nopTransformer());
    }

    public static <K, V, E> void populateMap(Map<K, V> map, Iterable<? extends E> iterable, Transformer<E, K> transformer, Transformer<E, V> transformer2) {
        for (Object next : iterable) {
            map.put(transformer.transform(next), transformer2.transform(next));
        }
    }

    public static <K, V> void populateMap(MultiMap<K, V> multiMap, Iterable<? extends V> iterable, Transformer<V, K> transformer) {
        populateMap(multiMap, iterable, transformer, TransformerUtils.nopTransformer());
    }

    public static <K, V, E> void populateMap(MultiMap<K, V> multiMap, Iterable<? extends E> iterable, Transformer<E, K> transformer, Transformer<E, V> transformer2) {
        for (Object next : iterable) {
            multiMap.put(transformer.transform(next), transformer2.transform(next));
        }
    }

    public static <K, V> IterableMap<K, V> iterableMap(Map<K, V> map) {
        Objects.requireNonNull(map, "Map must not be null");
        return map instanceof IterableMap ? (IterableMap) map : new AbstractMapDecorator<K, V>(map) {
        };
    }

    public static <K, V> IterableSortedMap<K, V> iterableSortedMap(SortedMap<K, V> sortedMap) {
        Objects.requireNonNull(sortedMap, "Map must not be null");
        return sortedMap instanceof IterableSortedMap ? (IterableSortedMap) sortedMap : new AbstractSortedMapDecorator<K, V>(sortedMap) {
        };
    }

    public static int size(Map<?, ?> map) {
        if (map == null) {
            return 0;
        }
        return map.size();
    }
}
