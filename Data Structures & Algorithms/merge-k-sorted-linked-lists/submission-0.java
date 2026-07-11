/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode merge(ListNode head1,ListNode head2){
        ListNode p1 = head1;
        ListNode p2 = head2;
        ListNode head = null;
        ListNode curr = null;
        while(p1 != null && p2 != null){
            ListNode temp;
            if(p1.val > p2.val){
                temp = new ListNode(p2.val);
                p2 = p2.next;
            }else{
                temp = new ListNode(p1.val);
                p1 = p1.next;
            }
            if(head == null) {
                head = temp;
            } else {
                curr.next = temp;
            }
            curr = temp;    
        }

        if(p1 != null){
            if(curr == null){
                return p1;
            }else{
                curr.next = p1;
            }
        }
        if(p2 != null){
            if(curr == null){
                return p2;
            }else{
                curr.next = p2;
            }
        }
        return head;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        ListNode head = lists[0];
        for(int i = 1;i<lists.length;i++){
            head = merge(head,lists[i]);
        }
        return head;
    }
}
