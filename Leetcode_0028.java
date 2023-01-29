/*
Topic:-  Intersection of Two Arrays II

Link:- https://leetcode.com/problems/intersection-of-two-arrays-ii/

Problem:-

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 

Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

Solution:-
*/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] hash = new int[1001];
        int[] store = new int[1001];
        int index = 0;

        for (int i = 0; i < nums1.length; i++) {
            hash[nums1[i]]++;
        }

        for (int i = 0; i < nums2.length; i++) {
            int candidate = nums2[i];

            if (hash[candidate] > 0) {
                hash[candidate]--;
                store[index++] = candidate;
            }
        }

        int[] answer = new int[index];

        System.arraycopy(store, 0, answer, 0, index);

        return answer;
    }

}
