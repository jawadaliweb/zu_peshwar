package org.apache.commons.collections4.iterators;

import java.util.ListIterator;
import java.util.Objects;

public class AbstractListIteratorDecorator<E> implements ListIterator<E> {
    private final ListIterator<E> iterator;

    public AbstractListIteratorDecorator(ListIterator<E> listIterator) {
        Objects.requireNonNull(listIterator, "ListIterator must not be null");
        this.iterator = listIterator;
    }

    /* access modifiers changed from: protected */
    public ListIterator<E> getListIterator() {
        return this.iterator;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public E next() {
        return this.iterator.next();
    }

    public int nextIndex() {
        return this.iterator.nextIndex();
    }

    public boolean hasPrevious() {
        return this.iterator.hasPrevious();
    }

    public E previous() {
        return this.iterator.previous();
    }

    public int previousIndex() {
        return this.iterator.previousIndex();
    }

    public void remove() {
        this.iterator.remove();
    }

    public void set(E e) {
        this.iterator.set(e);
    }

    public void add(E e) {
        this.iterator.add(e);
    }
}
