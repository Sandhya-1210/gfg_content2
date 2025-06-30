

class Solution {
    public int maxMinHeight(int[] arr, int k, int w) {
        int n = arr.length;
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int h : arr) {
            low = Math.min(low, h);
            high = Math.max(high, h);
        }
        high += k;
        
        int ans = low;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canAchieve(arr, k, w, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    
    private boolean canAchieve(int[] arr, int k, int w, int target) {
        int n = arr.length;
        int[] diff = new int[n + 1];
        long used = 0;
        long currAdd = 0;
        
        for (int i = 0; i < n; i++) {
            currAdd += diff[i];
            long need = target - (arr[i] + currAdd);
            if (need > 0) {
                used += need;
                if (used > k) return false;
                currAdd += need;
                if (i + w < n) {
                    diff[i + w] -= need;
                }
            }
        }
        return true;
    }
}
