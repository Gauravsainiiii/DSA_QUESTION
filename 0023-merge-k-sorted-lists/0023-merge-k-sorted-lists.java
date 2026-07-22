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
    public ListNode mergeKLists(ListNode[] lists) { // Standard LeetCode method name
        if (lists == null || lists.length == 0) return null;
        return partition_merge(lists, 0, lists.length - 1);
    }

    public ListNode partition_merge(ListNode[] lists, int start, int end) {
        if (start > end) return null; 
        if (start == end) {
            return lists[start];
        }
        
        int mid = start + (end - start) / 2;
        ListNode left = partition_merge(lists, start, mid);
        ListNode right = partition_merge(lists, mid + 1, end);
        
        return mergeLists(left, right); // Named correctly now
    }

    public ListNode mergeLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(1);
        ListNode curr = dummy;
        
        // Complete logic to merge two sorted lists
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        
        // Link any remaining nodes
        if (list1 != null) curr.next = list1;
        if (list2 != null) curr.next = list2;
        
        return dummy.next;
    }
}