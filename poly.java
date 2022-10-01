import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


interface IPolynomialSolver {
    /**
     * Set polynomial terms (coefficients & exponents)
     * @param poly: name of the polynomial
     * @param terms: array of [coefficients][exponents]
     */
    void setPolynomial(char poly, int[][] terms);

    /**
     * Print the polynomial in ordered human readable representation
     * @param poly: name of the polynomial
     * @return: polynomial in the form like 27x^2+x-1
     */
    String print(char poly);

    /**
     * Clear the polynomial
     * @param poly: name of the polynomial
     */
    void clearPolynomial(char poly);

    /**
     * Evaluate the polynomial
     * @param poly: name of the polynomial
     * @param value: the polynomial constant value
     * @return the value of the polynomial
     */
    float evaluatePolynomial(char poly, float value);

    /**
     * Add two polynomials
     * @param poly1: first polynomial
     * @param poly2: second polynomial
     * @return the result polynomial
     */
    int[][] add(char poly1, char poly2);

    /**
     * Subtract two polynomials
     * @param poly1: first polynomial
     * @param poly2: second polynomial
     * @return the result polynomial*/
    int[][] subtract(char poly1, char poly2);

    /**
     * Multiply two polynomials
     * @param poly1: first polynomial
     * @param poly2: second polynomial
     * @return: the result polynomial
     */
    int[][] multiply(char poly1, char poly2);
}
class SingleLinkedList  {
    /* Implement your linked list class here*/
    class Node{
        int coff;
        int expon;
        Node next ;

        public Node(int coff, int expon)
        {
            this.coff = coff ;
            this.expon= expon;
            this.next =null ;
        }
    }
    public Node head =null;
    public Node tail =null;
    int length =0;
    public void add(int coff, int expon){
        Node newnode=new Node(coff,expon);
        if(length==0)
        {  head =newnode;
            tail=newnode;}
        else
        {tail.next = newnode;
            tail =newnode;
            newnode.next= null;}
        length++;
    }}


public class PolynomialSolver implements IPolynomialSolver{
    SingleLinkedList lis_a=new SingleLinkedList();
    SingleLinkedList lis_b=new SingleLinkedList();
    SingleLinkedList lis_c=new SingleLinkedList();
    SingleLinkedList lis_r=new SingleLinkedList();

    @Override
    public void setPolynomial(char poly, int[][] terms)
    {
        if(poly=='A')
        {
            for(int i=0;i<terms[0].length;++i)
                lis_a.add(terms[0][i],terms[1][i]);}
        else if(poly=='B')
        {
            for(int i=0;i<terms[0].length;++i)
                lis_b.add(terms[0][i],terms[1][i]);}
        else if(poly=='C')
        {
            for(int i=0;i<terms[0].length;++i)
                lis_c.add(terms[0][i],terms[1][i]);}
        else if (poly=='R')
        {
            for(int i=0;i<terms[0].length;++i)
                lis_r.add(terms[0][i],terms[1][i]);}
    }
    @Override
    public String print(char poly)
    {
        if(poly=='A')
        {
            if(lis_a.length==0)
                return "[]";
            else{
                String a="";
                SingleLinkedList.Node cur=lis_a.head;
                if(cur.coff!=0)
                    a=a+Integer.toString(cur.coff)+" x^"+Integer.toString(cur.expon);
                for(int i=0;i<lis_a.length-2;++i)
                {
                    cur =cur.next ;
                    if(cur.coff!=0)
                        a=a + "+"+Integer.toString(cur.coff)+" x^"+Integer.toString(cur.expon);
                }
                cur =cur.next ;
                String b= a.replaceAll("\\^1","");
                String c= b.replaceAll("1 ","");
                a=c;
                if(cur.coff!=0)
                    a=c + "+"+Integer.toString(cur.coff);
                String d=a.replaceAll("\\+-","-");
                String e=d.replaceAll(" ","");
                return e;}
        }
        else if(poly=='B')
        {
            if(lis_b.length==0)
                return "[]";
            else{
                String a="";
                SingleLinkedList.Node cur=lis_b.head;
                if(cur.coff!=0)
                    a=a+Integer.toString(cur.coff)+" x^"+Integer.toString(cur.expon);
                for(int i=0;i<lis_b.length-2;++i)
                {
                    cur =cur.next ;
                    if(cur.coff!=0)
                        a=a + "+"+Integer.toString(cur.coff)+" x^"+Integer.toString(cur.expon);
                }
                cur =cur.next ;
                String b= a.replaceAll("\\^1","");
                String c= b.replaceAll("1 ","");
                a=c;
                if(cur.coff!=0)
                    a=c + "+"+Integer.toString(cur.coff);
                String d=a.replaceAll("\\+-","-");
                String e=d.replaceAll(" ","");
                return e;}
        }
        else if(poly=='C')
        {
            if(lis_c.length==0)
                return "[]";
            else{
                String a="";
                SingleLinkedList.Node cur=lis_c.head;
                if(cur.coff!=0)
                    a=a+Integer.toString(cur.coff)+" x^"+Integer.toString(cur.expon);
                for(int i=0;i<lis_c.length-2;++i)
                {
                    cur =cur.next ;
                    if(cur.coff!=0)
                        a=a + "+"+Integer.toString(cur.coff)+" x^"+Integer.toString(cur.expon);
                }
                cur =cur.next ;
                String b= a.replaceAll("\\^1","");
                String c= b.replaceAll("1 ","");
                a=c;
                if(cur.coff!=0)
                    a=c + "+"+Integer.toString(cur.coff);
                String d=a.replaceAll("\\+-","-");
                String e=d.replaceAll(" ","");
                return e;}
        }
        else
        {
            if(lis_r.length==0)
                return "[]";
            else{String a="";
                SingleLinkedList.Node cur=lis_r.head;
                if(cur.coff!=0)
                    a=a+Integer.toString(cur.coff)+" x^"+Integer.toString(cur.expon);
                for(int i=0;i<lis_r.length-2;++i)
                {
                    cur =cur.next ;
                    if(cur.coff!=0)
                        a=a + "+"+Integer.toString(cur.coff)+" x^"+Integer.toString(cur.expon);
                }
                cur =cur.next ;
                String b= a.replaceAll("\\^1","");
                String c= b.replaceAll("1 ","");
                a=c + "+"+Integer.toString(cur.coff);
                String d=a.replaceAll("\\+-","-");
                String e=d.replaceAll(" ","");
                return e;}
        }
    }
    @Override
    public void clearPolynomial(char poly)
    {
        if(poly=='A')
        { SingleLinkedList.Node cur= lis_a.head;
            for(int i=0;i<lis_a.length;++i)
            {
                cur.expon=0;
                cur.coff=0;
                cur =cur.next;
            }
            lis_a.length=0;}
        else if(poly=='B')
        { SingleLinkedList.Node cur= lis_b.head;
            for(int i=0;i<lis_b.length;++i)
            {
                cur.expon=0;
                cur.coff=0;
                cur =cur.next;
            }
            lis_b.length=0;}
        else if(poly=='C')
        { SingleLinkedList.Node cur= lis_c.head;
            for(int i=0;i<lis_c.length;++i)
            {
                cur.expon=0;
                cur.coff=0;
                cur =cur.next;
            }
            lis_c.length=0;}
        else if (poly=='R')
        { SingleLinkedList.Node cur= lis_r.head;
            for(int i=0;i<lis_r.length;++i)
            {
                cur.expon=0;
                cur.coff=0;
                cur =cur.next;
            }
            lis_r.length=0;}
    }
    @Override
    public float evaluatePolynomial(char poly, float value)
    {
        if(poly=='A')
        { if(lis_a.length==0)
            return 0;
        else
        {  float x=0;
            SingleLinkedList.Node cur= lis_a.head;
            for(int i=0;i<lis_a.length;++i)
            {
                x+=cur.coff*Math.pow(value,cur.expon);
                cur =cur.next;
            }
            return x;}
        }
        else if(poly=='B')
        { if(lis_b.length==0)
            return 0;
        else
        {  float x=0;
            SingleLinkedList.Node cur= lis_b.head;
            for(int i=0;i<lis_b.length;++i)
            {
                x+=cur.coff*Math.pow(value,cur.expon);
                cur =cur.next;
            }
            return x;}
        }
        else if(poly=='C')
        { if(lis_c.length==0)
            return 0;
        else
        {  float x=0;
            SingleLinkedList.Node cur= lis_c.head;
            for(int i=0;i<lis_c.length;++i)
            {
                x+=cur.coff*Math.pow(value,cur.expon);
                cur =cur.next;
            }
            return x;}
        }
        else
        { if(lis_r.length==0)
            return 0;
        else
        {  float x=0;
            SingleLinkedList.Node cur= lis_r.head;
            for(int i=0;i<lis_r.length;++i)
            {
                x+=cur.coff*Math.pow(value,cur.expon);
                cur =cur.next;
            }
            return x;}
        }
    }
    @Override
    public int[][] add(char poly1, char poly2)
    {
        if((poly1=='A'&&poly2=='B')||(poly1=='B'&&poly2=='A'))
        {
            if(lis_a.length>lis_b.length)
            {
                int[][]arr= new int[lis_a.length][lis_a.length];
                SingleLinkedList.Node cur =lis_a.head ;
                for(int i=0;i<lis_a.length;++i)
                {
                    arr[0][i]=cur.coff;
                    arr[1][i]=cur.expon;
                    cur =cur.next;
                }
                cur = lis_b.head ;
                for(int i=0;i<lis_b.length;++i)
                {
                    arr[0][i]+=cur.coff;
                    cur =cur.next;
                }
                return arr;

            }
            else
            {
                int[][]arr= new int[lis_b.length][lis_b.length];
                SingleLinkedList.Node cur =lis_b.head ;
                for(int i=0;i<lis_b.length;++i)
                {
                    arr[0][i]=cur.coff;
                    arr[1][i]=cur.expon;
                    cur =cur.next;
                }
                cur = lis_a.head ;
                for(int i=0;i<lis_a.length;++i)
                {
                    arr[0][i]+=cur.coff;
                    cur =cur.next;
                }


                return arr ;}
        }
        else if((poly1=='A'&&poly2=='C')||(poly1=='C'&&poly2=='A'))
        {
            if(lis_a.length>lis_c.length)
            {
                int[][]arr= new int[lis_a.length][lis_a.length];
                SingleLinkedList.Node cur =lis_a.head ;
                for(int i=0;i<lis_a.length;++i)
                {
                    arr[0][i]=cur.coff;
                    arr[1][i]=cur.expon;
                    cur =cur.next;
                }
                cur = lis_c.head ;
                for(int i=0;i<lis_c.length;++i)
                {
                    arr[0][i]+=cur.coff;
                    cur =cur.next;
                }
                return arr;
            }
            else
            {
                int[][]arr= new int[lis_c.length][lis_c.length];
                SingleLinkedList.Node cur =lis_c.head ;
                for(int i=0;i<lis_c.length;++i)
                {
                    arr[0][i]=cur.coff;
                    arr[1][i]=cur.expon;
                    cur =cur.next;
                }
                cur = lis_a.head ;
                for(int i=0;i<lis_a.length;++i)
                {
                    arr[0][i]+=cur.coff;
                    cur =cur.next;
                }


                return arr ;}
        }
        else
        {
            if(lis_b.length>lis_c.length)
            {
                int[][]arr= new int[lis_b.length][lis_b.length];
                SingleLinkedList.Node cur =lis_b.head ;
                for(int i=0;i<lis_b.length;++i)
                {
                    arr[0][i]=cur.coff;
                    arr[1][i]=cur.expon;
                    cur =cur.next;
                }
                cur = lis_c.head ;
                for(int i=0;i<lis_c.length;++i)
                {
                    arr[0][i]+=cur.coff;
                    cur =cur.next;
                }
                return arr;
            }
            else
            {
                int[][]arr= new int[lis_c.length][lis_c.length];
                SingleLinkedList.Node cur =lis_c.head ;
                for(int i=0;i<lis_c.length;++i)
                {
                    arr[0][i]=cur.coff;
                    arr[1][i]=cur.expon;
                    cur =cur.next;
                }
                cur = lis_b.head ;
                for(int i=0;i<lis_b.length;++i)
                {
                    arr[0][i]+=cur.coff;
                    cur =cur.next;
                }


                return arr ;}
        }
    }
    @Override
    public int[][] subtract(char poly1, char poly2)
    {
        if((poly1=='A'&&poly2=='B')||(poly1=='B'&&poly2=='A'))
        {
            if(lis_a.length>lis_b.length)
            {
                int[][]arr= new int[lis_a.length][lis_a.length];
                SingleLinkedList.Node cur =lis_a.head ;
                for(int i=0;i<lis_a.length;++i)
                {
                    if(poly1=='A')
                        arr[0][i]+=cur.coff;
                    else
                        arr[0][i]-=cur.coff;
                    arr[1][i]=cur.expon;
                    cur =cur.next;
                }
                cur = lis_b.head ;
                for(int i=0;i<lis_b.length;++i)
                {   if(poly1=='B')
                    arr[0][i]+=cur.coff;
                else
                    arr[0][i]-=cur.coff;
                    cur =cur.next;
                }
                return arr;
            }
            else
            {
                int[][]arr= new int[lis_b.length][lis_b.length];
                SingleLinkedList.Node cur =lis_b.head ;
                for(int i=0;i<lis_b.length;++i)
                {
                    if(poly1=='B')
                        arr[0][i]+=cur.coff;
                    else
                        arr[0][i]-=cur.coff;
                    arr[1][i]=cur.expon;
                    cur =cur.next;
                }
                cur = lis_a.head ;
                for(int i=0;i<lis_a.length;++i)
                {
                    if(poly1=='A')
                        arr[0][i]+=cur.coff;
                    else
                        arr[0][i]-=cur.coff;
                    cur =cur.next;
                }


                return arr ;}
        }
        else if((poly1=='A'&&poly2=='C')||(poly1=='C'&&poly2=='A'))
        {
            if(lis_a.length>lis_c.length)
            {
                int[][]arr= new int[lis_a.length][lis_a.length];
                SingleLinkedList.Node cur =lis_a.head ;
                for(int i=0;i<lis_a.length;++i)
                {
                    if(poly1=='A')
                        arr[0][i]+=cur.coff;
                    else
                        arr[0][i]-=cur.coff;
                    arr[1][i]=cur.expon;
                    cur =cur.next;
                }
                cur = lis_c.head ;
                for(int i=0;i<lis_c.length;++i)
                {
                    if(poly1=='C')
                        arr[0][i]+=cur.coff;
                    else
                        arr[0][i]-=cur.coff;
                    cur =cur.next;
                }
                return arr;
            }
            else
            {
                int[][]arr= new int[lis_c.length][lis_c.length];
                SingleLinkedList.Node cur =lis_c.head ;
                for(int i=0;i<lis_c.length;++i)
                {
                    if(poly1=='C')
                        arr[0][i]+=cur.coff;
                    else
                        arr[0][i]-=cur.coff;
                    arr[1][i]=cur.expon;
                    cur =cur.next;
                }
                cur = lis_a.head ;
                for(int i=0;i<lis_a.length;++i)
                {
                    if(poly1=='A')
                        arr[0][i]+=cur.coff;
                    else
                        arr[0][i]-=cur.coff;
                    cur =cur.next;
                }


                return arr ;}
        }
        else
        {
            if(lis_b.length>lis_c.length)
            {
                int[][]arr= new int[lis_b.length][lis_b.length];
                SingleLinkedList.Node cur =lis_b.head ;
                for(int i=0;i<lis_b.length;++i)
                {
                    if(poly1=='B')
                        arr[0][i]+=cur.coff;
                    else
                        arr[0][i]-=cur.coff;
                    arr[1][i]=cur.expon;
                    cur =cur.next;
                }
                cur = lis_c.head ;
                for(int i=0;i<lis_c.length;++i)
                {
                    if(poly1=='C')
                        arr[0][i]+=cur.coff;
                    else
                        arr[0][i]-=cur.coff;
                    cur =cur.next;
                }
                return arr;
            }
            else
            {
                int[][]arr= new int[lis_c.length][lis_c.length];
                SingleLinkedList.Node cur =lis_c.head ;
                for(int i=0;i<lis_c.length;++i)
                {
                    if(poly1=='C')
                        arr[0][i]+=cur.coff;
                    else
                        arr[0][i]-=cur.coff;
                    arr[1][i]=cur.expon;
                    cur =cur.next;
                }
                cur = lis_b.head ;
                for(int i=0;i<lis_b.length;++i)
                {
                    if(poly1=='B')
                        arr[0][i]+=cur.coff;
                    else
                        arr[0][i]-=cur.coff;
                    cur =cur.next;
                }


                return arr ;}
        }
    }
    @Override
    public int[][] multiply(char poly1, char poly2)
    {
        if(poly1=='A'&&poly2=='B'||poly1=='B'&&poly2=='A')
        { int[][] arr =new int [2][lis_a.length+lis_b.length-1];

            SingleLinkedList.Node cur1 =lis_a.head;
            SingleLinkedList.Node cur2 =lis_b.head;
            for(int j=0;j<lis_b.length;++j)
            {for(int i=0;i<lis_a.length;++i)
            {
                arr[0][lis_a.length+lis_b.length-2-cur1.expon-cur2.expon]+=cur1.coff*cur2.coff;
                cur1=cur1.next;
            }
                cur2=cur2.next;
                cur1=lis_a.head;}
            for(int i=0;i<lis_a.length+lis_b.length-2;++i)
                arr[1][i]=lis_a.length+lis_b.length-2-i;
            return arr;}
        else if(poly1=='A'&&poly2=='C'||poly1=='C'&&poly2=='A')
        { int[][] arr =new int [2][lis_a.length+lis_b.length-1];

            SingleLinkedList.Node cur1 =lis_a.head;
            SingleLinkedList.Node cur2 =lis_c.head;
            for(int j=0;j<lis_c.length;++j)
            {for(int i=0;i<lis_a.length;++i)
            {
                arr[0][lis_a.length+lis_c.length-2-cur1.expon-cur2.expon]+=cur1.coff*cur2.coff;
                cur1=cur1.next;
            }
                cur2=cur2.next;
                cur1=lis_a.head;}
            for(int i=0;i<lis_a.length+lis_c.length-2;++i)
                arr[1][i]=lis_a.length+lis_c.length-2-i;
            return arr;}
        else
        { int[][] arr =new int [2][lis_c.length+lis_b.length-1];

            SingleLinkedList.Node cur1 =lis_c.head;
            SingleLinkedList.Node cur2 =lis_b.head;
            for(int j=0;j<lis_b.length;++j)
            {for(int i=0;i<lis_c.length;++i)
            {
                arr[0][lis_c.length+lis_b.length-2-cur1.expon-cur2.expon]+=cur1.coff*cur2.coff;
                cur1=cur1.next;
            }
                cur2=cur2.next;
                cur1=lis_c.head;}
            for(int i=0;i<lis_c.length+lis_b.length-2;++i)
                arr[1][i]=lis_c.length+lis_b.length-2-i;
            return arr;}


    }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        PolynomialSolver pol = new PolynomialSolver();
        Scanner scan= new Scanner(System.in);

        while(scan.hasNextLine())
        {String a= scan.nextLine();
            if(a.equals("set"))
            {

                char b = scan.next().charAt(0);
                String sin = scan.next().replaceAll("\\[|\\]", "");
                if (sin.length() != 0) {
                    String[] str = sin.split(",");
                    int[] arr1 =new int [str.length];
                    for (int i = 0; i < str.length; ++i)
                        arr1[i]=Integer.parseInt(str[i]);

                    int[][] arr1_ = new int[2][arr1.length];
                    for(int i = 0; i < arr1.length; ++i)
                    {
                        arr1_[0][i]=arr1[i];
                        arr1_[1][i]=str.length-i-1;
                    }
                    pol.setPolynomial(b, arr1_);}}


            else if(a.equals("print"))
            {
                char b = scan.next().charAt(0);
                System.out.println(pol.print(b));

            }
            else if(a.equals("add"))
            {
                char b = scan.next().charAt(0);
                char c = scan.next().charAt(0);
                int[][] arr_a=pol.add(b, c);
                pol.setPolynomial('R', arr_a);
                System.out.println(pol.print('R'));


            }
            else if(a.equals("sub"))
            {
                char b = scan.next().charAt(0);
                char c = scan.next().charAt(0);
                int[][] arr_s= pol.subtract(b,c);
                pol.setPolynomial('R', arr_s);
                System.out.println(pol.print('R'));
            }
            else if(a.equals("eval"))
            {

                char c = scan.next().charAt(0);
                int b= scan.nextInt();
                float x=pol.evaluatePolynomial(c,b);
                System.out.println((int)x);


            }
            else if(a.equals("mult"))
            {
                char b = scan.next().charAt(0);
                char c = scan.next().charAt(0);
                int[][] arr_m=pol.multiply(b, c);
                pol.setPolynomial('R', arr_m);
                System.out.println(pol.print('R'));

            }
            else if(a.equals("clear"))
            {
                char b = scan.next().charAt(0);
                pol.clearPolynomial(b);
                System.out.println(pol.print(b));}

        }

    }
}

