package dishWashS;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class WetDishRack {
	// add variables
	private int rackSize,count;
	Semaphore semaphore;
	ArrayList<Integer> rack ;
	WetDishRack(int rackSize) {
	    // add correct code here
		this.rackSize = rackSize;
		semaphore = new Semaphore(0);
		rack = new ArrayList<>(rackSize);
		count = 0;
	}
	
	public void addDish(int dish_id)  throws InterruptedException {

		if(semaphore.availablePermits() < rackSize){
			semaphore.release();
			rack.add(dish_id);
			count++;
		}

	}
	
	public int removeDish() throws InterruptedException {
		//if (semaphore.availablePermits() > 0){
			semaphore.acquire();
			int dish = rack.get(0);
			rack.remove(0);
			return dish;
		//}
		//return -1;
	}
	
}



