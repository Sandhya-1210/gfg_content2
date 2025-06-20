class Solution {
    public boolean validgroup(int[] arr, int k) {
        // code here
        if((arr.length%k)!=0) return false;
        TreeMap<Integer,Integer> tm=new TreeMap<>();
        for(int i :arr){
            tm.put(i,tm.getOrDefault(i,0)+1);
        }
        
        
        while(!tm.isEmpty()){
            int first=tm.firstKey();
            for(int i=0;i<k;i++){
                int num=first+i;
                if(!tm.containsKey(num)) return false;
                tm.put(num,tm.get(num)-1);
                if(tm.get(num)==0){
                    tm.remove(num);
                }
            }
        }
        return true;
    }
}