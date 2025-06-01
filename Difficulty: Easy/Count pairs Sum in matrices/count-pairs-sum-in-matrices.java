class Solution {
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        // code here
        int count=0;
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<mat1.length;i++){
            for(int j=0;j<mat1.length;j++){
                hs.add(mat1[i][j]);
            }
        }
        for(int i=0;i<mat1.length;i++){
            for(int j=0;j<mat1.length;j++){
                if(hs.contains(x-mat2[i][j]))
                count++;
            }
        }
        return count;
    }
}