class Solution {
    public static int sumSubstrings(String s) {
        // code here
        int l=s.length();
        int sum=0;
        for(int i=0;i<l;i++){
            for(int j=i+1;j<=l;j++){
                String sub=s.substring(i,j);
                int num=Integer.parseInt(sub);
                sum+=num;
            }
        }
        return sum;
    }
}