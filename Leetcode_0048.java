/*

Topic:- Image Smoother

Link:- https://leetcode.com/problems/image-smoother/

Problem:-

An image smoother is a filter of the size 3 x 3 that can be applied to each cell of an image by rounding down the average of the cell and the eight surrounding cells (i.e., the average of the nine cells in the blue smoother). If one or more of the surrounding cells of a cell is not present, we do not consider it in the average (i.e., the average of the four cells in the red smoother).

Given an m x n integer matrix img representing the grayscale of an image, return the image after applying the smoother on each cell of it. 

Example 1:


Input: img = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[0,0,0],[0,0,0],[0,0,0]]
Explanation:
For the points (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the points (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0
Example 2:


Input: img = [[100,200,100],[200,50,200],[100,200,100]]
Output: [[137,141,137],[141,138,141],[137,141,137]]
Explanation:
For the points (0,0), (0,2), (2,0), (2,2): floor((100+200+200+50)/4) = floor(137.5) = 137
For the points (0,1), (1,0), (1,2), (2,1): floor((200+200+50+200+100+100)/6) = floor(141.666667) = 141
For the point (1,1): floor((50+200+200+200+200+100+100+100+100)/9) = floor(138.888889) = 138
 

Constraints:

m == img.length
n == img[i].length
1 <= m, n <= 200
0 <= img[i][j] <= 255



Solution:-
*/
class Solution {
    public int[][] imageSmoother(int[][] M) {
        int rowLast = M.length - 1;
        int colLast = M[0].length - 1;
        if (rowLast == 0) {     
            if (colLast != 0)  singleRow(M[0], colLast);
        }
     
        else if (colLast == 0) {  
            singleCol(M, rowLast);
        }
              else {                    
            for (int row = 0; row <= rowLast; row++)    
                sumRow(M[row], colLast);
            sumCol(M, 0, 4, 6, rowLast);                
            sumCol(M, colLast, 4, 6, rowLast);         
            for (int col = 1; col < colLast; col++)     
                sumCol(M, col, 6, 9, rowLast);
        }

        return M;
    }
    
    private void singleRow(int[] MR, int colLast) {
        int prev = 0;
        int curr = MR[0];
        int next = MR[1];
        MR[0] = (curr + next) / 2;
        for (int col = 1; col < colLast; col++) {
            prev = curr;
            curr = next;
            next = MR[col+1];
            MR[col] = (prev + curr + next) / 3;
        }
        MR[colLast] = (next + curr) / 2;
    }

    private void singleCol(int[][] M, int rowLast) {
        int prev = 0;
        int curr = M[0][0];
        int next = M[1][0];
        M[0][0] = (curr + next) / 2;
        for (int row = 1; row < rowLast; row++) {
            prev = curr;
            curr = next;
            next = M[row+1][0];
            M[row][0] = (prev + curr + next) / 3;
        }
        M[rowLast][0] = (next + curr) / 2;
    }
    
    private void sumRow(int[] MR, int colLast) {
        int prev = 0;
        int curr = 0;
        int next = MR[0];
        for (int col = 0; col < colLast; col++) {
            prev = curr;
            curr = next;
            next = MR[col+1];
            MR[col] = prev + curr + next;
        }
        MR[colLast] = next + curr;
    }
    private void sumCol(int[][] M, int col, int endDiv, int midDiv, int rowLast) {
        int prev = 0;
        int curr = M[0][col];
        int next = M[1][col];
        M[0][col] = (curr + next) / endDiv;
        for (int row = 1; row < rowLast; row++) {
            prev = curr;
            curr = next;
            next = M[row+1][col];
            M[row][col] = (prev + curr + next) / midDiv;
        }
        M[rowLast][col] = (next + curr) / endDiv;
    }
}
