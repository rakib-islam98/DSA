public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        int n = s2.length();
        if(k > n) return false;
        //Approach 1: T - O(n*26)
        // int[] countS1 = new int[26];
        // int[] window = new int[26];

        // //build s1 freq
        // for(int i = 0; i < k; i++) {
        //     countS1[s1.charAt(i) - 'a']++;
        // }

        // for(int i = 0; i < n; i++) {
        //     window[s2.charAt(i) - 'a']++;
        //     if(i >= k) {
        //         window[s2.charAt(i - k) - 'a']--;
        //     }
        //     if(Arrays.equals(countS1,window)) return true;
        // }
        // return false;

        int[] countS1 = new int[26];
        int[] countS2 = new int[26];

        //build freq of s1 and curr window
        for(int i = 0; i < k; i++) {
            countS1[s1.charAt(i) - 'a']++;
            countS2[s2.charAt(i) - 'a']++;
        }

        //count matches
        int matches = 0;
        for(int i = 0; i < 26; i++) {
            if(countS1[i] == countS2[i]) matches++;
        }

        for(int i = k; i < n; i++) {
            if(matches == 26) return true;

            int r = s2.charAt(i)-'a';   //new char
            int l = s2.charAt(i - k)-'a';   //old chR

            //update freq & matches
            countS2[r]++;
            if(countS2[r] == countS1[r]) matches++;
            else if(countS2[r] == countS1[r] + 1) matches--;

            countS2[l]--;
            if(countS2[l] == countS1[l]) matches++;
            else if(countS2[l] == countS1[l] - 1) matches--;
        }
        return matches == 26;
    }
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));   //true
        System.out.println(checkInclusion("ab", "eidboaoo"));   //false
    }
}