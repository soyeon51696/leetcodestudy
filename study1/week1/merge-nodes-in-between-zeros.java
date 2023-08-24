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
    public ListNode mergeNodes(ListNode head) {
        //time complexity O(n^2) -> because of while loop inside while loop
        //space omplexity O(n) -> because it creates n nodes..? (head has n nodes..)

        ListNode curr = head.next;
        while (curr != null) { //for head loop
            int sum = 0;
            ListNode pointer = curr;
            while (pointer.val != 0) { //for between 0s loop
                sum += pointer.val;
                pointer = pointer.next;
            }
            curr.val = sum;
            curr.next = pointer.next;
            curr = pointer.next;
        }
        return head.next;
    }
}
