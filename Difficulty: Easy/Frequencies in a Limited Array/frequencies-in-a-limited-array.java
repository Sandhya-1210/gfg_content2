class Solution {
    public List<Integer> frequencyCount(int[] arr) {
        // code here
        HashMap<Integer,Integer> hm=new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        List<Integer> res=new ArrayList<>();
        int j=0;
        int start=1;
        while(start<=arr.length){
            if(hm.containsKey(start)){
                res.add(hm.get(start));
            }
            else{
                res.add(0);
            }
            start++;
        }
        return res;
        
    }
}
