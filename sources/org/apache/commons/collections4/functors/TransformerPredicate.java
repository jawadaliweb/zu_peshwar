package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

public final class TransformerPredicate<T> implements Predicate<T>, Serializable {
    private static final long serialVersionUID = -2407966402920578741L;
    private final Transformer<? super T, Boolean> iTransformer;

    public static <T> Predicate<T> transformerPredicate(Transformer<? super T, Boolean> transformer) {
        Objects.requireNonNull(transformer, "The transformer to call must not be null");
        return new TransformerPredicate(transformer);
    }

    public TransformerPredicate(Transformer<? super T, Boolean> transformer) {
        this.iTransformer = transformer;
    }

    public boolean evaluate(T t) {
        Boolean transform = this.iTransformer.transform(t);
        if (transform != null) {
            return transform.booleanValue();
        }
        throw new FunctorException("Transformer must return an instanceof Boolean, it was a null object");
    }

    public Transformer<? super T, Boolean> getTransformer() {
        return this.iTransformer;
    }
}
