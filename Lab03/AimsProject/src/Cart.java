import java.util.ArrayList;

public class Cart {
	
	private int qtyOrdered;
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<DigitalVideoDisc> ();
	
	public Cart() {
		super();
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered >=MAX_NUMBERS_ORDERED) {
			System.out.println("Your cart is full!");
		}
		else {
			itemsOrdered.add(disc);
			qtyOrdered += 1;
			System.out.println("This DVD has been added to your Cart!");
			if (qtyOrdered >= 18) {
				System.out.println("Your cart is almost full!");
			}
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered <= 0) {
			System.out.println("Your cart is empty!");
		}
		else {
			qtyOrdered -= 1;
			int index= itemsOrdered.indexOf(disc);
			if (index==-1) {
				System.out.println("No DVD found to be removed!");
			}
			else {
				System.out.println("DVD '"+disc.getTitle()+"'"+" has been removed from your Cart!");
				itemsOrdered.remove(index);
			}
			
		}
	}
	public DigitalVideoDisc DVD(int rm) {
		return itemsOrdered.get(rm);
	}
	public float totalCost() {
		float cost = 0;
		for(DigitalVideoDisc item : itemsOrdered) {
			cost += item.getCost();
		}
		return cost;
	}
	public void displayCart() {
		int i=1;
		if (qtyOrdered >0) {
			System.out.printf("%-5s%-30s%-30s%-30s%-15s%-15s\n","No.","title","category","director","length","cost");
		for(DigitalVideoDisc item : itemsOrdered) {
			
			System.out.printf("%-5d%-30s%-30s%-30s%-15d%-15.2f\n",i,item.getTitle(),item.getCategory(),item.getDirector(),item.getLength(),item.getCost());
			i++;
		}
		}
		else {
			System.out.println("Your cart is NULL!");
		}
	}
}
