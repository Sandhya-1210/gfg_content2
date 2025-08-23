class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int l=0;
        int ans=0;
        int n=arr.length;
        int temp=0;
        for(int r=0;r<arr.length;r++){
            temp+=arr[r];
            if(r-l==k){
                temp-=arr[l];
                l++;
            }
            if(r+1-l==k)
            ans=Math.max(ans,temp);
        }
        return ans;
    }
}