/*

Topic:- Count Common Words With One Occurrence

Link:- https://leetcode.com/problems/count-common-words-with-one-occurrence/description/

Problem:-

Given two string arrays words1 and words2, return the number of strings that appear exactly once in each of the two arrays.

Example 1:

Input: words1 = ["leetcode","is","amazing","as","is"], words2 = ["amazing","leetcode","is"]
Output: 2
Explanation:
- "leetcode" appears exactly once in each of the two arrays. We count this string.
- "amazing" appears exactly once in each of the two arrays. We count this string.
- "is" appears in each of the two arrays, but there are 2 occurrences of it in words1. We do not count this string.
- "as" appears once in words1, but does not appear in words2. We do not count this string.
Thus, there are 2 strings that appear exactly once in each of the two arrays.
Example 2:

Input: words1 = ["b","bb","bbb"], words2 = ["a","aa","aaa"]
Output: 0
Explanation: There are no strings that appear in each of the two arrays.
Example 3:

Input: words1 = ["a","ab"], words2 = ["a","a","a","ab"]
Output: 1
Explanation: The only string that appears exactly once in each of the two arrays is "ab".
 
Constraints:

1 <= words1.length, words2.length <= 1000
1 <= words1[i].length, words2[j].length <= 30
words1[i] and words2[j] consists only of lowercase English letters.




Solution:-
*/
class Solution {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String,Integer> hm1 = new HashMap<>();
        HashMap<String,Integer> hm2 = new HashMap<>();
        int numOfWords = 0;

        for(int i=0;i<words1.length;i++) {
            if(hm1.containsKey(words1[i])) {
                hm1.put(words1[i],hm1.get(words1[i])+1);
            } else {
                hm1.put(words1[i],1);
            }
        }

        for(int i=0;i<words2.length;i++) {
            if(hm2.containsKey(words2[i])) {
                hm2.put(words2[i],hm2.get(words2[i])+1);
            } else {
                hm2.put(words2[i],1);
            }
        }

        for(String s : hm1.keySet()) {
            if(hm2.containsKey(s) && hm2.get(s) == 1 && hm1.get(s) == 1) {
                numOfWords++;
            }
        }

        return numOfWords;
    }
}
