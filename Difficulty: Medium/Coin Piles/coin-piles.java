import java.util.*;

class Solution {
    public int minimumCoins(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);

        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        TreeMap<Integer, Integer> freqMap = new TreeMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        long[] suffixSum = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + arr[i];
        }

        int minCoins = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int base = arr[i];
            int upperIdx = upperBound(arr, base + k);

            long leftRemove = prefixSum[i];
            long rightRemove = suffixSum[upperIdx] - (long)(n - upperIdx) * (base + k);

            long totalRemove = leftRemove + rightRemove;
            minCoins = (int) Math.min(minCoins, totalRemove);
        }

        return minCoins;
    }

    private int upperBound(int[] arr, int val) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= val) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
