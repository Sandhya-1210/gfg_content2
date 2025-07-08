

class Solution {
    public int sumSubMins(int[] arr) {
        int n = arr.length;
        int mod = (int)1e9 + 7;

        int[] prevLess = new int[n];
        int[] nextLess = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Previous Less
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            prevLess[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Next Less or Equal
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nextLess[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long sum = 0;

        for (int i = 0; i < n; i++) {
            int left = i - prevLess[i];
            int right = nextLess[i] - i;
            sum = (sum + (long)arr[i] * left * right) % mod;
        }

        return (int)sum;
    }
}
