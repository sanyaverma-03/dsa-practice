/*
Problem: Reverse a Singly Linked List  
Link: https://leetcode.com/problems/reverse-linked-list/description/

Description:  
Write a function to reverse a singly linked list.  
Each node has a 'next' pointer.  
After reversing, the head should point to the last node.

Example:  
Input: 1 -> 2 -> 3 -> 4  
Output: 4 -> 3 -> 2 -> 1

Approach 1 (Iterative):  
Traverse the list and reverse the next pointers using three pointers.  
Time Complexity: O(N)  
Space Complexity: O(1)

Approach 2 (Recursive):  
Reverse recursively by handling one node at a time.  
Time Complexity: O(N)  
Space Complexity: O(N) (due to recursion stack)
*/

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseLL {

    // Iterative Approach
    public static Node reverseListIterative(Node head) {
        Node temp = head;
        Node back = null;
        Node front = null;

        while (temp != null) {
            front = temp.next;   
            temp.next = back;     
            back = temp;          
            temp = front;          
        }
        return back; 
    }

    // Recursive Approach
    public static Node reverseListRecursive(Node head) {
        if (head == null || head.next == null) return head;

        Node newHead = reverseListRecursive(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;       
        return newHead;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        // Iterative Reversal
        head = reverseListIterative(head);
        System.out.print("Reversed (Iterative): ");
        printList(head);

        // Reverse again using Recursive to restore original
        head = reverseListRecursive(head);
        System.out.print("Reversed (Recursive): ");
        printList(head);
    }
}
