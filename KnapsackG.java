import java.util.Scanner;
public class KnapsackG
{
    public static void GKnapsack(int n,double m,double[]p,double[]w)
    {
       
        int i;
        for(i=0;i<n-1;i++)
        {
            int max=i;
            for(int j=i+1;j<n;j++)
            {
               if((p[j]/w[j])>(p[max]/w[max]))
                       {
                           max=j;
                       }
                       double temp=w[i];
                       w[i]=w[max];
                       w[max]=temp;
                       temp=p[i];
                       p[i]=p[max];
                       p[max]=temp;
            }
        }
       
        double x[]=new double[n];
        for(i=0;i<n;i++)
        {
            x[i]=0.0;
        }
        double U=m;
        for(i=0;i<n;i++)
        {
           if(w[i]>U)break;
           x[i]=1.0;
           U=U-w[i];
        }
        if(i<=n)
        {
            x[i]=U/w[i];
        }
        double netProfit=0.0;
        for(i=0;i<n;i++)
        {
            if(x[i]>0.0)
            {
                netProfit=netProfit+x[i]*p[i];
            }
        }
            
    System.out.println("The objects picked up into knapsack are:");
    System.out.println("Profit"+"\t\t"+"Weights"+"\t\t"+"Fraction taken ");
    for(i=0;i<n;i++)
    {
        System.out.println(p[i]+"\t\t\t"+w[i]+"\t\t\t"+x[i]);
           
        
    }
    System.out.println("Net profit:"+netProfit);
         
    }
    public static void main(String[] args) {
        int n;
        double m;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of objects:");
        n=sc.nextInt();
        double[]p=new double[n];
        double[]w=new double[n];
        int i;
        System.out.println("Enter the capacity of Knapsack:");
        m=sc.nextDouble();
        System.out.println("Enter profit for each"+n+"objects");
        for(i=0;i<n;i++)
        {
            p[i]=sc.nextDouble();
        }
        System.out.println("Enter weight for each"+n+"objects");
        for(i=0;i<n;i++)
        {
            w[i]=sc.nextDouble();
        }
         GKnapsack(n,m,p,w);   
    }
    
}