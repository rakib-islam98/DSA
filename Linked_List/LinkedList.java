import java.util.ArrayList;
class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        private final int data;
        private Node next;
        private Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int get(int index) {
        if(index < 0 || index >= size) return -1;    //out of bound
        Node curr = head;
        for(int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    public void insertHead(int val) {
        Node newNode = new Node(val);
        if(head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void insertTail(int val) {
        Node newNode = new Node(val);
        if(head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public boolean remove(int index) {
        //check if index is valid
        if(index < 0 || index >= size) return false;

        if(index == 0) {
            head = head.next;   //remove first
            //check if empty in case of 1 ele
            if(head == null) tail = null;
        } else {
            //Node is in between or at last
            //tack prev
            Node prev = head;
            for(int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            Node nodeToDelete = prev.next;
            prev.next = nodeToDelete.next;
            if(prev.next == null) {
                tail = prev;
            }
        }
        size --;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();
        Node curr = head;
        while(curr != null) {
            values.add(curr.data);
            curr = curr.next;
        }
        return values;
    }
}
