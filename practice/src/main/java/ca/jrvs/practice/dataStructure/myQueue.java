package ca.jrvs.practice.dataStructure;

import java.util.Stack;

public class myQueue {
    private Stack<Integer> newest = new Stack<>();
    private Stack<Integer> oldest = new Stack<>();
    private int front;
    public myQueue() {
        front =0;
    }

    //Helper method
    private void swapStack()
    {
        if(oldest.isEmpty()){
              while(newest.isEmpty()){

                  oldest.push(newest.pop());
              }        }

    }

    public void push(int x) {

        newest.push(x);

    }

    public int pop() {
        swapStack();
        return oldest.pop();

    }

    public int peek() {
        swapStack();
        return oldest.peek();
    }

    public boolean empty() {
        if(newest.isEmpty()) return true;
        else return false;
    }
}
