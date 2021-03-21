import java.util.Scanner;

public class Aims {

	public static void main(String[] args) {
		Cart cart = new Cart();
		//DigitalVideoDisc dvd;
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		
		
		int choice=0, rm;
		String tmp;
		while (choice != 4) {
		System.out.println("1. Add DVD ");
		System.out.println("2. Remove DVD");
		System.out.println("3. View cart and total cost ");
		System.out.println("4. Exit ");
		System.out.printf("Choose: ");
		choice = keyboard.nextInt();
		tmp = keyboard.nextLine(); 
		switch (choice)
		{
		     case 1:
		    	 System.out.println("Enter DVD: ");
		    	 System.out.printf("Title: ");
		    	 String title = keyboard.nextLine();
		    	 System.out.printf("Category: ");
		    	 String category = keyboard.nextLine();
		    	 System.out.printf("Director: ");
		    	 String director = keyboard.nextLine();
		    	 System.out.printf("Length: ");
		    	 int length = keyboard.nextInt();
		    	 
		    	 while (length <= 0) {
		    		 System.out.printf("Length must > 0! Try again: ");
			    	 length = keyboard.nextInt();
		    	 }
		    	 
		    	 System.out.printf("Cost: ");
		    	 float cost = (float) keyboard.nextDouble();
		    	 while (cost <= 0) {
		    		 System.out.printf("Cost must > 0! Try again: ");
		    		 cost = (float) keyboard.nextDouble();
		    	 }
		    	 DigitalVideoDisc dvd = new DigitalVideoDisc(title,category,director,length,cost);
		    	 cart.addDigitalVideoDisc(dvd);
		     break;

		     case 2:
		    	 System.out.printf("Choosing DVD number (view in option 3): ");
		    	 rm = keyboard.nextInt();
		    	 cart.removeDigitalVideoDisc(cart.DVD(rm-1));
		    	 
		     break;
		     
		     
		     case 3:
		    	 cart.displayCart();
		    	 System.out.printf("Total cost: %.2f\n", cart.totalCost());
		    
		     break;

		     case 4:
		    	 
			  
			break;

				 
		}
		}
	}
}
        
  
		
