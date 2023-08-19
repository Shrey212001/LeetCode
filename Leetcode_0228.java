/*

Topic:- Most Frequent Even Element

Link:- https://leetcode.com/problems/most-frequent-even-element/description/

Problem:-

Given an integer array nums, return the most frequent even element.

If there is a tie, return the smallest one. If there is no such element, return -1.

Example 1:

Input: nums = [0,1,2,2,4,4,1]
Output: 2
Explanation:
The even elements are 0, 2, and 4. Of these, 2 and 4 appear the most.
We return the smallest one, which is 2.
Example 2:

Input: nums = [4,4,4,9,2,4]
Output: 4
Explanation: 4 is the even element appears the most.
Example 3:

Input: nums = [29,47,21,41,13,37,25,7]
Output: -1
Explanation: There is no even element.
 

Constraints:

1 <= nums.length <= 2000
0 <= nums[i] <= 105




Solution:-
*/
class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int maxFreq = 0;
        int element = Integer.MAX_VALUE;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]%2==0){
                int curr = map.getOrDefault(nums[i],0)+1;
                map.put(nums[i],curr);
                if(curr > maxFreq  || (curr == maxFreq && nums[i]<element)){
                    maxFreq = curr;
                    element = nums[i];
                }
            }
        }

        return maxFreq==0 ? -1 : element;
    }
}
