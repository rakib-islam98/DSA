import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class GroupAnagrams {
    // public static boolean isAnagram(String s,String t) {
    //     if(s.length()!=t.length()) return false;
    //     int[] charMap=new int[26];
    //     for(int i=0;i<s.length();i++) {
    //         charMap[s.charAt(i)-'a']++;
    //     }
    //     for(int i=0;i<t.length();i++) {
    //         charMap[t.charAt(i)-'a']--;
    //     }
    //     for(int x:charMap) {
    //         if(x!=0) return false;
    //     }
    //     return true;
    // }
    public static List<List<String>> groupAnagrams(String[] strs) {
        // int n=strs.length;
        // List<List<String>> ans=new ArrayList<>();
        // ArrayList<String> currList;

        // for(int i=0;i<n;i++) {
        //     if(strs[i]=="-1") continue;
        //     currList=new ArrayList<>();
        //     currList.add(strs[i]);
        //     for(int j=i+1;j<n;j++) {
        //         if(strs[j]!="-1" && isAnagram(strs[i],strs[j])) {
        //             currList.add(strs[j]);
        //             strs[j]="-1";
        //         }
        //     }
        //     ans.add(currList);
        // }
        // return ans;

        // HashMap<String,List<String>> res=new HashMap<>();
        // for(String s:strs) {
        //     char[] charArray=s.toCharArray();
        //     Arrays.sort(charArray);
        //     String sortedS=new String(charArray);
        //     res.putIfAbsent(sortedS,new ArrayList<>());
        //     res.get(sortedS).add(s);
        // }
        // return new ArrayList<>(res.values());


        HashMap<String,List<String>> res=new HashMap<>();
        for(String s:strs) {
            int[] freq=new int[26];
            for(char ch:s.toCharArray()) {
                freq[ch-'a']++;
            }
            String freqString=Arrays.toString(freq);
            res.putIfAbsent(freqString,new ArrayList<>());
            res.get(freqString).add(s);
        }
        return new ArrayList<>(res.values());
    }
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}