package hust.soict.globalict.aims.cart;

import java.util.Comparator;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class DVDCostComparator implements Comparator<Media> {
	 
    public int compare(Media dvd1, Media dvd2) {
        float f1 = dvd1.getCost(); 
        float f2 = dvd2.getCost();
        if (f1>f2) return -1;
        if (f1<f2) return 1;
        else {
        	 return dvd1.getTitle().compareTo(dvd2.getTitle());
        }
    }
}