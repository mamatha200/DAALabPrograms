import java.util.Scanner;
public class Dijkstra1
{
   int d[]=new int[10];
   int p[]=new int[10];
   int visited[]=new int[10];
   public void dijk(int [][]a,int s,int n)
   {
       int u=-1,v,i,j,min;
       for(v=1;v<=n;v++)
       {
           d[v]=99;
           p[v]=-1;
       }
       d[s]=0;
       for(i=1;i<=n;i++)
       {
           min=99;
           for(j=1;j<=n;j++)
           {
               if(d[j]<min && visited[j]==0)
               {
                   min=d[j];
                   u=j;
               }
           }
           visited[u]=1;
           for(v=1;v<=n;v++)
           {
               if((d[u]+a[u][v]<d[v]) && (u!=v)&& visited[v]==0)
               {
                   d[v]=d[u]+a[u][v];
                   p[v]=u;
               }
           }
         }
    }
   
   void path(int v,int s)
   {
       if(p[v]!=-1)
           path(p[v],s);
       System.out.print("->"+v+" ");
   }
   void display(int s,int n)
   {
       int i;
       for(i=1;i<=n;i++)
       {
        path(i,s);
        System.out.print("="+d[i]+"");
        System.out.println();
        }
   }
   
    public static void main(String[] args) {
        int a[][]=new int[10][10];
        int i,j,n,s;
        System.out.println("Enter the number of vertices: ");
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        System.out.println("Enter the weighted matrix: ");
        for(i=1;i<=n;i++)
            for(j=1;j<=n;j++)
                a[i][j]=sc.nextInt();
        System.out.println("Enter the source vertex: ");
        s=sc.nextInt();
        Dijkstra1 tr=new Dijkstra1();
        tr.dijk(a,s,n);
        System.out.println("The shortest path between source "+s+"to remaining vertices are: ");
        tr.display(s,n);
       
    }
}
