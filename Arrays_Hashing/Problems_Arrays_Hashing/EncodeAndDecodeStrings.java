import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeStrings {
    public static String encode(List<String> strs) {
        String encodedString="";
        for(String str:strs) {
            int length=str.length();
            encodedString+=String.valueOf(length)+"#"+str;
        }
        return encodedString;
    }
    public static List<String> decode(String str) {
        ArrayList<String> decoded=new ArrayList<>();
        int i=0;
        while(i<str.length()) {
            //initialize 2nd pointer at i
            int j=i;
            //Find the "#"
            while(str.charAt(j)!='#') {
                j++;
            }
            //now ch. btw i & j is the length
            int length=Integer.parseInt(str.substring(i,j));
            //move i to pass "#" i.e., start of a string
            i=j+1;
            decoded.add(str.substring(i,i+length));
            //move i to the next string
            i+=length;
        }
        return decoded;
    }
    public static void main(String[] args) {
        String str=encode(new ArrayList<>(Arrays.asList("Hello", "World")));
        System.out.println(str);
        System.out.println(decode(str));
    }
}
