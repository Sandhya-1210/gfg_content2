class Solution {
    // Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[]) {
        // Your code here
        int[] prefixSum=new int[arr.length];
        HashSet<Integer> hs=new HashSet<>();
        prefixSum[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]==0) return true;
            prefixSum[i]=prefixSum[i-1]+arr[i];
        }
        for(int i=0;i<arr.length;i++){
            if(hs.contains(prefixSum[i]) || prefixSum[i]==0){
                return true;
            }
            else hs.add(prefixSum[i]);
        }
        return false;
    }
}