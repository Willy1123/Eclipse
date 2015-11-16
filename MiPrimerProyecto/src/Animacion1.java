import java.awt.Color;

import acm.program.*;
import acm.graphics.*;
import acm.util.*;

/*
 * Autor: Guillermo Blasco
 * +
 * Este programa muestra la técnica básica de la animación
 * 
 * Va a mover un GRect desde la coordenada (0,) hasta la 
 * esquina inferior derecha
 */

public class Animacion1 extends GraphicsProgram{

	private static int LADO = 20;
	//numero de pasos en los que recorre la distancia
	private static int N_PASOS = 2000;

	public void run() {
		RandomGenerator aleatorio = new RandomGenerator();
		for (int i=0; i < N_PASOS; i++) {
			//creamos el rectángulo
			GRect cuadrado = new GRect (aleatorio.nextInt(400), aleatorio.nextInt(400));
			//lo mintamos de un color
			cuadrado.setFilled(true);
			cuadrado.setFillColor(aleatorio.nextColor());
			add(cuadrado, aleatorio.nextInt(1920), aleatorio.nextInt(1080));
			pause(1);
			
			int anchoCirculo = aleatorio.nextInt(1000);
			//creamos un círuclo
			GOval circulo = new GOval (anchoCirculo, anchoCirculo);
			//lo mintamos de un color
			circulo.setFilled(true);
			circulo.setFillColor(aleatorio.nextColor());
			add(circulo, aleatorio.nextInt(1920), aleatorio.nextInt(1080));
			pause(1);

		}
		//el bucle se ejecutará N_PASOS
		//		for(int i=0; i<N_PASOS; i++) {
		//			cuadrado.move(aleatorio.nextInt(-20, 20), aleatorio.nextInt(-20, 20));
		//			pause(10);
		//		}

	}

}
