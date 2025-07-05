class Solution {
    public int maxSum(int arr[]) {
        int maxSum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int small = Math.min(arr[i], arr[i + 1]);
            int secondSmall = Math.max(arr[i], arr[i + 1]);
            int sum = small + secondSmall;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
