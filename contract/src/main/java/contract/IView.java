package contract;

/**
 * The Interface IView.
 *
 */
public interface IView {

	/**
	 * Prints the message.
	 *
	 * @param message
	 *          the message
	 */
	void printMessage(final String message);
	
	public void displayPlayer();

	void rock();

	void startThread();
}
