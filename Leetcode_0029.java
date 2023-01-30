/*
Topic:-Third Maximum Number

Link:-  https://leetcode.com/problems/third-maximum-number/

Problem:-

Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.

Example 1:

Input: nums = [3,2,1]

Output: 1

Explanation:

The first distinct maximum is 3.
The second distinct maximum is 2.
The third distinct maximum is 1.

Example 2:

Input: nums = [1,2]

Output: 2

Explanation:

The first distinct maximum is 2.
The second distinct maximum is 1.
The third distinct maximum does not exist, so the maximum (2) is returned instead.

Example 3:

Input: nums = [2,2,3,1]

Output: 1

Explanation:

The first distinct maximum is 3.
The second distinct maximum is 2 (both 2's are counted together since they have the same value).
The third distinct maximum is 1.
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1



Solution:-
*/
class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<> ();
        
        for (int num : nums) {
            set.add(num);
            
            if (set.size() == 4) {
                set.pollFirst();
            }
        }
        
        if (set.size() == 3) {
            return set.first();
        }
        
        return set.last();
    }
}
