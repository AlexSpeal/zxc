package edu.hw3.Task8;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BackwardIterator<T> implements Iterator<T> {

    private final Collection<T> collection;
    private int index;

    protected BackwardIterator(Collection<T> collection) {
        if (collection != null) {
            this.collection = collection;
            index = collection.size() - 1;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            return null;
        }
        T[] elem = (T[]) new Object[collection.size()];
        collection.toArray(elem);
        return elem[index--];
    }
}
