package hust.soict.globalict.aims.screen;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen{
	private ArrayList<Track> tracks = new ArrayList<Track>();
	private JTextField tfDirector,tfLength,tfArtist;
	JTextField tftracks = new JTextField("");

	
	public JTextField getTfArtist() {
		return tfArtist;
	}



	public JTextField getTfDirector() {
		return tfDirector;
	}



	public JTextField getTfLength() {
		return tfLength;
	}

	public AddCompactDiscToStoreScreen() {
		super();

		this.add(new JLabel("Director: "));
		tfDirector=new JTextField("");
		this.add(tfDirector);
		
		this.add(new JLabel("Length: "));
		tfLength =new JTextField("");
		this.add(tfLength);
		
		this.add(new JLabel("Artist: "));
		tfArtist=new JTextField("");
		this.add(tfArtist);
		
		JButton addTrack = new JButton("Add Track");
		this.add(addTrack);
		addTrack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame popup = new JFrame("Add track");
				popup.setSize(500,300 );
				popup.setLayout(new GridLayout(3,1));
				
				JTextField tftitle=new JTextField(""),tflength=new JTextField("");

				popup.add(new JLabel("Title: "));
				popup.add(tftitle);
				
				popup.add(new JLabel("Length: "));
				popup.add(tflength);
				
				popup.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				
				JButton OK = new JButton("OK");
				popup.add(OK);
				popup.setVisible(true);
				OK.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						Track track = new Track(tftitle.getText(),Integer.parseInt(tflength.getText()));
						tracks.add(track);
						tftracks.setText(tftracks.getText()+" "+ tftitle.getText()+"("+tflength.getText()+")");
						//System.exit(0);
						
					}
					
				});
				
			}
			
		});
		
		this.add(tftracks);
		tftracks.setEditable(false);
	}
	
	public Media make() {
		
		return new CompactDisc(this.getTfArtist().getText(),tracks,this.getTfTitle().getText(),this.getTfCategory().getText(),tfDirector.getText(),Float.parseFloat(this.getTfCost().getText()));
	}

}
