package Queue;

import java.util.NoSuchElementException;

/*
time & space: all O(1) except enqueue() & resize() O(n)
 */

public class CircularQueue {
    private int front, rear;
    private int[] nums;

    public CircularQueue(int initialSize){
        this.front = -1;
        this.rear = -1;
        this.nums = new int[initialSize];
    }

    /*
    arr = 1,  ,  , 4, 5
          r        f
    index:0, 1, 2, 3, 4

    add int 2 to rear
    (r+1)%len
    (1+1)%3 = 1 therefore we insert 2 into pos 1
    result = 1, 2,  , 4, 5   :)
     */
    public void enqueue(int data) {
        if (isFull()) {
            resize();
        } else if (isEmpty()) {
            front++; //-1++ = 0
            rear = (rear+1) % nums.length; //-1+0 % 5
            nums[rear] = data;
        }
    }

    /*
    remove from front
    arr = 1, 2 ,  , 4, 5, 6
            r      f
    index:0, 1, 2, 3, 4, 5
    (f+1)%len
    (3+1)%4 = 2

     */
    public int dequeue() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        //result =
        int temp = nums[front];
        //if only 1 el, then empties arr
        if(front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % nums.length;
        }
        return temp;
    }

    public int peek() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return nums[front];
    }

    public boolean isEmpty(){
        return front == 1;
    }

    public boolean isFull() {
        //both r & f points to the same spot, loop is finished
        return (rear+1) % nums.length == front;
    }

    private void resize() {
        int[] tempArr = new int[nums.length*2];
        int i =0;
        int j = front;
        do{
            tempArr[i++] = nums[j];
            j = (j+1) % nums.length;
        } while (j != front);

        front = 0;
        rear = nums.length - 1;
        nums = tempArr;
    }


}
