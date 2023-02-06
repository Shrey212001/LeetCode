/*
Topic:- Keyboard Row

Link:- https://leetcode.com/problems/keyboard-row/description/

Problem:-

Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.

In the American keyboard:

the first row consists of the characters "qwertyuiop",
the second row consists of the characters "asdfghjkl", and
the third row consists of the characters "zxcvbnm".
 

Example 1:

Input: words = ["Hello","Alaska","Dad","Peace"]
Output: ["Alaska","Dad"]
Example 2:

Input: words = ["omk"]
Output: []
Example 3:

Input: words = ["adsdf","sfd"]
Output: ["adsdf","sfd"]
 

Constraints:

1 <= words.length <= 20
1 <= words[i].length <= 100
words[i] consists of English letters (both lowercase and uppercase). 



Solution:-
*/
class Solution {
    public String[] findWords(String[] words) {
//         // Map <Character, String> kbMap = new HashMap<>();
//         // kbMap.put("q", )
String row1 = "qwertyuiopQWERTYUIOP" ;
String row2 = "asdfghjklASDFGHJKL";
String row3 = "zxcvbnmZXCVBNM";
List<String> res = new ArrayList<String>();

for(int i =0 ; i< words.length ; i++){
   int count1 = 0, count2 =0, count3=0, len = words[i].length();
   for(int j= 0; j < len; j++ ){
       if(row1.contains(Character.toString(words[i].charAt(j)))){
           count1++;
       }
       else if(row2.contains(Character.toString(words[i].charAt(j)))){
           count2++;
       }
       else if(row3.contains(Character.toString(words[i].charAt(j)))){
           count3++;
       }
   }
   if(count1 == len || count2 == len || count3 ==len){
       res.add(words[i]);
   }
   
}

String[] resultArray = new String[res.size()];
res.toArray(resultArray);
return resultArray;
    }
}
