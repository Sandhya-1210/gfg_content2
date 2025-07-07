
class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            int index = i % n;
            
            while (!stack.isEmpty() && stack.peek() <= arr[index]) {
                stack.pop();
            }
            
            if (i < n) {
                if (!stack.isEmpty()) {
                    res.set(index, stack.peek());
                }
            }
            
            stack.push(arr[index]);
        }
        
        return res;
    }
}
