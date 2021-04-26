package hust.soict.globalict.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {

	@Override
	public int compare(Media o1, Media o2) {
		int r = o1.getTitle().compareTo(o2.getTitle());
		if (r==0) {
			float f1 = o1.getCost(); 
	        float f2 = o2.getCost();
	        if (f1>f2) return -1;
	        if (f1<f2) return 1;
	        return 0;
		}
		else 
			return r;
	}

}
