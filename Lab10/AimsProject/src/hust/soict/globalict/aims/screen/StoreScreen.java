package hust.soict.globalict.aims.screen;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;

import hust.soict.globalict.aims.*;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;

public class StoreScreen extends JFrame{
	private Store store;
	private JPanel center = new JPanel();
	private Container cp = getContentPane();
	AddItemToStoreScreen panel = null;
	// panel has value when enter OK in update items


	public StoreScreen(Store store) {
		this.store = store;
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		
		center = createCenter();
		cp.add(center, BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024,768);
	}
	
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenu smUpdateStore = new JMenu("Update Store");
		
		JMenuItem addBook = new JMenuItem("Add Book");
		smUpdateStore.add(addBook);
		addBook.addActionListener(new UpdateStoreListener());
		
		
		JMenuItem addCD = new JMenuItem("Add CD");
		smUpdateStore.add(addCD);
		addCD.addActionListener(new UpdateStoreListener());
		
		JMenuItem addDVD = new JMenuItem("Add DVD");
		smUpdateStore.add(addDVD);
		addDVD.addActionListener(new UpdateStoreListener());
		
		menu.add(smUpdateStore);
		
		JMenuItem viewStore = new JMenuItem("View store");
		menu.add(viewStore);
		viewStore.addActionListener(new viewStoreActionListener());
		
		menu.add(new JMenuItem("View cart"));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
	return menuBar;	
	}
	
	private class viewStoreActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			cp.remove(center);
			center = createCenter();
			cp.add(center,BorderLayout.CENTER);
	        setVisible(true);
			
		}
	}

	private class UpdateStoreListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			cp.remove(center);
			String str = e.getActionCommand();
			JButton OK = new JButton("OK");

			
			if (str.equals("Add Book")) {
				panel = new AddBookToStoreScreen();

			} else if (str.equals("Add CD")) {
				panel = new AddCompactDiscToStoreScreen();

			} else if (str.equals("Add DVD")) {
				panel = new AddDigitalVideoDiscToStoreScreen();	
				
			} 
			
			panel.add(OK);
			OK.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Media media = panel.make();
					store.addMediatoStore(media);
					panel.add(new JLabel("Media " + panel.getTfTitle().getText() +" added!"));
					media.display();
					setVisible(true);
				}
			});
			
			center =  panel;
		
			cp.add(center,BorderLayout.CENTER);
			setVisible(true);
			
		}
		
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header,BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN,50));
		title.setForeground(Color.CYAN);
		
		JButton cart = new JButton("View cart");
		cart.setPreferredSize(new Dimension(100,50));
		cart.setMaximumSize(new Dimension(100,50));
		
		header.add(Box.createRigidArea(new Dimension(10,10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10,10)));
		
		return header;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3,3,2,2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i=0;i<9;i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		return center;
		
	}
	
	
	public static void main(String[] args) {
		Store store = new Store();
		//Add video to store
		Media dvd1 = new DigitalVideoDisc("Harry P","aaaa","aaaa",1,5.6f);
		Media dvd2 = new DigitalVideoDisc("H Potter ","bbbb","aaaa",1,5.3f);
		Media dvd3 = new DigitalVideoDisc("Your NameHary","cccc","aaaa",2,5.3f);
		Media dvd4 = new DigitalVideoDisc("Harry P","dddd","aaaa",1,7.1f);
		Media dvd5 = new DigitalVideoDisc("EEEE","eeee","aaaa",1,3.3f);
		Media dvd6 = new DigitalVideoDisc("EEEE","eeee","aaaa",1,3.3f);
		Media dvd7 = new DigitalVideoDisc("EEEE","eeee","aaaa",1,3.3f);
		Media cd = new CompactDisc("EEEE","eeee","aaaa","NA",3.3f);
		Track track = new Track("Track1",5);
		cd.addTrack(track);
		track = new Track("Track2",8);cd.addTrack(track);

		List<String> authors = new ArrayList<String>();
		Media book1 = new Book("Phan Anh","abc", 1.6f,authors);
		book1.addAuthor("Phan Anh");
		book1.setContent("d d as  l asds ahs as ue  da ad");
		
		store.addListMediatoStore(new Media [] {dvd1,dvd2,dvd3,dvd4,dvd5,dvd6,dvd7,cd});
		
		store.addMediatoStore(book1);
		
		new StoreScreen(store);
	}
	
}
