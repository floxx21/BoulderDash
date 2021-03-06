package view;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class View.
 *
 */
public final class View implements IView, Runnable {

	/** The frame. */
	private final ViewFrame viewFrame;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *            the model
	 */
	@Override
	public void displayPlayer() {
		try {
			((ViewPanel) this.viewFrame.getContentPane()).displayPlayer(this.viewFrame.getContentPane().getGraphics());
		} catch (IOException e) {
			Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	@Override
	public void rock() {
		((ViewPanel) this.viewFrame.getContentPane()).rock(this.viewFrame.getContentPane().getGraphics());
	}

	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *            the key code
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_UP:
			return ControllerOrder.Up;
		case KeyEvent.VK_DOWN:
			return ControllerOrder.Down;
		case KeyEvent.VK_LEFT:
			return ControllerOrder.Left;
		case KeyEvent.VK_RIGHT:
			return ControllerOrder.Right;
		default:
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.viewFrame.setVisible(true);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *            the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}

	@Override
	public void startThread() {
		int isActive = 0;
		if (isActive != 1) {
			Thread t = new Thread(new threadview());
			t.start();
			isActive = 1;

		}
	}

	public class threadview implements Runnable {
		@Override
		public void run() {
			int i = 1;
			while (i > 0) {
				rock();
				try {
					TimeUnit.MILLISECONDS.sleep(700);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
