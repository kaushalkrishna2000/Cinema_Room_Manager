
package cinema;
import java.util.*;
public class Cinema {
    static int[][] mat =new int[9][9];
    static int cost=0;
    static void display(int a,int b)
    {
        System.out.println("\nCinema:");
        {
            System.out.print("  ");
            for (int i = 1; i <= b; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        {
            for(int i=0;i<a;i++)
            {
                System.out.print((i+1)+" ");
                for(int j=0;j<b;j++)
                {
                    System.out.print(((mat[i][j]==1)?"B ":"S "));
                }
                System.out.println();
            }
        }

        
    }
    static void buy(int a,int b)
    {
        int s=a*b;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a row number:");
        int r1 = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        int c1 = sc.nextInt();

        while(((r1-1)>(a-1) || (c1-1)>(b-1)) || mat[r1-1][c1-1]==1 )
        {
            if((r1-1)>(a-1) || (c1-1)>(b-1))
                System.out.println("Wrong input!");
            else
                System.out.println("That ticket has already been purchased!\n");
            System.out.println("Enter a row number:");
            r1 = sc.nextInt();
            System.out.println("Enter a seat number in that row:");
            c1 = sc.nextInt();
        }

        if(s<=60) {

            System.out.println("\nTicket price: $" + (10));
            mat[r1-1][c1-1]=1;
            cost+=10;
        }
        else
        {
            int h1=(a/2);

            if(r1<=h1)
            {System.out.println("\nTicket price: $"+(10));cost+=10;}
            else
            {System.out.println("\nTicket price: $"+(8));cost+=8;}

            mat[r1-1][c1-1]=1;
        }
    }
    static void menu()
    {
        System.out.println("1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "3. Statistics\n" +
                "0. Exit");
    }
    static void stats(int r,int c) {
        int c1=0;int tot;
        {
            for (int i = 0; i < r; i++)
                for (int j = 0; j < c; j++)
                    if (mat[i][j] == 1) c1++;
        }

        double per=(c1)/(r*c*1.0);

        int s=r*c;
        if(s<=60) tot=s*10;
        else {
            int s1=(r/2)*c*10;
            int s2=(r-(r/2))*c*8;
            tot=s1+s2;
        }


        System.out.println("Number of purchased tickets: "+c1);
        System.out.printf("Percentage: %.2f%% \n",per);
        System.out.printf("Current income: $%d\n" +
                "Total income: $%d\n\n",cost,tot);

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int r,c;
        System.out.println("Enter the number of rows:");
        r=sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        c=sc.nextInt();

        while(true)
        {
            menu();
            int ch=sc.nextInt();
            if(ch==1)
                display(r,c);
            else if(ch==2)
                buy(r,c);
            else if(ch==3)
                stats(r,c);
            else
                break;
        }



    }


}