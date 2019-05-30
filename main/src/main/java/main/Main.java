/*
 * @version 1.0
 */
package main;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import contract.ControllerOrder;
import controller.Controller;
import model.Model;
import view.View;

/*
 * The Class Main.
 *
 */
public abstract class Main implements Runnable{

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
	public static boolean running;
	
    public static void main(final String[] args) {
        final Model model = new Model();
        final View view = new View(model);
        final Controller controller = new Controller(view, model);
        view.setController(controller);

        controller.control();
        controller.orderPerform(ControllerOrder.Map5);
        
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(3);
        ses.scheduleAtFixedRate(() -> {
			
			view.rock();
			
		}, 0, 1, TimeUnit.SECONDS);
    }
    
}