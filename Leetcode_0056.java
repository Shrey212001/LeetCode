/*

Topic:- Design HashMap

Link:- https://leetcode.com/problems/design-hashmap/

Problem:-

Design a HashMap without using any built-in hash table libraries.

Implement the MyHashMap class:

MyHashMap() initializes the object with an empty map.
void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
 

Example 1:

Input
["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
Output
[null, null, null, 1, -1, null, 1, null, -1]

Explanation
MyHashMap myHashMap = new MyHashMap();
myHashMap.put(1, 1); // The map is now [[1,1]]
myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
 

Constraints:

0 <= key, value <= 106
At most 104 calls will be made to put, get, and remove.




Solution:-
*/
class MyHashMap {
	
	private class Node {
		
		int key;
		int val;
		Node next;
		
		public Node(int key, int val){
			
			this.key = key;
			this.val = val;
			
		}
		
	}
	
	Node[] table;
	
	public MyHashMap() {
		
		table = new Node[2048];
		
	}
	
	public void put(int key, int val) {
		
		if(table[hashCode(key)] == null) {
			
			table[hashCode(key)] = new Node(key, val);
			return;
			
		}
		
		Node bucket = table[hashCode(key)];
		Node prev = bucket;
		
		while(bucket != null && bucket.key != key) {
			prev = bucket;
			bucket = bucket.next;
		}
		
		if(bucket == null) {
			prev.next = new Node(key, val);
		} else {
			bucket.val = val;
		}
		
	}
	
	public int get(int key) {
		
		if(table[hashCode(key)] == null) return -1;
		
		Node bucket = table[hashCode(key)];
		
		while(bucket != null && bucket.key != key) bucket = bucket.next;
		
		if(bucket == null) return -1;
		else return bucket.val;
		
	}
	
	public void remove(int key) {
		
		if(table[hashCode(key)] == null) return;
		
		Node bucket = table[hashCode(key)];
		
		if(bucket.key == key) {
	        table[hashCode(key)] = bucket.next;
	        return;
	    }
		
		Node prev = bucket;
		
		while(bucket != null && bucket.key != key) {
			prev = bucket;
			bucket = bucket.next;
		}
		
		if(bucket != null) {
			
			prev.next = bucket.next;
			
		}
		
	}
	
	private int hashCode(int num) {
		return num % 2048;
	}
	
}
