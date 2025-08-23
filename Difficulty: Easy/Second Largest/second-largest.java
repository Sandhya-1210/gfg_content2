class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        // int max=arr[0];
        // int temp=max;
        
        // for(int i=1;i<arr.length;i++){
        //     if(max<arr[i]){
        //         temp=max;
        //         max=arr[i];
        //     }
        //     else{
                
        //     }
        // }
        
        // return temp;
        Arrays.sort(arr);
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]!=arr[i+1]){
                return arr[i];
            }
        }
        return -1;
        
        
    }
}