import java.util.*;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node iter = head;
        while (iter != null) {
            map.put(iter, new Node(iter.val));
            iter = iter.next;
        }

        iter = head;
        while (iter != null) {
            map.get(iter).next = map.get(iter.next);    
            map.get(iter).random = map.get(iter.random);
            iter = iter.next;        
        }

        return map.get(head);
    }
}