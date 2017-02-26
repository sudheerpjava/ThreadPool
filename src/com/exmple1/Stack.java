package com.exmple1;

import java.util.NoSuchElementException;

/**
 * Created by Sudheer.
 */
public class Stack {
    public static void main(String[] args) {
        LinkedStack linkedStack=new LinkedStack();
        linkedStack.push(12);
        linkedStack.push(15);
        linkedStack.push(13);
        System.out.println(linkedStack.pop());

    }

}


class LinkedStack{

    protected Node top;
    protected int size;
    public  LinkedStack(){
        top=null;
        size=0;
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return top==null;
    }

    public void push(int data){
        Node newNode=new Node(data,null);
        if (top==null)
            top=newNode;
        else {
            newNode.setNext(top);
            top=newNode;
        }
    }

    public int pop(){
        if (isEmpty())
            throw new  NoSuchElementException("NO elements in the stack");
        Node ptr=top;
        top=ptr.getNext();
        size--;
        return ptr.getData();
    }
}


class Node{

    protected Node next;
    protected int data;
    Node(){
        data=0;
        next=null;
    }
    Node(int data,Node next){
        this.data=data;
        this.next=next;
    }
    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
