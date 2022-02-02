package ca.jrvs.practice.dataStructure;

public class myAtoi {


    /**
     * Requirements: Use Java build-in parsing method (be careful with exception handling)
     * Let n represent the number of char  in the input string
     *     Time complexity: O(N)
     *     Space complexity is O(1) no extra space required
     * @param str
     * @return result*current
     */
    public static int myAtoi(String str) {

        int result =0;
        int index =0;
        int sign =1;

        //   int result = 0;
//    int index = 0;
        //   int  = 1;

        while (str.charAt(index)==' '){

            index++;
        }
        //skips the leading white spaces
        while (str.charAt(index) == ' ') {
            index++;
        }
        //check the negative or positive   4
        if (str.charAt(index) == '+') {
            sign=1;
            index++;
        } else if (str.charAt(index) == '-') {

            sign = -1;
            index++;
        }

        //checks the digit
        while (Character.isDigit(str.charAt(index))) {
            for ( index=0; index < str.length(); index++)

                if ((result > Integer.MAX_VALUE / 10) ||
                        (result == Integer.MAX_VALUE / 10 ) ){
                    // If integer overflowed return 2^31-1, otherwise if underflowed return -2^31.
                    return  sign== 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }


            result = result * 10 + str.charAt(index) ;





        }
        return   sign*result;
    }
}
