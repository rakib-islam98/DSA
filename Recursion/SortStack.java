import java.util.*;
public class SortStack {
    public static void insert(Stack<Integer> st,int ele) {
        //Base
        if(st.isEmpty()||st.peek()<=ele)
        {
            st.push(ele);
            return;
        }
        //hypothesis
        int val=st.pop();
        insert(st,ele);
        //Induction
        st.push(val);
    }
    public static void sort(Stack<Integer> st) {
        //Base
        if(st.size()==1) return;
        //hypothesis
        int ele=st.pop();
        sort(st);
        //Induction
        insert(st,ele);
    }
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
        st.addAll(Arrays.asList(2,5,0,-4,6));
        System.out.print("Unsorted Stack: " +st+"\n");
        sort(st);
        System.out.print("Sorted Stack: "+st);
    }
}