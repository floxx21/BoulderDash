package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import entity.Player;

/**
 * The Class Controller.
 */
public final class Controller implements IController {

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	/**
     * Control.
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#control()
	 */
	public void control() {
		this.view.printMessage("Welcome to BoulderDash");
	}

	/**
     * Sets the view.
     *
     * @param pview
     *            the new view
     */
	private void setView(final IView pview) {
		this.view = pview;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
     * Order perform.
     *
     * @param controllerOrder
     *            the controller order
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		this.view.rock();
		switch (controllerOrder) {
			case Map1:
				this.model.loadHelloWorld("L1");
				break;
			case Map2:
				this.model.loadHelloWorld("L2");
				break;
			case Map3:
				this.model.loadHelloWorld("L3");
				break;
			case Map4:
				this.model.loadHelloWorld("L4");
				break;
			case Map5:
				this.model.loadHelloWorld("L5");
				break;
			case Up:
				Player.faceplayer = 2;
				Player.y = Player.y-16;
				this.view.displayPlayer();
				break;
			case Down:
				Player.faceplayer = 1;
				Player.y = Player.y+16;
				this.view.displayPlayer();
				break;
			case Left:
				Player.faceplayer = 3;
				Player.x=Player.x-16;
	            this.view.displayPlayer();
				break;
			case Right:
				Player.faceplayer = 4;
				Player.x=Player.x+16;
	            this.view.displayPlayer();
				break;
			default:
				break;
		}
	}
}
