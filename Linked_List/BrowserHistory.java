class Node {
    String data;
    Node prev;
    Node next;
    public Node(String data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
public class BrowserHistory {
    Node currPage;  //points to the current page in the tab

    public BrowserHistory(String homepage) {
        currPage = new Node(homepage);
    }
    
    public void visit(String url) {
        Node newPage = new Node(url);
        currPage.next = newPage; //remove all forward history after currPage
        newPage.prev = currPage;
        currPage = newPage;
    }
    
    public String back(int steps) {
        while(currPage.prev != null && steps != 0) {
            currPage = currPage.prev;
            steps--;
        }
        return currPage.data;
    }
    
    public String forward(int steps) {
        while(currPage.next != null && steps != 0) {
            currPage = currPage.next;
            steps--;
        }
        return currPage.data;
    }

    public static void main(String[] args) { 
        BrowserHistory obj = new BrowserHistory("leetcode.com");
        obj.visit("google.com");
        System.out.println(obj.back(10));
        System.out.println(obj.forward(5));
    }
}