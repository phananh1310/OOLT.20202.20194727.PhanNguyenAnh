package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.Store;
import hust.soict.globalict.aims.cart.Cart;

public class WRAP {
	public static Cart cart = new Cart();
	public static Store store = new Store();
	
	public static StoreScreen storeScreen; 
	public static CartScreen cartScreen;
	
	public static void wrap2store(Store store, Cart cart) {
		WRAP.cart=cart;
		WRAP.store=store;
		WRAP.storeScreen = new StoreScreen(WRAP.store);
	}
}
