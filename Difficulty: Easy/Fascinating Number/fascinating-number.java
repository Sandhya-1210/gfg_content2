class Solution {
    boolean fascinating(long n) {
        // code here
        long n2=n*2;
        long n3=n*3;
        String s=""+n+n2+n3;
        String seq="123456789";
        for(int i=0;i<seq.length();i++){
            String c = seq.charAt(i)+"";
            if(!s.contains(c)) return false;
        }
        return s.length()==9;
    }
}