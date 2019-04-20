package dishWashS;
import java.util.concurrent.Semaphore;

public class WetDishRack {
	// add variables
	private int rackSize;
	Semaphore semaphore;
	WetDishRack(int rackSize) {
	    // add correct code here
		this.rackSize = rackSize;
		semaphore = new Semaphore(0);
	}
	
	public void addDish(int dish_id)  throws InterruptedException {
		// add correct code here
	}
	
	public int removeDish() throws InterruptedException {
		return 0; // replace with correct code here
	}
	
}



