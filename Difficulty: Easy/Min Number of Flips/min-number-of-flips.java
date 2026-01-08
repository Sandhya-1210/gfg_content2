class Solution {
    public int minFlips(String s) {
        // Code here
        int flip1=0;
        int flip2=0;
       for(int i=0;i<s.length();i++){
           char ch=s.charAt(i);
           if((i%2==0 && ch!='1') || (i%2!=0 && ch!='0')){
               flip1++;
           }
       }
       for(int i=0;i<s.length();i++){
           char ch=s.charAt(i);
           if((i%2==0 && ch!='0') || (i%2!=0 && ch!='1')){
               flip2++;
           }
       }
       return Math.min(flip1,flip2);
        
        
    }
}