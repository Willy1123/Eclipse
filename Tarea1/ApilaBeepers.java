/*
 * Autor Guillermo Blasco
 * 
 * ApilaBeepers recoge todos los beepers que hay en el mapa
 * distribuidos en columnas
 */
public class ApilaBeepers extends KarelMejorada{

	public void run() {
		move();
		recogeTodosLosBeepers();
		dejaTodosLosBeepers();
		retornaAlInicio();
	}
	
	private void retornaAlInicio(){
		daVuelta();
		while(frontIsClear()) {
			move();
		}
		daVuelta();
	}
	
	private void dejaTodosLosBeepers() {
		while(beepersInBag()) {
			putBeeper();
		}
	}
	
	private void recogeTodosLosBeepers(){
		while(frontIsClear()) {
			limpiaUnaColumna();
			move();
		}
	}
	
	private void limpiaUnaColumna() {
		//1� girar a la izquierda a Karel para que mire al techo
		turnLeft();
		//2� avanzar recogiendo beepers hasta que no haya m�s
		while(frontIsClear()) {
			pickBeeper();
			move();
		}
		//3� dar media vuelta
		daVuelta();
		//4� avanzara hasta el suelo
		while(frontIsClear()) {
			move();
		}
		//5� girar a la izquierda para que quede mirando al Este
		turnLeft();
	}
}

