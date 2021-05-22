package hust.soict.globalict.aims.screen;
import javax.swing.JFrame;
import javax.swing.JLabel;

import hust.soict.globalict.aims.cart.Cart;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	
	@FXML
    private ToggleGroup filterCategory;
	
	 @FXML
	 private Button btnPlay;

	@FXML
	 private Button btnRemove;

	private Cart cart;
	
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

    public CartScreenController(Cart cart) {
		this.cart=cart;
	}

	@FXML
    private void initialize() {
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
    	tblMedia.setItems(this.cart.getItemsOrdered());
    	updateTotalCost();
 
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
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
		if (newValue == "") {
			FilteredList = cart.getItemsOrdered();
		}
		else {
		for(Media item : cart.getItemsOrdered()) {
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
}