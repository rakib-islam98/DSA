public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
    //    String str=s.replaceAll("[^a-zA-Z0-9]","");
    //    str=str.toLowerCase();
    //    int l=0;
    //    int h=str.length()-1;
    //    while(l<h)
    //    {
    //         if(str.charAt(l++)!=str.charAt(h--))
    //             return false;
    //    }
    //    return true;
    char a[]=s.toCharArray();
    int l=0,h=a.length-1;
    while(l<h)
    {
        if(!Character.isLetterOrDigit(a[l]))
            l++;
        else if(!Character.isLetterOrDigit(a[h]))
            h--;
        else if(Character.toLowerCase(a[l++])!=Character.toLowerCase(a[h--]))
            return false;
    }
    return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));
    }
}