/*
 * EscalerasKarel es un ejercicio muy sencillo
 * en el que Karel tiene que subir unas escaleras
 * En cada pelda�o hay un beeper
 * y tiene que recogerlos todos 
 */

public class EscalerasKarel extends KarelMejorada{

	public void run() {
		//encontrar la base de las escaleras
		encuentraLaBase();
		//repetir 4 veces:
		for(int i = 0; i < 4; i++)
			//limpiar un pelda�o
			limpiarUnPelda�o();
	}

	private void encuentraLaBase() {
		//este m�todo parte de Karel mirando al Este en la esquina inicial
		//y busca la base de la escalera
		while (frontIsClear()) {
			move();
		}
	}

	private void limpiarUnPelda�o() {
		//este m�todo limpia un pelda�o de la escalera
		//Karel est� mirando hacia el Este y en la base del pelda�o
		turnLeft();
		move();
		turnRight();
		move();
		pickBeeper();
	}	
			
//for(int i = 0; i < 4; i++)			
//			while (frontIsClear()) {
//				turnRight();
//				move();
//				if (beepersPresent()) {
//					pickBeeper();
//				}
//			}
		
	
}
