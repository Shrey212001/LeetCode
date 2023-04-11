/*

Topic:- Duplicate Zeros

Link:- https://leetcode.com/problems/duplicate-zeros/

Problem:-

Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.

Example 1:

Input: arr = [1,0,2,3,0,4,5,0]
Output: [1,0,0,2,3,0,0,4]
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
Example 2:

Input: arr = [1,2,3]
Output: [1,2,3]
Explanation: After calling your function, the input array is modified to: [1,2,3]
 
Constraints:

1 <= arr.length <= 104
0 <= arr[i] <= 9




Solution:-
*/

class Solution {
    public void duplicateZeros(int[] arr) {
        int nZe =0;
        for(int i : arr) {
            if(i==0) nZe++;
        }
        int i = arr.length-1;
        int j = arr.length+nZe-1;
        while(i!=j) {
            insert(arr,i,j);
            j--;
            if(arr[i]==0) {
                insert(arr,i,j);
                j--;
            }
            i--;
        }
    }
    void insert(int[] arr, int i, int j) {
        if(j<arr.length) {
            arr[j] = arr[i];
        }
    }
}
