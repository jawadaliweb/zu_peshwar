package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

public abstract class AbstractQuantifierPredicate<T> implements PredicateDecorator<T>, Serializable {
    private static final long serialVersionUID = -3094696765038308799L;
    protected final Predicate<? super T>[] iPredicates;

    public AbstractQuantifierPredicate(Predicate<? super T>... predicateArr) {
        this.iPredicates = predicateArr;
    }

    public Predicate<? super T>[] getPredicates() {
        return FunctorUtils.copy(this.iPredicates);
    }
}
