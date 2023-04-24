/*

Topic:- Element Appearing More Than 25% In Sorted Array

Link:- https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/

Problem:-

Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time, return that integer.

Example 1:

Input: arr = [1,2,2,6,6,6,6,7,10]
Output: 6
Example 2:

Input: arr = [1,1]
Output: 1
 
Constraints:

1 <= arr.length <= 104
0 <= arr[i] <= 105




Solution:-
*/
class Solution {
    public int findSpecialInteger(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int max = Integer.MIN_VALUE;
        int result = 0;

        for(int i : arr) map.put(i, map.getOrDefault(i, 0) + 1);

        for(int i : map.keySet()){
            max = Math.max(max,map.get(i));
        }
        for(int i : map.keySet()){
            if(max == map.get(i)) result = i;
        }

        return result;
    }
}
