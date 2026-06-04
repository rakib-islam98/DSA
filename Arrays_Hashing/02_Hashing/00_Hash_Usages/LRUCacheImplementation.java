import java.util.*;
class Node {
    int key;
    int value;
    Node next;
    Node prev;
    
    public Node(int key,int value) {
        this.key=key;
        this.value=value;
        this.next=null;
        this.prev=null;
    }
}
class LRUCache {

    // TODO: define required data structures
    //Approach 1:Brute Force(Using Array)
    // ArrayList<int[]> cache;
    // int capacity;

    //Approach 2: Optimal(Doubly Linked List + HashMap)
    // HashMap<Integer,Node> cacheMap;
    // Node start;
    // Node end;
    // int capacity;

    //Approach 3: Built-in Data Structure. (Linked Hash Map)
    LinkedHashMap<Integer, Integer> cacheMap;
    int capacity;

    public LRUCache(int capacity) {
        // TODO: initialize cache with given capacity
        // this.capacity=capacity;
        // cache=new ArrayList<>(capacity);

        // this.capacity=capacity;
        // cacheMap=new HashMap<>();
        // start=new Node(-1,-1);
        // end=new Node(-1,-1);
        // start.next=end;
        // end.prev=start;

        this.capacity=capacity;
        this.cacheMap=new LinkedHashMap<>(capacity,0.75f,true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
                return size()>LRUCache.this.capacity;
            }
        };
    }

    public int get(int key) {
        // TODO:
        // for(int i=0;i<cache.size();i++) {
        //     if(cache.get(i)[0]==key) {
        //         int[] temp=cache.remove(i);
        //         cache.add(temp);
        //         return temp[1];
        //     }
        // }


        // if(cacheMap.containsKey(key)) {
        //     Node temp=cacheMap.get(key);
        //     remove(temp);
        //     add(temp);
        //     return temp.value;
        // }
        // return -1;

        return cacheMap.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        // TODO:
        //int[] pair = new int[]{key, value};
        // //If key exist -> Update value & Move to last
        // for (int i = 0; i < cache.size(); i++) {
        //     if (cache.get(i)[0] == key) {
        //         cache.remove(i);
        //         cache.add(pair);
        //         return;
        //     }
        // }
        // //If key not exist -> if cap full -> remove at 0 & add at last, if not -> add at last
        // if(cache.size()==capacity) cache.remove(0);
        // cache.add(pair);


        // Node pair=new Node(key,value);
        // if(cacheMap.containsKey(key)) {
        //     Node temp=cacheMap.get(key);
        //     temp.value=value;
        //     remove(temp);
        //     add(temp);
        //     return;
        // }
        // if(cacheMap.size()==capacity) {
        //     Node temp=start.next;
        //     remove(temp);
        //     cacheMap.remove(temp.key);
        // }
        // add(pair);
        // cacheMap.put(key,pair);

        cacheMap.put(key,value);
    }
    
    // public void remove(Node node) {
    //     Node prevNode=node.prev;
    //     Node nextNode=node.next;
    //     prevNode.next=node.next;
    //     nextNode.prev=node.prev;
    // }

    // public void add(Node node) {
    //     Node prevNode=end.prev;
    //     prevNode.next=node;
    //     node.prev=prevNode;
    //     end.prev=node;
    //     node.next=end;
    // }

}

public class LRUCacheImplementation {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1); // cache = {1=1}
        cache.put(2, 2); // cache = {1=1, 2=2}

        System.out.println(cache.get(1)); 
        // Expected: 1 (makes key 1 most recent)

        cache.put(3, 3); 
        // Evicts key 2 → cache = {1=1, 3=3}

        System.out.println(cache.get(2)); 
        // Expected: -1 (not found)

        cache.put(4, 4); 
        // Evicts key 1 → cache = {4=4, 3=3}

        System.out.println(cache.get(1)); 
        // Expected: -1

        System.out.println(cache.get(3)); 
        // Expected: 3

        System.out.println(cache.get(4)); 
        // Expected: 4

        //Expected Output: 1 -1 -1 3 4
    }
}