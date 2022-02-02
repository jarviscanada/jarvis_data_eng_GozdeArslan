package ca.jrvs.practice.dataStructure;

import java.util.Stack;

public class validBrackets {


    /**
     * O(n) complexity using stacks
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        //iterate string from left to right
        for( char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);

            } else {
                if (stack.isEmpty()) {
                    return false;

                }
                //if closing symbol ) } ]
                if (c == ')' && stack.pop() != '(') {

                    return false;
                }
                if (c == ']' && stack.pop() != '[') {

                    return false;
                }
                if (c == '}' && stack.pop() != '{') {

                    return false;
                }
            }
        }
        //if we have more opening than more closing symbols that means stack is not empty this statement will guarantee to we have all matching parentheses or stack empty
        return stack.isEmpty();
    }

}
