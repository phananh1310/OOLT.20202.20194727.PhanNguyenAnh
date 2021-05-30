package hust.soict.globalict.aims.exception;

import javax.naming.LimitExceededException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class LuckyItemException extends LimitExceededException {
	public LuckyItemException() {
		
	}
	public LuckyItemException(String msg) {
		super(msg);
		JOptionPane optionPane = new JOptionPane(this.toString(), JOptionPane.ERROR_MESSAGE);    
		JDialog dialog = optionPane.createDialog("ERROR");
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);
	}
}
