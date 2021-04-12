package hust.soict.globalict.aims.cart;

import java.util.Comparator;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

//compare Title, Cost and Length
public class DVDComparator implements Comparator<Media> {
	 
	public int compare(Media dvd1, Media dvd2) {
		int cmp = dvd1.getTitle().compareTo(dvd2.getTitle());
		if (cmp ==0) {
			float f1 = dvd1.getCost(); 
	        float f2 = dvd2.getCost();
	        if (f1>f2) return -1;
	        else if (f1<f2) return 1;
	        else {
	        	return dvd2.getLength()-dvd1.getLength();
	        }
		}
     return cmp;
 
	}
}