package hust.soict.globalict.aims;
import java.util.Scanner;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.*;

public class Aims {

	public static void main(String[] args) {
		Store store = new Store();
		//Add video to store
		Media dvd1 = new DigitalVideoDisc("Harry P","aaaa","aaaa",1,5.6f);
		Media dvd2 = new DigitalVideoDisc("H Potter ","bbbb","aaaa",1,5.3f);
		Media dvd3 = new DigitalVideoDisc("Your NameHary","cccc","aaaa",2,5.3f);
		Media dvd4 = new DigitalVideoDisc("Harry P","dddd","aaaa",1,7.1f);
		Media dvd5 = new DigitalVideoDisc("EEEE","eeee","aaaa",1,3.3f);
		
		store.addListMediatoStore(new Media [] {dvd1,dvd2,dvd3,dvd4,dvd5});
		
		Cart cart = new Cart();
		@SuppressWarnings("resource")
		// some variables
		Scanner keyboard = new Scanner(System.in);
		int choice=0,choice2=0,choice3=0,choice4=0,choice5=0, rm;
		String tmp;
		int YesNo; // y=1, n=0
		//searching variable
		int ID,temp;
		Media media;
		
		while (choice != 4) {
		Store.ShowMenu();
		choice = keyboard.nextInt();
		tmp = keyboard.nextLine(); 

		switch (choice)
		{
		     case 1:{
		    	 store.displayStore();
		    	 choice2=0;
		    	 while (choice2 != 4) {
		    			Store.storeMenu();
		    			choice2 = keyboard.nextInt();
		    			tmp = keyboard.nextLine(); 

		    			switch (choice2)
		    			{
		    			     case 1:
		    			    	System.out.print("Enter ID of Media you want to see: ");
		    			    	ID = keyboard.nextInt();
				    			tmp = keyboard.nextLine(); 
				    			media = store.searchStorebyID(ID);
				    			if (media == null) {
				    				System.out.println("No Media found!");
				    			}
				    			else {
				    				System.out.println("DVD detail: ");
				    				media.display();
				    				while (true) {
				    				System.out.print("Want to add to your Cart? (Choose number) (1.yes/0.no)");
				    				YesNo = keyboard.nextInt();
					    			tmp = keyboard.nextLine();
					    			if (YesNo==1) {
					    				cart.addMedia(media);
					    			break;
					    			}
					    			else if (YesNo==0)
					    				break;
					    			else System.out.println("Choose only '1' or '0'!");
				    				}
				    			}
		    			     break;

		    			     case 2:
		    			    	 while (true) {
		    			    	 System.out.print("Enter ID of Media you want to add: ");
			    			    	ID = keyboard.nextInt();
					    			tmp = keyboard.nextLine();
					    		 if (ID>0) break;
					    		 else {
					    			 System.out.println("ID must > 0!");
					    		 }
		    			    	 }
					    			media = store.searchStorebyID(ID);
					    			if (media == null) {
					    				System.out.println("No DVD found!");
					    			}
					    			else {
						    				cart.addMedia(media);
						    				System.out.println("Number of DVD in cart: "+cart.getQtyOrdered());
					    				}
					    			
		    			     break;
		    			     
		    			     
		    			     case 3:
		    			    	cart.displayCart();
		    			 
		    			     break;

		    			     case 4:
		    			    	
		    				break;

		    					 
		    			}
		    			}
		     
		     }
		     break;
		     case 2:
		    	 choice4=0;
		    	 while (choice4 != 3) {
		    			System.out.println("1. Add DVD to Store");
		    			System.out.println("2. Remove DVD from Store");
		    			System.out.println("3. Exit");
		    			System.out.print("Please choose a number: 1-2-3:");
		    			choice4 = keyboard.nextInt();
		    			tmp = keyboard.nextLine(); 
		    			switch (choice4)
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
		    			    	 Media dvd = new DigitalVideoDisc(title,category,director,length,cost);
		    			    	 store.addMediatoStore(dvd);
		    			     break;	 
		    			     

		    			     case 2:
		    			    	 store.displayStore();
		    			    	 System.out.printf("Choosing DVD ID: ");
		    			    	 rm = keyboard.nextInt();
		    			    	 store.removeDVDfromStore(store.searchStorebyID(rm));
		    			    	 tmp = keyboard.nextLine(); 
		    			     break;
		    			     
		    			     
		    			     case 3:
		    			     break;
		    			   
		    					 
		    			}
		    			}
		    	 
		     break;
		     
		     
		     case 3:
		    	 choice3=0;
		    	 while (choice3 != 6) {
		    			Store.cartMenu();
		    			choice3 = keyboard.nextInt();
		    			tmp = keyboard.nextLine(); 
		    			switch (choice3)
		    			{
		    			     case 1:
		    			    	 while (choice5 != 3) {
		    			    		  	System.out.println("1. Filter by ID");
		    			    			System.out.println("2. Filter by Title");
		    			    			System.out.println("3. Exit");
		    			    			System.out.print("Please choose a number: 1-2-3:");
		    			    			choice5 = keyboard.nextInt();
		    			    			tmp = keyboard.nextLine(); 
		    			    			switch (choice5)
		    			    			{
		    			    			     case 1:
		    			    			    	 while (true) {
		    				    			    	 System.out.print("Enter ID of DVD you want to filter: ");
		    					    			    	ID = keyboard.nextInt();
		    							    			tmp = keyboard.nextLine();
		    							    		 if (ID>0) break;
		    							    		 else {
		    							    			 System.out.println("ID must > 0!");
		    							    		 }
		    				    			    	 }
		    			    			    	 cart.SearchIDandDisplay(ID);
		    			    			     break;

		    			    			     case 2:
		    			    			    	 System.out.print("Enter DVD Title: ");
		    			    			    	 String title = keyboard.nextLine();
		    			    			    	 cart.SearchAndDisplay_CartbyTitle(title);
		    			    			     break;
		    			    			     
		    			    			     
		    			    			     case 3:
		    			    			    	 
		    			    			    
		    			    			     break;
 
		    			    			}
		    			    			}
		    			     break;

		    			     case 2:
		    			    	 System.out.println("1. Sort by Cost");
	    			    		 System.out.println("2. Sort by Title");
	    			    		 System.out.print("Please choose a number: 1-2:");
	    			    			temp = keyboard.nextInt();
	    			    			tmp = keyboard.nextLine();
	    			    		if (temp==2) cart.sortCart();
	    			    		else if (temp==1) cart.sortCartbyCost();;
		    			     break;
		    			     
		    			     
		    			     case 3:
		    			    	 cart.displayCart();
		    			    	 if (cart.getQtyOrdered()>0) {
		    			    	 while (true) {
			    			    	 System.out.print("Enter ID of DVD you want to remove: ");
				    			    	ID = keyboard.nextInt();
						    			tmp = keyboard.nextLine();
						    		 if (ID>0) break;
						    		 else {
						    			 System.out.println("ID must > 0!");
						    		 }
			    			    	 }
		    			    	 
		    			    	 cart.removeMedia(ID);
		    			    	 }
		    			    
		    			     break;

		    			     case 4:
		    			    cart.getALuckyItem();
		    		  
		    				break;
		    			     case 5:
		    			    	 if (cart.getQtyOrdered()>0)
			    			    	 System.out.println("An order is created!");
			    			    	 else 
				    			    System.out.println("An order is not created! (0 DVD in cart)");

			    			    	 cart = new Cart();
		    			    	 break;
		    			     case 6:
		    			    	 break;

		    					 
		    			}
		    			}
		    
		     break;

		     case 4:
		    	 
			  
			break;

				 
		}
		}
	}
	
}

        
  
		
