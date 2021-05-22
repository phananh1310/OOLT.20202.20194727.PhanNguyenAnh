package hust.soict.globalict.aims.screen;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	
	@FXML
    private ToggleGroup filterCategory;
	
	private Cart cart;
	
    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String > colMediaCategory;

    public CartScreenController(Cart cart) {
		this.cart=cart;
	}

	@FXML
    private void initialize() {
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
    	tblMedia.setItems(this.cart.getItemsOrdered());

    }
}