package com.abhijeet.dsa;

public class CircularLL {
    private Node head;
    private Node tail;

    public CircularLL() {
        this.head = null;
        this.tail = null;//initial values
    }

    //inserting node after tail
    public void insert(int value){
        //create the new node
        Node node=new Node(value);
        if(head==null){
            //there is no element in the list
            head=node;
            tail=node;
            return;
        }

        //connect
        tail.next=node;
        node.next=head;
        //reassign tail
        tail=node;
    }

    //display
    public void display(){
        Node node=head;
        if(head!=null){
            //if head will be null there will be nothing to display ie empty list
            do{
                System.out.print(node.value+"->");
                node=node.next;
            }while(node!=head);
        }
    }

    public void delete(int value){
        Node node=head;
        //edge cases
        //when there is no node in the list
        if(node==null){
            //empty list
            return;//nothing to delete
        }
        //now if the head node is the node with the required value
        if(node.value==value){
            //shift head
            head=head.next;
            tail.next=head;
            return;
        }
        //but for any other general node we will require two nodes
        do{
          Node n=node.next;
          if(n.value==value){
              //this is the node that we have to delete
              node.next=n.next;
              break;
          }
          node=node.next;
        }while (node!=head);//required element not found

    }
    public class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
