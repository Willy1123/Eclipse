
public class LaberintoKarel extends KarelMejorada{
	
	public void run() {
		while(noBeepersPresent()) {
			turnRight();
			while(frontIsBlocked()) {
				turnLeft();
			}
		move();
		}
		if(beepersPresent()) {
			turnRight();
		}
	}

}
