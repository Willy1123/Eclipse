
import stanford.karel.*;

public class EjemploSuperKarel extends SuperKarel{

	public void run() {
//		while (true) {
//		while (frontIsClear()) {
//			if(random()) {
//				paintCorner(GRAY);
//			}
//			else{
//				paintCorner(BLACK);
//			}
//			move();
//		}
//		turnLeft();
//		}
		
		while(frontIsClear()) {
			paintCorner(BLACK);
			move();
			paintCorner(BLACK);
			if(frontIsBlocked()) {
				turnLeft();
			}
		}
		
		while(facingNorth()) {
			move();
			paintCorner(BLACK);
			if(frontIsBlocked()) {
				turnLeft();
			}
		}
		while(!cornerColorIs(BLACK)) {
			move();
		}
		turnLeft();
	}
	
}
