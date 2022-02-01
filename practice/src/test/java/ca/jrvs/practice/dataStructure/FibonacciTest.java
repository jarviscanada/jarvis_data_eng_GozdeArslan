package ca.jrvs.practice.dataStructure;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {

    @Test
    public int fibonacci(int i) {


        final int number = 50;

        for (i = 0; i < number; i++) {
            System.out.print(fibonacci(i) + " ");
        }

        return number;
    }
}