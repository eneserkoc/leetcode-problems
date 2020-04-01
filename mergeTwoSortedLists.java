/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode mergedList = new ListNode(-1);
        ListNode initNode = mergedList;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                mergedList.next = l1;
                l1 = l1.next;
            }else{
                mergedList.next = l2;
                l2 = l2.next;
            }

            mergedList = mergedList.next;

        }
        if(l1 == null){
            mergedList.next = l2;
        }else{
            mergedList.next = l1;
        }
    
        return initNode.next;
    }
}