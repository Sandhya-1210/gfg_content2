//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().majorityElement(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int majorityElement(int arr[]) {
        // code here
        HashMap<Integer,Integer> eleCount=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            eleCount.put(arr[i],eleCount.getOrDefault(arr[i],0)+1);
        }
        int res=-1;
        int max=0;
        for(int ele:eleCount.keySet()){
            if(eleCount.get(ele)>max){
            max=eleCount.get(ele);
            res=ele;
        }
        }
        return max>arr.length/2?res:-1;
    }
}