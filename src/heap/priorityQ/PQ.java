package heap.priorityQ;

import java.util.PriorityQueue;
//min heap!
public class PQ {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(-11);
        pq.add(2);
        pq.add(12);
        pq.add(10);

//        //returns -11 because min heap, returns first val
//        System.out.println(pq.peek());
//
//        System.out.println(pq.remove());//remove -11
//        //return 1 . same as remove but returns null instead of throwing exception
//        System.out.println(pq.poll());
        System.out.println(pq);
//        Object[] ints = pq.toArray();
//        for (Object i: ints) {
//            System.out.println(i);
//        }



    }
}
