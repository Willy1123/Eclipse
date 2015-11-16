/*
 * ArreglaCarretera debe colocar un Beeper en un agujero
 */
import stanford.karel.Karel;
public class ArreglaCarretera extends KarelMejorada {
	public void run() {
		move();
		rellenaAgujero();
		move();
	}
}
