/*

Topic:-  Number of Equivalent Domino Pairs

Link:- https://leetcode.com/problems/number-of-equivalent-domino-pairs/

Problem:-

Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a == c and b == d), or (a == d and b == c) - that is, one domino can be rotated to be equal to another domino.

Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].

Example 1:

Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
Output: 1
Example 2:

Input: dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]]
Output: 3
 

Constraints:

1 <= dominoes.length <= 4 * 104
dominoes[i].length == 2
1 <= dominoes[i][j] <= 9



Solution:-
*/
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] counter = new int[100];
        for (int[] d : dominoes) {
            int v = d[0] > d[1] ? d[0] * 10 + d[1] : d[1] * 10 + d[0];
            ++counter[v];
        }
        int ans = 0;
        for (int c : counter) {
            ans += c * (c - 1) / 2;
        }
        return ans;
    }
}
