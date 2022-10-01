import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface ILinkedList {
    /**
     * Inserts a specified element at the specified position in the list.
     * @param index
     * @param element
     */
    public int add(int index, int element);
    /**
     * Inserts the specified element at the end of the list.
     * @param element
     */
    public void add(int element);
    /**
     * @param index
     * @return the element at the specified position in this list.
     */
    public void get(int index);

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     * @param index
     * @param element
     */
    public int set(int index, int element);
    /**
     * Removes all of the elements from this list.
     */
    public void clear();
    /**
     * @return true if this list contains no elements.
     */
    public boolean isEmpty();
    /**
     * Removes the element at the specified position in this list.
     * @param index
     */
    public int remove(int index);
    /**
     * @return the number of elements in this list.
     */
    public int size();
    /**
     * @param fromIndex
     * @param toIndex
     * @return a view of the portion of this list between the specified fromIndex and toIndex, inclusively.
     */
    public int sublist(int fromIndex, int toIndex);
    /**
     * @param o
     * @return true if this list contains an element with the same value as the specified element.
     */
    public boolean contains(int o);
}


public class SingleLinkedList implements ILinkedList {
    /* Implement your linked list class here*/
    class Node{
        int item ;
        Node next ;
        Node previous ;
        public Node(int item)
        {
            this.item = item ;
            this.next =null ;
            this.previous=null;
        }
    }
    public Node head =null;
    public Node tail =null;
    int length =0;
    @Override
    public void add(int element){
        Node newnode=new Node(element);
        if(length==0)
        {  head =newnode;
            tail=newnode;
            newnode.previous=null;}
        else
        {tail.next = newnode;
            newnode.previous=tail;
            tail =newnode;
            newnode.next= null;}
        length++;
    }
    @Override
    public int add(int index, int element)
    {    if(index>length||index<0)
    {System.out.print("Error");
        return 0;}
    else{
        Node newnode=new Node(element);
        if(index==0)
        {
            newnode.next=head;
            head =newnode;
            newnode.previous=null;
        }
        else
        {
            Node cur;
            cur =head ;
            for(int i=0;i<index-1;++i)
                cur=cur.next;
            newnode.next=cur.next;
            cur.next =newnode;
            cur.next.previous=newnode;
            newnode.previous=cur;}
        length++;
        return 1;}
    }
    @Override
    public boolean isEmpty()
    {
        if(length==0)
            return true ;
        else
            return false ;
    }
    @Override
    public int set(int index, int element)
    {    if(index>=length||index<0)
    {System.out.print("Error");
        return 0;}
    else{
        Node cur;
        cur =head ;
        for(int i=0;i<index;++i)
            cur=cur.next;
        cur.item=element;
        return 1;}

    }
    @Override
    public void get(int index)
    {   if(index>=length||index<0)
        System.out.print("Error");
    else{
        Node cur;
        cur =head ;
        for(int i=0;i<index;++i)
            cur=cur.next;
        System.out.print(cur.item);}
    }
    @Override
    public int size()
    {
        return length;
    }
    @Override
    public boolean contains(int o)
    {
        Node cur ;
        cur =head ;
        while(cur.item!=o&&cur.next!=null)
            cur =cur.next;
        if(cur.item==o)
            return true;
        else
            return false ;
    }
    @Override
    public int remove(int index){
        if(index>=length||index<0)
        {System.out.print("Error");
            return 0;}
        else{
            if(index==0)
            {head=head.next;
                head.previous=null;}
            else{
                Node cur =head;
                Node cur_=null;
                for(int i=0;i<index;++i)
                {
                    cur_=cur;
                    cur=cur.next;
                }
                cur_.next=cur.next;
                if(index!=length-1)
                    cur.next.previous=cur_;}
            length --;
            return 1;
        }
    }
    @Override
    public void clear()
    {
        head.next=null;
        head=null;
        length=0;
    }
    public int sublist(int fromIndex, int toIndex)
    {
        if(fromIndex>=length||toIndex>=length)
        {System.out.print("Error");
            return 0;}
        else{
            Node cur ;
            cur = head ;
            for(int i=0;i<fromIndex;++i)
            {
                cur=cur.next;
            }
            head =cur;
            head.previous=null;
            for(int i= fromIndex;i<toIndex;++i)
            {
                cur=cur.next;
            }
            cur.next=null;
            return 1;}
    }
    public void print()
    {
        System.out.print("[");
        Node cur;
        cur=head;
        if(cur==null)
            System.out.print("");
        else
        { System.out.print(cur.item);
            while(cur.next!=null&&cur!=null)
            {
                System.out.print(", ");
                cur=cur.next;
                System.out.print(cur.item); }}
        System.out.print("]");
    }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
        SingleLinkedList lis=new SingleLinkedList();
        Scanner scan=new Scanner(System.in);
        String sin = scan.nextLine().replaceAll("\\[|\\]", "");
        String[] s = sin.split(", ");;
        int[] arr = new int[s.length];
        if (s.length == 1 && s[0].isEmpty())
            arr = new int[]{};
        else {
            for(int i = 0; i < s.length; ++i)
                arr[i] = Integer.parseInt(s[i]);

            for(int i=0;i<s.length;++i)
            {
                lis.add(arr[i]);
            }
        }
        String a =scan.nextLine();
        if(a.equals("add"))
        {
            int m=scan.nextInt();
            lis.add(m);
            lis.print();

        }
        else if(a.equals("addToIndex"))
        {
            int m=scan.nextInt();
            int n=scan.nextInt();
            if(lis.add(m,n)==1)
                lis.print();

        }
        else if(a.equals("isEmpty"))
        {
            if(lis.isEmpty())
                System.out.print("True");
            else
                System.out.print("False");
        }
        else if(a.equals("set"))
        {
            int m=scan.nextInt();
            int n=scan.nextInt();
            if(lis.set(m,n)==1)
                lis.print();
        }
        else if(a.equals("get"))
        {
            int m=scan.nextInt();
            lis.get(m);
        }
        else if(a.equals("size"))
        {
            System.out.print(lis.size());
        }
        else if (a.equals("contains"))
        {
            int m=scan.nextInt();
            if(lis.contains(m))
                System.out.print("True");
            else
                System.out.print("False");
        }
        else if (a.equals("remove"))
        {
            int m=scan.nextInt();
            if(lis.remove(m)==1)
                lis.print();
        }
        else if (a.equals("clear"))
        {

            if(sin.equals(""))
                System.out.print("[]");

            else
            {lis.clear();
                lis.print();}

        }
        else if (a.equals("sublist"))
        {
            int m=scan.nextInt();
            int n=scan.nextInt();
            if(m>n||m<0||n<0)
                System.out.print("Error");
            else
            {
                if(lis.sublist(m,n)==1)
                    lis.print();}
        }

    }
}