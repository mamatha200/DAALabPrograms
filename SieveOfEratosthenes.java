//Sieve Of Eratosthenes
import java.util.Scanner;

public class SieveOfEratosthenes 
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        //take input from the user for the maximum range
        System.out.print("Enter the maximum range to find the prime numbers:");
        int n=input.nextInt();
        //Create a boolean array to track the primes
        boolean[]primes=new boolean[n+1];
        //Initialise the array to true.assuming all numbers are prime
        for(int i=2;i<=n;i++)
        {
            primes[i]=true;
        }
        //Perform the sieve of eratosthenes algorithm
        for(int j=0; j<=Math.sqrt(n);j++)
        {
            if(primes[j])
        
            {
                for(int i=j*2;i<=n;i+=j)
                {
                    primes[i]=false;
                }
            }
        }    

        
        //Print out the prime numbers found
        System.out.println("Prime numbers between 2 and "+n+"are:");
        for(int i=2;i<=n;i++)
        {
            if(primes[i])
            {
                System.out.println(i+" ");
            }
        }
        
}
}