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
    public ListNode getMid(ListNode head){
        ListNode fast=head.next;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
     public ListNode merge(ListNode list1, ListNode list2) {
        if(list1==null && list2==null) return null;
        ListNode dummy = new ListNode(1);
        ListNode curr=dummy;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val) {
                curr.next=list1;
                list1=list1.next;
            }
            else{
                curr.next=list2;
                list2=list2.next;
            }
             curr=curr.next;
        }
        while(list1!=null){
            curr.next=list1;
            list1=list1.next;
            curr=curr.next;
        }
        while(list2!=null){
            curr.next=list2;
            list2=list2.next;
            curr=curr.next;
        }
        return dummy.next;
        }
        public ListNode sortList(ListNode head) {
            if(head==null ||  head.next==null) return head;
            ListNode mid=getMid(head);
            ListNode righthead=mid.next;
            mid.next=null;
            ListNode left=sortList(head);
            ListNode right=sortList(righthead);
            return merge(left,right);
        }
}
