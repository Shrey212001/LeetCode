/*
Topic:- Can Place Flowers

Link:- https://leetcode.com/problems/can-place-flowers/

Problem:-

You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
 

Constraints:

1 <= flowerbed.length <= 2 * 104
flowerbed[i] is 0 or 1.
There are no two adjacent flowers in flowerbed.
0 <= n <= flowerbed.length


Solution:-
*/
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0) {
            return false;
        }
        
        int len = flowerbed.length;
        int count = 1;  // count the number of continous empty plots.
        int rst = 0;    // the total number of empty plots that coule be planted.
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0) {
                count++;
            } else {
                rst += (count - 1) / 2;
                count = 0;
            }
        }
        
        if (count != 0) {
            rst += count / 2;
        }
        
        return rst >= n;
    }
}
