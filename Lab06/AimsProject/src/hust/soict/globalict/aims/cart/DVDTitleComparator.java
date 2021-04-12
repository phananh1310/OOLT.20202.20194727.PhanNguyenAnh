package hust.soict.globalict.aims.cart;

import java.util.Comparator;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class DVDTitleComparator implements Comparator<Media> {
	 
    public int compare(Media dvd1, Media dvd2) {
        return dvd1.getTitle().compareTo(dvd2.getTitle());
    }
}
