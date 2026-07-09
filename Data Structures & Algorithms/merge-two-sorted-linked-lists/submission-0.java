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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = null;
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode currNode = null;

        while(p1 != null && p2 != null){
            ListNode newNode = null;
            if(p1.val > p2.val){
                newNode = new ListNode(p2.val,null);
                p2 = p2.next;
            }else{
                newNode = new ListNode(p1.val,null);
                p1 = p1.next;
            }
            if(res == null){
                res = newNode;
            }else{
                currNode.next = newNode;
            }
            currNode = newNode;
        }
        while(p1 != null) {
            ListNode newNode = new ListNode(p1.val,null);
            if(res == null){
                res = newNode;
            }else{
                currNode.next = newNode;
            }
            currNode = newNode;
            p1 = p1.next;
        }

        while(p2 != null) {
            ListNode newNode = new ListNode(p2.val,null);
            if(res == null){
                res = newNode;
            }else{
                currNode.next = newNode;
            }
            currNode = newNode;
            p2 = p2.next;
        }

        return res;
    }
}