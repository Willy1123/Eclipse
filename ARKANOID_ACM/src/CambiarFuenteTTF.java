/*
 * Para cargar una fuente TTF
 * 
 * Tienes que guardar el archivo TTF en el proyecto
 * 
 */


import java.awt.Color;
import java.awt.Font;

import acm.graphics.GLabel;


public class CambiarFuenteTTF extends acm.program.GraphicsProgram{
	//label de prueba
	GLabel marcador = new GLabel("HOLA");
	//fuente 
	Font fuente;
	public void run(){
		try {
			//un try/catch se utiliza cuando una instrucción
			//puede dar problemas, por ejemplo cuando lee del disco duro un archivo 
			fuente = Font.createFont(Font.TRUETYPE_FONT, 
					getClass().getResourceAsStream("Pacifico.ttf"));
		} catch (Exception e) {}
		//cambio el color de la fuente
		marcador.setColor(Color.orange);
		// cambio el tamaño y tipo
		//Font.PLAIN = 0 , Font.BOLD = 1 , Font.ITALIC = 2
		marcador.setFont(fuente.deriveFont(0, 78));
		add(marcador, 50, 80);
	}
}
