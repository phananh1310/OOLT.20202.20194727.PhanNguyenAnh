import java.util.Arrays;   
public class Array  
{   
public static void main(String[] args)   
{   
int sum=0;
int [] array = new int [] {87, 63, 11, 9, 121, 23142, 2, 0};  
Arrays.sort(array);   
System.out.printf("Elements of array sorted:");  
for (int i = 0; i < array.length; i++)   
	{
	sum+=array[i];
	System.out.printf(" %d",array[i]);   
	} 
double a = sum;


System.out.println("\nSum: "+sum);
System.out.println("Average: "+a/array.length);  
}  
}  