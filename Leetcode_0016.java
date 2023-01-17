/*
Topic:-  Pascal's Triangle

Link:- https://leetcode.com/problems/pascals-triangle/description/

Problem:-

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 

Constraints:

1 <= numRows <= 30


Solution:-
*/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i =0;i<numRows;i++){
            List<Integer> store = new ArrayList<>();
            int val =1;
            int k =1;
            store.add(val);
            if(i==0){
                ans.add(store);
                continue;
            }
        
            for(int j =0;j<i;j++){
                val = ((i-j)*k)/(j+1);
                store.add(val);
                k = val;
            }
            ans.add(store);
        }
        return ans;
    }
}
