class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // code here
        ArrayList<Integer> li=new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                li.add(matrix[i][j]);
            }
        }
        Collections.sort(li);
        return li.get(k-1);
        
    }
}