package org.apache.commons.collections4.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bag.PredicatedBag;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.list.PredicatedList;
import org.apache.commons.collections4.multiset.HashMultiSet;
import org.apache.commons.collections4.multiset.PredicatedMultiSet;
import org.apache.commons.collections4.queue.PredicatedQueue;
import org.apache.commons.collections4.set.PredicatedSet;

public class PredicatedCollection<E> extends AbstractCollectionDecorator<E> {
    private static final long serialVersionUID = -5259182142076705162L;
    protected final Predicate<? super E> predicate;

    public static <E> Builder<E> builder(Predicate<? super E> predicate2) {
        return new Builder<>(predicate2);
    }

    public static <E> Builder<E> notNullBuilder() {
        return new Builder<>(NotNullPredicate.notNullPredicate());
    }

    public static <T> PredicatedCollection<T> predicatedCollection(Collection<T> collection, Predicate<? super T> predicate2) {
        return new PredicatedCollection<>(collection, predicate2);
    }

    protected PredicatedCollection(Collection<E> collection, Predicate<? super E> predicate2) {
        super(collection);
        Objects.requireNonNull(predicate2, "Predicate must not be null.");
        this.predicate = predicate2;
        for (E validate : collection) {
            validate(validate);
        }
    }

    /* access modifiers changed from: protected */
    public void validate(E e) {
        if (!this.predicate.evaluate(e)) {
            throw new IllegalArgumentException("Cannot add Object '" + e + "' - Predicate '" + this.predicate + "' rejected it");
        }
    }

    public boolean add(E e) {
        validate(e);
        return decorated().add(e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        for (Object validate : collection) {
            validate(validate);
        }
        return decorated().addAll(collection);
    }

    public static class Builder<E> {
        private final List<E> accepted = new ArrayList();
        private final Predicate<? super E> predicate;
        private final List<E> rejected = new ArrayList();

        public Builder(Predicate<? super E> predicate2) {
            Objects.requireNonNull(predicate2, "Predicate must not be null");
            this.predicate = predicate2;
        }

        public Builder<E> add(E e) {
            if (this.predicate.evaluate(e)) {
                this.accepted.add(e);
            } else {
                this.rejected.add(e);
            }
            return this;
        }

        public Builder<E> addAll(Collection<? extends E> collection) {
            if (collection != null) {
                for (Object add : collection) {
                    add(add);
                }
            }
            return this;
        }

        public List<E> createPredicatedList() {
            return createPredicatedList(new ArrayList());
        }

        public List<E> createPredicatedList(List<E> list) {
            Objects.requireNonNull(list, "List must not be null.");
            PredicatedList<? super E> predicatedList = PredicatedList.predicatedList(list, this.predicate);
            predicatedList.addAll(this.accepted);
            return predicatedList;
        }

        public Set<E> createPredicatedSet() {
            return createPredicatedSet(new HashSet());
        }

        public Set<E> createPredicatedSet(Set<E> set) {
            Objects.requireNonNull(set, "Set must not be null.");
            PredicatedSet<E> predicatedSet = PredicatedSet.predicatedSet(set, this.predicate);
            predicatedSet.addAll(this.accepted);
            return predicatedSet;
        }

        public MultiSet<E> createPredicatedMultiSet() {
            return createPredicatedMultiSet(new HashMultiSet());
        }

        public MultiSet<E> createPredicatedMultiSet(MultiSet<E> multiSet) {
            Objects.requireNonNull(multiSet, "MultiSet must not be null.");
            PredicatedMultiSet<E> predicatedMultiSet = PredicatedMultiSet.predicatedMultiSet(multiSet, this.predicate);
            predicatedMultiSet.addAll(this.accepted);
            return predicatedMultiSet;
        }

        public Bag<E> createPredicatedBag() {
            return createPredicatedBag(new HashBag());
        }

        public Bag<E> createPredicatedBag(Bag<E> bag) {
            Objects.requireNonNull(bag, "Bag must not be null.");
            PredicatedBag<E> predicatedBag = PredicatedBag.predicatedBag(bag, this.predicate);
            predicatedBag.addAll(this.accepted);
            return predicatedBag;
        }

        public Queue<E> createPredicatedQueue() {
            return createPredicatedQueue(new LinkedList());
        }

        public Queue<E> createPredicatedQueue(Queue<E> queue) {
            Objects.requireNonNull(queue, "queue must not be null");
            PredicatedQueue<E> predicatedQueue = PredicatedQueue.predicatedQueue(queue, this.predicate);
            predicatedQueue.addAll(this.accepted);
            return predicatedQueue;
        }

        public Collection<E> rejectedElements() {
            return Collections.unmodifiableCollection(this.rejected);
        }
    }
}
