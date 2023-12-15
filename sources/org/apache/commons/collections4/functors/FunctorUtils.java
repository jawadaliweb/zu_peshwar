package org.apache.commons.collections4.functors;

import java.util.Collection;
import java.util.Objects;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

class FunctorUtils {
    static <T> Closure<T> coerce(Closure<? super T> closure) {
        return closure;
    }

    static <T> Predicate<T> coerce(Predicate<? super T> predicate) {
        return predicate;
    }

    static <I, O> Transformer<I, O> coerce(Transformer<? super I, ? extends O> transformer) {
        return transformer;
    }

    private FunctorUtils() {
    }

    static <T> Predicate<T>[] copy(Predicate<? super T>... predicateArr) {
        if (predicateArr == null) {
            return null;
        }
        return (Predicate[]) predicateArr.clone();
    }

    static void validate(Predicate<?>... predicateArr) {
        Objects.requireNonNull(predicateArr, "The predicate array must not be null");
        int i = 0;
        while (i < predicateArr.length) {
            if (predicateArr[i] != null) {
                i++;
            } else {
                throw new NullPointerException("The predicate array must not contain a null predicate, index " + i + " was null");
            }
        }
    }

    static <T> Predicate<? super T>[] validate(Collection<? extends Predicate<? super T>> collection) {
        Objects.requireNonNull(collection, "The predicate collection must not be null");
        Predicate<? super T>[] predicateArr = new Predicate[collection.size()];
        int i = 0;
        for (Predicate<? super T> predicate : collection) {
            predicateArr[i] = predicate;
            if (predicateArr[i] != null) {
                i++;
            } else {
                throw new NullPointerException("The predicate collection must not contain a null predicate, index " + i + " was null");
            }
        }
        return predicateArr;
    }

    static <E> Closure<E>[] copy(Closure<? super E>... closureArr) {
        if (closureArr == null) {
            return null;
        }
        return (Closure[]) closureArr.clone();
    }

    static void validate(Closure<?>... closureArr) {
        Objects.requireNonNull(closureArr, "The closure array must not be null");
        int i = 0;
        while (i < closureArr.length) {
            if (closureArr[i] != null) {
                i++;
            } else {
                throw new NullPointerException("The closure array must not contain a null closure, index " + i + " was null");
            }
        }
    }

    static <I, O> Transformer<I, O>[] copy(Transformer<? super I, ? extends O>... transformerArr) {
        if (transformerArr == null) {
            return null;
        }
        return (Transformer[]) transformerArr.clone();
    }

    static void validate(Transformer<?, ?>... transformerArr) {
        Objects.requireNonNull(transformerArr, "The transformer array must not be null");
        int i = 0;
        while (i < transformerArr.length) {
            if (transformerArr[i] != null) {
                i++;
            } else {
                throw new NullPointerException("The transformer array must not contain a null transformer, index " + i + " was null");
            }
        }
    }
}
