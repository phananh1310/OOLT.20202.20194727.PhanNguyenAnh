package hust.soict.globalict.aims.cart;

import java.util.Comparator;

import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class DVDCostComparator implements Comparator<DigitalVideoDisc> {
	 
    public int compare(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        float f1 = dvd1.getCost(); 
        float f2 = dvd2.getCost();
        if (f1>f2) return -1;
        if (f1<f2) return 1;
        else {
        	 return dvd1.getTitle().compareTo(dvd2.getTitle());
        }
    }
}