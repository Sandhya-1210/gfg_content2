/*
class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
}*/

class Solution {
    public boolean isDeadEnd(Node root) {
        Set<Integer> allNodes = new HashSet<>();
        Set<Integer> leafNodes = new HashSet<>();
        allNodes.add(0);
        populateSets(root, allNodes, leafNodes);
        
        for (int leaf : leafNodes) {
            if ((allNodes.contains(leaf - 1) && allNodes.contains(leaf + 1)) ||
                (leaf == 1 && allNodes.contains(2))) {
                return true;
            }
        }
        return false;
    }
    
    private void populateSets(Node node, Set<Integer> allNodes, Set<Integer> leafNodes) {
        if (node == null) return;
        
        allNodes.add(node.data);
        
        if (node.left == null && node.right == null) {
            leafNodes.add(node.data);
        }
        
        populateSets(node.left, allNodes, leafNodes);
        populateSets(node.right, allNodes, leafNodes);
    }
}