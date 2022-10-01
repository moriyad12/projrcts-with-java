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
class MyStack implements IStack {
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
        Node newnode=new Node(element);
        if(length==0)
        {  head =newnode;
            tail=newnode;
            head.next=null;}
        else
        {   newnode.next =tail;
            tail=newnode;
        }
        length++;
    }
    @Override
    public Object pop()
    {   if(length!=0)
    {tail=tail.next;
        length--;
        return 1;}
    else
        return 0;
    }
    @Override
    public Object peek()
    {
        return tail.item;
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
}


interface IExpressionEvaluator {

    /**
     * Takes a symbolic/numeric infix expression as input and converts it to
     * postfix notation. There is no assumption on spaces between terms or the
     * length of the term (e.g., two digits symbolic or numeric term)
     *
     * @param expression infix expression
     * @return postfix expression
     */

    public String infixToPostfix(String expression);


    /**
     * Evaluate a postfix numeric expression, with a single space separator
     * @param expression postfix expression
     * @return the expression evaluated value
     */

    public int evaluate(String expression);

}


public class Evaluator implements IExpressionEvaluator {
    static int [] arr=new int [3];
    static int m=1;
    @Override
    public String infixToPostfix(String expression)
    {   MyStack s=new MyStack();
        int check=0;
        int[] length =new int [100];


        if(expression.charAt(expression.length()-1)=='/'||expression.charAt(expression.length()-1)=='-'||expression.charAt(expression.length()-1)=='*'||expression.charAt(expression.length()-1)=='^'||expression.charAt(expression.length()-1)=='+')
        {
            m=0;

        }

        if(expression.charAt(0)=='*'||expression.charAt(0)=='/'||m==0)
        {
            System.out.println("Error");
            m=0;
            return expression;

        }
        else
        {String a=expression.replaceAll("\\--","+");
            String b=a.replaceAll("\\++","+");
            String c=b.replaceAll("\\+-","-");
            String c2=c.replaceAll("\\-+","-");
            String d=c2.replaceAll("\\-","1");
            String e=d.replaceAll("\\+","2");
            String f=e.replaceAll("\\/","3");
            String g=f.replaceAll("\\*","4");
            String h1=g.replaceAll("\\^","6");
            String h2=h1.replace("62","6");
            String h3=h2.replace("32","3");
            String h=h3.replace("42","4");
            String o="";
            for(int i=0;i<h.length();++i)
            {   if(i<h.length()-1)
                if(((h.charAt(i)=='a'||h.charAt(i)=='b'||h.charAt(i)=='c')&&h.charAt(i+1)=='(')||((h.charAt(i+1)=='a'||h.charAt(i+1)=='b'||h.charAt(i+1)=='c')&&h.charAt(i)==')'))
                {
                    System.out.println("Error");
                    m=0;
                    break;
                }
                if(h.charAt(i)=='2'&&i==0)
                    i++;
                if(h.charAt(i)=='a')
                    o=o+"a";
                else if(h.charAt(i)=='b')
                    o=o+"b";
                else if(h.charAt(i)=='c')
                    o=o+"c";
                else if(h.charAt(i)=='(')
                {
                    check++;
                }
                else if(h.charAt(i)==')')
                {

                    while(length[check]>0)
                    {
                        o=o+String.valueOf(s.peek());
                        s.pop();
                        length[check]--;
                    }
                    check--;
                }
                else if (h.charAt(0)=='1'&&i==0&&h.charAt(1)!='(')
                {
                    if(h.charAt(i+1)=='a')
                    {
                        arr[0]=-arr[0];
                        o=o+"a1";
                    }
                    if(h.charAt(i+1)=='b')
                    {

                        arr[1]=-arr[1];
                        o=o+"b1";

                    }
                    if(h.charAt(i+1)=='c')
                    {
                        arr[2]=-arr[2];
                        o=o+"c1";
                    }
                    i=i+1;
                }

                else
                {
                    if(s.size()==0)
                    { s.push(h.charAt(i));
                        if (check>0)
                            length[check]++;}
                    else{
                        if((Character.getNumericValue((char)s.peek())>Character.getNumericValue(h.charAt(i))-1)||(Character.getNumericValue((char)s.peek())==Character.getNumericValue(h.charAt(i)))||(Character.getNumericValue((char)s.peek())==1&&Character.getNumericValue(h.charAt(i))==2)||(Character.getNumericValue((char)s.peek())==3&&Character.getNumericValue(h.charAt(i))==4))
                        {
                            if (check>0)
                            {
                                while(length[check]>0)
                                {
                                    o=o+String.valueOf(s.peek());
                                    s.pop();
                                    length[check]--;
                                }
                            }
                            else
                            {
                                while(!s.isEmpty()&&((Character.getNumericValue((char)s.peek())>Character.getNumericValue(h.charAt(i))-1)||(Character.getNumericValue((char)s.peek())==Character.getNumericValue(h.charAt(i)))||(Character.getNumericValue((char)s.peek())==1&&Character.getNumericValue(h.charAt(i))==2)||(Character.getNumericValue((char)s.peek())==3&&Character.getNumericValue(h.charAt(i))==4)))
                                {
                                    o=o+String.valueOf(s.peek());
                                    s.pop();

                                }

                            }
                            if(i<h.length())
                                s.push(h.charAt(i));

                        }
                        else{
                            if(check==1)
                                length[check]++;
                            s.push(h.charAt(i));
                        }
                    }
                }

            }
            while(!s.isEmpty())
            {
                o=o+String.valueOf(s.peek());
                s.pop();
            }
            if(check!=0&&m!=0)
            {System.out.println("Error");
                m=0;}

            String a4=o.replaceAll("1","-");
            String b1=a4.replaceAll("2","+");
            String c1=b1.replaceAll("3","/");
            String e1=c1.replaceAll("4","*");
            String d1=e1.replaceAll("6","^");
            return d1;}

    }
    @Override
    public int evaluate(String expression)
    {   MyStack s_=new MyStack();
        int x=0;
        int length =0;
        int check=0;
        for(int i=0;i<expression.length();++i)
        {
            int a=0;
            int b=0;

            if(expression.charAt(i)=='+')
            {   if(length>1)
            {b=(int)s_.peek();
                s_.pop();
                a=(int)s_.peek();
                s_.pop();
                x=a+b;
                s_.push(x);
                length--;}
            }
            else if (expression.charAt(i)=='-'&&i==1)
                a=a;
            else if (expression.charAt(i)=='-')
            {   if(length>1)
            {
                b=(int)s_.peek();
                s_.pop();
                a=(int)s_.peek();
                s_.pop();
                x=a-b;
                s_.push(x);
                length--;}
            else
                check=1;
            }
            else if (expression.charAt(i)=='*')
            {
                if(length>1)
                { b=(int)s_.peek();
                    s_.pop();
                    a=(int)s_.peek();
                    s_.pop();
                    x=a*b;
                    s_.push(x);
                    length--;}
                else
                {System.out.println("Error");
                    m=0;
                    break;}
            }
            else if (expression.charAt(i)=='/')
            {
                if(length>1)
                { b=(int)s_.peek();
                    s_.pop();
                    a=(int)s_.peek();
                    s_.pop();
                    x=a/b;
                    s_.push(x);
                    length--;
                }
                else
                {System.out.println("Error");
                    m=0;
                    break;}
            }
            else if (expression.charAt(i)=='^')
            {   if(length>1)
            {b=(int)s_.peek();
                s_.pop();
                a=(int)s_.peek();
                s_.pop();
                x=(int)Math.pow(a,b);
                s_.push(x);
                length--;}
            else
            {System.out.println("Error");
                m=0;
                break;}
            }
            else if (expression.charAt(i)=='a')
            {  s_.push(arr[0]);
                length++;
            }
            else if (expression.charAt(i)=='b')
            {  s_.push(arr[1]);
                length++;
            }
            else if (expression.charAt(i)=='c')
            {  s_.push(arr[2]);
                length++;
            }

        }
        x=(int)s_.peek();
        if(check==1)
            x=-x;
        return x;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
        Evaluator E=new Evaluator();
        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine();
        String sin1 = sc.nextLine().replaceAll("a=", "");
        String sin2 = sc.nextLine().replaceAll("b=", "");
        String sin3 = sc.nextLine().replaceAll("c=", "");
        arr[0]=Integer.parseInt(sin1);
        arr[1]=Integer.parseInt(sin2);
        arr[2]=Integer.parseInt(sin3);
        String o=E.infixToPostfix(sin);
        if(m==1)
        {   int y=E.evaluate(o);
            if(m==1)
            { System.out.println(o);
                System.out.println(y);}}

    }
}