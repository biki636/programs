class LongestPalindromicSubString {
    public static void main(String[] args) {
        String input = "bananas";
        String rInput = new StringBuilder(input).reverse().toString();

        int index = 0;
        int rIndex = 0;

        String longestPalindrome = "";
        int tempMaxLength = 0;
        int maxLength = 0;

        while(true) {
            if(index == input.length()) {
                break;
            }

            if(input.charAt(index) == rInput.charAt(rIndex)) {
                longestPalindrome += input.charAt(index);
                index++; rIndex++; tempMaxLength ++;
            } else {
                
                if(maxLength < tempMaxLength) {
                    maxLength = tempMaxLength;
                    longestPalindrome = "";
                }

                rIndex++;
                index = 0;
                tempMaxLength = 0;
            }
        }

        System.out.println(longestPalindrome);
    }
}