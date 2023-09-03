
import java.util.Scanner;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of an array:");
        int n=sc.nextInt();
        int[]array=new int[n];
        Random rand=new Random();
        for(int i=0;i<n;i++)
        {
            array[i]=rand.nextInt(10000);
        }
        System.out.println("Print the unsorted array:");
        for(int i=0;i<n;i++)
        {
            System.out.println(array[i]);
        }
        long startTime=System.nanoTime();
        
        quickSort(array,0,n-1);
        long endTime=System.nanoTime();
        long timeElapsed=endTime-startTime;
        System.out.println("Sorted array:");
        for(int i=0;i<n;i++)
        {
            System.out.println(array[i]);
        }
        System.out.println("Time taken:"+timeElapsed+"nanoseconds");
    }
    public static int partition(int[]array,int low,int high)
    {
        int pivot=array[high];
        int i=low-1;
        for(int j=low;j<high;j++)
        {
            if(array[j]<pivot)
            {
                i++;
                int temp=array[i];
                array[i]=array[j];
                array[j]=temp;
            }
        }
        int temp=array[i+1];
        array[i+1]=array[high];
        array[high]=temp;
        return i+1;
        
    }
    public static void quickSort(int[]array,int low,int high)
    {
        if(low<high)
        {
        int pivot=partition(array,low,high);
        quickSort(array,low,pivot-1);
        quickSort(array,pivot+1,high);
        }
        
    }
    
}
