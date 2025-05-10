/*
Problem: Segregate 0s, 1s and 2s
Link: https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1

Description:
Given a linked list of N nodes where each node can contain either 0, 1, or 2. 
Sort the linked list such that all 0s appear first, followed by all 1s, then all 2s.

Approach:
- Create three dummy nodes for 0s, 1s, and 2s.
- Traverse the original list and connect nodes to the corresponding list based on value.
- After traversal, connect the 0s list to the 1s list, and the 1s list to the 2s list.
- Make sure to terminate the final list with `null`.
- Return the head of the merged list starting from dummyZero.

Time Complexity: O(N), where N is the number of nodes in the linked list.
Space Complexity: O(1), as we use constant extra space (pointers only).
*/

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class SortNumbers {
    public static Node segregate(Node head) {
        Node temp = head;
        Node dummyZero = new Node(-1);
        Node dummyOne = new Node(-1);
        Node dummyTwo = new Node(-1);
        
        Node zero = dummyZero;
        Node one = dummyOne;
        Node two = dummyTwo;
        
        while(temp!=null){
            if(temp.data==0){
                zero.next = temp;
                zero=temp;
            }
            else if(temp.data==1){
                one.next = temp;
                one=temp;
            }
            else{
                two.next = temp;
                two=temp;
            }
            temp=temp.next;
        }
        
        zero.next = dummyOne.next==null?dummyTwo.next:dummyOne.next;
        one.next = dummyTwo.next;
        two.next = null;
        
        return dummyZero.next;
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
        Node head = new Node(2);
        head.next = new Node(0);
        head.next.next = new Node(1);
        head.next.next.next = new Node(0);

        head = segregate(head);
        printList(head);  
    }
}
