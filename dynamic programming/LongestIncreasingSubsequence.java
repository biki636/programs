// Find out the longest increaing array
// The following array will have the output of this : 1, 3, 4, 6, 7
// Solutions : https://www.youtube.com/watch?v=Ns4LCeeOFS4&index=5&list=PLqM7alHXFySGbXhWx7sBJEwY2DnhDjmxm
class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {9, 1, 3, 4, 1, 6, 7, 3, 2 ,6};
        int[] longestArray = new int[arr.length];

        // First set all the postion's as 1, that will cover 1 length
        for(int i = 0 ; i < arr.length ; i ++) {
            longestArray[i] = 1;
        }

        // we ll start with the 2nd item
        // Meaning i will always be the next element, where as, j will be the elemnt left to i
        // If arr[i] > arr[j], meaning, if the item to the right is greater than the item to the left,
        // then we set i th index's value as j's index's value + 1. 
        // If j + 1 is less than the current value store in i index, then we won't chnage the i th index value. 
        int i = 1; 
        int j = 0;

        int longestSubsequenceLength = 0; // This will store the lenght of longest increaing subsequence

        while(true) {

            if(i == arr.length-1) {
                break;
            }

            // If left side number = right side number, 
            // then move to the next right side number, and set the left side number to the first
            if(j == i) { 
                i ++; // Move to the next right side number
                j = 0; // Reset j to the begining of the array
            }
            
            if(arr[i] > arr[j]) { // Check if the right side number is greater than the left side number
                if(longestArray[i] < (longestArray[j] + 1)) {
                    longestArray[i] = longestArray[j] + 1;

                    if(longestSubsequenceLength < longestArray[i]) { // Set the longest increaing subsequence
                        longestSubsequenceLength = longestArray[i];
                    }
                }
            }

            j ++; // Jump to the next item
        }

        // Now longest array all the longest sunsequnces for each position, 
        // in this case [1, 1, 2, 3, 1, 4, 5, 2, 2, 1]
        // The longest increasing subsequence array's indexes here will be [1, 2, 3, 4, 5]
        int[] longestIncreasingSubsequence = new int[longestSubsequenceLength];
        int currentLength = longestSubsequenceLength;
        int longestCounter = 0;
        // Forming the lonest increaing subsequence array
        for(int counter = longestArray.length - 1  ; counter >= 0 ; counter --) {
            if(longestArray[counter] == currentLength) {
                longestCounter ++;
                longestIncreasingSubsequence[longestSubsequenceLength - longestCounter] = arr[counter];
                currentLength--;
            }
        }

        for(int number : longestIncreasingSubsequence) {
            System.out.print(number + ", ");
        }
    }
}