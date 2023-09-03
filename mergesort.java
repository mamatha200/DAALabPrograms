import java.util.Random;
import java.util.Scanner;
public class mergesort { 
public static void main(String[] args) {
Scanner sc =new Scanner(System.in);
System.out.println("Enter the array size");
int n=sc.nextInt();
int array[]=new int[n];
Random rand=new Random();
for(int i=0;i<n;i++)
{
  array[i]=rand.nextInt(10000);  
}

System.out.println("print the unsorted array");
for( int i=0;i<n;i++)
{
    System.out.println(array[i]);
}
long startTime=System.nanoTime();
sort(array,0,n-1);
long endTime=System.nanoTime();
long timeElapsed=(endTime-startTime);
System.out.println("Sorted array is");

for(int i=0;i<n;i++)
{
   System.out.println(array[i]); 
}
System.out.println("Time taken to sort array is:"+timeElapsed+"nanoseconds");
}
       
public static void merge(int[] array,int low, int mid,int high)
{
int i=low; /*left array with i value low to mid*/
int j=mid+1; /*right array with j value mid+1 to high*/
int k=low;
int resarray[]=new int[100000]; /*new Array with k value low to high*/
while(i<=mid&&j<=high)
{
if(array[i]<array[j]) /*compare the elements in subarray and*/
{ /*copy smallest element in new array*/
resarray[k]=array[i];
i++;
k++;
}
else
{
resarray[k]=array[j];
j++;
k++;
}
}
while(i<=mid) /*copy the remaining elements into the new array*/
    resarray[k++]=array[i++];
while(j<=high)
    resarray[k++]=array[j++];
for(int m=low;m<=high;m++)
    array[m]=resarray[m];
}
public static void sort( int[] array,int low,int high)
{
if(low<high)
{
int mid=(low+high)/2;
sort(array,low,mid);
sort(array,mid+1,high);
merge(array,low,mid,high);
}
}
}


