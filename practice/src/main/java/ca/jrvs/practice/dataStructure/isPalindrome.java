package ca.jrvs.practice.dataStructure;

public class isPalindrome {
    /**
     * O(n) time complexity  using two pointers
     * considering only alphanumeric chars and ignoring cases
     * @param s
     * @return
     */
    public boolean palindrome(String s) {
        if (s == null) { //if the string null not a palindrome
            return false;

        }
        int left = 0, right = s.length() - 1;

        while (left < right) {

            //char from the left is letter or digit
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } else if ((!Character.isLetterOrDigit(s.charAt(right)))) {
                --right;
            } else if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            } else {

                ++left;
                --right;

            }


        }
        return true;


    }

}

