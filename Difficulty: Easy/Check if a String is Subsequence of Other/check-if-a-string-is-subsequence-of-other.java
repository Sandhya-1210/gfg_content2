class Solution {
    public boolean isSubSeq(String s1, String s2) {
        // code here
        int index=0;
        int flag=0;
        for(int i=0;i<s1.length();i++){
            for(int j=index;j<s2.length();j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    flag++;
                    index=j+1;
                    break;
                }
            }
        }
        if(flag==s1.length()) return true;
        return false;
    }
};