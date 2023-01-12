/*
Topic:- Search Insert Position

Link:- https://leetcode.com/problems/search-insert-position/description/

Problem:-
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.


Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104


Solution:-
*/
class Solution {
    public int searchInsert(int[] nums, int target)
    {
        if(nums[0]>target)return 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==target)
                return i;
            else if(nums[i]<target)
            {
                if(i+1<nums.length&&target<nums[i+1])
                {
                    return i+1;
                }
            }
        }
        return nums.length;
    }
}
