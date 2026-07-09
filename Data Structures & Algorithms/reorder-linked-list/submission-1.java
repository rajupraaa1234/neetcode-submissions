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
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode temp = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
    public void reorderList(ListNode head) {
        int count = 0;
        ListNode curr = head;
        while(curr != null){
            count++;
            curr = curr.next;
        }
        if(count ==0 || count == 1) return;
        int mid = count/2;
        ListNode second = head;
        ListNode prev = null;
        while(mid > 0 && second != null){
            mid--;
            prev = second;
            second = second.next;
        }
        if(prev != null){
            prev.next = null;
        }

        ListNode p2 = reverse(second);
        ListNode p1 = head;
        boolean isFirst = true;
       while(p1 != null && p2 != null){
            if(isFirst){
                ListNode currP1 = p1;
                p1 = p1.next;
                currP1.next = p2;
            }else{
                ListNode currP2 = p2;
                p2 = p2.next;
                currP2.next = p1;
            }
          isFirst = !isFirst;
       }

       
    }
}
