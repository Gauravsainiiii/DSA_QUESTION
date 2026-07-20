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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null) return head;
        ListNode dummy=new ListNode(1);
        dummy.next=head;
        ListNode beforehead=dummy;
        for(int i=1;i<left;i++){
            beforehead=beforehead.next;
        }
        ListNode currHead=beforehead.next;
        ListNode prev=null;
        ListNode curr=currHead;
        for(int i=0;i<=right-left;i++){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        currHead.next=curr;
        beforehead.next=prev;
        return dummy.next;
    }
}
