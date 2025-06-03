// User function Template for Java

import java.util.*;

class Solution {
    int countSubstr(String s, int k) {
        return countAtMostK(s, k) - countAtMostK(s, k - 1);
    }

    int countAtMostK(String s, int k) {
        int i = 0, j = 0, res = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (j < s.length()) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() > k) {
                char leftChar = s.charAt(i);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                i++;
            }

            res += (j - i + 1);
            j++;
        }

        return res;
    }
}
