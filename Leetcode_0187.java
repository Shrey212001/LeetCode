/*

Topic:- Two Out of Three

Link:- https://leetcode.com/problems/two-out-of-three/description/

Problem:-

Given three integer arrays nums1, nums2, and nums3, return a distinct array containing all the values that are present in at least two out of the three arrays. You may return the values in any order.

Example 1:

Input: nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
Output: [3,2]
Explanation: The values that are present in at least two arrays are:
- 3, in all three arrays.
- 2, in nums1 and nums2.
Example 2:

Input: nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
Output: [2,3,1]
Explanation: The values that are present in at least two arrays are:
- 2, in nums2 and nums3.
- 3, in nums1 and nums2.
- 1, in nums1 and nums3.
Example 3:

Input: nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
Output: []
Explanation: No value is present in at least two arrays.
 
Constraints:

1 <= nums1.length, nums2.length, nums3.length <= 100
1 <= nums1[i], nums2[j], nums3[k] <= 100




Solution:-
*/
class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int n1 = nums1.length , n2 = nums2.length , n3 = nums3.length;
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        HashSet<Integer> set3 = new HashSet<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < n1 ; i++){
            if(set1.add(nums1[i])){
                map.put(nums1[i], map.getOrDefault(nums1[i],0)+1);
            }
        }
        for(int i = 0 ; i < n2 ; i++){
            if(set2.add(nums2[i])){
                map.put(nums2[i], map.getOrDefault(nums2[i],0)+1);
            }
        }
        for(int i = 0 ; i < n3 ; i++){
            if(set3.add(nums3[i])){
                map.put(nums3[i], map.getOrDefault(nums3[i],0)+1);
            }
        }
        List<Integer> ans = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>(set1);
        ArrayList<Integer> list2 = new ArrayList<>(set2);
        ArrayList<Integer> list3 = new ArrayList<>(set3);
        for (int i = 0; i < list1.size(); i++) {
            if (map.get(list1.get(i))>1) {
                ans.add(list1.get(i));
                map.put(list1.get(i),0);
            }
        }
        for (int i = 0; i < list2.size(); i++) {
            if (map.get(list2.get(i))>1) {
                ans.add(list2.get(i));
                map.put(list2.get(i),0);
            }
        }
        for (int i = 0; i < list3.size(); i++) {
            if (map.get(list3.get(i))>1){
                ans.add(list3.get(i));
                map.put(list3.get(i),0);
            }
        }
        return ans;
    }
}
