/*
 * Autor Guillermo Blasco
 * 
 * En este Ejercicio Karel va a coger los beepers que se encuentre por el camino
 * y los va a apilar en una sola columna, uno encima de otro
 * 
 */
public class ExpandeBeepers extends KarelMejorada{

	public void run() {
		while(frontIsClear()) {
			/**
			 * Karel avanza hasta encontrar los beepers amontonados
			 */
			encuentraBeepers();

			/**
			 * Karel gira para mirar al norte y apilar los beepers y luego baja
			 */
			apilaBeepers();
		}
		/**
		 * Karel vuelve al Inicio tras haber apilado todos los beepers
		 */
		vuelveAlInicio();
	}

	private void encuentraBeepers() {
		while(noBeepersPresent()) {
			move();
		}
	}

	private void apilaBeepers() {
		//1. Gira a la Izquierda para mirar hacia el norte
		turnLeft();

		//2. Recoge todos los Beepers que se ha encontrado
		while(beepersPresent()) {
			pickBeeper();
		}

		//3. Avanza hacia el norte colocando los beepers uno encima de otro
		// hasta que se quede sin beepers
		while(frontIsClear() && beepersInBag()) {
			putBeeper();
			
			if(frontIsClear()) {
				move();
			}
			
			if(frontIsBlocked()) {
				putBeeper();
			}
		}

		//4. Da la vuelta para mirar hacia el Sur
		turnAround();

		//5. Avanza hasta llegar al suelo
		while(frontIsClear() && facingSouth()) {
			move();
		}

		//6. Gira a la Izquierda para mirar hacia el Este
		turnLeft();

		//7. Si no hay muro delante avanza a la siguiente posición
		if(frontIsClear()) {
			move();
		}
	}

	private void vuelveAlInicio() {
		//1. Da la vuelta
		turnAround();

		//2. Avanza hasta la posición inicial
		while(frontIsClear()) {
			move();
		}

		//3. Da la vuelta para colocarte en la posición inicial
		turnAround();
	}
}
