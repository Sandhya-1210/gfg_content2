class Solution {
    public int maxRectSum(int mat[][]) {
        // code here
        int n = mat.length, m = mat[0].length;
        int maxi = Integer.MIN_VALUE;
        for(int left = 0; left < m; left++) {
            for(int right = left; right < m; right++) {
                
                int curSum = 0;
                for(int i=0; i<n; i++) {
                    for(int j=left; j<=right; j++) curSum += mat[i][j];
                    maxi = Math.max(maxi, curSum);
                    if(curSum < 0) curSum = 0;
                }
            }
        }
        return maxi;
    }
}
