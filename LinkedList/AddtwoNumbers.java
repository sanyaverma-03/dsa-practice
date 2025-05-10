/*
Problem: Add Two Numbers
Link: https://leetcode.com/problems/add-two-numbers/

Description:
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order, and each of their nodes contains a single digit. 
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Approach:
- Initialize a dummy node to build the result list.
- Use two pointers to traverse the input lists and a variable to keep track of the carry.
- At each step, sum the corresponding digits and the carry.
- Create a new node with the value of (sum % 10) and update the carry.
- Move the pointers forward and repeat until both lists are fully processed and there’s no carry left.
- Return the next of dummy node as the result head.

Time Complexity: O(max(N, M)), where N and M are the lengths of the two input lists.
Space Complexity: O(max(N, M)), due to the space required for the output list.
*/

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
        this.next = null;
    }
}

public class AddtwoNumbers {
        
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int carry = 0;
        int sum = 0;

        while(temp1!=null || temp2!=null || carry!=0){
            int val1 = temp1!=null?temp1.val:0;
            int val2 = temp2!=null?temp2.val:0;

            sum=val1+val2+carry;
            carry=sum/10;

            current.next = new ListNode(sum%10);
            current=current.next;
          
            if(temp1!=null) temp1=temp1.next;
            if(temp2!=null) temp2=temp2.next;
        }

        return dummyNode.next;

    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode head = addTwoNumbers(l1,l2);
        printList(head);  
    }
}
