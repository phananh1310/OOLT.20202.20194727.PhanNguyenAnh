package hust.soict.globalict.aims.test.ultils;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.utils.DVDUtils;

public class DVDTest {
	public static void main (String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("AAAA","aaaa","aaaa",1,5.6f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("BBBB","bbbb","aaaa",1,5.3f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("CCCC","cccc","aaaa",1,5f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("DDDD","dddd","aaaa",1,7.1f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("EEEE","eeee","aaaa",1,3.3f);
		
		DVDUtils.compareByCost(dvd1,dvd2);
		DVDUtils.compareByTitle(dvd5,dvd3);
		// return type of these 2 compare is integer, and I also display the result  to the console
		
		DigitalVideoDisc [] sorted = DVDUtils.sortByCost(new DigitalVideoDisc [] {dvd1,dvd2,dvd3,dvd4,dvd5});
		System.out.println("Sort by Cost: ");
		for (int i=0;i< sorted.length;i++) {
			
			sorted[i].displayDVD();
		}
		
		sorted = DVDUtils.sortByTitle(new DigitalVideoDisc [] {dvd1,dvd2,dvd3,dvd4,dvd5});
		System.out.println("Sort by Title: ");
		for (int i=0;i< sorted.length;i++) {
			sorted[i].displayDVD();
		}
		
	}
}
