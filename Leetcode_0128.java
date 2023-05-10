/*

Topic:- String Matching in an Array

Link:- https://leetcode.com/problems/string-matching-in-an-array/description/

Problem:-

Given an array of string words, return all strings in words that is a substring of another word. You can return the answer in any order.

A substring is a contiguous sequence of characters within a string

Example 1:

Input: words = ["mass","as","hero","superhero"]
Output: ["as","hero"]
Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
["hero","as"] is also a valid answer.
Example 2:

Input: words = ["leetcode","et","code"]
Output: ["et","code"]
Explanation: "et", "code" are substring of "leetcode".
Example 3:

Input: words = ["blue","green","bu"]
Output: []
Explanation: No string of words is substring of another string.
 
Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 30
words[i] contains only lowercase English letters.
All the strings of words are unique.




Solution:-
*/
class Solution {

    public List<String> stringMatching(String[] words) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].contains(words[j])) {
                    result.add(words[j]);
                } else if (words[j].contains(words[i])) {
                    result.add(words[i]);
                }
            }
        }

        return new ArrayList<>(result);
    }
}
