import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacter {
    public static int lengthOfLongestSubstring(String s) {
        char[] str=s.toCharArray();
        int maxLen=0,n=str.length;

        //Approach 1:
        // HashSet<Character> hs=new HashSet<>();
        // for(int i=0;i<n;i++) {
        //     for(int j=i;j<n;j++) {
        //         if(hs.contains(str[j])) {
        //             break;
        //         }
        //         hs.add(str[j]);
        //         maxLen=Math.max(maxLen,j-i+1);
        //     }
        //     hs.clear();
        // }

        //Approach 2:
        // int L=0;
        // HashSet<Character> hs=new HashSet<>();
        // for(int R=0;R<n;R++) {
        //     while(hs.contains(str[R])) {
        //         hs.remove(str[L]);
        //         L++;
        //     }
        //     hs.add(str[R]);
        //     maxLen=Math.max(maxLen,R-L+1);
        // }

        //Approach 3: Using Map
        int L=0;
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int R=0;R<n;R++) {
            if(hm.containsKey(str[R])) {
                L=Math.max(hm.get(str[R])+1,L);
            }
            hm.put(str[R],R);
            maxLen=Math.max(maxLen,R-L+1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s1="abcabcbb";
        System.out.println(lengthOfLongestSubstring(s1));

        String s2="bbbbb";
        System.out.println(lengthOfLongestSubstring(s2));

        String s3="anviaj";
        System.out.println(lengthOfLongestSubstring(s3));

        String s4="qrsvbspk";
        System.out.println(lengthOfLongestSubstring(s4));
    }
}