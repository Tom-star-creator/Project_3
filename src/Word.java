import java.io.File;
import java.io.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class Word implements Comparable<Word> {
	// New Word Being Inserted

	protected String word;

	// returns the Word
	// returns the Word
    // have the constructor of the Word throw it (IllegalWordException).
	
	/**
	 *  @author Tommaso Coraci
	 * @since 11/19/20
	 * @version 1
	 * @description this is the section where it makes sure it word is valid or not
	 * @param word uses a String in order to take in the array of Strings inside the   
	 * the Word Object called word 
	 * @throws IllegalWordException this makes sure if there's an invalid 
	 * in this an invalid String
 	**/
	
	public Word(String word) throws IllegalWordException {
		this.word = word;
		// throw IllegalWordException if its erroneous
        if(!(word.matches("[a-zA-Z]+"))) { // matches to see if the String is erroneous or not
          	throw new IllegalWordException("Erraneous word");
        }
	}


	// enables the String to be printed
	public String toString() {
		return this.word;
	}

	
	@Override
	public int compareTo(Word other) { //this compareTo is used for the Collecetions.sort
		// what Word objects do I have? this,other
		// which one is word1 and word2 from example? this is word1, other is word2
		// what property of this do we want to compare? word
		// what property of other do we want to compare? word
		// this.other has no meaning (Word objects don't have an other property)

		if (this.word.compareTo(other.word) < 0)
			return -1;

		else if (this.word.compareTo(other.word) > 0)
			return 1;

		else
			return 0;
	}


}
