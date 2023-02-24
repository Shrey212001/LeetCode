/*

Topic:- Design HashSet

Link:- https://leetcode.com/problems/design-hashset/description/

Problem:-

Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
 

Example 1:

Input
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
Output
[null, null, null, true, false, null, true, null, false]

Explanation
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      // set = [1]
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(1); // return True
myHashSet.contains(3); // return False, (not found)
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2); // return True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // return False, (already removed)
 

Constraints:

0 <= key <= 106
At most 104 calls will be made to add, remove, and contains.



Solution:-

*/
class MyHashSet {

    class Node{
        int key;
        Node next;

        Node(int key){
            super();
            this.key = key;
        }
    }

    Node hs[];
    int len = 9000;

    public MyHashSet() {
        hs = new Node[len];
    }
    
    public void add(int key) {
        int realKey = key%len;
        Node init = hs[realKey];

        while(init != null){
            if(init.key == key) return;
            if(init.next == null){
                init.next = new Node(key);
                return;
            }
            else init = init.next;
        }

        hs[realKey] = new Node(key);
    }
    
    public void remove(int key) {
        int realKey = key%len;
        Node init = hs[realKey];    

        if(init == null) return;
        else if(init.key == key){
            hs[realKey] = init.next;
            return;
        }

        Node previous = hs[realKey];
        init = previous.next;

        while(init != null){
            if(init.key == key){
                previous.next = init.next;
                return;
            }else{
                previous = init;
                init = init.next;
            }
        }

    }
    
    public boolean contains(int key) {
        int realKey = key%len;
        Node init = hs[realKey];

        while(init != null){
            if(init.key == key) return true;
            else init = init.next;
        }

        return false;   
    }
}

