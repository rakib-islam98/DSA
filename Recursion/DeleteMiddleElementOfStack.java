import java.util.*;
public class DeleteMiddleElementOfStack {
    public static Stack<Integer> deleteMiddleElement(Stack<Integer> st,int k,boolean isEven) {
        //Base
        if(k==1)
        {
            st.pop();
            if(isEven) st.pop();
            return st;
        }
        //Hypothesis
        int val=st.pop();
        deleteMiddleElement(st,k-1,isEven);
        //Induction
        st.push(val);
        return st;
    }
    public static Stack<Integer> solve(Stack<Integer> st) {
        if(st.isEmpty()) return st;
        boolean isEven=(st.size()%2==0);
        int k=(st.size()%2==0)?(st.size()/2):(st.size()/2+1);
        return deleteMiddleElement(st,k,isEven);
    }
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
        st.addAll(Arrays.asList(1,2,3,4,5,6,8,9));
        System.out.println("Before: "+st);
        st=solve(st);
        System.out.println("After: "+st);
    }
}