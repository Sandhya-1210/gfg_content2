class Solution {
    public int countBalanced(String[] arr) {
        int n = arr.length;
        int []count = new int[n];
        for(int i=0; i<n; i++){
            int c = 0;
            for(int j = 0; j<arr[i].length(); j++){
                char ch = arr[i].charAt(j);
                if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                    c--;
                }else c++;
            }
            count[i] = c;
        }
        
        
        HashMap<Integer, Integer>map = new HashMap<>();
        int sum = 0, c = 0;
        for(int i=0; i<n; i++){
            sum+=count[i];
            if(sum==0)c++;
            if(map.containsKey(sum))c+=map.get(sum);
            
            map.put(sum, map.getOrDefault(sum , 0) + 1);
        }
        
        
        return c;
        
    }
}