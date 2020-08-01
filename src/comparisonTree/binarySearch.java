package comparisonTree;

public class binarySearch {
    public static void main(String[] args) {

    }
    public static boolean binarySearch(int[] list, int target) {
        int lo = 0;
        int hi = list.length-1;
        while (lo <= hi) {
            int mid = (lo+hi)/2;
            if (target == list[mid]) {
                return true;
            }
            if (target < list[mid]) {
                hi = mid - 1;
            } else {
                lo = mid+1;
            }
        }
        return false;
    }
}

