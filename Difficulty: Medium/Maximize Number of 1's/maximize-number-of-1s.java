class Solution {
    public int maxOnes(int arr[], int k) {
        // code here
        int l=0,len=0,z=0;
        for(int r=0;r<arr.length;r++){
            if(arr[r]==0){
                z++;
            }
            while(z>k){
                if(arr[l]==0) z--;
                l++;
            }
            len=Math.max(len,r-l+1);
        }
        return len;
    }
}