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
            System.out.println(", ");
        }
        System.out.println();
    }
    public Heap(int capacity) {
        heap = new int[capacity];
    }
    public boolean isFull() {
        return size == heap.length;
    }
    public int getParent(int index) {
        //div with int already rounds it down so no need to floor
        return (index-1) / 2;
    }


    public void insert(int value){
        if (isFull()){
            throw new IndexOutOfBoundsException("full");
        }
        heap[size] = value; //insert at rear
        bubbleUp(size);
        size++;

    }

    private void bubbleUp(int index) {
        int newVal = heap[index];
        //if newVal is not root && > its parent
        while (index > 0 && newVal > heap[getParent(index)]) {
            //now assign the parent to where that value currently is
            heap[index] = heap[getParent(index)];
            //update index to point at parent,
            // this index is being used to compare to its other parents
            index = getParent(index);
        }
        //only assign value once dropped out of loop
        //don't need to assign values while pushing the parent down
        heap[index] = newVal;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getChild(int index, boolean left) {
        return 2*index + (left ? 1: 2);
    }

    public int delete(int index){
        if (isEmpty()){
            throw new IndexOutOfBoundsException("empty");
        }
        //save the parent of the deleted item
        int parent = getParent(index);
        int deletedVal = heap[index];
        //right most val will replace whatever was in the index
        heap[index] = heap[size-1];
        //if delete root or value is less than parent, then don't need to bubble up
        if (index == 0 || heap[index] < heap[parent]) {
            //so we bubble down
            bubbleDown(index, size - 1);
        }else {
            bubbleUp(index);
        }
        size--;
        return deletedVal;


    }

    //deleted value is always the right most leaf
    private void bubbleDown(int index, int lastHeapIndex) {
        int childToSwap;
        while (index <= lastHeapIndex) {
            int l = getChild(index, true);
            int r = getChild(index, false);
            //if has a left child
            if (l <= lastHeapIndex) {
                //and if right child is out of bounds, we have to swap with left
                if (r > lastHeapIndex) {
                    childToSwap = l;
                } else {
                    //else there are both children, swap with the largest one
                    //if l > r, then l, else r
                    childToSwap = (heap[l] > heap[r] ? l : r);
                }
                //
                if (heap[index] < heap[childToSwap]) {
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;
                } else {
                    break;
                }
                index = childToSwap;
            }

        }
    }
}
