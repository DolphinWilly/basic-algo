package graph;

public class ValidTreeUnionFind extends ValidTree {

    @Override
    public boolean validTree(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        // go over each edge, and union it.
        // if they are already connected by find before union, we have a cycle
        // if no cycle, we iterate if every node is connected to node 0 to verify connectivity
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if (unionFind.find(edge[0], edge[1]))
                return false;
            unionFind.union(edge[0], edge[1]);
        }
        for (int i = 0; i < n; i++) {
            if (!unionFind.find(0,i))
                return false;
        }
        return true;
    }

    class UnionFind {
        private int n;
        private int[] size;
        private int[] parent;
        public UnionFind(int n) {
            this.size = new int[n];
            this.parent = new int[n];
            for (int i = 0; i <n ; i++) {
                this.size[i] = 1;
                this.parent[i] = i;
            }
        }

        private int root(int node) {
            return node == parent[node] ? node : (parent[node] = root(parent[node]));
        }

        public boolean find(int node1, int node2) {
            return root(node1) == root(node2);
        }

        public void union(int node1, int node2) {
            int root1 = root(node1);
            int root2 = root(node2);
            // append tree 2 to tree 1
            if (size[root1] > size[root2]) {
                parent[root2] =  root1;
                size[root1] += size[root2];
            } else {
                // append tree 1 to tree 2
                parent[root1] = root2;
                size[root2] += size[root1];
            }
        }
    }
}
