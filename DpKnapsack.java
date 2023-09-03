import java.util.Scanner;
public class DpKnapsack{
    public void solve(int[]wt,int[]val,int m,int n)
    {
        int i,j;
        int[][]sol=new int[20][20];
        for(i=0;i<=n;i++)
        {
            for(j=0;j<=m;j++)
            {
                if(i==0||j==0)
                    sol[i][j]=0;
                else if(wt[i]>j)
                    sol[i][j]=sol[i-1][j];
                else
                    sol[i][j]=Math.max((sol[i-1][j]),(sol[i-1][j-wt[i]])+val[i]);
       
                }
            }
        System.out.println("The maximum profit is:"+sol[n][m]);
        int[]selected=new int[20];
        for(i=0;i<=n;i++)
        selected[i]=0;
         i=n;
         j=m;
         while(i>0&&j>0)
         {
               if(sol[i][j]!=sol[i-1][j])
               {
                selected[i]=1;
                j=j-wt[i];
               }
               i--;
         }
        
           System.out.println("\n Items selected:");
           for(i=1;i<=n;i++)
           {
              if(selected[i]==1)
              {
              System.out.println(i+" ");
              
              System.out.println();
              }
           }
        }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        DpKnapsack ks=new DpKnapsack();
        System.out.println("Enter no of elements:");
        int n=sc.nextInt();
        int[]weight=new int[20];
        int[]profit=new int[20];
        System.out.println("Enter weight of "+n+" objects");
        for(int i=1;i<=n;i++)
        weight[i]=sc.nextInt();
        System.out.println("Enter profit of "+n+" objects");
        for(int i=1;i<=n;i++)
        profit[i]=sc.nextInt();
        System.out.println("Enter knapsack weight:");
        int m=sc.nextInt();
        ks.solve(weight,profit,m,n);
    }
    }

