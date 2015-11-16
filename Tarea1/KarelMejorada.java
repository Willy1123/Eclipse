/*
 * File: KarelMejorada.java
 * ---------------------------
 * la clase KarelMejorada extiende las acciones b�sicas
 * de Karel para que cualquier subclase tenga acceso al m�todo
 * giraDerecha()
 * adem�s a�ade el m�todo daVuelta() que gira 180 grados a Karel
 */
import stanford.karel.*;
public class KarelMejorada extends SuperKarel {
	/**
	 * gira a Karel 90 grados a la derecha.
	 */
	public void giraDerecha() {
		turnRight();
	}

	/**
	 * gira a Karel 180 grados
	 */
	public void daVuelta() {
		turnAround();
	}

	/**
	 * rellenaAgujero supone que Karel comprueba si hay un agujero debajo de ella.
	 * Si el agujero est� vacio, pone un beeper y vuelve a subir, por el contrario, hay un beeper
	 * entra, da la vuelta y sale
	 */
	public void rellenaAgujero() {
		giraDerecha();
		move();
		if(noBeepersPresent()){
		putBeeper();
		}
		daVuelta();
		move();
		giraDerecha();

	}
	
}