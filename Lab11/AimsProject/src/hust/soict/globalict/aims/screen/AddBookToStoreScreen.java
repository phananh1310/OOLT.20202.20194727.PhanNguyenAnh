package hust.soict.globalict.aims.screen;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
	private ArrayList<String> authors = new ArrayList<String>();
	private JTextField tfContent;
	private JTextField tfAuthor = new JTextField("");
	
	public AddBookToStoreScreen() {
		super();
		this.add(new JLabel("Content: "));
		tfContent=new JTextField("");
		this.add(tfContent);
		
		JButton addAuthor = new JButton("Add Author");
		this.add(addAuthor);
		this.add(tfAuthor);
		tfAuthor.setEditable(false);
		addAuthor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame popup = new JFrame("Add Author");
				popup.setSize(500,300 );
				popup.setLayout(new GridLayout(2,1));
				
				JTextField tfAuthorName=new JTextField("");

				popup.add(new JLabel("Author Name: "));
				popup.add(tfAuthorName);
				
				
				popup.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				
				JButton OK = new JButton("OK");
				popup.add(OK);
				popup.setVisible(true);
				OK.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						authors.add(tfAuthorName.getText());
						tfAuthor.setText(tfAuthor.getText()+ tfAuthorName.getText()+"; ");
					}
					
				});
			}
	});
	}
	
	public Media make() {
		Book  book = new Book(this.getTfTitle().getText(),this.getTfCategory().getText(),Float.parseFloat(this.getTfCost().getText()));
		book.setContent(this.getTfContent().getText());
		book.setAuthors(authors);
		return book;
	}

	public JTextField getTfContent() {
		return tfContent;
	}

	//public List<String> getAuthors() {
		//return authors;
	//}

}
