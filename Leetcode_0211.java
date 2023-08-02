/*

Topic:-Intersection of Multiple Arrays

Link:- https://leetcode.com/problems/intersection-of-multiple-arrays/description/

Problem:-

Given a 2D integer array nums where nums[i] is a non-empty array of distinct positive integers, return the list of integers that are present in each array of nums sorted in ascending order.
 
Example 1:

Input: nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]
Output: [3,4]
Explanation: 
The only integers present in each of nums[0] = [3,1,2,4,5], nums[1] = [1,2,3,4], and nums[2] = [3,4,5,6] are 3 and 4, so we return [3,4].
Example 2:

Input: nums = [[1,2,3],[4,5,6]]
Output: []
Explanation: 
There does not exist any integer present both in nums[0] and nums[1], so we return an empty list [].
 
Constraints:

1 <= nums.length <= 1000
1 <= sum(nums[i].length) <= 1000
1 <= nums[i][j] <= 1000
All the values of nums[i] are unique.




Solution:-
*/
class Solution {
    public List<Integer> intersection(int[][] nums) {
        HashSet<Integer> common= new HashSet<>();
        for(int i=0;i<nums[0].length;i++){
            common.add(nums[0][i]);
        }
            for(int i=1;i<nums.length;i++){
            HashSet<Integer> current= new HashSet<>();
            for(int j=0;j<nums[i].length;j++){
                if(common.contains(nums[i][j]))
                        current.add(nums[i][j]);
            }
            common.retainAll(current);
        }
        List<Integer> ls= new ArrayList<>(common);
        Collections.sort(ls);
        return ls;
    }
}
