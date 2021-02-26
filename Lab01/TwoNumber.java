// 2.2.5
import java.util.Scanner;
public class TwoNumber {
	public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.printf("Input 1st number: ");
        double first = in.nextDouble();
        System.out.printf("Input 2nd number: ");
        double second = in.nextDouble();

        System.out.printf("Sum: %.2f \n",first + second);
        System.out.printf("Difference: %.2f \n", first - second);
        System.out.printf("Product: %.2f \n", first * second);
        if (second == 0) 
        	System.out.println("Divisor Error! Can't calculate the Quotient.");
        else
        	System.out.printf("Quotient: %.2f \n", first/second);
    }
}
