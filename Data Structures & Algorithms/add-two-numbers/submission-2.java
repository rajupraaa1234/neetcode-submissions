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
        head.next.next=head.next;
        head.next = null;
        return temp;
    }
    public long getNumber(ListNode head) {
        long number = 0;
        long curr = 1;
        while(head != null ){
            number = number+ head.val * curr;
            curr = curr * 10;
            head = head.next;
        }
        return number;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = null;
        ListNode curr = null;
        int carry = 0;
        while(p1 != null && p2 != null) {
            int num = p1.val + p2.val + carry;
            carry = 0;
            ListNode newNode = null;
            if(num>=10){
                int rem = num%10;
                carry = num/10;
                newNode = new ListNode(rem);
            }else{
                newNode = new ListNode(num);  
            }

            if(curr == null){
                head = newNode;
                curr = newNode;
            }else{
                curr.next = newNode;
                curr = newNode;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        while(p1 != null){
            int num = p1.val + carry;
            carry = 0;
            ListNode newNode = null;
            if(num>=10){
                int rem = num%10;
                carry = num/10;
                newNode = new ListNode(rem);
            }else{
                newNode = new ListNode(num);  
            }
            curr.next = newNode;
            curr = newNode;
            p1 = p1.next;
        }
        while(p2 != null){
            int num = p2.val + carry;
            carry = 0;
            ListNode newNode = null;
            if(num>=10){
                int rem = num%10;
                carry = num/10;
                newNode = new ListNode(rem);
            }else{
                newNode = new ListNode(num);  
            }
            curr.next = newNode;
            curr = newNode; 
            p2 = p2.next;
        }
        
        if(carry>0){
            curr.next = new ListNode(carry);
        }
        return head;
    }
}
