// User function Template for Java

class Solution {
    static int isStrong(int N) {
        // code here
        int num=N,sum=0;
        while(N!=0){
            sum+=fact(N%10);
            N/=10;
        }
        return (sum==num)?1:0;
    }
    public static int fact(int n){
        int fact=1;
        while(n!=0){
            fact*=n;
            n-=1;
        }
        return fact;
    }
};