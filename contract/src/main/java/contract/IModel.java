package contract;

import java.util.Observable;

import entity.HelloWorld;

/**
 * The Interface IModel.
 *
 */
public interface IModel {

	/**
	 * Gets the map.
	 *
	 * @return the map entity
	 */
	HelloWorld getHelloWorld();

	/**
	 * Load the map.
	 *
	 * @param code
	 *          the code
	 */
	void loadHelloWorld(String code);

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}
