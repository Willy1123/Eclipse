/**
 * CollectNespaperKarel hace que Karel salga de la caja interna,
 * llegue hasta el Beeper, lo recoga, vuelva al punto inicial
 * y suelte el Beeper
 */

public class RecogeElPeriodico extends KarelMejorada {

	public void run() {
		//1º Karel se mueve hasta la entrada de la caja interna
		veALaEntrada();
		//2º Karel avanza para recoger el Beeper da la vuelta y vuelve a entrar a la caja
		recogeElPeriodico();
		//3º Karel gira a la derecha y vuelve a la posición inicial
		vuelveAlSofa();
		//4º Karel deja el Beeper en su misma posición
		dejaElPeriodico();
	}

	private void veALaEntrada() {
		//1º Karel avanza hasta llegar a la pared
		while(frontIsClear()) { 
			move();
		}

		//2º Al llegar a la pared Karel gira 90 grados a la derecha
		giraDerecha();

		//3º Karel avanza hasta llegar a la entrada y gira 90 grados a la izquierda
		//para quedarse mirando jacia el este (derecha) 
		while(leftIsBlocked()) {
			move();
		}
		turnLeft();
	}

	private void recogeElPeriodico() {
		//1º Karel avanza hasta llegar donde está el Beeper
		while(frontIsClear()) {
			move();
			//2º Al llegar donde está el Beeper, Karel lo recoge y da media vuelta	
			if(beepersPresent()) {
				pickBeeper();
				daVuelta();
			}
		}
		//3º Karel vuelve a entrar hasta llegar a la pared de la caja interna
		//(ya que termina el bucle, y como no hay nada delante de Karel,
		//está avanza hasta encontrarse con una pared)
	}

	private void vuelveAlSofa() {
		//1º Karel gira a la derecha
		giraDerecha();

		//2º Karel avanza hasta llegar al punto de partida
		while(frontIsClear()) {
			move();
		}
		//Karel gira 90 grados a la derecha para colocarse en la misma posición que al principio
		giraDerecha();
	}

	private void dejaElPeriodico() {
		//Karel deja el Beeper en su posición
		putBeeper();

	}
}
