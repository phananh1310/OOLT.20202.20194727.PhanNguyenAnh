package hust.soict.globalict.aims;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.naming.LimitExceededException;
import javax.swing.JOptionPane;

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
		List<String> authors = new ArrayList<String>();
		Media book1 = new Book("Phan Anh","abc", 1.6f,authors);
		book1.addAuthor("Phan Anh");
		book1.setContent("d d as  l asds ahs as ue  da ad");
		
		store.addListMediatoStore(new Media [] {dvd1,dvd2,dvd3,dvd4,dvd5});
		store.addMediatoStore(book1);
		
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
		    	 while (choice2 != 5) {
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
					    				try {
											cart.addMedia(media);
										} catch (LimitExceededException e) {
											e.printStackTrace();
										}
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
						    				try {
												cart.addMedia(media);
											} catch (LimitExceededException e) {
												e.printStackTrace();
											}
						    				System.out.println("Number of DVD in cart: "+cart.getQtyOrdered());
					    				}
					    			
		    			     break;
		    			     
		    			     
		    			     case 3:
		    			    	cart.displayCart();
		    			 
		    			     break;

		    			     case 4:
		    			    	 
		    			    	 while (true) {
			    			    	 System.out.print("Enter ID of Media you want to play: ");
				    			    	ID = keyboard.nextInt();
						    			tmp = keyboard.nextLine();
						    		 if (ID>0) break;
						    		 else {
						    			 System.out.println("ID must > 0!");
						    		 }
			    			    	 }
		    			    	 media = store.searchStorebyID(ID);
		    			    	 if (media instanceof CompactDisc ||media instanceof DigitalVideoDisc ) {
		    			    		 try {
										media.play();
									} catch (Exception e) {
										e.printStackTrace();
									}
		    			    		 
		    			    	 }
		    			    	 else {
		    			    		 System.out.println("This Media is not playable!");
		    			    	 }
		    				break;
		    			     case 5:
		    			    	 break;

		    					 
		    			}
		    			}
		     
		     }
		     break;
		     case 2:
		    	 choice4=0;
		    	 while (choice4 != 5) {
		    			System.out.println("1. Add DVD to Store");
		    			System.out.println("3. Add Book to Store");
		    			System.out.println("4. Add CD to Store");

		    			System.out.println("2. Remove Media from Store");
		    			System.out.println("5. Exit");
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
		    			    	 
		    			    	 //handle excepttion
		    			    	 //while (length <= 0) {
		    			    		// System.out.printf("Length must > 0! Try again: ");
		    				    	 //length = keyboard.nextInt();
		    			    	 //}
		    			    	 
		    			    	 System.out.printf("Cost: ");
		    			    	 float cost = (float) keyboard.nextDouble();
		    			    	 //while (cost <= 0) {
		    			    		// System.out.printf("Cost must > 0! Try again: ");
		    			    		 //cost = (float) keyboard.nextDouble();
		    			    	 //}
		    			    		 try {
		    			    	 Media dvd = new DigitalVideoDisc(title,category,director,length,cost);
		    			    	 store.addMediatoStore(dvd);
		    			    		 }
		    			    		 catch (IllegalArgumentException e) {
		    			    			 e.printStackTrace();
		    			    		 }
		    			     break;	 
		    			     

		    			     case 2:
		    			    	 store.displayStore();
		    			    	 System.out.printf("Choosing DVD ID: ");
		    			    	 rm = keyboard.nextInt();
		    			    	 store.removeMediafromStore(store.searchStorebyID(rm));
		    			    	 tmp = keyboard.nextLine(); 
		    			     break;
		    			     
		    			     
		    			     case 3:
		    			    	 System.out.println("Enter Book: ");
		    			    	 System.out.printf("Title: ");
		    			    	 title = keyboard.nextLine();
		    			    	 System.out.printf("Category: ");
		    			    	 category = keyboard.nextLine();
		    			    	 
		    	
		    			    	 
		    			    	 System.out.printf("Cost: ");
		    			    	 cost = (float) keyboard.nextDouble();
					    			tmp = keyboard.nextLine();
		    			    	 //while (cost <= 0) {
		    			    		 //System.out.printf("Cost must > 0! Try again: ");
		    			    		// cost = (float) keyboard.nextDouble();
						    		//	tmp = keyboard.nextLine();

		    			    	// }
		    			    	 authors = new ArrayList<String>();
		    			    	 Media book = null;
		    			    	 try {
		    			    	  book = new Book(title,category,cost,authors);
		    			    	 }
		    			    	 catch (IllegalArgumentException e) {
		    			    		 e.printStackTrace();
		    			    	 }
		    			    	 while(true) {
		    			    	 System.out.printf("Author (Enter if don't want to add anymore): ");
		    			    	 String author = keyboard.nextLine();
		    			    	 if (author == "") {
		    			    		 break;
		    			    	 }
		    			    	 else {
		    			    		book.addAuthor(author); 
		    			    	 }
		    			    	 }
		    			    	 store.addMediatoStore(book);
		    			     break;
		    			     case 4:
		    			    	 String artist = null;
		    			    	 System.out.println("Enter CD: ");
		    			    	 System.out.printf("Title: ");
		    			    	 title = keyboard.nextLine();
		    			    	 System.out.printf("Category: ");
		    			    	 category = keyboard.nextLine();
		    			    	 System.out.printf("Director: ");
		    			    	 director = keyboard.nextLine();
		    			    	 System.out.printf("Artist: ");
		    			    	 artist = keyboard.nextLine();
		    	
		    			    	 
		    			    	 System.out.printf("Cost: ");
		    			    	 cost = (float) keyboard.nextDouble();
					    			tmp = keyboard.nextLine();
		    			    	// while (cost <= 0) {
		    			    		// System.out.printf("Cost must > 0! Try again: ");
		    			    		 //cost = (float) keyboard.nextDouble();
						    		//	tmp = keyboard.nextLine();

		    			    	// }
		    			    	 ArrayList<Track> tracks = new ArrayList<Track>();
		    			    	 Media CD = null;
		    			    	 try {
		    			    	  CD = new CompactDisc(artist,tracks,title,category,director,cost);
		    			    	 }
		    			    	 catch (IllegalArgumentException e) {
		    			    		 e.printStackTrace();
		    			    		 
		    			    	 }
		    			    	 while(true) {
		    			    	 System.out.println("Track (Enter at title if don't want to add anymore): ");
		    			    	 System.out.print("- Title: ");
		    			    	 title = keyboard.nextLine();
		    			    	 if (title == "") {
		    			    		 break;
		    			    	 }
		    			    	 
		    			    	 System.out.print("- Length: ");
		    			    	 length = keyboard.nextInt();
					    			tmp = keyboard.nextLine();

		    			    	 
		    			    	 //while (length <= 0) {
		    			    		// System.out.printf("Length must > 0! Try again: ");
		    				    	// length = keyboard.nextInt();
						    		//	tmp = keyboard.nextLine();
		    			    	 //}
		    			    	 Track track = new Track(title,length);
		    			    	 CD.addTrack(track);
		    			  
		    			    	 }
		    			    	 store.addMediatoStore(CD);
		    			    	 break;
		    			     case 5: 
		    			    	 break;
		    			   
		    					 
		    			}
		    			}
		    	 
		     break;
		     
		     
		     case 3: // add choice 5 =0
		    	 choice3=0;
		    	 while (choice3 != 6) {
		    			Store.cartMenu();
		    			choice3 = keyboard.nextInt();
		    			tmp = keyboard.nextLine(); 
		    			switch (choice3)
		    			{
		    			     case 1:
		    			    	 choice5 =0;
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
	    			    		if (temp==2) cart.sortCartByTitleCost();
	    			    		else if (temp==1) cart.sortCartByCostTitle();;
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
		    			    	 
		    			    	 try {
									cart.removeMedia(ID);
								} catch (NoSuchElementException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (LimitExceededException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
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

        
  
		
