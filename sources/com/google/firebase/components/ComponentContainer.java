package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Set;

public interface ComponentContainer {
    <T> T get(Qualified<T> qualified);

    <T> T get(Class<T> cls);

    <T> Deferred<T> getDeferred(Qualified<T> qualified);

    <T> Deferred<T> getDeferred(Class<T> cls);

    <T> Provider<T> getProvider(Qualified<T> qualified);

    <T> Provider<T> getProvider(Class<T> cls);

    <T> Set<T> setOf(Qualified<T> qualified);

    <T> Set<T> setOf(Class<T> cls);

    <T> Provider<Set<T>> setOfProvider(Qualified<T> qualified);

    <T> Provider<Set<T>> setOfProvider(Class<T> cls);

    /* renamed from: com.google.firebase.components.ComponentContainer$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static <T> Object $default$get(ComponentContainer _this, Class cls) {
            return _this.get(Qualified.unqualified(cls));
        }

        public static <T> Provider $default$getProvider(ComponentContainer _this, Class cls) {
            return _this.getProvider(Qualified.unqualified(cls));
        }

        public static <T> Deferred $default$getDeferred(ComponentContainer _this, Class cls) {
            return _this.getDeferred(Qualified.unqualified(cls));
        }

        public static <T> Set $default$setOf(ComponentContainer _this, Class cls) {
            return _this.setOf(Qualified.unqualified(cls));
        }

        public static <T> Provider $default$setOfProvider(ComponentContainer _this, Class cls) {
            return _this.setOfProvider(Qualified.unqualified(cls));
        }

        public static <T> Object $default$get(ComponentContainer _this, Qualified qualified) {
            Provider provider = _this.getProvider(qualified);
            if (provider == null) {
                return null;
            }
            return provider.get();
        }

        public static <T> Set $default$setOf(ComponentContainer _this, Qualified qualified) {
            return (Set) _this.setOfProvider(qualified).get();
        }
    }
}
