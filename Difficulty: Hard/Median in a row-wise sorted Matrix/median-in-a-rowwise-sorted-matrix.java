class Solution {
    public int median(int[][] mat) {
        // code here
        int r=mat.length;
        int c=mat[0].length;
        int[] sorted=new int[r*c];
        int k=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                sorted[k++]=mat[i][j];
            }
        }
        Arrays.sort(sorted);
        return sorted[sorted.length/2];
        
    }
}