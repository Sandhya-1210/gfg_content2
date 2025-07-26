class Solution {
     public void setMatrixZeroes(int[][] mat) {
        int rowLength=mat.length;
        int colLength=mat[0].length;
        
        int[] row=new int[rowLength];
        int[] col=new int[colLength];
        
        for(int i=0;i<rowLength;i++){
            for(int j=0;j<colLength;j++){
                if(mat[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        for(int i=0;i<rowLength;i++){
            for(int j=0;j<colLength;j++){
                if(row[i]==1||col[j]==1){
                    mat[i][j]=0;
                }
            }
        }
    }
}