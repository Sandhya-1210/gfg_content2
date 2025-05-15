//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();

            Solution ob = new Solution();
            int result = ob.countSubstring(s);

            System.out.println(result);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int countSubstring(String s) {
        int[] freq = new int[26];
        
        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int count = 0;

        for (int f : freq) {
            if (f > 0) {
                count += f + (f * (f - 1)) / 2;
            }
        }

        return count;
    }
}
