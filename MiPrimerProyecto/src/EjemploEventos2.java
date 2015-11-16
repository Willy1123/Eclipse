import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.program.*;
import acm.graphics.*;

/*
 * Autor: Guillermo Blasco
 * 
 * Este programa es un ejemplo de c�mo utilizar los
 * eventos de rat�n
 */

public class EjemploEventos2 extends GraphicsProgram{

	GOval circulo;
	
	public void init() {
		setSize(700,800);
		//digo que voy a utilizar el rat�n
		addMouseListeners();
		

	}
	
	//mouseMoved es llamado cada vez que se mueve el rat�n
	public void mouseMoved (MouseEvent evento) {
		//circulo.setLocation(evento.getX(), 700);
	}
	
	//mouseClicked es llamado cada vez que se hace click
	//en la pantalla
	public void mouseClicked (MouseEvent evento) {
		circulo = new GOval(60, 10);
		circulo.setFilled(true);
		circulo.setFillColor(Color.BLUE);
		add(circulo, evento.getX(), evento.getY());
	}
}
