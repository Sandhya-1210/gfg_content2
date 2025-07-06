import java.util.*;

class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        Arrays.sort(a);
        Arrays.sort(b);
        
        int n = a.length;
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        HashSet<String> visited = new HashSet<>();
        
        maxHeap.add(new int[]{a[n-1] + b[n-1], n-1, n-1});
        visited.add((n-1) + "_" + (n-1));
        
        while (k > 0 && !maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            int sum = curr[0];
            int i = curr[1];
            int j = curr[2];
            
            result.add(sum);
            k--;
            
            if (i - 1 >= 0) {
                String key = (i-1) + "_" + j;
                if (!visited.contains(key)) {
                    maxHeap.add(new int[]{a[i-1] + b[j], i-1, j});
                    visited.add(key);
                }
            }
            
            if (j - 1 >= 0) {
                String key = i + "_" + (j-1);
                if (!visited.contains(key)) {
                    maxHeap.add(new int[]{a[i] + b[j-1], i, j-1});
                    visited.add(key);
                }
            }
        }
        
        return result;
    }
}
