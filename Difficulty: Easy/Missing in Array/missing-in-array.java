class Solution {
    int missingNum(int arr[]) {
        // code here
        // ArrayList<Integer> al=new ArrayList<>();
        // for(int i=0;i<arr.length;i++){
        //     al.add(arr[i]);
        // }
        // int j=1;
        // for(int i=0;i<al.size();i++){
        //     if(!al.contains(j++)){
        //         //break;
        //     }
        //     return j--;
        // }
        // return 1;
        Arrays.sort(arr);
        int j=1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=j){
            break;
            }
            j++;
        }
        return j;
    }
}