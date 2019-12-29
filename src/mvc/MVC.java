package mvc;

/**
 * The MVC class starts the program and essentially initializes the code by making a controller object that controls interaction between parts of MVC
 * 
 * Due Date: 04/12/2019
 * 
 * @author Lannie Dalton Hough III
 * @version 1.0
 */

public class MVC {

	private Controller myController;
	
	/**
	 * Main method
	 */
	
	public static void main(String[] args) {
		
		new MVC();

	}
	
	/**
	 * Constructs MVC object
	 */
	
	public MVC() {
		setController(new Controller());
	}
	
	/**
	 * Sets the controller
	 */
	
	public void setController(Controller controller) {
		myController = controller;
	}
	
	/**
	 * Gets and returns the controller
	 * 
	 * @return controller object
	 */
	
	public Controller getController() {
		return myController;
	}

}
