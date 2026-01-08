class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int maxp=Integer.MIN_VALUE;
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                maxp=max;
                max=arr[i];
            }
            else if(arr[i]>maxp && arr[i]!=max){
            maxp=arr[i];
            }
        }
        return maxp;
    }
}