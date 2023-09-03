import java.util.Scanner;
public class HamiltonianCycles
{
    
int n,g[][],x[],i,j,k;
public HamiltonianCycles(int n,int[][] g)
{
this.n=n;//: Represents the number of vertices in the graph.
this.g=g;//: Represents the number of vertices in the graph.
this.x = new int[n+1];// Represents the array for the Hamiltonian cycle.
x[1]=1;
}
public void hamiltonian(int k)
{
while(true)
{
nextValue(k);//It takes a parameter k that represents the current position in the Hamiltonian cycle
if(x[k] == 0)
{
return;
}
if(k==n)
{
System.out.println("Solution :");
for(int i=1;i<=n;i++)
{
System.out.print(x[i] + "\t");
}
System.out.println(1);
}
else
{
hamiltonian(k+1);
}
}
}
public void nextValue(int k)//This method is used to find the next valid value for x[k].
{
while(true)
{
x[k] = (x[k]+1)%(n+1);
if(x[k]==0)
{
return;
}
if(g[x[k-1]][x[k]] != 0)
{
for(j=1;j<=k-1;j++)
{
if(x[j] == x[k])
{
break;
}
}
if(j==k)
{
if((k<n) || ((k==n) && (g[x[n]][x[1]] != 0 )))
{
return;
}
}
}
}
}
public static void main(String[] args)
{
int n;
Scanner s = new Scanner(System.in);
System.out.println("Enter the number of vertices :");
n=s.nextInt();
int[][] g = new int[n+1][n+1];
System.out.println("Enter the matrix :");
for(int i=1;i<=n;i++)
for(int j=1;j<=n;j++)
g[i][j]=s.nextInt();
HamiltonianCycles ham = new HamiltonianCycles(n,g);
ham.hamiltonian(2);//Calls the hamiltonian method with an initial position of 2 (since the first vertex is set to 1).
}
}