// 6.1
import javax.swing.JOptionPane;
public class ChoosingOption {
	public static void main (String[] args) {
		int option = JOptionPane.showConfirmDialog(null, "Do you want to change the first class ticket?");
		JOptionPane.showMessageDialog(null, "You've chosen: "+(option==JOptionPane.YES_OPTION?"Yes":"No"));
		System.exit(0);
	}
}
/* Question
 - if users choose "Cancel": we don't save and launch the program
 - To customize:
if (option == JOptionPane.YES_OPTION) {
  JOptionPane.showMessageDialog(null, "You've chosen I do");
} else {
  JOptionPane.showMessageDialog(null, "You've chosen I don't");  
 
*/