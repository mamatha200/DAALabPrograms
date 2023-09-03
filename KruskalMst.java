import java.util.Scanner;

public class KruskalMst {
    static int parent[], cost[][], mincost, n, i, j, ne, a, b, min, u, v;

    public void kruskal(int n, int[][] cost) {
        ne = 1;
        while (ne < n)
        {  // You want a spanning tree, so the number of edges should be n - 1
            min = 999;
            for (i = 1; i <= n; i++)
            {  // Changed loop condition
                for (j = 1; j <= n; j++)
                {  // Changed loop condition
                    if (cost[i][j] < min)
                    {
                        min = cost[i][j];
                        a = u = i;
                        b = v = j;
                    }
                }
            }
            u = find(u);
            v = find(v);
            if (v != u) {
                System.out.println(ne + " edge(" + a + "," + b + ")=" + min);  // Adjusted output
                ne = ne + 1;
                mincost = mincost + min;
                uni(u, v);
            }
            cost[a][b] = cost[b][a] = 999;
        }
        System.out.println("The minimum cost of spanning tree is " + mincost);
    }

    public int find(int i) {
        while (parent[i] != 0)
            i = parent[i];
        return i;
    }

    public void uni(int i, int j) {
        parent[j] = i;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        n = sc.nextInt();
        int[][] cost = new int[n+1][n+1];  // Changed array size
        parent = new int[n+1];
        System.out.println("Enter the cost matrix");
        for (i = 1; i <= n; i++)
        {  // Changed loop condition
            for (j = 1; j <= n; j++) 
            {  // Changed loop condition
                cost[i][j] = sc.nextInt();
                if (cost[i][j] == 0)
                    cost[i][j] = 999;
            }
        }
        KruskalMst k = new KruskalMst();
        k.kruskal(n, cost);
    }
}
