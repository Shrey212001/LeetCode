/*
Topic:-  Minimum Index Sum of Two Lists

Link:- https://leetcode.com/problems/minimum-index-sum-of-two-lists/

Problem:-

Given two arrays of strings list1 and list2, find the common strings with the least index sum.

A common string is a string that appeared in both list1 and list2.

A common string with the least index sum is a common string such that if it appeared at list1[i] and list2[j] then i + j should be the minimum value among all the other common strings.

Return all the common strings with the least index sum. Return the answer in any order.

 

Example 1:

Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
Output: ["Shogun"]
Explanation: The only common string is "Shogun".
Example 2:

Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Shogun","Burger King"]
Output: ["Shogun"]
Explanation: The common string with the least index sum is "Shogun" with index sum = (0 + 1) = 1.
Example 3:

Input: list1 = ["happy","sad","good"], list2 = ["sad","happy","good"]
Output: ["sad","happy"]
Explanation: There are three common strings:
"happy" with index sum = (0 + 1) = 1.
"sad" with index sum = (1 + 0) = 1.
"good" with index sum = (2 + 2) = 4.
The strings with the least index sum are "sad" and "happy".
 

Constraints:

1 <= list1.length, list2.length <= 1000
1 <= list1[i].length, list2[i].length <= 30
list1[i] and list2[i] consist of spaces ' ' and English letters.
All the strings of list1 are unique.
All the strings of list2 are unique.
There is at least a common string between list1 and list2.





Solution:-
*/
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if(list1.length>list2.length) {
            String[] t = list1;
            list1 = list2;
            list2 = t;
        }
        HashMap<String, Integer> map = new HashMap<>(list1.length);
        for(int i=0; i<list1.length; i++)
            map.put(list1[i], i);
        int min = list1.length + list2.length -2;
        boolean first = false;
        List<String> result = new ArrayList<>(list1.length);
        for(int i=0; i<list2.length && i<=min; i++) {
            Integer index = map.get(list2[i]);
            if(index != null) {
                if(min > index + i) {
                    min = index + i;
                    result.clear();
                    result.add(list2[i]);
                }
                else if(min == index + i)
                    result.add(list2[i]);
            }
        }
        return (String[]) result.toArray(new String[result.size()]);
    }
}
