package contract;

/**
 * The Interface IController.
 *
 */
public interface IController {

	/**
	 * Control.
	 */
	public void control();

	/**
	 * Order perform.
	 *
	 * Assigns the selection to a variable
	 * 
	 * @param controllerOrder the controller order
	 * 
	 */
	public void orderPerform(ControllerOrder controllerOrder);
}
