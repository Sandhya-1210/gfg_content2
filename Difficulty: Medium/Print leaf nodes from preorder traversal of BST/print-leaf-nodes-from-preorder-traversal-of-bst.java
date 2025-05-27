import java.util.*;

class Solution {
    public ArrayList<Integer> leafNodes(int[] preorder) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < preorder.length - 1; i++) {
            boolean isLeaf = false;
            if (preorder[i + 1] < preorder[i]) {
                stack.push(preorder[i]);
            } else {
                int count = 0;
                while (!stack.isEmpty() && preorder[i + 1] > stack.peek()) {
                    stack.pop();
                    count++;
                }
                if (count > 0) {
                    isLeaf = true;
                }
            }
            if (isLeaf) {
                result.add(preorder[i]);
            }
        }
        result.add(preorder[preorder.length - 1]);
        
        return result;
    }
}
