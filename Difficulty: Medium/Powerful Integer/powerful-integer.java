// class Solution {
//     public int powerfulInteger(int[][] intervals, int k) {
//         // code here
//         HashMap<Integer,Integer> hm=new HashMap<>();
        
        
//         for(int i=0;i<intervals.length;i++){
//             int start = intervals[i][0];
//             int end = intervals[i][1];
//             for (int num = start; num <= end; num++) {
//                 hm.put(num,hm.getOrDefault(num,0)+1);
            
//             }
//         }
//         int max=Integer.MIN_VALUE;
//         int flag=0;
//         for(int ele:hm.keySet()){
//             if(hm.get(ele)>=k){
//                 flag=1;
//                 max=Math.max(max,ele);
//             }
//         }
//         if(flag!=0)
//         return max;
//         return -1;
        
//     }
// }

import java.util.*;

class Solution {
    public int powerfulInteger(int[][] intervals, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end + 1, map.getOrDefault(end + 1, 0) - 1);
        }

        int active = 0;
        int maxPowerful = -1;

        for (int point : map.keySet()) {
            active += map.get(point);
            if (active >= k) {
                maxPowerful = Math.max(point,maxPowerful);
            }
            else if((active-map.get(point))>=k){
                maxPowerful = Math.max(point-1,maxPowerful);
            }
        }

        return maxPowerful;
    }
}
