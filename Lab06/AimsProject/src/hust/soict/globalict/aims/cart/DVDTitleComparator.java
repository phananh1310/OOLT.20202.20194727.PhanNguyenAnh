package hust.soict.globalict.aims.cart;

import java.util.Comparator;

import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class DVDTitleComparator implements Comparator<DigitalVideoDisc> {
	 
    public int compare(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        return dvd1.getTitle().compareTo(dvd2.getTitle());
    }
}
