package ca.jrvs.practice.dataStructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Last in first out (LIFO) -->stacks
 * Fist in first out (FIFO) -->Queue Therefore we need to use two queue t implement this method
 * pop O(n) time complexity ,push O(1)
 * using two queues
 */
class myStack {

    public myStack() {
        top=0;
    }

    private Queue<Integer> q1 =new LinkedList<>();
    private Queue<Integer>q2 =new LinkedList<>();
    private int top;

    public void push(int x) {
        q1.add(x);
        top =x;
    }

    public void pop() {

        while(!q1.isEmpty()){

            top=q1.remove(); //removes all the elements from q1
            q2.add(top); //then add q2
        }
        q1.remove(); //removes all the elements from q1
        Queue<Integer> temp = q1; //creates temp Queue
        q1 = q2;
        q2 = temp;
    }


    public int top() {
        if(q1.size()>0){
            return q1.remove();
        }else if(q2.size()>0){
            return q2.remove();
        }
        return 0;
    }

    public boolean empty() {
        if(q1.isEmpty()&&q2.isEmpty()) return true;
        else return false;
    }
}
