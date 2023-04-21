/*
 
Topic:- Shift 2D Grid

Link:- https://leetcode.com/problems/shift-2d-grid/

Problem:-

Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.

In one shift operation:

Element at grid[i][j] moves to grid[i][j + 1].
Element at grid[i][n - 1] moves to grid[i + 1][0].
Element at grid[m - 1][n - 1] moves to grid[0][0].
Return the 2D grid after applying shift operation k times.

Example 1:

Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
Output: [[9,1,2],[3,4,5],[6,7,8]]
Example 2:

Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
Example 3:

Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
Output: [[1,2,3],[4,5,6],[7,8,9]]
 
Constraints:

m == grid.length
n == grid[i].length
1 <= m <= 50
1 <= n <= 50
-1000 <= grid[i][j] <= 1000
0 <= k <= 100




Solution:-
*/
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> Final_List=new ArrayList<List<Integer>>();
        k = k % (grid.length*grid[0].length);
        int[] arr=new int[grid.length*grid[0].length];
        int index=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                arr[index++]=grid[i][j];
            }
        }
        reverseArray(arr,0,arr.length-1);
        reverseArray(arr,0,k-1);
        reverseArray(arr,k,arr.length-1);
        int index1=0;
        for(int i=0;i<grid.length;i++)
        {
            ArrayList<Integer> list=new ArrayList<Integer>();
            for(int j=0;j<grid[i].length;j++)
            {
                list.add(arr[index1++]);
            }
            Final_List.add(list);
        }
        return Final_List;
    }
    public static void reverseArray(int[] arr,int start, int end)
    {
        while(start<end)
        {
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}
