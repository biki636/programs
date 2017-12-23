import java.util.ArrayList;
import java.util.List;

class LargestNumberInRight {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6, 7, 4, 6};
        int max = Integer.MIN_VALUE;

        List<Integer> covered = new ArrayList<>();

        // Find out the min and max
        max = findMax(arr, 0);

        for(int i = 0 ; i < arr.length ; i ++) {
            covered.add(arr[i]);

            if(i == 0) {
                System.out.println(arr[i] + " | " + max);
                continue;
            }

            if(i == arr.length - 1) {
                System.out.println(arr[i] + " | " + -1);
                continue;
            }

            if(! covered.contains(max)) {
                System.out.println(arr[i] + " | " + max);
            } else {
                max = findMax(arr, i + 1);
                System.out.println(arr[i] + " | " + max);
            }

        }
    }

    public static int findMax(int[] arr, int startIndex) {
     
        int max = Integer.MIN_VALUE;
        for(int j = startIndex ; j < arr.length ; j ++) {
            if(arr[j] > max) {
                max = arr[j];
            }
        }

        return max;
    }
}