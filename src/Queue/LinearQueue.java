package Queue;
//linear data structure that supports fifo operations
import java.util.NoSuchElementException;

//all operations time and space complexity = O(1)
//Time: independent of size of array
//Space: not resizing the queue

public class LinearQueue {
    private int front, rear;
    private int[] nums;

    public LinearQueue(int size){
        this.front = -1;
        this.rear = -1;
        this.nums = new int[size];
    }
    //insert from the back
    public void enqueue(int data) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        if (isEmpty()){
            front ++; //front from -1 to 0
            nums[++rear] = data; //inc rear and insert data at that position
        }
    }

    //remove from front
    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        //save el that is removed
        int temp = nums[front];
        //if only 1 item
        if (front == rear) {
            front = rear = -1;
            //else there are more than 1 item, so front can increment
        } else {
            front++;
        }
        return temp;
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return nums[front];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return rear == nums.length - 1;
    }
}

















