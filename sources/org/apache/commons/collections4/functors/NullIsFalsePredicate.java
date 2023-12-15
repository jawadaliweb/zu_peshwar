package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Predicate;

public final class NullIsFalsePredicate<T> implements PredicateDecorator<T>, Serializable {
    private static final long serialVersionUID = -2997501534564735525L;
    private final Predicate<? super T> iPredicate;

    public static <T> Predicate<T> nullIsFalsePredicate(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "Predicate must not be null");
        return new NullIsFalsePredicate(predicate);
    }

    public NullIsFalsePredicate(Predicate<? super T> predicate) {
        this.iPredicate = predicate;
    }

    public boolean evaluate(T t) {
        if (t == null) {
            return false;
        }
        return this.iPredicate.evaluate(t);
    }

    public Predicate<? super T>[] getPredicates() {
        return new Predicate[]{this.iPredicate};
    }
}
