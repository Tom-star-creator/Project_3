import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;



public class FileMenuHandler implements ActionListener {
	JFrame jframe;


	JFileChooser jfile;
	/**
	 * @author Tommaso Coraci
	 * @since 11/19/20
	 * @version 1
	 * @description this is used to produce the method whenever the user clicks on a specific button in the JMenu
	 * @param jf this Jframe is used in order for the createFileMenu in the WordGUI class to process
	 * 
	 **/
	
	public FileMenuHandler(JFrame jf) {
		jframe = jf;
	}
	/**
	 * 
	 * @param event this ActionEvent is used to make sure a method is processed whenever the user 
	 * clicks on either the Open or Quit JButton 
	 * 
	 */
	public void actionPerformed(ActionEvent event) {
		int returnValue;
		String menuName = event.getActionCommand();
		if (menuName.equals("Open")) {
			// JOptionPane.showMessageDialog(null,"You clicked on Open");
			jfile = new JFileChooser("./");
			jfile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			returnValue = jfile.showOpenDialog(null); // the return value is the button the user clicks on 
			File f = jfile.getSelectedFile();
			if (returnValue == JFileChooser.APPROVE_OPTION) {// making sure the user clicked the Open button
				((WordGUI) jframe).createColumns(f);
			}
		}

		else if (menuName.equals("Quit")) {
			// JOptionPane.showMessageDialog(null,"You clicked on Quit");
			System.exit(0);
		}

	} // actionPerformed

}