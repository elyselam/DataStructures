package heap.Heapify;

/*
l= 2i+1
r=2i+2
p = floor((i-1)/2)
 */
public class Heap {
    private int[] heap;
    private int size;

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
















    public static void main(String[] args) {


    }
}
