class Solution {
    static int knapSack(int val[], int wt[], int capacity) {
        int[][] dp = new int[val.length+1][capacity+1];
        for(int i=0; i<val.length+1;i++){
            dp[i][0] = 0;
        }
        for(int j=0; j<capacity+1;j++){
            dp[0][j] = 0;
        }
        
        for(int i=1; i<val.length+1; i++){ 
            for(int j=1; j<capacity+1; j++){ 
                int value = val[i-1]; 
                int weight = wt[i-1]; 
                if(weight<=j){                    int include = value + dp[i][j-weight];
                    
                    int exclude = dp[i-1][j];
                                        dp[i][j] = Math.max(include, exclude);
                }else{
                    int exclude = dp[i-1][j];
                    dp[i][j] = exclude;
                }
            }
        }
        return dp[val.length][capacity];
    }
}