/*

Topic:- Sort Array by Increasing Frequency

Link:- https://leetcode.com/problems/sort-array-by-increasing-frequency/submissions/961469058/

Problem:-

Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.

Return the sorted array.

Example 1:

Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
Example 2:

Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
Example 3:

Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]
 
Constraints:

1 <= nums.length <= 100
-100 <= nums[i] <= 100




Solution:-
*/
class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> tempList = new TreeMap<>();
        Map<Integer, ArrayList<Integer>> countList = new TreeMap<>();
        for(int a: nums){
           if(tempList.containsKey(a)) tempList.put(a, tempList.get(a)+1);
           else tempList.put(a,1);
        } 
        for(Map.Entry<Integer,Integer> entry: tempList.entrySet()){
            int val = entry.getValue(); int key = entry.getKey();
            if(!countList.containsKey(val)) countList.put(val, new ArrayList<Integer>());
            countList.get(val).add(key);
        }

        int index = 0;
        for(Map.Entry<Integer,ArrayList<Integer>> entry: countList.entrySet()){
            int val = entry.getKey(); ArrayList<Integer> array = entry.getValue();
            Collections.sort(array);
            for(int a = array.size()-1; a>-1; a--){
                int value = array.get(a);
                for(int b = 0; b < val; b++){
                    nums[index] = value;
                    index++;
                }
            }
        }
        return nums;
    }
}
