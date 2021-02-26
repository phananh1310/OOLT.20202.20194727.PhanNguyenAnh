import java.util.Scanner;
import java.lang.Math; 
// 2.2.6
public class _2_2_6 {
	public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
		int choice=0;
		double a,b,c, a11,a12,b1,a21,a22,b2;
		double D,Dx,Dy;
		while (choice != 4) {
		
		System.out.println("1. First degree equation ");
		System.out.println("2. System of first degree equation");
		System.out.println("3. Second degree equation ");
		System.out.println("4. Exit ");
		System.out.printf("Choose: ");
		choice = in.nextInt();
		switch (choice)
		{
		     case 1:
				  System.out.println("ax + b = 0");
				  System.out.printf("a = "); a = in.nextDouble();
				  System.out.printf("b = "); b = in.nextDouble();
				  
				  if (a==0) {
					  if (b==0) {
						  
						  System.out.println("Infinite solutions for x!");
					  }
					  else {
						  System.out.println("NO solutions for x!");
					  }
				  }
				  else {
					  System.out.println("x = "+(-b/a));
				  }
		     break;

		     case 2:
				  System.out.println("a11x + a12y  = b1");
				  System.out.println("a21x + a22y  = b2");
				  System.out.printf("a11 = "); a11 = in.nextDouble();
				  System.out.printf("a12 = "); a12 = in.nextDouble();
				  System.out.printf("b1 = "); b1 = in.nextDouble();

				  System.out.printf("a21 = "); a21 = in.nextDouble();
				  System.out.printf("a22 = "); a22 = in.nextDouble();
				  System.out.printf("b2 = "); b2 = in.nextDouble();
				  
				  D = a11*a22-a12*a21;
				  Dx = a22*b1-a12*b2;
				  Dy = b2*a11-b1*a21;
				  
				  if (D==0) {
					  if (b1 == b2)
						  System.out.println("Infinite solutions!");
					  else {
						  System.out.println("No solution!");
					  }
				  }
				  else {
				  System.out.println("x = " + (Dx/D));
				  System.out.println("y = " + (Dy/D));
				  }	  
		     break;
		     
		     
		     case 3:
		    	 
		    System.out.println("ax^2 + bx + c = 0");
		    System.out.printf("a = "); a = in.nextDouble();
			System.out.printf("b = "); b = in.nextDouble();
			System.out.printf("c = "); c = in.nextDouble();
			// delta
			D = b*b - 4*a*c;
			if (D < 0)
			{
				System.out.println("No solution!");
			}
			else if (D == 0)
			{
				System.out.println("1 solution:\n x = " + (-b/2*a));
			}
			else
			{
				System.out.println("2 solutions:\n x1 = "+ ((-b+Math.sqrt(D))/2*a));
				System.out.println(" x2 = "+ ((-b-Math.sqrt(D))/2*a));

			}
		     break;

		     case 4:
			  System.out.println("Exit!");
			  break;
			 default:
			System.out.println("Choice ranges from 1 to 4! Try again!");
			break;

				 
		}
		}
        
    }
}
