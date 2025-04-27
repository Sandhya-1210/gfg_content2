//{ Driver Code Starts
// Initial Template for Java

import java.math.*;
import java.util.*;

class Multiply {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a = sc.next();
            String b = sc.next();
            Solution g = new Solution();
            System.out.println(g.multiplyStrings(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String multiplyStrings(String s1, String s2) {
        // code here.
        s1 = removeLeadingZeros(s1);
        s2 = removeLeadingZeros(s2);

        if (s1.equals("0") || s2.equals("0"))
            return "0";
        boolean negative = false;
        if (s1.charAt(0) == '-') {
            negative = !negative;
            s1 = s1.substring(1);
        }
        if (s2.charAt(0) == '-') {
            negative = !negative;
            s2 = s2.substring(1);
        }

        int n = s1.length();
        int m = s2.length();
        int[] result = new int[n + m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int mul = (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + result[p2];

                result[p2] = sum % 10;
                result[p1] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < result.length && result[i] == 0)
            i++;
        while (i < result.length)
            sb.append(result[i++]);

        if (negative)
            sb.insert(0, '-');

        return sb.toString();
    }

    private static String removeLeadingZeros(String s) {
        int i = 0;
        while (i < s.length() && (s.charAt(i) == '0' || s.charAt(i) == '+')) {
            i++;
        }
        if (i == s.length())
            return "0";
        return s.substring(i);
    }
    }
