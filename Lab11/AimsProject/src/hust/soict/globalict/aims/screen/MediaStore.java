package hust.soict.globalict.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;

public class MediaStore extends JPanel {
	private Media media;
	
	public MediaStore(Media media) {
		this.media = media;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN,20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel(""+media.getCost()+" $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton addCart =new JButton("Add to cart");
		container.add(addCart);
		addCart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// add to cart here
				WRAP.cart.addMedia(media);
				JFrame f = new JFrame("Message");
				f.add(new JLabel("Cart added!"));
				f.setSize(350,100);
				f.setVisible(true);
			}
			
		});
		
		if (media instanceof Playable) {
			JButton Play = new JButton("Play");
			container.add(Play);
			Play.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame f = new JFrame();
					JDialog dialog = new JDialog(f,"Play");
					dialog.setSize(300, 200);
					dialog.add(new JTextArea(media.playToString()));
					
					dialog.setVisible(true);
				}
				
			});
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
	}

}
