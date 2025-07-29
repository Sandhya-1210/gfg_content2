class Solution {
    public ArrayList<Integer> asciirange(String s) {
        // code here
        HashMap<Character,Integer> hm=new HashMap<>();
        for(char ch:s.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        ArrayList<Integer> arr=new ArrayList<>();
        for(char ele:hm.keySet()){
            int sum=0;
            if(hm.get(ele)!=1){
                int f=s.indexOf(ele);
                int l=s.lastIndexOf(ele);
                while(f<l-1){
                    sum+=s.charAt(++f);
                }
                if(sum!=0)
                arr.add(sum);
                
            }
            //hm.remove(ele);
        }
        return arr;
    }
}