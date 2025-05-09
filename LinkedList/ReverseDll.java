/*
Problem: Reverse a Doubly Linked List

Description:
Write a function to reverse a doubly linked list. 
The list has nodes with 'next' and 'back' pointers. 
After reversing, the head should point to the last node, 
and all next/back pointers should be correctly updated.

Example:
Input: head = 1 <-> 2 <-> 3
Output: head = 3 <-> 2 <-> 1

Approach:
Traverse the list and for each node, swap its next and back pointers.
Move to the originally next node (now at temp.back due to the swap).
Keep track of the last visited node before null to update head.
At the end, update head to the new head of the reversed list.

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Node{
    int data;
    Node next;
    Node back;
    Node(int data){
        this.data = data;
        this.next = null;
        this.back = null;
    }
}

class ReverseDll {
    private static Node reverse(Node head){
        Node last = null;
        Node temp = head;
        while(temp!=null){
            last = temp.back;
            temp.back = temp.next;
            temp.next = last;
            
            temp=temp.back;
        }
        if(last!=null) head = last.back;
        return head;
    }
    public static void main(String[] args) {
       int[] arr = {1,2,3};
       Node head = new Node(arr[0]);
       Node mover = head;
       for(int i=1;i<arr.length;i++){
           Node newNode = new Node(arr[i]);
           mover.next = newNode;
           newNode.back = mover;
           mover = newNode;
       }
       
        head = reverse(head);
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
}