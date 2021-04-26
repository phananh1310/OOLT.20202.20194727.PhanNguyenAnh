package hust.soict.globalict.aims.test.cart;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.*;

public class CartTest {
	public static void main (String[] args) {
		Media dvd1 = new DigitalVideoDisc("Harry P","aaaa","aaaa",1,5.3f);
		Media dvd2 = new DigitalVideoDisc("Baby","bbbb","aaaa",1,5.3f);
		Media dvd3 = new DigitalVideoDisc("Your NameHary","cccc","aaaa",1,5f);
		Media dvd4 = new DigitalVideoDisc("Harry P","dddd","aaaa",1,7.1f);
		Media dvd5 = new DigitalVideoDisc("EEEE","eeee","aaaa",1,3.3f);
		
		Cart cart = new Cart();
		cart.addMedia(new Media [] {dvd1,dvd2,dvd3,dvd4,dvd5});
		cart.sortCartByCostTitle();
		cart.sortCartByTitleCost();
		

		
	}

}
