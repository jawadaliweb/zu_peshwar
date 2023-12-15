package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import java.util.Objects;

public abstract class AbstractUntypedIteratorDecorator<I, O> implements Iterator<O> {
    private final Iterator<I> iterator;

    protected AbstractUntypedIteratorDecorator(Iterator<I> it) {
        Objects.requireNonNull(it, "Iterator must not be null");
        this.iterator = it;
    }

    /* access modifiers changed from: protected */
    public Iterator<I> getIterator() {
        return this.iterator;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public void remove() {
        this.iterator.remove();
    }
}
