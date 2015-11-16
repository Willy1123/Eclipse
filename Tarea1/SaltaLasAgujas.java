
public class SaltaLasAgujas extends KarelMejorada{

	public void run() {
		//sube columna
		/**
		 * girar a la izquierda
		 * avanzar hasta la cima
		 * girar a la derecha
		 */

		//salta aguja
		/**
		 * mover 1
		 */
		//bajar columana
		/**
		 * descender hasta el suelo
		 * girar a la derecha
		 */
		turnLeft();
		while(frontIsClear()) {
			move();

			subeLaAguja();
			//saltaLaAguja();
			bajaLaAguja();

		}

	}

	private void subeLaAguja() {

		while(rightIsBlocked() && frontIsClear()) {
			move();
		}
		turnRight();
		if(frontIsClear()) {
			move();
		}
	}

	private void bajaLaAguja() {
		turnRight();
		while(frontIsClear()) {
			move();
		}
		turnLeft();
	}
}

//	private void subeLaAguja() {
//		//			while(frontIsBlocked() && rightIsBlocked() && facingNorth()) {
//		//			turnAround();
//		//		}
//		turnLeft();
//
//		while(frontIsClear() && rightIsBlocked()) {
//			move();
//			if(frontIsBlocked() && rightIsBlocked() && facingNorth()) {
//				turnAround();
//			}
//		}
//		turnRight();
//	}
//
//	private void saltaLaAguja() {
//		move();
//	}
//
//	private void bajaLaAguja() {
//		turnRight();
//		while(frontIsClear()) {
//			move();
//		}
//		turnLeft();
//		while(frontIsClear()) {
//			move();
//		}
//	}
//
//}