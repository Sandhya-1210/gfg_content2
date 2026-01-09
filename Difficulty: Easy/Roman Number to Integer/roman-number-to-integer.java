class Solution {
    public int romanTod(char c){
        if(c=='I') return 1;
        if(c=='V') return 5;
        if(c=='X') return 10;
        if(c=='L') return 50;
        if(c=='C') return 100;
        if(c=='D') return 500;
        else return 1000;
    }
    public int romanToDecimal(String s) {
        // code here
        int i=0;
        int ans=0;
        while(i<s.length()){
            if(i!=s.length()-1 && romanTod(s.charAt(i))<romanTod(s.charAt(i+1))){
                ans+=romanTod(s.charAt(i+1))-romanTod(s.charAt(i));
                i=i+2;
            }
            else{
                ans+=romanTod(s.charAt(i));
                i++;
            }
        }
        return ans;
        
    }
}