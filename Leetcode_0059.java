/*

Topic:- Sort an Array

Link:- https://leetcode.com/problems/sort-an-array/description/

Problem:-

Given an array of integers nums, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.

Example 1:

Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
Example 2:

Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
Explanation: Note that the values of nums are not necessairly unique.
 

Constraints:

1 <= nums.length <= 5 * 104
-5 * 104 <= nums[i] <= 5 * 104



Solution:-
*/
class Solution{
public int[] sortArray(int[] nums) {
    mergeSort(nums,0,nums.length-1);
    return nums;
}
public static void mergeFun(int[] arr, int l, int m, int r) {
    int n1 = m + 1 - l;
    int n2 = r - m;
    int[] left = new int[n1];
    for (int i = 0; i < n1; i++) {
        left[i] = arr[l + i];
    }
    int[] right = new int[n2];
    for (int i = 0; i < n2; i++) {
        right[i] = arr[m + 1 + i];
    }
    int i = 0, j = 0, k = l;
    while (i < n1 || j < n2) {
        if (j == n2 || i < n1 && left[i] < right[j])
            arr[k++] = left[i++];
        else
            arr[k++] = right[j++];
    }
}

public static void mergeSort(int[] arr, int low, int high) {
    if (low < high) {
        int middle = (high - low) / 2 + low;
        mergeSort(arr, low, middle);
        mergeSort(arr, middle + 1, high);
        mergeFun(arr, low, middle, high);
    }
}
}
