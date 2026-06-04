public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        // char[] str=s.toCharArray();
        // int ans=0,n=str.length;
        // for(int L=0;L<n;L++) {
        //     HashMap<Character,Integer> hm=new HashMap<>();
        //     int maxFreq=0;
        //     for(int R=L;R<n;R++) {
        //         hm.put(str[R],hm.getOrDefault(str[R],0)+1);
        //         maxFreq=Math.max(maxFreq,hm.get(str[R]));
        //         int len=R-L+1;
        //         int remaining=len-maxFreq;
        //         if(remaining<=k) {
        //             ans=Math.max(ans,len);
        //         }
        //         else break;
        //     }
        // }
        // return ans;

        int[] freq=new int[26];
        int L=0,ans=0,maxFreq=0,n=s.length();

        for(int R=0;R<n;R++) {
            //update freq map
            freq[s.charAt(R)-'A']++;
            //update maxFreq, only increasing 
            maxFreq=Math.max(maxFreq,freq[s.charAt(R)-'A']);

            int windowSize=R-L+1;
            int rem=windowSize-maxFreq;
            if(rem>k) {
                freq[s.charAt(L)-'A']--;
                L++;
            }
            //as L updated,windowSize change, can't use old
            ans=Math.max(ans,R-L+1);
        }

        return ans;
    }
    public static void main(String[] args) {
        String s="AABABBA";
        int k=1;
        System.out.println(characterReplacement(s, k));

        s="AAAA";
        k=2;
        System.out.println(characterReplacement(s, k));
    }
}