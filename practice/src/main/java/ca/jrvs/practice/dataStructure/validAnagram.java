package ca.jrvs.practice.dataStructure;

import java.util.HashMap;
import java.util.Set;

public class validAnagram {
    /**
     * Time Complexity : O(n)
     * @param str1
     * @param str2
     * @return
     */
    public boolean isAnagram(String str1, String str2) {

        // Check if length of both strings is same or not
        if (str1.length() != str2.length()) {
            return false;
        }
        // Create a HashMap includes chars as Key and value.
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {

            if (map.containsKey(str1.charAt(i))) {
                               map.put(str1.charAt(i),
                        map.get(str1.charAt(i)) + 1);
            } else {
                              map.put(str1.charAt(i), 1);
            }
        }

        for (int i = 0; i < str2.length(); i++) {

            if (map.containsKey(str2.charAt(i))) {

                map.put(str2.charAt(i),
                        map.get(str2.charAt(i)) - 1);
            }
        }

        Set<Character> keys = map.keySet();

        for (Character key : keys) {
            if (map.get(key) != 0) {

                return false;
            }
        }

        return true;
    }
}
