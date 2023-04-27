/*

Topic:- Find N Unique Integers Sum up to Zero

Link:- https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/description/

Problem:-

Given an integer n, return any array containing n unique integers such that they add up to 0.

Example 1:

Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
Example 2:

Input: n = 3
Output: [-1,0,1]
Example 3:

Input: n = 1
Output: [0]
 
Constraints:

1 <= n <= 1000




Solution:-
*/
class Solution {
    public int[] sumZero(int n) {
        int arr[]=new int[n];
        for(int i=1;i<n;i+=2){
            int val=i-(2*i);//-1,-2,-3....-n last 0;
            int val2=i;//1,2,3,4....n;
            arr[i]=val;
            arr[i-1]=val2;
        }
        return arr;
    }
}
