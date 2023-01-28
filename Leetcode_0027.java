/*
Topic:-  Intersection of Two Arrays

Link:- https://leetcode.com/problems/intersection-of-two-arrays/description/

Problem:-
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]

Explanation: [4,9] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000


Solution:-
*/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

		int L = Math.min(nums1.length, nums2.length);
		
		int result[] = new int[L];

		int hashArr[] = new int[1001];

		for (int i = 0; i < nums1.length; i++) {
			hashArr[nums1[i]] = 1; 
		}

		int j = 0; // store length of the intersection array
		
		for (int i = 0; i < nums2.length; i++) {
			if (hashArr[nums2[i]] == 1) 
			{
				hashArr[nums2[i]] = 0; 
				result[j] = nums2[i]; 
				j++; 
			}
		}

		// Trimming the intersection array to j length
		int intersection[] = new int[j]; 
		
		for (int i = 0; i < j; i++) {
			intersection[i] = result[i];
		}
		
		return intersection;        
    }
}
