package discrete;


import org.junit.jupiter.api.Test;

public class DiscreteTraversalTest {

    @Test
    public void longestConsecutiveInteger() {
        int[] testCase1 = {1,1,1,2,2,2,3,3,3};
        int[] testCase2 = {-1,0,1,2,3};
        int[] testCase3 = {0};
        int[] testCase4 = {1,3,5,9,4,0,2};
        int[] testCase5 = {-1,-2,-3,2,3,4,5,1};

        assert DiscreteTraversal.longestConsecutiveInteger(testCase1) == 3;
        assert DiscreteTraversal.longestConsecutiveInteger(testCase2) == 5;
        assert DiscreteTraversal.longestConsecutiveInteger(testCase3) == 1;
        assert DiscreteTraversal.longestConsecutiveInteger(testCase4) == 6;
        assert DiscreteTraversal.longestConsecutiveInteger(testCase5) == 5;
    }
}
