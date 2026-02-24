class Solution {
    public String isAutomorphic(int n) {
        // code here
        int sq=(int)Math.pow(n,2);
        while(n!=0){
            int nr=n%10;
            int sqr=sq%10;
            if(nr!=sqr) return "Not Automorphic";
            n/=10;
            sq/=10;
        }
        return "Automorphic";
    }
}