class Solution {
    public static Boolean subset(int n,int sum,int [] arr,Boolean [][]dp)
    {
        if(sum==0)
        
        {
            return true;
            
        }
        if(n==0)
        {
            return false;
        }
        if(dp[n][sum]==null){
            if(arr[n-1]<=sum){
                
                dp[n][sum]= (subset(n-1,sum,arr,dp)|| subset(n-1,sum-arr[n-1],arr,dp));}
                else{
                    dp[n][sum]= subset(n-1,sum,arr,dp);}
        }
        else{
            return dp[n][sum];
        }
        return dp[n][sum];
        
    }
    

    public static Boolean isSubsetSum(int arr[], int sum) {
        int n=arr.length;
        Boolean [][]dp=new Boolean[n+1][sum+1];
        return subset(arr.length,sum,arr,dp);
        
        // code here
        
    }
}