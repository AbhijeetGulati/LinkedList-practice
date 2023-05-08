package com.abhijeet.dsa;



public class Link {
    //linked list implementation
//we also need head and tail of linkedlist
    private Node head;
    private Node tail;
    private int size;
    //constructor for size
    public Link(){
        this.size=0;//initialising size with zero
    }

    public Link merge(Link first,Link second){
        Link ans=new Link();//to contain final merged list
        Node h1=first.head;
        Node h2=second.head;
        while(h1!=null && h2!=null){
            //compare values
            if(h1.value<h2.value){
                ans.insertLast(h1.value);
            }else{
                ans.insertLast(h2.value);
            }
        }//while both lists contain elements
        while(h1!=null){
            //add all elements of h1 to ans list
            ans.insertLast(h1.value);
            //move h1 ahead
            h1=h1.next;
        }
        while(h2!=null){
            //add all elements of h2 to ans list
            ans.insertLast(h2.value);
            //move h2 ahead
            h2=h2.next;
        }
        return ans;
    }

    public void insertFirst(int value){
        //create node
        Node node=new Node(value);
        //connect it
        node.next=head;
        //adjust head
        head=node;
        //System.out.println("element inserted"+node.value);
       /* if(tail==null){
            head=tail;//both pointing to same single element
        }

        */
        size+=1;//when element is added size increases by one
    }

    //insert at last
    public void insertLast(int value){
        if(tail==null){
            insertFirst(value);
            return;
        }


        //create node to insert
        Node node=new Node(value);
        tail.next=node;
        //restructure tail now
        tail=node;//because now the node that we inserted is the last element
        size++;
    }

    //insert at any index
    public void insert(int value,int index){
        if(index==0){
            insertFirst(value);
            return;
        }
        if(index==size){
            insertLast(value);
            return;
        }
        Node temp=head;//take it till index-1 place
        for(int i=1;i<index;i++){
            //move temp
            temp=temp.next;
        }
        Node newnode=new Node(value,temp.next);
        temp.next=newnode;
        size++;
    }

    //deletefirst
    public int deleteFirst(){
        //first we will store the value that we are going to delete
        int val=head.value;

        //just move head ahead and the first element of the list will be deleted
        head=head.next;
        if(head==null){
            //there was only single element in the list
            tail=null;//make tail null also
        }
        size--;
        return val;
    }
    //using this we will reach the index after which we have the reqd element which we want to delete
    public Node get(int index){
        Node temp=head;
        //we will run for loop index times
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp;
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
     public int deleteLast(){
         int delval=tail.value;//this is the removed value
    //for lists with single elements
         if(size<=1){
             return deleteFirst();
         }


         //get the index of second last element
         Node secondlast=get(size-2);

         //now connect secondlast ka next to null
         tail=secondlast;
         tail.next=null;
         return delval;
     }


     //delete element at any index
    public int delete(int index){
        //edge cases
        if(index==0){
            return deleteFirst();
        }
        if(index==size-1){
            return deleteLast();
        }
        //for general index
        Node prev=get(index-1);
        int value=prev.next.value;
        //now forming the new connection
        prev.next=prev.next.next;
        return value;
    }
    //display elements of linked list
    public void display(){
        Node temp=head;//we will move the temp pointer because it doesnt affect structure of linkedlist
        //while loop because we dont know how many nodes are there

        while(temp!=null){
            System.out.print(temp.value+"->");
            temp=temp.next;
        }
        System.out.println("Done");
    }










    private class Node{
        private int value;
        private Node next;
        //constructors
        public Node(int value){
            this.value=value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
