/*
Problem: Convert Array to LinkedList

Description:
Given an integer array, convert it into singly linked list.

*/

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class ArraytoLinkedlist {
    public static void main(String[] args) {
       int[] arr = {2,3,4,5,6,7,8,9};
       Node head = new Node(arr[0]);
       Node mover = head;
       for(int i=1;i<arr.length;i++){
           Node newNode = new Node(arr[i]);
           mover.next = newNode;
           mover = newNode;
       }
       
       Node temp = head;
       while(temp!=null){
           System.out.print(temp.data+"->");
           temp=temp.next;
       }
       System.out.print("null");
    }
}
