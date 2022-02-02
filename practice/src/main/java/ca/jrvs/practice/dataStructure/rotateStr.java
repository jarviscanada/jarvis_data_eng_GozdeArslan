package ca.jrvs.practice.dataStructure;

public class rotateStr {


    /**
     *O(N^2)
     * @param s
     * @param goal
     * @return
     */
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()){
            return false;}
        if (s.length() == 0){
            return true;
    }
       return true;


       //fastest solution
       // return s.length() == goal.length() && (s + s).contains(goal);
    }
}
