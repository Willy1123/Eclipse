
public class Fibonacci extends KarelMejorada{

	public void run() {
		move();
		while(frontIsClear()) {
		pasaBeepers();
		}
	}
	
	private void pasaBeepers() {
		while(beepersPresent()) {
			move();
		}
	}


}
