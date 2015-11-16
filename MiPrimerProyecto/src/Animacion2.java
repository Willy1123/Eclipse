import java.awt.Color;

import acm.program.*;
import acm.graphics.*;
import acm.util.*;
/*
 * Autor: Guillermo Blasco P�rez
 * 
 * La clase Animacion2 realiza la animaci�n pero con un bucle while
 */

public class Animacion2 extends GraphicsProgram{

	int velocidadX = 10;
	int velocidadY = 20;

	public void run() {

		GOval pelota = new GOval (50,50);
		pelota.setFilled(true);
		pelota.setFillColor(Color.YELLOW);
		add(pelota);

		while(true) {
			pelota.move(velocidadX, velocidadY);
			pause(30);
			//si la posici�n X de la pelota s superior a 1024
			//es que ha tocado la pared derecha y tiene que vovler
			if((pelota.getLocation().getX() > 1860) || (pelota.getLocation().getX() < 0)){
				velocidadX = velocidadX * (-1);
			}

			if((pelota.getLocation().getY() > 1033) || (pelota.getLocation().getY() < 20)){
				velocidadY = velocidadY * (-1);
			}
		}
	}
}
