/*
 * Autor Guillermo Blasco
 * Versión reducida del Flappy Bird
 * 
 */
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import acm.program.*;
import acm.util.RandomGenerator;
import acm.graphics.*;

public class FlappyAcm extends GraphicsProgram{
	
	private static final int ANCHO_PANTALLA = 800;
	private static final int ALTO_PANTALLA = 400;
	
	private static final int ALTO_PAJARO = 12;
	
	private static final int ALTO_COLUMNA = 300;
	//private static final int ANCHO_COLUMNA = 24;
	
	private static final int SEPARACION_COLUMNAS = 200;
	private static final int HUECO = 100;
	
	//velocidad en el eje X y en el eje Y
	double xVelocidad = -1;
	double yVelocidad = 1;
	
	GImage pajaro;
	GImage fondo = new GImage("Background.png");
	
	GImage columna1 = new GImage("pipe_top.png");
	GImage columna2 = new GImage("pipe_top.png");
	GImage columna3 = new GImage("pipe_top.png");
	GImage columna4 = new GImage("pipe_top.png");
	
	GImage base1 = new GImage("pipe_bottom.png");
	GImage base2 = new GImage("pipe_bottom.png");
	GImage base3 = new GImage("pipe_bottom.png");
	GImage base4 = new GImage("pipe_bottom.png");
	
	//uso una variable booleana para indicar que se ha terminado
	//la partida
	boolean GameOver = false;
	
	public void init() {
		//cambio el tamaño de la ventana
		setSize(ANCHO_PANTALLA, ALTO_PANTALLA);
		add(fondo);
		fondo.scale(ANCHO_PANTALLA, ALTO_PANTALLA);
		//como voy a utilizar el ratón para mover el pájaro, añado
		//los mouse listeners
		addMouseListeners();
		//añado también los listeners del teclado
		addKeyListeners();
		
		//creo el pájaro y lo añado
		pajaro = new GImage("fly1.png");
		pajaro.scale(0.5, 0.5);
		add(pajaro, 200, ALTO_PANTALLA/2);
		
		//añado las columnas y las bases
		cambiaColumna(columna1, 0);
		cambiaColumna(columna2, SEPARACION_COLUMNAS);
		cambiaColumna(columna3, SEPARACION_COLUMNAS*2);
		cambiaColumna(columna4, SEPARACION_COLUMNAS*3);
		
		cambiaBase(base1, columna1, 0);
		cambiaBase(base2, columna2, SEPARACION_COLUMNAS);
		cambiaBase(base3, columna3, SEPARACION_COLUMNAS*2);
		cambiaBase(base4, columna4, SEPARACION_COLUMNAS*3);
		
		
	}
	
	private void cambiaColumna(GImage columna, int separacion) {
		//añadimos la imagen en su posición correspondiente.
		columna.scale(0.35, 0.35);
		add(columna, ANCHO_PANTALLA + separacion, longitudColumna());
	}
	
	private void cambiaBase(GImage imagen,GImage imagen2, int separacion ){
		//añadimos la imagen en su posición correspondiente
		imagen.scale(0.35, 0.35);
		add(imagen, ANCHO_PANTALLA + separacion, imagen2.getY() + imagen2.getHeight() + HUECO);
	}
	
	public void run() {
		while (!GameOver) {
			mueveColumna(columna1);
			mueveColumna(columna2);
			mueveColumna(columna3);
			mueveColumna(columna4);
			mueveBase(base1, columna1);
			mueveBase(base2, columna2);
			mueveBase(base3, columna3);
			mueveBase(base4, columna4);
			muevePajaro();
			chequeaColision();
			
			pause(7);
		}
	}
	
	private void mueveColumna(GImage imagen){
		//mueve la columna a la izquierda
		imagen.move(xVelocidad, 0);
		//si la columna llega a la pared izquierda, le cambio 
		//la posición a la pared derecha
		if ((imagen.getX() + imagen.getWidth())  < 0){
			imagen.setLocation(ANCHO_PANTALLA, longitudColumna());
		}
	}
	
	private void chequeaColision() {
		//este método va a buscar si en la esquina
		//superior derecha del pájaro hay una columna ko
		//una base
		
		GObject choque = fondo;
		double posXpajaro = pajaro.getX() + pajaro.getWidth() + 1;
		double posYpajaro = pajaro.getY();
		
		//chequeo la posición superior derecha
		choque = getElementAt(posXpajaro, posYpajaro);
		if(choque != fondo) {
			GameOver = true;
		}
		
		choque = getElementAt(posXpajaro, posYpajaro + pajaro.getHeight() + 1);
		if(choque != fondo) {
			GameOver = true;
		}
		
	}
	
	private void mueveBase(GImage imagen, GImage imagen2){
		//mueve la base a la izquierda
		imagen.move(xVelocidad, 0);
		//si la base llega a la pared izquierda, le cambio 
		//la posición a la pared derecha
		if ((imagen.getX() + imagen.getWidth())  < 0){
			imagen.setLocation(ANCHO_PANTALLA, imagen2.getY()+imagen2.getHeight()+HUECO);
		}
	}	
	
	private void muevePajaro() {
		pajaro.move(0, yVelocidad);
		yVelocidad++;
		if(yVelocidad > 1) {
			yVelocidad = 1;
		}
	}
	
	public void keyPressed(KeyEvent evento) {
		if (evento.getKeyCode() == KeyEvent.VK_SPACE) {
		yVelocidad = -8;
		}
	}
	
	//El método longitudcolumna va a generar una posición distinta
	//de la columna cda vez que es llamado
	
	private int longitudColumna() {
		RandomGenerator r = new RandomGenerator();
		//lo que hago es generar un número negativo que está entre
		//el alto de la columna dividido entre 2
		//y -20
		return -(r.nextInt(ALTO_COLUMNA / 2) + 20);
	}
	
//	private int longitudBase() {
//		RandomGenerator r = new RandomGenerator();
//		//lo que hago es generar un número negativo que está entre
//		//el alto de la columna dividido entre 2
//		//y -20
//		return (r.nextInt(ALTO_COLUMNA / 2) + HUECO);
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
