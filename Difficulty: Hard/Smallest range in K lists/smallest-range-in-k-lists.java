//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class DriverClass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[][] = new int[k][n];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();
            }
            ArrayList<Integer> range = new Solution().findSmallestRange(arr);
            System.out.println(range.get(0) + " " + range.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static class Node {
        int val, row, col;
        Node(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }

    public ArrayList<Integer> findSmallestRange(int[][] arr) {
        int k = arr.length;  // Number of lists
        int n = arr[0].length;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        int max = Integer.MIN_VALUE;
        
        // Initialize min heap with first element of each list
        for (int i = 0; i < k; i++) {
            pq.add(new Node(arr[i][0], i, 0));
            max = Math.max(max, arr[i][0]);
        }

        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;

        while (pq.size() == k) {
            Node curr = pq.poll();
            int min = curr.val;

            if (max - min < rangeEnd - rangeStart) {
                rangeStart = min;
                rangeEnd = max;
            }

            if (curr.col + 1 < n) {
                int nextVal = arr[curr.row][curr.col + 1];
                pq.add(new Node(nextVal, curr.row, curr.col + 1));
                max = Math.max(max, nextVal);
            } else {
                break; // One list is exhausted
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(rangeStart);
        result.add(rangeEnd);
        return result;
    }
}
