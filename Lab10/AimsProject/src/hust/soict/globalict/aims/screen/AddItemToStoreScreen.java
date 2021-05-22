package hust.soict.globalict.aims.screen;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import hust.soict.globalict.aims.Store;
import hust.soict.globalict.aims.media.Media;

public class AddItemToStoreScreen extends JPanel {

	private JTextField tfTitle,tfCategory,tfCost;
	
	public JTextField getTfTitle() {
		return tfTitle;
	}

	public JTextField getTfCategory() {
		return tfCategory;
	}

	public JTextField getTfCost() {
		return tfCost;
	}

	public AddItemToStoreScreen() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(new JLabel("Title: "));
		tfTitle=new JTextField("");
		
		this.add(tfTitle);
		
		this.add(new JLabel("Category: "));
		tfCategory =new JTextField("");
		this.add(tfCategory);

		this.add(new JLabel("Cost: "));
		tfCost =new JTextField("");
		this.add(tfCost);

	}
	
	public Media make() { //make a media when you  press ok
	return null;
	}

}
