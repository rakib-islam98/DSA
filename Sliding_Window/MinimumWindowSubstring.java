
import java.util.HashMap;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        /*
        Pattern:
        initialize window
        expnad right:
            while(valid) {
                update answer
                shrink left
            }
        */
        //Initialize Window
        int m = t.length();
        int n = s.length();

        HashMap<Character, Integer> need = new HashMap<>();
        for(int i = 0; i < m; i++) {
            char ch = t.charAt(i);
            need.put(ch,need.getOrDefault(ch,0)+1);
        }
        int required = need.size(); //required entry to match
        int formed = 0; //entry matched till now.
        HashMap<Character, Integer> window = new HashMap<>();
        int minLen = Integer.MAX_VALUE; //minLen window 
        int start = 0; //start of minLen window
        int l = 0; //left pointer

        //Expand Right 
        for(int r = 0; r < n; r++) {
            char ch = s.charAt(r);
            //put ch in window
            window.put(ch,window.getOrDefault(ch, 0)+1);
            //check if an entry matches
            if(need.containsKey(ch) && need.get(ch).equals(window.get(ch))) formed++;
            //while vaild, shrink and try to find minimum
            while(formed == required) {
                //update answer to find min
                int currLen = r - l + 1;
                if(currLen < minLen) {
                    minLen = currLen;
                    start = l;
                }

                //shrink left
                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar)-1);
                //update formed entry
                if(need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                    formed--;
                }
                l++;
            }
        }

        //return answer
        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(start, start + minLen);
    }
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); //"DANC"
    }
}