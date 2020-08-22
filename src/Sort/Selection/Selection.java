package Sort.Selection;

/*
in place algo, unstable
O(n^2)
doesn't require as much swapping as bubble sort


2 4 5 8 9 7
0 1 2 3 4 5
 */

public class Selection {
    public static void main(String[] args) {
    }
    public int[] selectionSort(int[] arr) {
        int i, j, minVal, minI, temp = 0;

        //0-5
        // 2 4 5 8 9 7
        // 0 1 2 3 4 5
        for(i=0; i<arr.length; i++) {
            minVal = arr[i];
            minI = i;

            // 2 4 5 8 9 7
            // 0 1 2 3 4 5
            //       j starts at 3 bc first unsorted val to 5
            for (j=i; j<arr.length; j++){
                //if less than min, swap
                if (arr[j] < minVal){
                    minVal=arr[j];
                    minI = j;
                }
            }
            //if it's not the first unsorted value
            if(minVal < arr[i]){
                temp = arr[i];
                arr[i] = arr[minI];
                arr[minI] = temp;
            }
        }
        return arr;
    }
}
