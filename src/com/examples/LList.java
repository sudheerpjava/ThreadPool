package com.examples;

import java.util.NoSuchElementException;

public class LList {

    public static void main(String[] args) {
        SList sList=new SList();
        sList.add(1);
        sList.add(2);
        sList.add(3);
        sList.add(4);
        sList.add(5);
        sList.add(6);
       System.out.println(sList.size);
    }
}

class SList{
    protected Node head;
    protected int size;
    public SList(){
        head=null;
        size=0;
    }

    public int getSize(){
        return size;
    }
    public  boolean isEmpty(){
        return head==null;
    }

    public void add(int data){
        Node newNode=new Node(data,null);
        Node ptr=null;
        if (head==null)
            head=newNode;
        else {
            ptr = head;
            newNode.setLink(ptr);
            head=newNode;

        }
        size++;
    }

    public int remove(){
        if (isEmpty())
            throw new NoSuchElementException("NO elements in the linked List");
        Node ptr=head;
        head=ptr.getLink();
        size--;
        return ptr.getData();
    }

    public Node getNext(){
        if (isEmpty())
            throw new NoSuchElementException("NO elements in the linked List");

        Node ptr=head;
        head=ptr.getLink();
        return head;

    }
}
class Node{
    protected Node link;

    protected int data;

    public  Node(){
        link=null;
        data=0;
    }

    public Node(int data,Node link){
        this.data=data;
        this.link=link;
    }

    public Node getLink() {
        return link;
    }

    public void setLink(Node link) {
        this.link = link;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
