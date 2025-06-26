import java.util.Arrays;
import java.util.Stack;

public class StackReverse {
    public static void insert(Stack<Integer> st,int ele) {
        //base
        if(st.isEmpty())
        {
            st.push(ele);
            return;
        }
        //Hypothesis
        int val=st.pop();
        insert(st,ele);
        //Induction
        st.push(val);
    }
    public static void reverse(Stack<Integer> st) {
        //Base
        if(st.size()==1) return;
        //Hypothesis
        int ele=st.pop();
        reverse(st);
        //Induction
        insert(st,ele);
    }
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
        st.addAll(Arrays.asList(1,2,3,4,5,6,8,9));
        System.out.println("Before: "+st);
        reverse(st);
        System.out.println("After: "+st);
    }
}