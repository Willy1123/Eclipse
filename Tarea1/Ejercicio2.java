/*
 * ArreglaCarreteraLarga debe colocar un beeper en cada agujero
 */

public class Ejercicio2 extends KarelMejorada {
	public void run() {
		while(frontIsClear()) { //Mientras no haya pared delante muevete
			if(rightIsClear()) { //Si hay un agujero a la derecha, rellenalo
				rellenaAgujero(); //Gira a la derecha, se mete en el agujero pone un beeper, da la vuela, avanza y gira a la derecha
			}
			if(beepersPresent()) { //Si hay un beeper en el agujero, entra, y da la vuelta
				daVuelta();
			}
			move();
		}
	}
}
