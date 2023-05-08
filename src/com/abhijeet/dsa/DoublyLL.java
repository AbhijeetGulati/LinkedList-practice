package com.abhijeet.dsa;

public class DoublyLL {
     private Node head;

     public void insertFirstDLL(int value){
         //create node
         Node node=new Node(value);
         node.next=head;
         node.prev=null;
         if(head!=null){
             head.prev=node;//check for null pointer exception here
         }

         //reassign head
         head=node;
     }

     public void display(){
         Node node=head;//we will use this to traverse over the linkedlist
         while(node!=null){
             System.out.print(node.value+"->");
             node=node.next;
         }
         System.out.println("Done");
     }

     //display in reverse
    public void displayReverse(){
         Node temp=head;
         //make it reach till last element
        while(temp.next!=null){
            temp=temp.next;
        }
        //now we will move left side and display in reverse
        while(temp!=null){
            System.out.print(temp.value+"->");
            temp=temp.prev;
        }
        System.out.println("Displayed in reverse");
    }
    //insert at last
    public void insertLast(int value){
        //create node u want to insert
        Node node=new Node(value);
         Node temp=head;
         if(head==null){
             node.prev=null;
             head=node;
             return;
         }
         while(temp.next!=null){
             temp=temp.next;

         }
        //System.out.println(temp.value);
        //now temp is at the reqd position

         node.prev=temp;
         temp.next=node;
         node.next=null;
    }

    //insert after a particular value
    public void insertAfterValue(int after,int value){
         //we will find the value after which we have to insert in the linkedlist
        Node p=findByValue(after);
        // if that value not found in list
        if(p==null){
            System.out.println("doesnt exist");
            return;
        }
        //create node that you have to insert
        Node node=new Node(value);
        node.next=p.next;
        p.next=node;
        node.prev=p;
        if(node.next!=null) {
            node.next.prev = node;//check for null pointer exception
        }
    }
    public Node findByValue(int value){
        Node temp=head;
        //we will run for loop index times
        while(temp!=null){
            if(temp.value==value){
                //this is our reqd node
                return temp;
            }
            temp=temp.next;
        }
        return null;//in case reqd node not found
    }
    public class Node{
        private int value;
        private Node next;
        private Node prev;

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public Node(int value) {
            this.value = value;
        }
    }
}
