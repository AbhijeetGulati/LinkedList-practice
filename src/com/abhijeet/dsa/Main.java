package com.abhijeet.dsa;

import java.util.*;

public class Main {

    public static void main(String[] args) {

//      Link ll=new Link();
//      //insert elements in our linked list
//        ll.insertFirst(3);
//        ll.insertFirst(45);
//        ll.insertFirst(5);
//        ll.insertFirst(18);
//        ll.insertFirst(100);
//        ll.display();
//        ll.insert(69,2);
//        ll.display();
//        //removing 69 which is at index 2
//        System.out.println(ll.delete(2));
//        ll.display();
//        System.out.println(ll.delete(0));
//        ll.display();
////        System.out.println(ll.deleteFirst());
////        ll.display();
////        System.out.println(ll.deleteLast());
////        ll.display();
//        System.out.println("inserted and displayed elements of a linked list");

        //Doubly Linked list

//        DoublyLL dll=new DoublyLL();
//        dll.insertFirstDLL(5);
//        dll.insertFirstDLL(45);
//        dll.insertFirstDLL(23);
//        dll.insertFirstDLL(8);
//        dll.display();
//        dll.insertLast(30);
//        dll.display();
//        dll.insertAfterValue(30,80);
//        dll.display();
        //dll.displayReverse();

//        //circular linked list
//        CircularLL list=new CircularLL();
//        list.insert(45);
//        list.insert(17);
//        list.insert(42);
//        list.insert(9);
//        list.display();
//        list.delete(42);
//        System.out.println();
//        list.display();
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //our two pointers
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                    return true;
            }

        }
        return false;
    }
    public int lengthOfCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                //calculate length
                ListNode temp=slow;
                int length=0;
                do{
                    temp=temp.next;
                    length++;
                }while (temp!=slow);
                return length;
            }
        }
        return 0;//cycle is not present
    }
    public ListNode detectCycle(ListNode head) {
//to find node where cycle starts
        ListNode first=head;
        ListNode second=head;
        //move second length of cycle times
        int l=lengthOfCycle(head);
        for(int i=0;i<l;i++){
            second=second.next;
        }
        //now move first and second till they meet
        //where they meet will be start of the cycle
        while(first!=second){
            first=first.next;
            second=second.next;

        }
         return second;
    }
    //to get square of a number
    private int getSquare(int n){
        int temp=n;
        int reqd=0;//we will store the value of the next number of linked list in this

        while(temp!=0){
            int rem=temp%10;
            reqd+=(int)Math.pow(rem,2);
            temp=temp/10;
        }
        return reqd;
    }
    public boolean isHappy(int n) {
      //2 pointers to detect cycle
        int slow=n;
        int fast=n;
        do{
            slow=getSquare(slow);
            fast=getSquare(getSquare(fast));//because fast moves two steps ahead
        }while (fast!=slow);
        if(slow==1){
            //cycle is not there
            return true;
        }
            return false;//cycle  present

    }
    //middle of linked list
    public ListNode middleNode(ListNode head) {

    }

    public ListNode deleteDuplicates(ListNode head) {
      ListNode temp=head;
        //edge case
        if(temp==null){
            //no element in list
            return temp;
        }

        while(temp!=null){
            //traverse entire list
            if(temp.val==temp.next.val && temp.next!=null){
                //skip the duplicate
                temp.next=temp.next.next;
            }else{
                //move normally to next node
                temp=temp.next;
            }
        }
        return head;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
   /* public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        HashSet<Integer> rows=new HashSet<>();
        HashSet<Integer> col=new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){//if element zero add its indexes to set
                if(matrix[i][j]==0){
                    rows.add(i);
                    col.add(j);
                }
            }
        }
        //now we will iterate again to set the rest of the row and column elements as zero
        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                if(rows.contains(i) || col.contains(j)){
                    matrix[i][j]=0;
                }

            }

        }
    }*/
    //Twosum

    public int[] twoSum(int[] nums, int target) {
        int[] ans=new int[2];//this is our ans array
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int reqd=target-nums[i];
            //if it exists in hashmap return it else ut the current element in the map
            if(map.containsKey(reqd)){
                ans[0]=map.get(reqd);
                ans[1]=i;
                return ans;
            }
            //else put current element in hashmap
            map.put(nums[i],i);
        }
      return ans;
    }

    //threesum
    //brute force
    /*
    public List<List<Integer>> threeSum(int[] nums) {

    //we will use a set to store the unique triplets
        int n=nums.length;
        HashSet<List<Integer>> set=new HashSet<>();//set will contain lists of triplets
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    List<Integer> temp=new ArrayList<>();//will store our triplets
                    if(nums[i]+nums[j]+nums[k]==0){
                        //now if its unique also then its the reqd triplet
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        Collections.sort(temp);
                        set.add(temp);//now only unique triplets will be added to the set

                    }
                }
            }
        }
        return new ArrayList<>(set);//all elements in set come inside this arraylist
    }


     */
    //optimal way :- 2 pointers
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
    int n=nums.length;
    List<List<Integer>> ans=new ArrayList<>();

    for(int i=0;i<n;i++){
        if(i>0 && nums[i]==nums[i-1]){
            continue;
        }
        int j=i+1;
        int k=n-1;
        while(j<k){
            if(nums[i]+nums[j]+nums[k]<0){
                //move j ahead
               j++;
            }
            else if(nums[i]+nums[j]+nums[k]>0){
                //move k left
                k--;
            }
            else{
                //we have got the reqd triplet
                List<Integer> temp=new ArrayList<>();
                temp.add(nums[i]);
                temp.add(nums[j]);
                temp.add(nums[k]);
                //add it to ans list
                ans.add(temp);//required triplet
                j++;
                k--;//after we found reqd  triplet j and k need to move so that they are not at same index as before
                while(j<k && nums[j]==nums[j-1]){
                    j++;//to avoid duplicate elements
                }
                while(j<k && nums[k]==nums[k+1]){
                    k++;//to avoid duplicate elements
                }
            }
        }
    }//end of i loop
        return ans;
    }

    public boolean check(int[] nums) {
        int n=nums.length;
      int count=0;
      for(int i=1;i<n;i++){
          if(nums[i-1]>nums[i]){
              //breakpoint
              count++;
          }
      }
      if(nums[n-1]>nums[0]){
          count++;
      }
      return count<=1;//if count>1 returns false
    }

    //rotate an array

    public void rotate(int[] nums, int k) {
        int n=nums.length;
        reverse(nums,0,n-k);
        reverse(nums,n-k,n-1);
        //reverse entire array
        reverse(nums,0,n-1);


    }


    public static void reverse(int[] nums,int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }

    public void moveZeroes(int[] nums) {
        int k=0;//will store index of last non zero element
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                //place it at kth index
                nums[k]=nums[i];
                k++;
            }
        }
        //now all non zero elements will be sorted and we just need to add zeros in the end positions
        for(int i=k;i<nums.length;i++){
            nums[i]=0;
        }
    }

    //max consecutive ones
    public int findMaxConsecutiveOnes(int[] nums) {
     int maxi=Integer.MIN_VALUE;
     int c=0;
     for(int i=0;i<nums.length;i++){
         if(nums[i]==1){
             c++;
         }
         if(nums[i]==0){
             maxi=Math.max(maxi,c);
             //now reset count
             c=0;
         }
     }
     return maxi;
    }

    public int singleNumber(int[] nums) {
    int n=nums.length;
    HashMap<Integer,Integer> map=new HashMap<>();
    for(int i=0;i<n;i++){
        //put all entries in map
        map.put(nums[i],map.getOrDefault(nums[i],0)+1);//storing array elements and their frequency
    }
    for(Map.Entry<Integer,Integer> entry: map.entrySet()){
        if(entry.getValue()==1){
            //return its corresponding key
            return entry.getKey();
        }
    }
    return -1;
    }

    //better way
//    public List<List<Integer>> threeSum(int[] nums) {
//        //using two for loops only and using set instead of third loop
//        int n = nums.length;
//        //set to store all unique triplets
//        HashSet<List<Integer>> unique = new HashSet<>();
//        List<HashSet<List<Integer>>> aList = null;
//        for (int i = 0; i < n; i++) {
//            //every time one pass will be done hashset will be refreshed
//            HashSet<Integer> store = new HashSet<>();
//            for (int j = i + 1; j < n; j++) {
//                int third = -(nums[i] + nums[j]);
//                if (store.contains(third)) {
//                    //found the reqd triplet
//                    List<Integer> temp = new ArrayList<>();
//                    temp.add(nums[i]);
//                    temp.add(nums[j]);
//                    temp.add(third);
//                    //sort temp
//                    Collections.sort(temp);
//                    //add this list to unique set
//                    unique.add(temp);
//                } else {
//                    //store nums[j] in unique set
//                    unique.add(Collections.singletonList(nums[j]));
//                }
//            }
//            //now add current elements of store set into unique set
//            int m = unique.size();
//            aList = new ArrayList<>(m);
//            for (List<Integer> x : unique)
//                aList.add(unique);
//        }//end of i loop
//        return aList;
//    }

    //way 2 using dummy arrays
    public void setZeroes(int[][] matrix) {
    int m= matrix.length;
    int n=matrix[0].length;
    int[] d1=new int[m];
    int[] d2=new int[n];
    Arrays.fill(d1,-1);
    Arrays.fill(d2,-1);
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(matrix[i][j]==0){
                //set values in dummy array
                d1[i]=0;
                d2[j]=0;
            }
        }
    }
    //now we will check dummy arrays and set values accordingly
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(d1[i]==0 || d2[j]==0){
                    //set value of element in matrix as zero
                    matrix[i][j]=0;
                }
            }
        }
    }

//    public int minNumber(int[] nums1, int[] nums2) {
//     int mini=Integer.MAX_VALUE;
//     for(int i:nums1){
//         for(int j:nums2){
//             //traversing both loops first we will search for common elements
//             if(i==j){
//                 //any of these digit can be our ans
//                 mini=Math.min(mini,i);
//             }
//             //else we will select one digit from both
//             else{
//                 Arrays.sort(nums1);
//                 Arrays.sort(nums2);
//                 mini=Math.min(mini,Math.min(nums1[0]*10+nums2[0],nums2[0]*10+nums1));
//             }
//         }
//     }
//     return mini;
//
//    }
    //April 13 leetcode

    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == j) || (i + j == n - 1)) {
                    if (checkPrime(nums[i][j]) == true) {
                        //now we send this element to be checked if its a prime
                        int tempmax = nums[i][j];
                        if (tempmax > maxi) {
                            maxi = tempmax;
                        }
                    }
                }
            }

        }
        return maxi;
    }

    public static boolean checkPrime(int n) {
        //now we will check if the number given to us is prime or not
            int count=0;
        for(int i=2;i*i<=n;i++){
            //only check from 2 till square root if no factor then its prime
            if(n%i==0){
                count++;
            }
        }
        if(count!=0){
            return false;
        }
        return true;
    }

    //q2 sum of distances
    public long[] distance(int[] nums) {
        int n=nums.length;
    long[] arr=new long[n];//same length as nums array
        for(int i=0;i<n;i++){
            for(int j=0;j<n && j!=i;j++){
                if(nums[j]==nums[i]){
                    //valid
                    arr[i]+=Math.abs(j-i);
                }//end of if condition
                else{
                    arr[i]=0;
                }
            }//end of j loop

        }//end of i loop
        return arr;
    }

    //q3 minimise maximum difference
    public int minimizeMax(int[] nums, int p) {
        //sort array so that we can perform binary search on it
        Arrays.sort(nums);
    //we will use binary search to reduce our search space
        int l=0;
        int r=1000000000;
        while(l<r){
            int mid=l+(r-l)/2;
            //now we will check mid
            if(diffPossible(nums,p,nums[mid])==true){
                //no need to search in right half
                r=mid;
            }else{
                //if we get false then we dont need left half
                l=mid+1;
            }
        }
        return l;
    }
    //use this function to check and find if the given difference is the min or not
    public boolean diffPossible(int[] nums,int p,int currDiff){
        //currDiff is the difference that we will be checking for currently
      //here we will check the differences for the reduced search space that we achieved through binary search
        int pair=0;
        for(int i=0;i<nums.length-1;i++){
            //now we will check adjacent elements for their difference
            if(nums[i+1]-nums[i]<=currDiff){
                //valid difference found
                pair++;
                i++;//because we are checking two elements at a time so we need to skip them both next time we iterate
            }
        }
        return (pair>=p);
    }
    //leetcode 339

//q1
    public int findTheLongestBalancedSubstring(String s) {
        int ans=0;
     for(int i=0;i<s.length();){
         if(s.charAt(i)=='0') {
             //we will update i as we go and check each character
             int z = 0;
             int one = 0;
             while (i < s.length() && s.charAt(i) == '0') {
                 z++;
                 i++;

             }
             while (i < s.length() && s.charAt(i) == '1') {
                 one++;
                 i++;
             }
             int len=Math.min(z,one);
             ans=Math.max(ans,2*len);
         }

     }
     return ans; 
    }//end of function









    //bfs traversal
    public ArrayList<Integer> bfsGraph(int V,ArrayList<ArrayList<Integer>> adj){
        //adjacency list is already provided'
        ArrayList<Integer> bfs=new ArrayList<>();//use to store the bfs traversal
        Queue<Integer> q=new LinkedList<>();//queue is an interface which we implement through linked list
        //visited array
        boolean vis[] =new boolean[V];
        //add starting node to the queue
        q.add(0);
        //mark its attendance in visited array
        vis[0]=true;

        while(!q.isEmpty()){
            //taking out the node
            Integer node=q.poll();
            bfs.add(node);//whatever we get from queue will be added to bfs

            for(Integer it: adj.get(node)){
                //adj.get(node) will get us the neighbours of the current node
                //now we will check if these neighbours have been visited or not
                if(vis[it]==false){
                    //not visited then mark attendance and add to queue
                      vis[it] = true;//marking attendance
                    //add to queue
                    q.add(it);

                }
            }
        }//end of while loop
        return bfs;
    }

    public void dfs(int node,boolean vis[],ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> list){//helper function
        //dfs traversal
        //list will store the final dfs traversal

        //first we will mark the current node as visited and then add it to the final dfs list
        vis[node]=true;//here we are checking for each node
        list.add(node);

        //now we will travel to its neighbours
        //for neighbours we need adjacency list
        for(Integer it:adj.get(node)){
            //to get the neighbours of the current node we will need to pass it as parameter to the adjacency list
            //if already visited then leave it
            //else recursion will take place
            if(vis[it]==false){
                //recursion
                dfs(it,vis,adj,list);
            }
        }
    }

    public ArrayList<Integer> dfsGraph(int node,ArrayList<ArrayList<Integer>> adj){
        //visited array will be of size node+1
        boolean vis[]=new boolean[node+1];
        vis[0]=true;
        ArrayList<Integer> ls=new ArrayList<>();//to store final ans or dfs traversal
        dfs(0,vis,adj,ls);
        return ls;
    }
}//main class

