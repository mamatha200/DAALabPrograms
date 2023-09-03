import java.util.Scanner;
 public class BinarySearch2{  

    public static int binarySearch(int arr[], int low, int high, int key){  

        while(low<=high){  
            int mid = (low+high)/2; 
            if (key == arr[mid]){  
            return mid;  
            }  
           else if (key<arr[mid]){  
            return binarySearch(arr, low, mid-1, key);//search in left subarray  
            }
           else{  
            return binarySearch(arr, mid+1, high, key);//search in right subarray  
            }  
        }  
        return -1;  
    }  
    public static void main(String args[]){  
      Scanner sc=new Scanner(System.in);
       int key ,n; 
      int[] arr=new int[100];
        System.out.println("Enter the size of an array:");
        n=sc.nextInt();
        System.out.println("Enter the array elements:");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
        System.out.println("Enter the key element:");
        key=sc.nextInt();
        long startTime=System.nanoTime();
         int result = binarySearch(arr,0,n-1,key);
         long endTime=System.nanoTime();
         long timeElapsed=endTime-startTime;
        if (result == -1)  
            System.out.println("Element is not found!");  
        else  
            System.out.println("Element is found at index: "+result); 
            System.out.println("Time taken to search element is:"+timeElapsed+"nanoseconds");
    }  
    }
}  