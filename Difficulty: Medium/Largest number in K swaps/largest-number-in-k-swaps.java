//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            String str = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findMaximumNum(str, k));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    public String findMaximumNum(String s, int k) {
    char[] arr = s.toCharArray();
    String[] max = new String[]{s};  
    findMaxUtil(arr, k, 0, max);
    return max[0];
}

private void findMaxUtil(char[] arr, int k, int index, String[] max) {
    if (k == 0 || index==arr.length) return;

    char maxChar = arr[index];
    for (int i = index + 1; i < arr.length; i++) {
        if (arr[i] > maxChar) {
            maxChar = arr[i];
        }
    }
    if (maxChar != arr[index]) k--;

    for (int i = arr.length - 1; i >= index; i--) {
        if (arr[i] == maxChar) {
            swap(arr, index, i);
            if (new String(arr).compareTo(max[0]) > 0) {
                max[0] = new String(arr);
            }
            findMaxUtil(arr, k, index + 1, max);
            swap(arr, index, i); 
        }
    }
}

private void swap(char[] arr, int i, int j) {
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

}