package discrete;

import java.util.HashSet;
import java.util.Set;


public class DiscreteTraversal {

    /**
     * @param l input int list
     * @return length of longest consecutive integer sequence
     * 1. consecutive integer means different sequences are disjoint
     * 2. each consecutive sequence has only one start
     * 3. different consecutive sequences have different starts
     * 4. ==> iterate start and traverse from each start; each element in l is traversed exactly once
     */
    public static int longestConsecutiveInteger(int[] l) {
        if (l == null)
            return 0;
        Set<Integer> collisionSet = new HashSet<>();
        for (int x : l) {
            collisionSet.add(x);
        }
        int maxLength = 0;
        for (int x : l) {
            // check if x is start
            if (!collisionSet.contains(x-1)) {
                // length of consecutive sequence with x as start
                int currentLength = 0;
                while(collisionSet.contains(x++))
                    currentLength++;
                maxLength = Math.max(currentLength,maxLength);
            }
        }
        return maxLength;
    }
}
