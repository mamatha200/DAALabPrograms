
import java.util.Scanner;
import java.util.Random;
public class Program1 {
    public static void main(String[] args) {
        
        Scanner s=new Scanner(System.in);
        int n;
        
        while(true)
        {
        System.out.println("Enter the no of elements:");
        n=s.nextInt();
        int[]array=new int[n];
        Random rand =new Random();
        for(int i=0;i<n;i++)
        {
            array[i]=rand.nextInt(10000);
        }
        System.out.println("unsorted array");
        for(int i=0;i<n;i++)
        {
            System.out.println(array[i]);
        }
        long startTime=System.nanoTime();
        selectionSort(array,n);
        long endTime=System.nanoTime();
        long timeElapsed=(endTime-startTime);
        System.out.println("sorted array:");
        for(int i=0;i<n;i++)
        {
            System.out.println(array[i]+" ");
        }
        
            System.out.println("time taken to sort the array:"+timeElapsed+"nanoseconds");
        
        } 
         
         
    }
    
    public static void selectionSort(int[] array,int n)
    {
       
        for(int i=0;i<n-1;i++)
        {
            int min_indx=i;
            for(int j=i+1;j<n;j++)
            {
                if (array[j]<array[min_indx])
                {
                    min_indx=j;
                }
            }
            int temp=array[min_indx];
            array[min_indx]=array[i];
            array[i]=temp;
        }
    }
   
}

