package hust.soict.globalict.aims.screen;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;

import hust.soict.globalict.aims.*;
import hust.soict.globalict.aims.cart.Cart;
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
		
		JMenuItem viewCartItem = new JMenuItem("View cart");
		menu.add(viewCartItem);
		viewCartItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				WRAP.cartScreen = new CartScreen(WRAP.cart);
			}
			
		});
		
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
					
					JFrame f = new JFrame();
					JDialog dialog = new JDialog(f,"Media " + panel.getTfTitle().getText() + " added. Detail ");
					
					dialog.add(new JTextArea(media.toString()));
					if (media instanceof DigitalVideoDisc)
						dialog.setSize(400, 100);
					else if (media instanceof Book)
						dialog.setSize(media.toString().length()*2,150);
					else if (media instanceof CompactDisc)
						dialog.setSize(media.toString().length(), 600);
					dialog.setAlwaysOnTop(true);
					dialog.setVisible(true);
				
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
		
		JButton cartBtn = new JButton("View cart");
		cartBtn.setPreferredSize(new Dimension(100,50));
		cartBtn.setMaximumSize(new Dimension(100,50));
		cartBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				WRAP.cartScreen = new CartScreen(WRAP.cart);
			}
			
		});
		
		
		header.add(Box.createRigidArea(new Dimension(10,10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cartBtn);
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
	
}
