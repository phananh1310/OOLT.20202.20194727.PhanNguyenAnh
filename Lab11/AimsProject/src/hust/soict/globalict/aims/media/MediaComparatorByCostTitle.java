package hust.soict.globalict.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {

	@Override
	public int compare(Media m1, Media m2) {
        float f1 = m1.getCost(); 
        float f2 = m2.getCost();
        if (f1>f2) return -1;
        if (f1<f2) return 1;
        int r = 0;
        try {
        r= m1.getTitle().compareTo(m2.getTitle());
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
        return r;
    }

}
