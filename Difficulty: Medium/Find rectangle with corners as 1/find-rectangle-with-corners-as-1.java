class Solution {
    public boolean ValidCorner(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        // Iterate over all pairs of rows
        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < rows; j++) {
                int count = 0;
                for (int c = 0; c < cols; c++) {
                    if (mat[i][c] == 1 && mat[j][c] == 1) {
                        count++;
                        if (count >= 2) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
