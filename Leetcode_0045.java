/*
Topic:- Maximum Product of Three Numbers

Link:- https://leetcode.com/problems/maximum-product-of-three-numbers/

Problem:-

Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

Example 1:

Input: nums = [1,2,3]
Output: 6
Example 2:

Input: nums = [1,2,3,4]
Output: 24
Example 3:

Input: nums = [-1,-2,-3]
Output: -6
 

Constraints:

3 <= nums.length <= 104
-1000 <= nums[i] <= 1000



Solution:-
*/
class Solution {
    public int maximumProduct(int[] nums) {
        /**
        max prod can be either product of 3 max numbers or product of 2 min (-ves) and 1 max
         */
        int n = nums.length;
        // Arrays.sort(nums);
        // return Math.max(nums[0] * nums[1] * nums[n-1], nums[n-1] * nums[n-2] * nums[n-3]);

        int mx1 = Integer.MIN_VALUE, mx2 = Integer.MIN_VALUE, mx3 = Integer.MIN_VALUE;
        int mn1 = Integer.MAX_VALUE, mn2 = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] > mx3) {
                if (nums[i] > mx2) {
                    if (nums[i] > mx1) { // bigger than the largest val
                        mx3 = mx2;
                        mx2 = mx1;
                        mx1 = nums[i];
                    } else {
                        mx3 = mx2;
                        mx2 = nums[i];
                    }
                } else {
                    mx3 = nums[i];
                }
            }
            if (nums[i] < mn2) {
                if (nums[i] < mn1) {
                    mn2 = mn1;
                    mn1 = nums[i];
                } else {
                    mn2 = nums[i];
                }
            }
        }

        return Math.max(mx1 * mx2 * mx3, mx1 * mn1 * mn2);
    }
}
