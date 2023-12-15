package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Predicate;

public final class NullIsTruePredicate<T> implements PredicateDecorator<T>, Serializable {
    private static final long serialVersionUID = -7625133768987126273L;
    private final Predicate<? super T> iPredicate;

    public static <T> Predicate<T> nullIsTruePredicate(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "Predicate must not be null");
        return new NullIsTruePredicate(predicate);
    }

    public NullIsTruePredicate(Predicate<? super T> predicate) {
        this.iPredicate = predicate;
    }

    public boolean evaluate(T t) {
        if (t == null) {
            return true;
        }
        return this.iPredicate.evaluate(t);
    }

    public Predicate<? super T>[] getPredicates() {
        return new Predicate[]{this.iPredicate};
    }
}
