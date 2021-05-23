package hust.soict.globalict.aims.screen;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.*;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class CartScreenController {
	private Cart cart;
	 @FXML
	    private MenuItem addBookMenuItem;
	
	@FXML
    private ToggleGroup filterCategory;
	
	 @FXML
	 private Button btnPlay;

	@FXML
	 private Button btnRemove;

	@FXML
	private Button addToCartBtn;
	
    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private RadioButton radioBtnFilterId;
    
    @FXML
    private RadioButton radioBtnFilterTitle;
    
    @FXML
    private TextField tfFilter;
    
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    
    @FXML
    private Label totalCost;

    @FXML
    private TableColumn<Media, String > colMediaCategory;
    
    @FXML
    private Button placeOrderbtn;
    
    @FXML
    private MenuItem viewStoreMenuChoice;

    @FXML
    private MenuItem viewCartMenuChoice;

    
    public CartScreenController(Cart cart) {
		this.cart=cart;
	}
   
    private static int STORE=1,CART=0;
    private int StoreOrCart ; // 1 mean store, 0 mean cart
	@FXML
    private void initialize() {
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
    	tblMedia.setItems(this.cart.getItemsOrdered());
    	updateTotalCost();
    	addToCartBtn.setVisible(false);
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	StoreOrCart = CART;
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
    		@Override
    		public void changed(ObservableValue< ? extends Media> observable, Media oldValue, Media newValue) {
    			if (newValue != null) {
    				updateButtonBar(newValue);
    			}
    		}
    	});
    	
    	tfFilter.textProperty().addListener(new ChangeListener<String>() {
    		@Override
    		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    			ShowFilteredMedia(newValue);
    		}
    	});
    	
    }

	protected void ShowFilteredMedia(String newValue) {
		ObservableList<Media> FilteredList = FXCollections.observableArrayList();
		ObservableList<Media> InitialList = FXCollections.observableArrayList();// don't know store or cart
		if (StoreOrCart==STORE)
			InitialList=WRAP.store.getItemsInStore();
		else //cart
			InitialList=WRAP.cart.getItemsOrdered();
		
		if (newValue == "") {
			FilteredList = InitialList;
		}
		else {
		for(Media item : InitialList) {
			if (item.search(newValue)) {
				FilteredList.add(item);
			}
		// done adding filtered items in FilteredList
		// next display 
			}
		}
		
		tblMedia.setItems(FilteredList);
		
	}

	protected void updateButtonBar(Media newValue) {
		if (tblMedia.getItems()==WRAP.cart.getItemsOrdered()) // means in cart table view
			btnRemove.setVisible(true);
		if (newValue instanceof Playable) {
			btnPlay.setVisible(true);
		}
		else {
			btnPlay.setVisible(false);
		}
	}
	@FXML
    void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media.getId());
		updateTotalCost();
    }
	
	void updateTotalCost() {
		if (cart == null) {
			totalCost.textProperty().setValue(String.valueOf("0$")); 
		}
		else {
			totalCost.textProperty().setValue(String.valueOf(cart.totalCost()+"$")); 
		}
	}
	@FXML
    void placeOrderbtnPressed(ActionEvent event) {
		String msg="Your cart is empty!";
		// OrderScreen
		if (cart.getItemsOrdered().size()>0) 
			msg = "An Order is created!";
	
		JFrame orderFrame = new JFrame("Order Message");
		orderFrame.add(new JLabel(msg));
		orderFrame.setVisible(true);
		orderFrame.setSize(300,100);
		
		this.cart = new Cart();
		updateTotalCost();
		tblMedia.setItems(cart.getItemsOrdered());
    }
	@FXML
    void viewStoreMenuChoiceClicked(ActionEvent event) {
    	addToCartBtn.setVisible(true);
		tblMedia.setItems(WRAP.store.getItemsInStore());
		btnRemove.setVisible(false);
		StoreOrCart=STORE;
		
    }

    @FXML
    void viewCartMenuChoiceClicked(ActionEvent event) {
    	addToCartBtn.setVisible(false);
    	tblMedia.setItems(WRAP.cart.getItemsOrdered());
		StoreOrCart=CART;

    }
    
    @FXML
    void addBookMenuItemClicked(ActionEvent event) {
    	btnRemove.setVisible(false);
    	addToCartBtn.setVisible(true);
    	ObservableList<Media> List = FXCollections.observableArrayList();
    	for (Media m: WRAP.store.getItemsInStore()) {
    		if (m instanceof Book) {
    			List.add(m);
    		}
    	}
    	tblMedia.setItems(List);
    	
    }

    @FXML
    void addCDMenuItemClicked(ActionEvent event) {
    	btnRemove.setVisible(false);
    	addToCartBtn.setVisible(true);
    	ObservableList<Media> List = FXCollections.observableArrayList();
    	for (Media m: WRAP.store.getItemsInStore()) {
    		if (m instanceof CompactDisc ) {
    			List.add(m);
    		}
    	}
    	tblMedia.setItems(List);
    }

    @FXML
    void addDVDMenuItemClicked(ActionEvent event) {
    	btnRemove.setVisible(false);
    	addToCartBtn.setVisible(true);
    	ObservableList<Media> List = FXCollections.observableArrayList();
    	for (Media m: WRAP.store.getItemsInStore()) {
    		if (m instanceof DigitalVideoDisc ) {
    			List.add(m);
    		}
    	}
    	tblMedia.setItems(List);
    }
    
   
    @FXML
    void btnPlayClicked(ActionEvent event) {
    	JFrame f = new JFrame();
		JDialog dialog = new JDialog(f,"Play");
		dialog.setSize(300, 200);
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		dialog.add(new JTextArea(media.playToString()));
		dialog.setVisible(true);
    }
    @FXML
    void addToCartBtnClicked(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.addMedia(media);
		updateTotalCost();
		
		//Cart added Message
		JFrame f = new JFrame("Message");
		f.add(new JLabel("Cart added!"));
		f.setSize(350,100);
		f.setVisible(true);
		
    }
}
