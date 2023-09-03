import java.util.Scanner;
public class PrimsMst {
    public static void prims(int cost[][],int source,int n)
    {
        int vertex=0;//initialises variable vertex to zero.
        int u=0,v=0,i,j,min,totalcost=0;
        int tvertex[]=new int[10];//declare and initialise an array tvertex of size 10
        tvertex[source]=1;//set the source vertex in tvertex array to 1 to mark it as visited
      
 
while (vertex<n-1)//continues until vertex reaches n-1
{
min=999;//initialises minimum to a large value
for(i=0;i<n;i++)
{
    if(tvertex[i]==1)//check if the vertex i has been visited.
    {
       for(j=0;j<n;j++) 
       {
           if(tvertex[j]==0&&cost[i][j]<min)//check if the vertex j has not been visited&if the cost between vertex i and j is smaller than the current minimum
           {
               min=cost[i][j];
                u=i;//store the value of i in u
                v=j; //store the value of j in v
           }
       }
    }
}
System.out.println("The edge from "+u+"->"+v+"is"+min);
tvertex[v]=1;//set the vertex v as visited in the minimum spanning tree.
vertex++;//incerement the count of visited vertex in the mst
totalcost=totalcost+min;


}
        System.out.println("The totalcost of minimum spannig tree="+totalcost);
    }
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        n=sc.nextInt();
        int[][]cost=new int[10][10];
        System.out.println("Enter cost matrix");   
        for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
        cost[i][j]=sc.nextInt();
        System.out.println("Enter the source vertex:");
        int source=sc.nextInt();
     
       prims(cost,source,n);
    }
    
}
