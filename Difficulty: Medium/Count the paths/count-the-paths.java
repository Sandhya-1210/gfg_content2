// class Solution {
//     int pathCount;

//     public int countPaths(int[][] edges, int V, int src, int dest) {
//         List<List<Integer>> graph = new ArrayList<>();
//         for (int i = 0; i < V; i++) {
//             graph.add(new ArrayList<>());
//         }

//         for (int[] edge : edges) {
//             graph.get(edge[0]).add(edge[1]);
//         }
//         pathCount = 0;
//         dfs(graph, src, dest);
//         return pathCount;
//     }

//     private void dfs(List<List<Integer>> graph, int current, int dest) {
//         if (current == dest) {
//             pathCount++;
//             return;
//         }

//         for (int neighbor : graph.get(current)) {
//             dfs(graph, neighbor, dest);
//         }
//     }
// }

class Solution {
    public int countPaths(int[][] edges, int V, int src, int dest) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        int[] dp = new int[V];
        Arrays.fill(dp, -1);

        return dfsMemo(graph, src, dest, dp);
    }

    private int dfsMemo(List<List<Integer>> graph, int current, int dest, int[] dp) {
        if (current == dest) return 1;

        if (dp[current] != -1) return dp[current]; 

        int count = 0;
        for (int neighbor : graph.get(current)) {
            count += dfsMemo(graph, neighbor, dest, dp);
        }

        dp[current] = count;
        return count;
    }
}
