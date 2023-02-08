/*
Topic:- Array Partition

Link:- https://leetcode.com/problems/array-partition/

Problem:-

Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.

Example 1:

Input: nums = [1,4,3,2]
Output: 4
Explanation: All possible pairings (ignoring the ordering of elements) are:
1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
So the maximum possible sum is 4.
Example 2:

Input: nums = [6,2,6,5,1,2]
Output: 9
Explanation: The optimal pairing is (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9.
 

Constraints:

1 <= n <= 104
nums.length == 2 * n
-104 <= nums[i] <= 104



Solution:-
*/
class Solution {
          public static final int MIN_N = -10000;
  public static final int MAX_N = 10000;
  
  private static final int counts[] = new int[MAX_N-MIN_N+1];
    public static int arrayPairSum(int[] nums) {
    
      int minN = nums[0];
      int maxN = minN;
      
      for (final int n: nums) {
        ++Solution.counts[n - MIN_N];
        if (minN > n) {
          minN = n;
        } else if (maxN < n) {
          maxN = n;
        }
      }
      
      int offset = 0;
        
      int total = 0;
    
      for (int n = minN; n <= maxN; ++n) {
        int i = n - MIN_N;
        final int freq = Solution.counts[i];
        
        if (freq > 0) {
          if (freq - offset > 0) {
            total += ((freq + 1 - offset) >> 1) * n;
          }
          Solution.counts[i] = 0;
          offset ^= freq & 1;
        }
      }
      
      return total;
  }
}
