/*
 * La Clase BucleInfinito hace que Karel de vueltas alrededor del
 * mapa de tal modo que avance hasta encontrarse una pared, después
 * gire a la izquierda y se repita el proceso, formando un bucle
 * infinito.
 */

public class BucleInfinito extends KarelMejorada {

	public void run() {
		while(frontIsClear()) {
			move();
			if(frontIsBlocked()) {
				turnLeft();
			}
		}
	}
}
