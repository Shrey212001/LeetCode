/*

Topic:- Check If It Is a Straight Line

Link:- https://leetcode.com/problems/check-if-it-is-a-straight-line/submissions/936384135/

Problem:-

You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

Example 1:

Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Example 2:

Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
 
Constraints:

2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.





Solution:-
*/
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        if(n == 1 || n == 2) return true;
        double x1=coordinates[0][0],y1=coordinates[0][1];
        double x2=coordinates[1][0],y2=coordinates[1][1];
        double slope ;
        double x = x2-x1;
        if(x == 0) slope = -111111;
        else slope = (y2-y1)/(x);        
        for(int i = 2;i<n;i++){
            x1=coordinates[i-1][0];
            y1=coordinates[i-1][1];
            x2=coordinates[i][0];
            y2=coordinates[i][1];
             x = x2-x1;
             double m ;
            if( x== 0) m = -111111;
            else m = (y2-y1)/(x);
            
            if( m!=slope ) return false;

        }
      return true;

    }
}
