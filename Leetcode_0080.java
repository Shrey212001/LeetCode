/*

Topic:- Sort Array By Parity II

Link:- https://leetcode.com/problems/sort-array-by-parity-ii/description/

Problem:-

Given an array of integers nums, half of the integers in nums are odd, and the other half are even.

Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.

Return any answer array that satisfies this condition.

Example 1:

Input: nums = [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
Example 2:

Input: nums = [2,3]
Output: [2,3]
 
Constraints:

2 <= nums.length <= 2 * 104
nums.length is even.
Half of the integers in nums are even.
0 <= nums[i] <= 1000



Solution:-
*/
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        
        for (int n : A) {
            if (n % 2 == 0)
                even.add(n);
            else 
                odd.add(n);
        }
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                result[i] = even.remove(0);
            } else {
                result[i] = odd.remove(0);
            }
        }
        return result;
    }
}
