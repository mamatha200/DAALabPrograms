
import java.util.Scanner;

public class EuclidAlgorithm {
    public static int gcd(int m,int n)
    {
        while(n!=0)
        {
            int r=m%n;
            m=n;
            n=r;
        }
        return m;
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the first number:");
        int m=s.nextInt();
        System.out.println("Enter the second number:");
        int n=s.nextInt();
        int gcd=gcd(m,n);
        System.out.println("The gcd of "+m+" and "+n+" is "+gcd);
    }
    
}
