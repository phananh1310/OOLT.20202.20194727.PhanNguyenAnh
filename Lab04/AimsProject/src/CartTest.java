import java.time.*;
public class CartTest {
	public static void main (String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("AAAA","aaaa","aaaa",1,5.6f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("BBBB","bbbb","aaaa",1,5.3f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("CCCC","cccc","aaaa",1,5f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("DDDD","dddd","aaaa",1,7.1f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("EEEE","eeee","aaaa",1,3.3f);
		
		Cart cart = new Cart();
		cart.addDigitalVideoDisc(new DigitalVideoDisc [] {dvd1,dvd2,dvd3,dvd4,dvd5});
		//cart.sortCartbyCost(); // sort and display in increasing
		//cart.sortCartbyTitle();// sort and display in increasing
		
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("BBBB","bbb","aaaa",2,5.3f,LocalDate.of(2021, 3, 14));
		cart.addDigitalVideoDisc(dvd6);
		//cart.removeDigitalVideoDisc(dvd6);

		cart.displayCart();
		//cart.SearchIDandDisplay(3); //it would return the first item has that ID in List
		//cart.sortCart(); // sort by title first, then by cost, then by length
		
		
	}

}
