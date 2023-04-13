/*

Topic:-Find Words That Can Be Formed by Characters

Link:- https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/

Problem:-

You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.

Example 1:

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
Example 2:

Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation: The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 

Constraints:

1 <= words.length <= 1000
1 <= words[i].length, chars.length <= 100
words[i] and chars consist of lowercase English letters.





Solution:-
*/
class Solution {
  public int countCharacters(String[] words, String chars) {
    int ans = 0;
    int[] count = new int[26];

    for (final char c : chars.toCharArray())
      ++count[c - 'a'];

    for (final String word : words) {
      int[] tempCount = count.clone();
      for (final char c : word.toCharArray())
        if (--tempCount[c - 'a'] < 0) {
          ans -= word.length();
          break;
        }
      ans += word.length();
    }

    return ans;
  }
}
