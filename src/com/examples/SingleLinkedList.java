package com.examples;
/**
 * Created by Sudheer.
 */
public class SingleLinkedList {
    SNode head;
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.insertLat(1);
        singleLinkedList.insertLat(9);
        singleLinkedList.insertLat(9);
        singleLinkedList.insertLat(9);

        //singleLinkedList.insertAfter(newNode,10);
        //singleLinkedList.insertLat(12);
       // singleLinkedList.delete();
        singleLinkedList.display();
        System.out.println("After reversed");
        singleLinkedList.reverse();
        singleLinkedList.display();
/*        singleLinkedList.addOne(1111);
        singleLinkedList.reverse();
        singleLinkedList.display();*/
    }


    public void delete(){

    }
    public void addOne(int num){
        SNode current=head;
        if (head==null)
            return;
        int data;
        int carry=num;
        while (current!=null) {
            data=current.data+carry;
            //System.out.println(data);
            if (data >= 10) {
                carry = data / 10;
                current.data = data % 10;
            }else{
                carry = data / 10;
                current.data=data;
            }
            current=current.next;
        }

    }
    public void reverse(){
        SNode prev=null;
        SNode current=head;
        SNode next=null;
        while (current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head=prev;
    }
    //add an element at the front of the linkedList--which takes o(1) to add an element
    public void addFront(int data){
        SNode newNode=new SNode(data);
        if (head==null)
            head=newNode;
        else {
            newNode.next=head;
            head=newNode;
        }
    }

    //insert an elemet after aperticular Node
    public void insertAfter(SNode prev_node,int data){
        if (prev_node==null){
            System.out.println("The given prev node cannot be null");
            return;
        }
        SNode newNode=new SNode(data);
        newNode.next=prev_node.next;
        prev_node.next=newNode;
    }
    public  void display(){
        SNode n=head;
        while (n!=null){
            System.out.println(n.data);
            n=n.next;
        }
    }
    public SNode insertLat(int data){
        SNode newNode=new SNode(data);
        if (head==null){
            head=newNode;
            return head;
        }
        newNode.next=null;
        SNode last=head;
        while (last.next!=null){
            last=last.next;
        }
        last.next=newNode;
        return last;
    }
}
class SNode{
    SNode next;
    int data;
    SNode(int d){
        data=d;
        next=null;
    }

}