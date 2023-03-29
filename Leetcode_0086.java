/*

Topic:- Largest Perimeter Triangle

Link:- https://leetcode.com/problems/largest-perimeter-triangle/description/

Problem:-

Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.

Example 1:

Input: nums = [2,1,2]
Output: 5
Explanation: You can form a triangle with three side lengths: 1, 2, and 2.
Example 2:

Input: nums = [1,2,1,10]
Output: 0
Explanation: 
You cannot use the side lengths 1, 1, and 2 to form a triangle.
You cannot use the side lengths 1, 1, and 10 to form a triangle.
You cannot use the side lengths 1, 2, and 10 to form a triangle.
As we cannot use any three side lengths to form a triangle of non-zero area, we return 0.
 
Constraints:

3 <= nums.length <= 104
1 <= nums[i] <= 106





Solution:-
*/
class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int per=0;// case where triangle will not be formed will be handled by per=0;
        for(int i=nums.length-1;i>=2; i--)
        {
            if(nums[i-1]+nums[i-2]>nums[i])
            {
                per=nums[i]+nums[i-1]+nums[i-2];
                break;
            }
            
        }
        return per;
    }
}
