import java.util.HashMap;

public class ValidAnagrams {
    public static boolean isAnagram(String s,String t) {
        // if(s.length()!=t.length()) return false;

        // HashMap<Character,Integer> freq=new HashMap<>();
        // for(char ch:s.toCharArray()) {
        //     freq.put(ch,freq.getOrDefault(ch, 0)+1);
        // }
        // for(char ch:t.toCharArray()) {
        //     if(!freq.containsKey(ch)) return false;
        //     freq.put(ch,freq.get(ch)-1);
        //     if(freq.get(ch)==0) freq.remove(ch);
        // }
        // return freq.isEmpty();

        int[] freq=new int[26];

        for(char ch:s.toCharArray()) freq[ch-'a']++;
        for(char ch:t.toCharArray()) freq[ch-'a']--;

        for(int x:freq) if(x!=0) return false;
        return true;
    }
    
    public static void main(String[] args) {
        String s1 = "anagram";
        String t1 = "nagaram";

        String s2 = "rat";
        String t2 = "car";

        System.out.println(isAnagram(s1, t1)); // true
        System.out.println(isAnagram(s2, t2)); // false
    }
}