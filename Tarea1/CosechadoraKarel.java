/*******************************************************************
 * Este ejrecicio usa un mapa con beepers
 * Karel tiene que recogerlos todos
 * Parte de la esquina inferior izquierda, mirando haicia el Este
 * y termina en el mismo sitio
 * *****************************************************************
 */

public class CosechadoraKarel extends KarelMejorada{

	public void run() {
		while(frontIsClear()) {
			limpiaColumnaDeSubida();
			limpiaColumnaDeBajada();
		}
		turnLeft();
		while(frontIsClear()) {
			move();
		}
		if(frontIsBlocked()) {
			if(rightIsBlocked()) {
				turnAround();
			}
		}
		while(frontIsClear()) {
			move();
		}
		turnLeft();
		retornoAlInicio();
	}

	private void limpiaColumnaDeSubida() {
		turnLeft();
		while(frontIsClear()) {
			move();
			if(beepersPresent()) {
				pickBeeper();
			}
		}
		if(frontIsBlocked()) {
			turnRight();
			move();
			turnRight();

		}
	}

	private void limpiaColumnaDeBajada() {
		while(frontIsClear()) {
			move();
			if(beepersPresent()) {
				pickBeeper();
			}
		}
		if(frontIsBlocked()) {
			turnLeft();
			if(frontIsClear()) {
				move();
			}
			//turnLeft();
		}
	}

	private void retornoAlInicio() {
		turnAround();
		while(frontIsClear()) {
			move();
		}
		turnAround();
	}








	//		//Karel asciende una columna y desciende por la siguiente
	//		//recogiendo todos los Beepers que se encuentre
	//		//		while (frontIsClear()) {
	//		//Karel asciende una columna y desciende por la siguiente
	//		//recogiendo todos los Beepers que se encuentre
	//		recogeTodosLosBeepers();
	//		//			if (frontIsBlocked()){
	//		//				//Karel retorna al punto de Partida
	//		//				retornaAlInicio();
	//		//			}
	//		//		}
	//	}
	//
	//	private void limpiaColumna() {
	//		//Karel gira 90 grados a la izquierda para mirar al norte
	//		turnLeft();
	//		//Karel asciende por la columna recogiendo los beepers a su paso
	//		while (frontIsClear()) {
	//			move();
	//			if (beepersPresent()) {
	//				pickBeeper();
	//			}
	//
	//			//Al llegar arriba Karel gira 90 grados a la derecha, pasa a la
	//			//segunda columna y se coloca mirando al Sur
	//			if (frontIsBlocked()) {
	//				turnRight();
	//
	//			}
	//		}
	//		move();
	//	}
	//
	//	private void recogeTodosLosBeepers(){
	//		while(frontIsClear()) {
	//			limpiaColumna();
	//			move();
	//		}
	//	}
	//	
	//	private void limpiaUnaColumna() {
	//		//1º girar a la izquierda a Karel para que mire al techo
	//		turnLeft();
	//		//2º avanzar recogiendo beepers hasta que no haya más
	//		while(frontIsClear()) {
	//			pickBeeper();
	//			move();
	//		}
	//		//3º dar media vuelta
	//		turnRight();
	//	}
	//
	//		//Karel desciende por la siguiente columna recogiendo los beepers a su paso
	//		//		while (facingSouth()) {
	//		//			move();
	//		//			if (beepersPresent()) {
	//		//				pickBeeper();
	//		//			}
	//		//
	//		//			//Al llegar al suelo Karel gira a 90 grados a la izquierda, colocandose
	//		//			//mirando al Este y avanza uno
	//		//			if (frontIsBlocked()) {
	//		//				turnLeft();
	//		//				move();
	//		//			}
	//		//		}
	//
	//
	//
	//		//Karel retorna a la posicioón inicial
	//		private void retornaAlInicio(){
	//			daVuelta();
	//			while(frontIsClear()) {
	//				move();
	//			}
	//			daVuelta();
	//		}


}
