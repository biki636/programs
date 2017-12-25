class LongestPalindromicSubString {
    public static void main(String[] args) {
        String input = "sdbananasf";
        String rInput = new StringBuilder(input).reverse().toString();

        int index = 0; // Index for the original input
        int rIndex = 0; // Index for the reverse of the input

        String tempLongestPalindrome = ""; // This will contain the current longest palindromic substring
        String longestPalindromicSubString = ""; // This will hold the actual longest palindrome substring
        int tempMaxLength = 0;
        int maxLength = 0; // This will hold the length of the longest palindromic substring

        /*
         * What we will do is, fix the 'index', 
         * and start looking for palindromes in the reverse string by incrementing the rIndex.
         * 
         * If characters at both the indexes matche, then we will increatement both,
         * If they do not match, then we will increment the rIndex and continue the same.
         * 
         * Increament the 'index' when rIndex reaches 0
         */
        while(true) {
            if(index == input.length()-1) { // break condition
                break;
            }

            if(input.charAt(index) == rInput.charAt(rIndex)) { // if both matches, then increment both
                tempLongestPalindrome += input.charAt(index);
                index++; rIndex++; tempMaxLength ++;

                if(maxLength < tempMaxLength) {
                    maxLength = tempMaxLength;
                    longestPalindromicSubString = tempLongestPalindrome;
                }

            } else { // If both index and rIndex are not same, then increment the rIndex and reset tmep variables
                rIndex++;
                tempMaxLength = 0;
                tempLongestPalindrome = "";
            }

            // if rIndex reaches 0, then move to the next item in the input string by increamenting index
            if(rIndex == rInput.length()-1) {
                rIndex = 0;
                index++;
            }
        }

        System.out.println(longestPalindromicSubString);
    }
}