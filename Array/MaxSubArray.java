// Wrtie a program that will find the sub array from an integer array whose sum is maximum
// The array can contain +ve, -ve, 0 and duplicate items

class MaxSubArray {
    public static void main(String[] args) {
        
        int[] arr = {1, -2, 9, -5, -1, 4, -2, 8, -1, 0, 5, -1}; // Input array
        int max = Integer.MIN_VALUE;
        int endIndex = -1;
        int sum = 0;

        for(int i = 0 ; i < arr.length ; i ++) { // Find the end index
            sum += arr[i];
            if(sum >= max) {
                max = sum;
                endIndex = i; 
            }
        }

        int rSum = 0;
        int rMax = Integer.MIN_VALUE;
        int startIndex = -1;

        for(int i = endIndex ; i >= 0 ; i --) { // Find the start index
            rSum += arr[i];
            if(rSum >= rMax) {
                rMax = rSum;
                startIndex = i;
            }
        }
        
        System.out.println("Start index = " + startIndex + " End index = " + endIndex);
    }
}