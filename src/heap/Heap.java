package heap;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Heap<T extends Comparable<T>> {

    private ArrayList<T> items;

    public Heap() {
        items = new ArrayList<T>();
    }
/*
              p               k
0   1   2  3  4   5  6  7  8  9
15, 10, 9, 8, 12, 6, 3, 4, 2, 9

    p          k
0   1   2  3  4   5  6  7  8  9
15, 10, 9, 8, 12, 6, 3, 4, 2, 9


p   k
0   1   2  3  4   5  6  7  8  9
15, 10, 9, 8, 12, 6, 3, 4, 2, 9

            15
         10    9
       8  9   6  3
   4  2  12

 */
    //use with insert()
    private void siftUp() {
        //k=10-1 = 9
        int k = items.size() - 1;
        while (k > 0) {
            //node at index k has parent at index (k-1)-2 = 4
            // (9-1) // 2 = 4
            int p = (k - 1) / 2;
            //
            T item = items.get(k);
            T parent = items.get(p);
            //if k item > its parent item
            if (item.compareTo(parent) > 0) {
                // sift up, set k as parent, p as k
                items.set(k, parent);
                items.set(p, item);

                //k is now pointing in place of p after swap
                k = p;
            //if not larger than parent, we good
            } else {
                break;
            }
        }
    }

    public void insert(T item) {
        items.add(item);
        siftUp();
    }
    //use with delete()

    /*
    3, 10, 15, 9, 10, 6, 8, 5, 2, 9, 7, 3, 2, 4
    0  1   2   3   4  5  6  7  8  9  10 11 12 13
    k  l   r
          max

                15
            10         3
          9   10     6      8
      5  2   9  7   3  2   4

      -compare #10 vs #15, set 15 as max
      - compare to k, swap with #3
      -k now takes place of max, points at index 2, #3


    next iteration:
    15, 10, 3, 9, 10, 6, 8, 5, 2, 9, 7, 3, 2, 4
    0  1   2   3   4  5  6  7  8  9  10 11 12 13
           k          l  r
                         max

                 -compare 6 & 8, max is set to 6
                 - k #3 compare with max #8, max is larger, so swap
                 -now k points at r #6
             *swapped     *swapped
     15, 10, 8, 9, 10, 6, 3, 5, 2, 9, 7, 3, 2, 4
     0  1   2   3   4  5  6  7  8  9  10 11 12 13
                          k                     l
                          (6*2)+1 = 14 => #4
                          (6*2)+2 = 15, outOfBounds, no right child
                          k < l, swap 3 and 4








     */
    private void siftDown() {
        int k = 0; //3
        int l = 2 * k + 1; //2*0 +1 = 1
        while (l < items.size()) {
            //max starts at l, 1
            //r = 1+1 = 2
            int max = l, r = l + 1;
            // there is a right child
            if (r < items.size()) {

                if (items.get(r).compareTo(items.get(l)) > 0) {
                    max++;
                }
            }
            if (items.get(k).compareTo(items.get(max)) < 0) {
                // switch
                T temp = items.get(k);
                items.set(k, items.get(max));
                items.set(max, temp);
                k = max;
                l = 2 * k + 1;
            } else {
                break;
            }
        }
    }

    public T delete()
            throws NoSuchElementException {
        if (items.size() == 0) {
            throw new NoSuchElementException();
        }
        if (items.size() == 1) {
            return items.remove(0);
        }
        T hold = items.get(0);
        items.set(0, items.remove(items.size() - 1));
        siftDown();
        return hold;
    }

    public int size() {
        return items.size();
    }
    public boolean isEmpty() {
        return items == null;
    }
}
