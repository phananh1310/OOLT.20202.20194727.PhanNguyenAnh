package hust.soict.globalict.swing;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LookAndFeelDemo extends JFrame {
	public LookAndFeelDemo() {
	addDemoComponents();
	addLookAndFeelComboBox();
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(380,150);
	setVisible(true);

	}
	void addDemoComponents() {
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(new JLabel("Label:"));
		cp.add(new JTextField("Text field"));
		cp.add(new JRadioButton("Radio button"));
		cp.add(new JButton("Button"));
		
	}
	void addLookAndFeelComboBox() {
		Container cp = getContentPane();
		cp.add(new JLabel("Change Look and Feel Here: "));
		
		// create combo box
		
		LookAndFeelInfo[] lafInfos = UIManager.getInstalledLookAndFeels();
		String[] lafNames = new String[lafInfos.length+2];
		for (int i=0;i<lafInfos.length;i++) {
			lafNames[i] = lafInfos[i].getName();
		}

		// add 2  new laf
		
		lafNames[lafNames.length-2]=	"Cross Platform";
		lafNames[lafNames.length-1]=	" System";
		
		JComboBox cbLookAndFeel = new JComboBox(lafNames);
		cp.add(cbLookAndFeel);
		JFrame frame = this;
		cbLookAndFeel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				int index = cbLookAndFeel.getSelectedIndex();
				if (index < lafNames.length-2) {
				try {
					UIManager.setLookAndFeel(lafInfos[index].getClassName());
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				}
				else if (index == lafNames.length-2) {
					try {
					UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
					else if (index == lafNames.length-1) {
						try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						} catch (Exception e) {
							e.printStackTrace();
						}
					
				}
				SwingUtilities.updateComponentTreeUI(frame);
				setTitle(lafNames[index] + " Look And Feel");
			}
		});
		
	}
	public static void main (String[] args) {
		new LookAndFeelDemo();
	}
}
