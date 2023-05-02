/*

Topic:- Count Negative Numbers in a Sorted Matrix

Link:- https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

Problem:-

Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.

Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100
-100 <= grid[i][j] <= 100
 

Follow up: Could you find an O(n + m) solution?




Solution:-
*/
class Solution {
    public int countNegatives(int[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++)
        {
            ans+=negativeEachRow(grid[i]);
        }
        return ans;
    }

    public int negativeEachRow(int row[])
    {
        int ans=0;
        int l=0, h=row.length-1;
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            if(row[mid]>=0)
                l=mid+1;
            else if(row[mid]<0)
            {
                ans+=h-mid+1;
                h=mid-1;
            }
        }
        return ans;
    }
}
