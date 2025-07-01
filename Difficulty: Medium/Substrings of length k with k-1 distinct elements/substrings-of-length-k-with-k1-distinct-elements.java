class Solution {
    public int substrCount(String s, int k) {
        if (s == null || s.length() < k) return 0;

        Map<Character, Integer> freqMap = new HashMap<>();
        int count = 0;
        for (int i = 0; i < k; i++) {
            char c = s.charAt(i);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        if (freqMap.size() == k - 1) {
            count++;
        }
        for (int i = k; i < s.length(); i++) {
            char outChar = s.charAt(i - k);
            char inChar = s.charAt(i);
            freqMap.put(outChar, freqMap.get(outChar) - 1);
            if (freqMap.get(outChar) == 0) {
                freqMap.remove(outChar);
            }
            freqMap.put(inChar, freqMap.getOrDefault(inChar, 0) + 1);
            if (freqMap.size() == k - 1) {
                count++;
            }
        }

        return count;
    }
}
