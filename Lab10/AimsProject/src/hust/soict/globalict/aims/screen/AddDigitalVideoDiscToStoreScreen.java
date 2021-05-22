package hust.soict.globalict.aims.screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;


public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen{
	
	private JTextField tfDirector,tfLength;
	
	
	public JTextField getTfDirector() {
		return tfDirector;
	}



	public JTextField getTfLength() {
		return tfLength;
	}



	public AddDigitalVideoDiscToStoreScreen() {
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(new JLabel("Director: "));
		tfDirector=new JTextField("");
		this.add(tfDirector);
		
		this.add(new JLabel("Length: "));
		tfLength =new JTextField("");
		this.add(tfLength);
		
	}	

	
	
	public Media make() {
		return new DigitalVideoDisc(this.getTfTitle().getText(),this.getTfCategory().getText(),tfDirector.getText(),Integer.parseInt(tfLength.getText()),Float.parseFloat(this.getTfCost().getText()));
	}
	
}

