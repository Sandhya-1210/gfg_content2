// User function Template for Java

class Solution {
    public int is_StrongNumber(int n) {
        int num=n,sum=0;
        // Code here
        while(n!=0){
            sum+=fact(n%10);
            n/=10;
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
}