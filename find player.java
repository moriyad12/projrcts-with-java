import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


interface IPlayersFinder {

    /**
     * Search for players locations at the given photo
     * @param photo
     *     Two dimension array of photo contents
     *     Will contain between 1 and 50 elements, inclusive
     * @param team
     *     Identifier of the team
     * @param threshold
     *     Minimum area for an element
     *     Will be between 1 and 10000, inclusive
     * @return
     *     Array of players locations of the given team
     */
    int[] findPlayers(String[] photo, int team, int threshold,int m, int n);
}


public class PlayersFinder implements IPlayersFinder{
    /*
       Implement your class here
    */
    static int count=0,conter=0;
    static int x1=0,x2=0,y1=0,y2=0;
    static String[] photo= new String[500];
    static int[][] photo_= new int[500][5000];
    @Override
    public int[] findPlayers(String[] photo, int team, int threshold,int m,int n)
    {
        int[] arr =new int[500];


        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
                if(photo_[i][j]==team)
                { count=0;
                    x1=j;
                    x2=j;
                    y1=i;
                    y2=i;
                    search(i,j,team,threshold,m,n);
                    if (count*4>=threshold)
                    {arr[conter++]=(2*x1+(2*x2+2))/2;
                        arr[conter++]=(2*y1+(2*y2+2))/2;}

                }

        }
        return arr ;
    }
    public void search(int i,int j,int k,int threshold,int m,int n )
    {


        if(i>-1&&i<m&&j>-1&&j<n)
        {if(photo_[i][j]==k)
        {
            count++;
            photo_[i][j]=-1;
            if(x1>j)
                x1=j;
            if(x2<j)
                x2=j;
            if(y1>i)
                y1=i;
            if(y2<i)
                y2=i;
            search(i+1,j,k,threshold,m,n);
            search(i-1,j,k,threshold,m,n);
            search(i,j+1,k,threshold,m,n);
            search(i,j-1,k,threshold,m,n);
            return;
        }
        else
            return;
        }
        else
            return ;
    }
    public static void main(String[] args) {
        /* Implement main method to parse the input from stdin and print output to stdout */
        Scanner scan =new Scanner(System.in);
        String a = scan.nextLine();
        String[] b = a.split(", ");
        int m =Integer.parseInt(b[0]);
        int n =Integer.parseInt(b[1]);
        if(m==0&&n==0)
            System.out.print("[]");
        else{

            for(int i=0;i<m;i++)
            {photo[i] = scan.nextLine();

            }
            int k =scan.nextInt()+48 ;
            for(int i=0;i<m;i++)
            { if(n!=photo[i].length())
                n=photo[i].length();
                for(int j=0;j<n;j++)
                {
                    photo_[i][j]=photo[i].charAt(j);
                    if(photo_[i][j]!=k)
                        photo_[i][j]=-1;
                }
            }
            int area =scan.nextInt() ;
            PlayersFinder sol =new PlayersFinder();
            int[] arr2=sol.findPlayers(photo,k,area,m,n);
            int [][]arr3= new int[conter/2][2];
            int z=0;
            for(int i=0;i<conter/2;i++)
            {
                for(int j=0;j<2;j++)
                {
                    arr3[i][j]=arr2[z++];
                }
            }
            for(int i=0;i<arr3.length;i++)
            {
                for(int j=i+1;j<arr3.length;j++)
                {
                    if(arr3[i][0]>arr3[j][0])
                    {
                        int temp =arr3[i][0];
                        arr3[i][0]=arr3[j][0];
                        arr3[j][0]=temp;
                        temp =arr3[i][1];
                        arr3[i][1]=arr3[j][1];
                        arr3[j][1]=temp;
                    }
                }
            }
            for(int i=0;i<arr3.length-1;i++)
            {
                if(arr3[i][0]==arr3[i+1][0])
                {
                    if(arr3[i][1]>arr3[i+1][1])
                    {
                        int temp= arr3[i][1];
                        arr3[i][1]=arr3[i+1][1];
                        arr3[i+1][1]=temp;
                    }
                }
            }
            System.out.print("[");
            for(int i = 0; i < arr3.length; i++)
            {
                System.out.print("(");
                for(int j=0;j<arr3[0].length;j++)
                {
                    System.out.print(arr3[i][j]);
                    if(j!=arr3[0].length-1)
                        System.out.print(", ");

                }
                System.out.print(")");
                if(i!=arr3.length-1)
                    System.out.print(", ");

            }
            System.out.print("]");
        }
    }
}




