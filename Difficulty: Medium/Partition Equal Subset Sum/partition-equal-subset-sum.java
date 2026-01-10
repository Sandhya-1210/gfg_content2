class Solution {
     public static Boolean subset(int n, int sum, int[] arr, Boolean[][] dp){
        if(sum == 0){
            return true;
        }
        if(n == 0){
            return false;
        }
        if(dp[n][sum] == null){
            if(arr[n-1] <= sum){
                dp[n][sum] =  (subset(n-1, sum, arr, dp) || subset(n-1, sum - arr[n-1], arr, dp));
            }else{
                dp[n][sum] =  subset(n-1, sum, arr, dp);
            }
        }else{
            return dp[n][sum];
        }
        return dp[n][sum];
    }
    static boolean equalPartition(int arr[]) {
        int sum = 0;
        for(int i : arr){
            sum+=i;
        }
        if(sum %2 != 0){
            return false;
        }
        int n = arr.length;
        Boolean[][] dp = new Boolean[n+1][sum+1];
        return subset(n, sum/2,arr, dp);
    }
}
