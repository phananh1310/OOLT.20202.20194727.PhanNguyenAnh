package hust.soict.globalict.aims.test.ultils;
import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.utils.DVDUtils;

public class DVDTest {
	public static void main (String[] args) {
		Media dvd1 = new DigitalVideoDisc("Hary P","aaaa","aaaa",1,5.6f);
		Media dvd2 = new DigitalVideoDisc("H Potter","bbbb","aaaa",1,5.3f);
		Media dvd3 = new DigitalVideoDisc("CCCC","cccc","aaaa",1,5f);
		Media dvd4 = new DigitalVideoDisc("DDDD","dddd","aaaa",1,7.1f);
		Media dvd5 = new DigitalVideoDisc("EEEE","eeee","aaaa",1,3.3f);
		
		//System.out.println(dvd1.search("harry potter"));
		
		DVDUtils.compareByCost(dvd1,dvd2);
		DVDUtils.compareByTitle(dvd5,dvd3);
		// return type of these 2 compare is integer, and I also display the result  to the console
		
		Media [] sorted = DVDUtils.sortByCost(new Media [] {dvd1,dvd2,dvd3,dvd4,dvd5});
		System.out.println("Sort by Cost: ");
		for (int i=0;i< sorted.length;i++) {
			
			sorted[i].display();
		}
		
		sorted = DVDUtils.sortByTitle(new Media [] {dvd1,dvd2,dvd3,dvd4,dvd5});
		System.out.println("Sort by Title: ");
		for (int i=0;i< sorted.length;i++) {
			sorted[i].display();
		}
	
		
	}
}
