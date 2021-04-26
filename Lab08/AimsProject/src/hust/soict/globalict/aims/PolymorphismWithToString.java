package hust.soict.globalict.aims;

/*
 * I use display() instead of toString()
 * For each Media, depends on what type of it is (CD,DVD,Book) It will display its information
 * Because in each (CD/DVD/Book) class have a display() method, when the Media comes to DVD, it will use the
 * display() method of DVD,.... this is overriding 
 * There are two types of polymorphism in Java. Compile time polymorphism (overloading) and runtime polymorphism (overriding)
 * In here we use overriding, at previous lab we use overloading
 * When using overriding, the parameters must be the same (not like overloading)
 */
import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;

public class PolymorphismWithToString {

	public static void main(String[] args) {
		List<String> authors = new ArrayList<String>();
		ArrayList<Track> Track = new ArrayList<Track>();
		Track track1= new Track("track 1",1);
		Track track2=new Track("track 2",2);
		
		Media dvd = new DigitalVideoDisc("CCCC","cccc","aaaa",1,5f);
		Media book = new Book("BBB","CBA",5.3f,authors);
		book.addAuthor("Phan Anh");
		Media CD = new CompactDisc("Phan Anh",Track,"BBB","CCC","DDD",5.3f);
		CD.addTrack(track1);
		CD.addTrack(track2);
		
		
		ArrayList<Media> collection = new ArrayList<Media>();

		collection.add(dvd);
		collection.add(book);
		collection.add(CD);
		System.out.println("---------------------DISPLAY---------------------------------");
		int i=0;
		for (Media m: collection) {
			System.out.println(i++ + ".");
			m.display();
		}

	}

}
