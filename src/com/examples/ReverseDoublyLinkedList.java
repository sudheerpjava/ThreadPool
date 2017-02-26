package com.examples;

/**
 * Created by Sudheer on 1/16/2017.
 */
public class ReverseDoublyLinkedList {

    static Node head;

    //create a node to store the data,links
    class Node{
        int data;
        Node next,prev;
        Node(int d){
            data=d;
            next=prev=null;
        }
    }
    //reverse the doubly linked list
     public void reverse(){
        Node temp=null;

        Node current = head;
        //swap the elements to reverse the list
         while(current!=null){
             temp=current.prev;
             current.prev=current.next;
             current.next=temp;
             current=current.prev;
         }

         if(temp!=null){
             head=temp.prev;
         }
     }
     //print the list
    public void display(Node node){
         while(node!=null){
             System.out.println(node.data+" ");
             node=node.next;
         }
    }

    //push the data into list
    public void push(int data){
        Node newNode=new Node(data);
        newNode.prev=null;
        newNode.next=head;
        if(head !=null)
            head.prev=newNode;

        head=newNode;
    }

    public static void main(String[] args) {
        ReverseDoublyLinkedList list=new ReverseDoublyLinkedList();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(5);
        System.out.println("Before reversed");
        list.display(head);
        list.reverse();
        System.out.println("After reversed");
        list.display(head);


    }
}
