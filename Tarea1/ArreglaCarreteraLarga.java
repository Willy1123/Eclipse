/*
* ArreglaCarreteraLarga debe colocar un beeper en cada agujero
*/

public class ArreglaCarreteraLarga extends KarelMejorada {

	public void run() {
		for(int i = 0; i < 9; i++) { //inicia el contador y lo inicia en i = 0. Siendo "i" el Nº de veces q se repite el bucle
			move();
			if(rightIsClear()) {
				rellenaAgujero();
			}
		}
		}
		
//		while (frontIsClear()) {
//			move();
//			rellenaAgujero();
//			if (frontIsClear()) {
//				move();
//			}
//		}
		
	}

