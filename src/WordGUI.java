import java.awt.GridLayout;
import java.awt.TextArea;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class WordGUI extends JFrame {
/**
 * @author Tommaso Coraci
 * @since 11/19/20
 * @version 1
 * @description this is where all the ArrayLists are appended and sorted to dipslay into the final output
 * @param title takes in the title of the GUI
 * @param height takes in the height of the GUI
 * @param width takes in the width of the GUI
 * 
 **/
    public WordGUI(String title, int height, int width) {
        setTitle(title);
        setSize(height, width);
        setLocation(400, 200);
        createFileMenu(); // this is the used for the createFileMenu method
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1, 3));
        this.setVisible(true);
    }
/**
 * 
 * @param f takes in the file thats being used to be read through the strings
**/
    public void createColumns(File f) { 
        Scanner filescanner = null; 
        try {
            filescanner = new Scanner(f);// used a scanner to take in the file
        } catch (FileNotFoundException e1) { // uses an exeception in case there isn't a file to use
            return;
        }

        ArrayList<Word> unsorted = new ArrayList<Word>();  // created an ArrayList that takes in a Word object from the Word class
        ArrayList<Word> sorted = new ArrayList<Word>(); // this is similar to the sorted ArrayList
        ArrayList<String> erroneous = new ArrayList<String>(); // this Arraylist uses a String instead of a Word
        while (filescanner.hasNextLine()) { // use a while loop to go through each line inside the scanner that contains the file
            // fill ArrayList from words in file
            String line = filescanner.nextLine();
            String[] words = line.split("\\W+");
            // store the right words in the right ArrayList
            for (int i = 0; i < words.length; i++) {
                try { // use a try catch block catch make sure each Word word object is valid
                    Word word = new Word(words[i]);
                    unsorted.add(word); // adds the word object into the unsorted ArrayList
                    sorted.add(word); // adds the word object into the sorted ArrayList
                } catch (IllegalWordException e ) { // this makes sure to catch an invalid word with IllegalWordException class
                    erroneous.add(words[i]); //adds the invalid Strings into the String ArrayList
                }
            }
        }
        filescanner.close(); // closes the Scanner object
        Collections.sort(sorted); //  sorts the sorted ArrayList

        TextArea unsortedTextArea = new TextArea();
        TextArea sortedTextArea = new TextArea();
        TextArea erroneousTextArea = new TextArea();

        // Put the data into unsortedTextArea
        for (Word word : unsorted) { // for every word in unsorted
            unsortedTextArea.append(word.toString() + "\n");
        }
        for (Word word : sorted) {
            sortedTextArea.append(word.toString() + "\n");
        }
        for (String word : erroneous) {
            erroneousTextArea.append(word + "\n");
        }

        this.add(unsortedTextArea);
        this.add(sortedTextArea);
        this.add(erroneousTextArea);
        this.validate();
        this.repaint();
    }

    private void createFileMenu() {
        // this whole section allows for you to go thought the Project3 file
    	JMenuItem item; 
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        FileMenuHandler fmh = new FileMenuHandler(this);

        item = new JMenuItem("Open"); // Open...
        item.addActionListener(fmh);
        fileMenu.add(item);

        fileMenu.addSeparator(); // add a horizontal separator line

        item = new JMenuItem("Quit"); // Quit
        item.addActionListener(fmh);
        fileMenu.add(item);

        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
    }
}

