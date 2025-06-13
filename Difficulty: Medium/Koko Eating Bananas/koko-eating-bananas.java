

class Solution {
    public int kokoEat(int[] arr, int k) {
        int lo = 1, hi = 0;
        for (int a : arr) hi = Math.max(hi, a);

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canFinish(arr, mid, k)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean canFinish(int[] arr, int s, int k) {
        long hours = 0;
        for (int a : arr) {
            hours += (a + s - 1) / s;
            if (hours > k) return false;
        }
        return true;
    }
}
