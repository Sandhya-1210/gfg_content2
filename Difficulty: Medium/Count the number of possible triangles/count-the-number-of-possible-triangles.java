class Solution {
    public int countTriangles(int arr[]) {
        // code here
        int count=0;
        Arrays.sort(arr);
        if(arr.length<3) return 0;
        
        for(int i=0;i<arr.length;i++){
        int left=0;
        int right=i-1;
        while(left<right){
            int sum=arr[right]+arr[left];
            if(sum>arr[i]){
                count+=right-left;
                //left++;
                right--;
            }
            else 
            left++;
        }
        }
        
        return count;
    }
}