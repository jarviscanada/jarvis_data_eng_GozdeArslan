package ca.jrvs.practice.dataStructure;


/**
 * Recursive functions occupy more stacks than iterations calls because it need to call function itself repeatedly sometimes can be slower than iterations therefore best match for these inferences that is exponential growth or cubic growth.The reason relating the exponential rate that for each recursive call we need extra unit that means doubling data.
 * Let n represent the value we are finding the fibonacci for Let T(n) represent number of operations needed to find using the code
 * This implementation uses recursive algorithms
 * T(n) =O(n^2)
 */
public class Fibonacci {

    public static int fibonacci( int n) {
        if (n == 0) {    //1
            return 0;     //1
        }

        if ((n == 1)) {      //1
            return 1;        //1
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2); //T(n-1) +T(n-2)
        }
    }

    public static void main(String[] args) {

        final int  number =50;

        for(int i = 0; i < number; i++){
            System.out.print(fibonacci(i) +" ");
        }
    }


}
