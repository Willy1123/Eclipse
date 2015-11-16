/*
 * 
 */

import java.awt.Color;
import acm.graphics.*;
import acm.program.*;

public class HolaMundo extends acm.program.GraphicsProgram{
	public void run() {
		//Grect (nombre) Sirve para crear un nuevo rectangulo
		//new Grect(X,Y) Para poner el tamaño del rectangulo
		GRect rectangulorojo = new GRect(900, 150);
		rectangulorojo.setColor(Color.red);
		rectangulorojo.setFilled(true);
		rectangulorojo.setFillColor(Color.RED);
		rectangulorojo.setLocation(20, 50);
		add(rectangulorojo);
		
		GRect rectanguloamarillo = new GRect(900, 400);
		rectanguloamarillo.setColor(Color.yellow);
		rectanguloamarillo.setFilled(true);
		rectanguloamarillo.setFillColor(Color.yellow);
		rectanguloamarillo.setLocation(20, 200);
		add(rectanguloamarillo);
		
		GRect rectangulorojo1 = new GRect(900, 150);
		rectangulorojo1.setColor(Color.red);
		rectangulorojo1.setFilled(true);
		rectangulorojo1.setFillColor(Color.red);
		rectangulorojo1.setLocation(20, 500);
		add(rectangulorojo1);
		
		//GLabel (nombre) Para poner un texto
		//new GLabel ("Texto")
		GLabel etiqueta = new GLabel("HOLA MUNDO!");
		etiqueta.setLocation(450, 360);
		etiqueta.setFont("25");
		add(etiqueta);
	}

}
