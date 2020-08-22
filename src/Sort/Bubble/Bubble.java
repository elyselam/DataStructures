package Sort.Bubble;

public class Bubble {
    public static void main(String[] args) {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};
        for (int lastUnsorted = arr.length-1; lastUnsorted >0; lastUnsorted--){
            for (int i = 0; i < lastUnsorted; i++) {
                swap(arr, i, i+1);
            }
        }

    }
    public static void swap(int[] arr, int i, int j) {
        if (i==j) {return;}
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
