// Given an int array and a number, 
// write a function that takes these two in and returns a pair which adds up to the given number
// Example : array = {1, 3, 4, 5, 2, 1} | sum = 6 --> O/P : 5, 1 or 4, 2 

import java.util.Arrays;

class PairSumArray {
    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5, 2, 1};
        int sum = 6;

        // First sort the array
        Arrays.sort(array);

        int i = 0; // First index
        int j = array.length - 1; // Last index
        while(i < j) {

            // Check if the first + last is equals or greater or smaller than the sum
            int tempSum = array[i] + array[j];
            if(tempSum == sum) {
                System.out.println("[" + array[i] + ", " + array[j] + "]");
                return;
            } else if(tempSum < sum) {
                // if array[i] + array[j] is less than sum, then increament i to move to a greater number
                i ++;
            } else {
                // if array[i] + array[j] is greater than sum, then decrement j to move to a lesser number
                j --;
            }
        }

        System.out.println("No match found");
    }
}
 