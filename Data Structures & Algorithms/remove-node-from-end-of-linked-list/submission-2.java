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
    public int getCount(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        n = getCount(head) - n;
        if(n==0){
            ListNode temp = head.next;
            if(temp == null){
                return null;
            }else{
                head.next = null;
                return temp;
            }
        }
        ListNode prev = head;
        ListNode mainHead = head;
        
        while(head != null && n>=0){
            if(n == 0){
                System.out.println(head.val);
                 prev.next = head.next;
                 if(head.next != null){
                    head.next = null;
                 }
                 break;
            }
            n--;
            prev = head;
            head = head.next;
        }
        return mainHead;
    }
}
