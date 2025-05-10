//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java
import java.util.*;

class Solution {
    static int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int[] mapped = new int[n];
        
        // Step 1: Map the array to +1/-1
        for (int i = 0; i < n; i++) {
            if (arr[i] > k)
                mapped[i] = 1;
            else
                mapped[i] = -1;
        }

        // Step 2: Find longest subarray with positive sum
        Map<Integer, Integer> prefixMap = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += mapped[i];

            // If total sum so far is positive
            if (prefixSum > 0) {
                maxLen = i + 1;
            } else {
                // Check if (prefixSum - 1) has been seen before
                if (prefixMap.containsKey(prefixSum - 1)) {
                    maxLen = Math.max(maxLen, i - prefixMap.get(prefixSum - 1));
                }
            }

            // Only store the first occurrence
            if (!prefixMap.containsKey(prefixSum)) {
                prefixMap.put(prefixSum, i);
            }
        }

        return maxLen;
    }
}



//{ Driver Code Starts.

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            int n = tokens.length;
            int[] arr = new int[n];

            int i = 0;
            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                arr[i] = Integer.parseInt(token);
                i++;
            }

            int k = Integer.parseInt(br.readLine().trim());
            System.out.println(new Solution().longestSubarray(arr, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends