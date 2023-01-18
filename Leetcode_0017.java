/*
Topic:- Pascal's Triangle II

Link:- https://leetcode.com/problems/pascals-triangle-ii/

Problem:-

Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:

Input: rowIndex = 0
Output: [1]
Example 3:

Input: rowIndex = 1
Output: [1,1]
 

Constraints:

0 <= rowIndex <= 33

Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?


Solution:-
*/
class Solution {
    public List<Integer> getRow(int rowIndex) {

        int[] arr = new int[rowIndex + 1];

        arr[0] = 1;
        
        for (int i = 1; i <= rowIndex; i++) 
            for (int j = i; j > 0; j--) 
                arr[j] = arr[j] + arr[j - 1];
        
        List<Integer> ans = new ArrayList<>();
        for(int i : arr)
            ans.add(i);
        return ans;
    }
}
