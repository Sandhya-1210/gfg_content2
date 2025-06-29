// class Solution {
//     public int splitArray(int[] arr, int k) {
//         // code here
        
//     }
// };

class Solution {
    public int splitArray(int[] arr, int k) {
        int max = 0;
        long sum = 0;
        
        for (int num : arr) {
            max = Math.max(max, num);
            sum += num;
        }
        
        long left = max;
        long right = sum;
        long answer = sum;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            if (canSplit(arr, k, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return (int) answer;
    }
    
    private boolean canSplit(int[] arr, int k, long maxSum) {
        int count = 1;
        long currentSum = 0;
        
        for (int num : arr) {
            if (currentSum + num > maxSum) {
                count++;
                currentSum = num;
                if (count > k) {
                    return false;
                }
            } else {
                currentSum += num;
            }
        }
        
        return true;
    }
}
