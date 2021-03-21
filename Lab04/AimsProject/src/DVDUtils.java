
import java.util.Arrays;
import java.util.Comparator;
/*
Compare two DVDs (by cost)
Compare two DVDs (by title)
Sorting a number of DVDs (by cost)
Sorting a number of DVDs (by title)
 */
public class DVDUtils {
	// return 0/1/-1
	public static int compareByCost(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2 ) {
		if (dvd1.getCost()>dvd2.getCost()) {
			System.out.println("DVD "+dvd1.getTitle()+" is more expensive than DVD "+dvd2.getTitle());
			return 1;
		}
		else if (dvd1.getCost()<dvd2.getCost()) {
			System.out.println("DVD "+dvd1.getTitle()+" is cheaper than DVD "+dvd2.getTitle());
			return -1;
		}
		else {
			System.out.println("DVD "+dvd1.getTitle()+" has the same price as DVD "+dvd2.getTitle());
			return 0;
		}
	
	}
	// return 0/<0/>0
	public static int compareByTitle(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2 ) {
		int cmp = dvd1.getTitle().compareTo(dvd2.getTitle());
		if (cmp==0) {
			System.out.println("Title of those DVDs are the same");
		}
		else if (cmp>0) {
			System.out.println("Title of the first DVD is greater than the second one");
		}
		else {
			System.out.println("Title of the first DVD is less than the second one");
		}
		return cmp;
	}
	
	
	public static DigitalVideoDisc [] sortByCost(DigitalVideoDisc [] sort) {
		Arrays.sort(sort, new DVDCostComparator());
		return sort;
	}
	public static DigitalVideoDisc [] sortByTitle(DigitalVideoDisc [] sort) {
		Arrays.sort(sort, new DVDTitleComparator());
		return sort;
	}
	
}

// DEFINE COMPARATOR
class DVDCostComparator implements Comparator<DigitalVideoDisc> {
	 
    public int compare(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        float f1 = dvd1.getCost(); 
        float f2 = dvd2.getCost();
        if (f1<f2) return -1;
        if (f1>f2) return 1;
        return 0;
    }
}
class DVDTitleComparator implements Comparator<DigitalVideoDisc> {
	 
    public int compare(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        return dvd1.getTitle().compareTo(dvd2.getTitle());
    }
}
// compare Title, Cost and Length
class DVDComparator implements Comparator<DigitalVideoDisc> {
	 
	public int compare(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
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