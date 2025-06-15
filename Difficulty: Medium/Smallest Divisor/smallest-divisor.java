class Solution {
    int smallestDivisor(int[] arr, int k) {
        int left = 1, right = Integer.MIN_VALUE;
        
        for (int num : arr) {
            right = Math.max(right, num);
        }

        int answer = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isValid(arr, k, mid)) {
                answer = mid;
                right = mid - 1; 
            } else {
                left = mid + 1;  
            }
        }

        return answer;
    }

    boolean isValid(int[] arr, int k, int divisor) {
        int sum = 0;
        for (int num : arr) {
            sum += (num + divisor - 1) / divisor; 
        }
        return sum <= k;
    }
}
