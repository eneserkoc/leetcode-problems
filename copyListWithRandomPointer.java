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
        Node copy = new Node(-1);

        Node tmpCopy = copy;
        Node tmpHead = head;

        HashMap<Node, Node> map = new HashMap();


        while(head != null){
            copy.next = new Node(head.val);

            map.put(head, copy.next);

            copy = copy.next;
            head = head.next;
        }

        copy = tmpCopy.next;
        head = tmpHead;
        while (head != null){
            if(head.random != null){
                copy.random = map.get(head.random);
            }else{
                copy.random = null;
            }

            copy = copy.next;
            head = head.next;
        }

        copy = tmpCopy;
        return copy.next;
    }
    
    
}