
public class IllegalWordException extends IllegalArgumentException{
	/**
	 * @author Tommaso Coraci
	 * @since 11/19/20
	 * @version 1
	 * @description this is used to take extend to the IllegalArguementException that has
	 * all of the work to make sure an argument is invalid or not
	 * @param message this is used to call in the the the super class constructor
	 * 
	 */
	public IllegalWordException(String message){
		super(message); // super class's constructor 
	}
	

	
}
