package com.artists.sorting.insertion;

/**
 * Insertion Sort
 * @author ArtistS
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 * Hint:
 * 1. Imagine there are 2 ListNode, 1 is the head they give,
 * anothe one is you mockup firstNode.
 * 2. Try to find where is the right place you need to insert
 * i.e
 * currentNode
 * firstNode firstNode_next firstNode_next_next ....
 * compare firstNode_next.val with currentNode.val
 * if firstNode_next.val > currentNode.val
 * so the new listNode should like
 * firstNode firstNode_next currentNode firstNode_next_next
 * 3. Swap the value
 * 4. Edge case test -> i.e head is null
 */
public class Java_147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode firstNode = new ListNode();
        ListNode curr = head;
        ListNode pre = firstNode;
        ListNode curr_next = null;

        while (curr != null) {
            curr_next = curr.next;
            while (pre.next != null && pre.next.val < curr.val) {
                pre = pre.next;
            }

            curr.next = pre.next;
            pre.next = curr;
            pre = firstNode;
            curr = curr_next;
        }
        return firstNode.next;
    }

}
