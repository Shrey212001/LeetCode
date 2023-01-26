/*
Topic:- Move Zeroes

Link:- https://leetcode.com/problems/move-zeroes/

Problem:-

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 

Follow up: Could you minimize the total number of operations done?


Solution:-
*/
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int zeroStartIdx = -1;
        for(int i=0;i<n;i++){
            if(nums[i] != 0 && zeroStartIdx > -1){
                nums[zeroStartIdx] = nums[i];
                nums[i] = 0;
                zeroStartIdx++;
            }else{
                if(nums[i] == 0 && zeroStartIdx == -1){zeroStartIdx = i;}
            }
        }
        System.gc();
    }
}
