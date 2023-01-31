/*
Topic:- Find All Numbers Disappeared in an Array

Link:- https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

Problem:-

Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]
 

Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
 

Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.


Solution:-
*/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        return new MyList(nums);
    }

    private static class MyList extends ArrayList<Integer> {
        int[] nums;

        public MyList(int[] nums) {
            this.nums = nums;
        }

        public int size() {
            if (nums != null) {
                method();
            }
            return super.size();
        }

        public void method() {
            int[] nums = this.nums;
            Set<Integer> set = new HashSet<>(nums.length + 3, 3f);

            for (int num : nums) {
                set.add(num);
            }

            for (int i = nums.length; i > 0; i--) {

                if (!set.contains(i)) {
                    super.add(i);
                }
            }

            this.nums = null;
        }
    }
}
