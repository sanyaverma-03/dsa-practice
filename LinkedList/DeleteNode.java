/*
Problem: Delete Node in a Linked List
Link: https://leetcode.com/problems/delete-node-in-a-linked-list/

Description:
Write a function to delete a node in a singly-linked list. 
You will not be given access to the head of the list, 
instead you will be given access to the node to be deleted directly.

It is guaranteed that the node to be deleted is not the tail node.

Example:
Input: head = [4,5,1,9], node = 5
Output: [4,1,9]

Approach:
Since we do not have access to the previous node, we can't simply remove the node.
Instead, copy the value of the next node into the current node,
then unlink the next node by adjusting pointers.

Time Complexity: O(1)
Space Complexity: O(1)
*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class DeleteNode {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        printList(head);

        DeleteNode solution = new DeleteNode();
        solution.deleteNode(head.next); 

        System.out.println("List after deleting node: ");
        printList(head);
    }
}
