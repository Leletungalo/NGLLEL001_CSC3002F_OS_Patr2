package dishWashS;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;


public class WetDishRack {
	// add variables
	private int rackSize;
	private Semaphore washersemaphore;
	private Semaphore dryerSemaphore;
	private ArrayList<Integer> rack ;
	WetDishRack(int rackSize) {
		this.rackSize = rackSize;
		washersemaphore = new Semaphore(1);
		dryerSemaphore = new Semaphore(0);
		rack = new ArrayList<>(rackSize);
	}
	
	public void addDish(int dish_id)  throws InterruptedException {
		if(washersemaphore.availablePermits() >= 0){
			washersemaphore.acquire();
			rack.add(dish_id);
			washersemaphore.release();
			dryerSemaphore.release();
		}

	}
	
	public int removeDish() throws InterruptedException {

		dryerSemaphore.acquire();
		int dish = rack.get(0);
		rack.remove(0);
		return dish;
	}
	
}



