import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        int[] ans=new int[k];

        HashMap<Integer,Integer> freq=new HashMap<>();
        for(int x:nums) {
            freq.put(x,freq.getOrDefault(x,0)+1);
        }

        //Brute Force: (O(nlogn))
        // List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freq.entrySet());
        // Collections.sort(list, (o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        
        // int idx=0;
        // for(int i=0;i<k;i++) {
        //     ans[idx]=list.get(i).getKey();
        //     idx++;
        // }

        //Better:Heap (O(nlogk))
        // PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
        // for(Map.Entry<Integer,Integer> entry:freq.entrySet()) {
        //     pq.offer(entry);
        //     if(pq.size()>k) pq.poll();
        // }

        // int idx=0;
        // while(!pq.isEmpty()) {
        //     ans[idx++]=pq.poll().getKey();
        // }

        //Optimal: Bins/Buckets(O(n))
        ArrayList<ArrayList<Integer>> buckets=new ArrayList<>();
        for(int i=0;i<=n;i++) {
            buckets.add(new ArrayList<>());
        }

        for(Map.Entry<Integer,Integer> entry:freq.entrySet()) {
            int count=entry.getValue();
            int value=entry.getKey();
            buckets.get(count).add(value);
        }

        int idx=0;
        for(int i=n;i>=0;i--) {
            for(Integer x:buckets.get(i)) {
                ans[idx++]=x;
                if(idx==k) return ans;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,2,1,2,1,2,3,1,3,2},2)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,2,2,3},2)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1},1)));

        //[1,2] [1,2] [1]
    }
}