/*
Topic:- Palindrome Linked List

Link:- https://leetcode.com/problems/palindrome-linked-list/description/

Problem:-

Given the head of a singly linked list, return true if it is a 
palindrome or false otherwise.

Example 1:


Input: head = [1,2,2,1]
Output: true

Example 2:


Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
 

Follow up: Could you do it in O(n) time and O(1) space?

Solution:-
*/
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rev = reverse(slow.next);
        slow = head;
        fast = rev;
        while (fast != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    private ListNode reverse(ListNode node) {
        ListNode reverse = new ListNode(-1);
        while (node != null) {
            ListNode next = node.next;
            node.next = reverse.next;
            reverse.next = node;
            node = next;
        }
        return reverse.next;
    }
}
