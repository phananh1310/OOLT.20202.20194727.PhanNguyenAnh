package hust.soict.globalict.aims.exception;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class PlayerException extends Exception {

	public PlayerException() {
	}

	public PlayerException(String message) {
		super(message);
		this.printStackTrace();
		JOptionPane optionPane = new JOptionPane(this.toString(), JOptionPane.ERROR_MESSAGE);    
		JDialog dialog = optionPane.createDialog("ERROR");
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);
		// TODO Auto-generated constructor stub
	}

	public PlayerException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public PlayerException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PlayerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
