package graph;

public abstract class ValidTree {
    private static final ValidTreeTest testCase1 = new ValidTreeTest(5,
            new int[][] {{0,1}, {0,2}, {0,3}, {1,4}});
    private static final ValidTreeTest testCase2 = new ValidTreeTest(5,
            new int[][] {{0,1}, {0,2}, {3,4}});
    private static final ValidTreeTest testCase3 = new ValidTreeTest(5,
            new int[][] {{0,1}, {1,2}, {2,3}, {3,4}, {3,0}});
    private static final ValidTreeTest testCase4 = new ValidTreeTest(6,
            new int[][] {{0,1}, {1,2}, {3,4}, {5,4}});
    private static final ValidTreeTest testCase5 = new ValidTreeTest(7,
            new int[][] {{0,1}, {0,2}, {0,3}, {2,4}, {2,5}, {3,6}});

    public abstract boolean validTree(int n, int[][] edges);

    public static void main(String args[]) {
        // Test DFS valid tree
        ValidTree validTreeDFS = new ValidTreeDFS();
        // valid
        System.out.println(validTreeDFS.validTree(testCase1.n, testCase1.edges));
        System.out.println(validTreeDFS.validTree(testCase5.n, testCase5.edges));

        // not valid
        System.out.println(validTreeDFS.validTree(testCase2.n, testCase2.edges));
        System.out.println(validTreeDFS.validTree(testCase3.n, testCase3.edges));
        System.out.println(validTreeDFS.validTree(testCase4.n, testCase4.edges));

    }

    static class ValidTreeTest {
        int n;
        int[][] edges;

        public ValidTreeTest(int n, int[][] edges) {
            this.n = n;
            this.edges = edges;
        }
    }
}
