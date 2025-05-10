/*
Problem: Odd Even Linked List  
Link: https://leetcode.com/problems/odd-even-linked-list/

Description:
Given a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list. 
Note: The relative order inside the groups should be preserved.

The first node is considered odd, the second node even, and so on.

Approach:
- If the list is empty or has only one node, return it as is.
- Use two pointers, `odd` and `even`, to build two separate lists:
    - `odd` starts at the first node.
    - `even` starts at the second node.
- Maintain a reference to the head of the even list (`evenHead`) for later merging.
- Traverse the list:
    - Link odd nodes together by skipping over even nodes.
    - Link even nodes together by skipping over odd nodes.
- After traversal, link the last odd node to the head of the even list.
- Return the head of the modified list.

Time Complexity: O(N), where N is the number of nodes in the linked list.  
Space Complexity: O(1), since the reordering is done in-place.
*/


class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class OddEvenLL {
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;

            even.next = even.next.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        printList(head);
        head=oddEvenList(head);
        printList(head);

    }

}
