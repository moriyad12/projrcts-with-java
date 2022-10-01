import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface IStack {

    /*** Removes the element at the top of stack and returnsthat element.
     * @return top of stack element, or through exception if empty
     */

    public Object pop();

    /*** Get the element at the top of stack without removing it from stack.
     * @return top of stack element, or through exception if empty
     */

    public Object peek();

    /*** Pushes an item onto the top of this stack.
     * @param object to insert*
     */

    public void push(Object element);

    /*** Tests if this stack is empty
     * @return true if stack empty
     */
    public boolean isEmpty();

    public int size();
}


public class MyStack implements IStack {
    class Node{
        Object item ;
        Node next ;
        public Node(Object item)
        {
            this.item = item ;
            this.next =null ;
        }
    }
    public Node head =null;
    public Node tail =null;
    int length =0;

    @Override
    public void push(Object element)
    {

    @Override
    public Object pop()
    {   if(length!=0)
    {tail=tail.next;
        return 1;}
    else
        return 0;
    }
    @Override
    public Object peek()
    {
        if(length!=0)
        {System.out.println((int)tail.item);
            return 1;}
        else
            return 0;
    }
    @Override
    public boolean isEmpty()
    {
        if(length==0)
            return true;
        else
            return false ;
    }

    @Override
    public int size()
    {
        return length ;
    }

    public void print()
    {
        System.out.print("[");
        Node cur;
        cur=tail;
        if(cur==null)
            System.out.print("");
        else
        { System.out.print((int)cur.item);
            while(cur.next!=null&&cur!=null)
            {
                System.out.print(", ");
                cur=cur.next;
                System.out.print((int)cur.item); }}
        System.out.print("]");

    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        MyStack sa =new MyStack();
        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
        String[] s = sin.split(", ");;
        int[] arr = new int[s.length];
        if (s.length == 1 && s[0].isEmpty())
            arr = new int[]{};
        else {
            for(int i=0;i<s.length;i++)
                arr[i] = Integer.parseInt(s[i]);
            for(int i = s.length-1; i >-1; --i)
                sa.push((Object)arr[i]);}
        String in =sc.nextLine();
        if(in.equals("push"))
        {
            Object x=sc.nextInt();
            sa.push(x);
            sa.print();
        }
        else if (in.equals("pop"))
        {
            if((int)sa.pop()==1)
                sa.print();
            else
                System.out.println("Error");
        }
        else if (in.equals("peek"))
        {
            if((int)sa.peek()!=1)
                System.out.println("Error");
        }
        else if (in.equals("isEmpty"))
        {
            if(sa.isEmpty())
                System.out.println("True");
            else
                System.out.println("False") ;
        }
        else

            System.out.println(sa.size());

    }
}