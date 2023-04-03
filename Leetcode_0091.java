/*

Topic:- Find Common Characters

Link:- https://leetcode.com/problems/find-common-characters/description/

Problem:-

Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order. 

Example 1:

Input: words = ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: words = ["cool","lock","cook"]
Output: ["c","o"] 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of lowercase English letters.




Solution:-
*/

class Solution {
    public List<String> commonChars(String[] words) {
        List<HashMap<Character,Integer>> list = new ArrayList<>();
        for(String s: words){
            HashMap<Character,Integer> map = new HashMap<>();
            for(char ch: s.toCharArray()){
                map.put(ch, map.getOrDefault(ch,0)+1);
            }
            list.add(map);
        }
        List<String> ans = new ArrayList<>();
        for(char ch : list.get(0).keySet()) {
            int min = Integer.MAX_VALUE;
            for (HashMap<Character, Integer> map : list) {
                if (!map.containsKey(ch)) {
                    min = 0;
                    break;
                }
                min = Math.min(min, map.get(ch));
            }
            for (int i = 0; i < min; i++) {
                ans.add(String.valueOf(ch));
            }
        }
        return ans;
    }
}
