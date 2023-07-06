package graph;

import java.util.ArrayList;
import java.util.List;

public class ValidTreeDFS extends ValidTree {
    @Override
    public boolean validTree(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<Integer>[] adj = buildAdj(n, edges);
        // cycle detection
        boolean hasCycle = dfsCycleDetection(adj, visited, -1, 0);

        return !hasCycle && isAllTrue(visited);
    }

    public static boolean isAllTrue(boolean[] array) {
        for (boolean b : array) if(!b) return false;
        return true;
    }

    private List<Integer>[] buildAdj(int n, int[][] edges) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        return adj;
    }
    private boolean dfsCycleDetection(List<Integer>[] adj, boolean[] visited, int prev, int start) {
        if (visited[start]) {
            return true;
        }
        visited[start] = true;
        for (int neighbor : adj[start]) {
            if (neighbor != prev) {
                if (dfsCycleDetection(adj, visited, start, neighbor))
                    return true;
            }
        }
        return false;
    }
}
