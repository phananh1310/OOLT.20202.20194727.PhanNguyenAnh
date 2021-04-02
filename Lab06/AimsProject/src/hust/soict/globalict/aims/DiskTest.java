package hust.soict.globalict.aims;

import java.time.LocalDate;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class DiskTest {
	public static void main (String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Harry P","aaaa","aaaa",1,5.6f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("H Potter ","bbbb","aaaa",1,5.3f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Your NameHary","cccc","aaaa",1,5f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("DDDD","dddd","aaaa",1,7.1f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("EEEE","eeee","aaaa",1,3.3f);
		
		Cart cart = new Cart();
		cart.addDigitalVideoDisc(new DigitalVideoDisc [] {dvd1,dvd2,dvd3,dvd4,dvd5});
		
		//Test methods
		System.out.println(dvd1.search("Harry"));
		cart.SearchAndDisplay_CartbyTitle("Harry Potter");
		
	}
}
