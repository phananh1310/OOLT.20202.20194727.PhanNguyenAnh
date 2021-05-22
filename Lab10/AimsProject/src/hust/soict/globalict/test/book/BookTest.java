package hust.soict.globalict.test.book;

import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.media.*;
public class BookTest {

	public static void main(String[] args) {
		List<String> authors = new ArrayList<String>();
		Media book1 = new Book("Phan Anh","abc", 1.6f,authors);
		book1.addAuthor("Phan Anh");
		book1.setContent("a c b d f e g n i k m h");
		book1.display();
		
	}

}
