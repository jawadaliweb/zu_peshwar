package org.apache.commons.collections4.iterators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

public class PermutationIterator<E> implements Iterator<List<E>> {
    private final boolean[] direction;
    private final int[] keys;
    private List<E> nextPermutation;
    private final Map<Integer, E> objectMap = new HashMap();

    public PermutationIterator(Collection<? extends E> collection) {
        Objects.requireNonNull(collection, "The collection must not be null");
        this.keys = new int[collection.size()];
        boolean[] zArr = new boolean[collection.size()];
        this.direction = zArr;
        Arrays.fill(zArr, false);
        int i = 1;
        for (Object put : collection) {
            this.objectMap.put(Integer.valueOf(i), put);
            this.keys[i - 1] = i;
            i++;
        }
        this.nextPermutation = new ArrayList(collection);
    }

    public boolean hasNext() {
        return this.nextPermutation != null;
    }

    public List<E> next() {
        int[] iArr;
        if (hasNext()) {
            int i = 0;
            int i2 = -1;
            int i3 = 0;
            int i4 = -1;
            int i5 = -1;
            while (true) {
                iArr = this.keys;
                if (i3 >= iArr.length) {
                    break;
                }
                boolean[] zArr = this.direction;
                if (((zArr[i3] && i3 < iArr.length - 1 && iArr[i3] > iArr[i3 + 1]) || (!zArr[i3] && i3 > 0 && iArr[i3] > iArr[i3 - 1])) && iArr[i3] > i4) {
                    i4 = iArr[i3];
                    i5 = i3;
                }
                i3++;
            }
            if (i4 == -1) {
                List<E> list = this.nextPermutation;
                this.nextPermutation = null;
                return list;
            }
            boolean[] zArr2 = this.direction;
            if (zArr2[i5]) {
                i2 = 1;
            }
            int i6 = iArr[i5];
            int i7 = i2 + i5;
            iArr[i5] = iArr[i7];
            iArr[i7] = i6;
            boolean z = zArr2[i5];
            zArr2[i5] = zArr2[i7];
            zArr2[i7] = z;
            ArrayList arrayList = new ArrayList();
            while (true) {
                int[] iArr2 = this.keys;
                if (i < iArr2.length) {
                    if (iArr2[i] > i4) {
                        boolean[] zArr3 = this.direction;
                        zArr3[i] = !zArr3[i];
                    }
                    arrayList.add(this.objectMap.get(Integer.valueOf(iArr2[i])));
                    i++;
                } else {
                    List<E> list2 = this.nextPermutation;
                    this.nextPermutation = arrayList;
                    return list2;
                }
            }
        } else {
            throw new NoSuchElementException();
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("remove() is not supported");
    }
}
