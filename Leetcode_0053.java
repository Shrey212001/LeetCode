/*

Topic:- Binary Search

Link:- https://leetcode.com/problems/binary-search/

Problem:-

Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity. 

Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 

Constraints:

1 <= nums.length <= 104
-104 < nums[i], target < 104
All the integers in nums are unique.
nums is sorted in ascending order.



Solution:-
*/

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, h = n-1;
        int p = 0;
        while(l<=h){
            p = l+(h-l)/2;
            if(nums[p]==target)
                return p;
            if(target<nums[p])
                h = p-1;
            else
                l = p+1;
        }
        return -1;
    }
}
