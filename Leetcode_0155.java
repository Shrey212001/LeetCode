/*

Topic:- Check If Two String Arrays are Equivalent

Link:- https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/description/

Problem:-

Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.

A string is represented by an array if the array elements concatenated in order forms the string.

Example 1:

Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
Output: true
Explanation:
word1 represents string "ab" + "c" -> "abc"
word2 represents string "a" + "bc" -> "abc"
The strings are the same, so return true.
Example 2:

Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
Output: false
Example 3:

Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
Output: true
 
Constraints:

1 <= word1.length, word2.length <= 103
1 <= word1[i].length, word2[i].length <= 103
1 <= sum(word1[i].length), sum(word2[i].length) <= 103
word1[i] and word2[i] consist of lowercase letters.




Solution:-
*/
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) 
    {
        int wordIdx1 = 0, wordIdx2 = 0, chIdx1 = 0, chIdx2 = 0;
        while(true)
        {
            char ch1 = word1[wordIdx1].charAt(chIdx1);
            char ch2 = word2[wordIdx2].charAt(chIdx2);
            if (ch1 != ch2) return false;
            
            chIdx1++;
            chIdx2++;
            if (chIdx1 == word1[wordIdx1].length()) { wordIdx1++; chIdx1 = 0; }
            if (chIdx2 == word2[wordIdx2].length()) { wordIdx2++; chIdx2 = 0; }
            
            if (wordIdx1 == word1.length && wordIdx2 == word2.length) break;
            if (wordIdx1 == word1.length || wordIdx2 == word2.length) return false;
        }
        return true;
        
    }
}
