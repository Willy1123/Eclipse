/*
 * Para cambiar un fondo con un clic
 * 
 * Tienes que guardar el archivo del fondo en el proyecto
 * 
 */


import java.awt.Color;
import java.awt.Font;

import acm.graphics.GImage;
import acm.graphics.GLabel;


public class CambiarFondoConUnClick extends acm.program.GraphicsProgram{

	GImage imagenFondo = new GImage("imagenes/espacio1.jpg");
	GImage imagenFondo2 = new GImage("imagenes/ECD.gif");
	public void run(){

		add(imagenFondo, 0, 0);
		GLabel mensaje = new GLabel (" Haz clic con el botón del ratón");
		add(mensaje, 100, 200);
		waitForClick();
		
		//cambio a la segunda imagen porque ya han hecho clic
		remove (imagenFondo);
		add(imagenFondo2, 0, 0);
		
	}
}
