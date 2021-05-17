package hust.soict.globalict.test.media;

import java.util.*;

import hust.soict.globalict.aims.media.*;

public class TestMediaCompareTo {
	public static void main(String[] args) {
	List<String> authors = new ArrayList<String>();
	ArrayList<Track> Track = new ArrayList<Track>();
	Track track1= new Track("track 1",1);
	Track track2=new Track("track 2",2);
	
	Media dvd1 = new DigitalVideoDisc("Hary P","aaaa","aaaa",1,5.6f);
	Media dvd2 = new DigitalVideoDisc("H Potter","bbbb","aaaa",1,5.3f);
	Media dvd3 = new DigitalVideoDisc("CCCC","cccc","aaaa",1,5f);
	Media book1 = new Book("BBB","CBA",5.3f,authors);
	book1.addAuthor("Phan Anh");
	Media CD1 = new CompactDisc("Phan Anh",Track,"BBB","CCC","DDD",5.3f);
	CD1.addTrack(track1);
	CD1.addTrack(track2);
	
	
	ArrayList<Media> collection = new ArrayList<Media>();

	collection.add(dvd1);
	collection.add(dvd2);
	collection.add(dvd3);
	collection.add(book1);
	collection.add(CD1);
	
	Iterator<Media> iter = collection.iterator();
	int i=0;
	Media temp;
	while (iter.hasNext()) {
		i++;
		temp = iter.next();
		System.out.println(i+"."+temp.getTitle()+" - "+ temp.getCategory());
		
	}
	System.out.println("------------------------AFTER SORTING--------------------------------");
	
	Collections.sort(collection);
	
	i=0;
	iter = collection.iterator();
	while (iter.hasNext()) {
		i++;
		temp = iter.next();
		System.out.println(i+"."+temp.getTitle()+" - "+ temp.getCategory());
		
	}

	
	
	}
}
