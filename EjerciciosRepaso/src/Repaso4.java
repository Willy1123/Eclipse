/*
 * Autor: Guillermo Blasco
 * 
 * La clase Repaso2 tienen que dibujar un rectángulo
 * a partir del centro de la pantalla, en el lado superior
 * de la pantalla
 * 
 */
import acm.graphics.*;
import acm.program.*;

public class Repaso4 extends GraphicsProgram{
	
	//declaro una variable de instancia para almacenar el rectánulo
	//como es de instancia, se ve desde el init y desde el run
	GRect rectangulo;
	
	//declaro otra variable de instancia que guardará el punto X de la 
	//pantalla en que empezará a pintarse el rectángulo
	int distanciaX;
	int distanciaY;
	
	public void init() {
		//cambio el tamaño de la pantalla
		setSize(800, 600);
		
		//creo el rectángulo de 120 de ancho por 80 de alto
		rectangulo = new GRect(120, 80);
		add(rectangulo);
	}
	
	public void run() {
		//divido el ancho de la pantalla en 2 para saber donde está
		//la mitad exacta de la pantalla
		distanciaX = getWidth()/2;
		distanciaY = getHeight()/2;
		rectangulo.setLocation(distanciaX - rectangulo.getWidth()/2, distanciaY - rectangulo.getHeight()/2);
	}
}
