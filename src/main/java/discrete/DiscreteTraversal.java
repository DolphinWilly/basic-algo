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

    /**
     * @param s the input string
     * @return the longest palindromic substring
     *
     * if the structure can be recursively buildup in terms of length,
     * we can try iterating on length
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        int n = s.length();
        String ans = "";
        boolean[][] dp = new boolean[n][n];
        int ml = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j+i-1 < n; j++) {
                if (i==1) {
                    dp[j][j+i-1] = true;
                } else if (i==2) {
                    dp[j][j+i-1] = s.charAt(j) == s.charAt(j+i-1);
                } else {
                    dp[j][j+i-1] = (s.charAt(j) == s.charAt(j+i-1)) && dp[j+1][j+i-2];
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j+i-1 < n; j++) {
                if (dp[j][j+i-1]) {
                    if (i > ml) {
                        ans = s.substring(j,i+j);
                        ml = i;
                    }
                }
            }
        }
        return ans;
    }
}
