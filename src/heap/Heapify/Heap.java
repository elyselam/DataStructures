package heap.Heapify;

/*
l= 2i+1
r=2i+2
p = floor((i-1)/2)
 */

public class Heap {
    private int[] heap;
    private int size;
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.println(heap[i]);
//            System.out.println(", ");
        }
        System.out.println();
    }
    public Heap(int capacity) {
        heap = new int[capacity];
    }
    public boolean isFull() {
        return size == heap.length;
    }
    public int getParent(int i) {
        //div with int already rounds it down so no need to floor
        return (i-1) / 2;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getChild(int i, boolean left) {
        return 2*i + (left ? 1: 2);
    }



    public void insert(int value){
        if (isFull()){
            throw new IndexOutOfBoundsException("full");
        }
        heap[size] = value; //insert at rear
        bubbleUp(size); //
        size++;
    }

    private void bubbleUp(int i) {
        int newVal = heap[i];

        //if newVal is not root && > its p
        while (i > 0 && newVal > heap[getParent(i)]) {

            //swap curr with heap[(i-1)/2]
            heap[i] = heap[getParent(i)];

            //update i to point at p,
            // keep bubbling up until value is not > than p
            i = getParent(i);
        }
        //only assign value once dropped out of loop
        heap[i] = newVal;
    }



    /*
    - remove right-most value so tree remains complete
    - then if newVal > p, bubbleUp
    else bubbleDown
     */

    public int delete(int i){
        if (isEmpty()){
            throw new IndexOutOfBoundsException("empty");
        }
        //save the p of the deleted item
        int p = getParent(i);
        //always returns this at the end
        int deletedVal = heap[i];

        //replaces val with the very last value
        heap[i] = heap[size-1];

        //bubbleDown
        //if the curr is root || curr < p
        //root can't bubble up
        if (i == 0 || heap[i] < heap[p]) {
            //swap i with the right most value
            bubbleDown(i, size - 1);
        } else {
            bubbleUp(i);
        }
        size--;
        return deletedVal;
    }

    //deleted value is always the right most leaf
    private void bubbleDown(int i, int lastI) {
        //if 1 side, make sure to swap with left
        //if 2 sides, swap with larger one
        int childToSwap;
        while (i <= lastI) {
            int l = getChild(i, true);
            int r = getChild(i, false);

            //if l is not last leaf
            if (l <= lastI) {
                //and if right child is out of bounds, there is only left child, so swap with left
                if (r > lastI) {
                    childToSwap = l;
                } else {
                    //else there are both children, swap with the largest one
                    //if l > r, then l, else r
                    childToSwap = (heap[l] > heap[r] ? l : r);
                }
                //if item is less than children, need to bubbleDown
                if (heap[i] < heap[childToSwap]) {
                    //save current value as temp
                    int temp = heap[i];
                    //now swap with the larger child
                    heap[i] = heap[childToSwap];
                    //place that temp value to be swap in later iterations if the conditions meet
                    heap[childToSwap] = temp;
                    //else break out
                } else {
                    break;
                }
                //now goes down the tree until i is at the last leaf
                i = childToSwap;
            }
        }
    }

    public int peek() {
        if(isEmpty()){
            throw new IndexOutOfBoundsException("empty");
        }
        return heap[0];
    }
}
