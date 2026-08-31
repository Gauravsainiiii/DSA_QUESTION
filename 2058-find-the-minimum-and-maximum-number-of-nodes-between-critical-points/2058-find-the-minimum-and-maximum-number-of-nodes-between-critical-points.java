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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        // Less than 3 nodes cannot have any critical points
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        int firstCP = -1;
        int lastCP = -1;
        int minDistance = Integer.MAX_VALUE;

        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1;

        while (curr.next != null) {
            boolean isLocalMin = curr.val < prev.val && curr.val < curr.next.val;
            boolean isLocalMax = curr.val > prev.val && curr.val > curr.next.val;

            if (isLocalMin || isLocalMax) {
                if (firstCP == -1) {
                    firstCP = index;
                } else {
                    minDistance = Math.min(minDistance, index - lastCP);
                }
                lastCP = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        // If fewer than 2 critical points were found
        if (firstCP == -1 || firstCP == lastCP) {
            return new int[]{-1, -1};
        }

        int maxDistance = lastCP - firstCP;
        return new int[]{minDistance, maxDistance};
    }
}