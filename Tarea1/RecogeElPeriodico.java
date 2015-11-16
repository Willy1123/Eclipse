/**
 * CollectNespaperKarel hace que Karel salga de la caja interna,
 * llegue hasta el Beeper, lo recoga, vuelva al punto inicial
 * y suelte el Beeper
 */

public class RecogeElPeriodico extends KarelMejorada {

	public void run() {
		//1� Karel se mueve hasta la entrada de la caja interna
		veALaEntrada();
		//2� Karel avanza para recoger el Beeper da la vuelta y vuelve a entrar a la caja
		recogeElPeriodico();
		//3� Karel gira a la derecha y vuelve a la posici�n inicial
		vuelveAlSofa();
		//4� Karel deja el Beeper en su misma posici�n
		dejaElPeriodico();
	}

	private void veALaEntrada() {
		//1� Karel avanza hasta llegar a la pared
		while(frontIsClear()) { 
			move();
		}

		//2� Al llegar a la pared Karel gira 90 grados a la derecha
		giraDerecha();

		//3� Karel avanza hasta llegar a la entrada y gira 90 grados a la izquierda
		//para quedarse mirando jacia el este (derecha) 
		while(leftIsBlocked()) {
			move();
		}
		turnLeft();
	}

	private void recogeElPeriodico() {
		//1� Karel avanza hasta llegar donde est� el Beeper
		while(frontIsClear()) {
			move();
			//2� Al llegar donde est� el Beeper, Karel lo recoge y da media vuelta	
			if(beepersPresent()) {
				pickBeeper();
				daVuelta();
			}
		}
		//3� Karel vuelve a entrar hasta llegar a la pared de la caja interna
		//(ya que termina el bucle, y como no hay nada delante de Karel,
		//est� avanza hasta encontrarse con una pared)
	}

	private void vuelveAlSofa() {
		//1� Karel gira a la derecha
		giraDerecha();

		//2� Karel avanza hasta llegar al punto de partida
		while(frontIsClear()) {
			move();
		}
		//Karel gira 90 grados a la derecha para colocarse en la misma posici�n que al principio
		giraDerecha();
	}

	private void dejaElPeriodico() {
		//Karel deja el Beeper en su posici�n
		putBeeper();

	}
}
