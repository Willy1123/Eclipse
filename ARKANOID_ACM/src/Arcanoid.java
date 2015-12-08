
import acm.program.*;
import acm.util.RandomGenerator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;

import acm.graphics.*;

public class Arcanoid extends GraphicsProgram{

	//Imagenes varias
	GImage imagenFondo = new GImage("Fondo_Intro.jpg");
	GImage fondoJuego = new GImage("Fondo_Juego.jpg");
	GImage ladrillo = new GImage("ladrillo.png");
	GImage gameOver1 = new GImage("GameOver.png");
	GImage gameWin = new GImage("GameWin.png");

	// Pantalla.
	private static int ANCHO_PANTALLA = 1024;
	private static int ALTO_PANTALLA = 768;

	// Piramide
	private static final int ANCHO_LADRILLO = 60;
	private static final int ALTO_LADRILLO = 30;
	private static final int LADRILLOS_BASE = 9;

	// Cursor
	private static int ANCHO_CURSOR = 150;
	private static int ALTO_CURSOR = 100;
	// cursor
	GImage cursor = new GImage("cursor.png");

	// Random
	RandomGenerator aleatorio = new RandomGenerator();

	// pelota
	int ancho_pelota = 28;
	int alto_pelota = 28;
	GImage pelota = new GImage("pelota.png");
	double xVelocidad = 4 + aleatorio.nextInt(5); // velocidad de la pelota en el eje x
	double yVelocidad = -4 + aleatorio.nextInt(-5); // velocidad de la pelota en el eje y

	
	//marcador
	int puntos = 0;
	GLabel marcador = new GLabel(""+ puntos);
	
	//vidas
	int vida = 3;
	GLabel vidas = new GLabel(""+vida);
	
	//Fuente
	Font fuente;
	
	//uso una variable booleana para indicar que se ha terminado 
	//la partida
	boolean gameOver = false;

	public void init(){
		setSize(ANCHO_PANTALLA, ALTO_PANTALLA);

		add(imagenFondo, 0, 0);
		try{
			fuente = Font.createFont(Font.TRUETYPE_FONT, 
					getClass().getResourceAsStream("CASTELAR.ttf"));
		} catch (Exception e) {}
		GLabel mensaje = new GLabel (" Haz clic con el bot�n del rat�n");
		mensaje.setColor(Color.RED);
		mensaje.setFont(fuente.deriveFont(0, 20));
		mensaje.setLocation(ANCHO_PANTALLA/4 + 40, ALTO_PANTALLA/2 -60);
		add(mensaje);
		waitForClick();

		//cambio a la segunda imagen porque ya han hecho clic
		remove (imagenFondo);
		remove (mensaje);

		add(fondoJuego, 0, 0);
		
		pintaPiramide();
		
		//a�ado el marcador
		try{
			fuente = Font.createFont(Font.TRUETYPE_FONT, 
					getClass().getResourceAsStream("CASTELAR.ttf"));
		} catch (Exception e) {}
		marcador.setColor(Color.RED);
		marcador.setFont(fuente.deriveFont(0, 20));
		marcador.setLocation(ANCHO_PANTALLA - 200, 50);
		add(marcador);
		marcador.setLabel("PUNTOS: "+puntos);
		
		//a�ado las vidas
		try{
			fuente = Font.createFont(Font.TRUETYPE_FONT, 
					getClass().getResourceAsStream("CASTELAR.ttf"));
		} catch (Exception e) {}
		vidas.setColor(Color.RED);
		vidas.setFont(fuente.deriveFont(0, 20));
		vidas.setLocation(50, 50);
		add(vidas);
		vidas.setLabel("VIDAS: "+vida);
		
		//a�ado el cursor
		cursor.setLocation(ANCHO_PANTALLA/2, ALTO_PANTALLA - 150);
		add(cursor);
		addMouseListeners();

		//pelota.setLocation(aleatorio.nextInt(ANCHO_PANTALLA/2 + 200), aleatorio.nextInt(ALTO_PANTALLA - 200));
		add(pelota, ANCHO_PANTALLA/2, ALTO_PANTALLA - 220);

	}

	public void run() {
		

		while (!gameOver) {
			
			pelota.move(xVelocidad, yVelocidad);
			//cursor.setLocation(pelota.getX() - cursor.getWidth()/2, ALTO_PANTALLA - 150);
			// Comprobamos si la pelota choca con alguno de los elementos
			chequeaColision();
			
			
			// Ponemos una pausa para limitar la velocidad
			pause(20);
			
			if(pelota.getY() > ALTO_PANTALLA) {
				
				pelota.setLocation(ANCHO_PANTALLA/2, ALTO_PANTALLA - 300);
				
				vida = vida - 1;
				vidas.setLabel("VIDAS: "+vida);
				waitForClick();
			}
			
			
			if(puntos == 2250){
				gameOver=true;
				add(gameWin);
			}

			
			
			if(vida == 0) {
				gameOver = true;
				add(gameOver1);
			}

		}

//		add(gameOver1);
	}




	/*
	 * pintaPiramide introduce una piramide de ladrillos en la pantalla.
	 */
	private void pintaPiramide(){
		int x= -(ANCHO_PANTALLA - LADRILLOS_BASE*ANCHO_LADRILLO) /2;
		int y= 50;

		for (int j=0; j<LADRILLOS_BASE; j++){
			for (int i=j; i<LADRILLOS_BASE; i++){
				GImage ladrillo = new GImage("ladrillo.png");
//				GRect ladrillo = new GRect (ANCHO_LADRILLO,ALTO_LADRILLO);
//				ladrillo.setFilled(true);
//				ladrillo.setColor(aleatorio.nextColor());
				add (ladrillo,i*ANCHO_LADRILLO-x,y+j*ALTO_LADRILLO);
				//pause(60);
			}
			x = x+ANCHO_LADRILLO/2;
		}
	}


	private void chequeaColision(){
		if (chequeaPared()){
			//chequeo si toca con el cursor
			if(!chequeaCursor()){
				chequeaLadrillos();
			}
		}

	}

	private boolean chequeaPared(){
		boolean auxiliar = true;
		//si toca el techo
		if (pelota.getY() <= 0){
			yVelocidad = -yVelocidad;
			auxiliar = false;
		}

		//si toca la pared derecha
		if (pelota.getX() >= ANCHO_PANTALLA - alto_pelota){
			xVelocidad = -xVelocidad;
			auxiliar = false;
		}

		//si toca la pared izquierda
		if (pelota.getX() <= 0){
			xVelocidad = -xVelocidad;
			auxiliar = false;
		}
		return auxiliar;
	}


	//chequeaCursor devolver� true si ha chocado el cursor con la pelota
	// y false si no ha chocado.
	private boolean chequeaCursor(){
		if (xVelocidad < 15 && yVelocidad < 15){
			if (getElementAt(pelota.getX(), pelota.getY()+alto_pelota)==cursor){
				yVelocidad = -yVelocidad;	
			}
			else if (getElementAt(pelota.getX()+alto_pelota, pelota.getY()+alto_pelota)==cursor){
				yVelocidad = -yVelocidad;	
			}
			else if (getElementAt(pelota.getX(), pelota.getY())==cursor){
				xVelocidad = -xVelocidad;	
			}
			else if (getElementAt(pelota.getX()+alto_pelota, pelota.getY())==cursor){
				xVelocidad = -xVelocidad;	
			}

			else {
				return false;
			} 
		}
		return true;
	}




	/*
	 * chequeaLadrillos comprueba chequeaPosicion con las coordenadas de la
	 * pelota 
	 */
	private void chequeaLadrillos() {

		int pelotaX = (int) pelota.getX();
		int pelotaY = (int) pelota.getY();
		int alto = alto_pelota;
		int ancho = ancho_pelota;

		// si chequea posicion devuelve false sigue mirando el resto de puntos
		//de la pelota

		if( !chequeaPosicion(pelotaX, pelotaY,'y')){
			if( !chequeaPosicion(pelotaX+alto, pelotaY,'y')){
				if( !chequeaPosicion(pelotaX, pelotaY+alto,'x')){
					if( !chequeaPosicion(pelotaX+alto, pelotaY+alto,'y')){
						if( !chequeaPosicion(pelotaX+ancho/2, pelotaY,'y')){
							if( !chequeaPosicion(pelotaX+ancho, pelotaY+alto/2,'x')){
								if( !chequeaPosicion(pelotaX, pelotaY+alto/2,'x')){
									if( !chequeaPosicion(pelotaX+ancho/2, pelotaY+alto,'y')){
									}
								}
							}
						}
					}
				}
			}
		}
	}




	/**
	 * chequeaPosicion dadas unas cordenadas (posX y posY)de la pelota y una
	 * direccion, calcula el rebote teniendo en cuenta el objeto que se encuentra en esas
	 * coordenadas.
	 * 
	 */
	private boolean chequeaPosicion(int posX, int posY, char direccion) {

		GObject auxiliar;
		boolean choque = false;
		auxiliar = getElementAt(posX, posY);

		// Chequeamos los ladrillos
		if ((auxiliar != cursor) && (auxiliar != fondoJuego) && (auxiliar != pelota) && (auxiliar != null) && (auxiliar != marcador) && (auxiliar != vidas)) {
			remove(auxiliar);
			puntos = puntos + 50;
			marcador.setLabel("PUNTOS: "+puntos);
			
//			remove(marcador);
			if (direccion == 'y') {
				yVelocidad = -yVelocidad;
			} else {
				xVelocidad = -xVelocidad;
			}
			//puntuacion++;// aumentamos la puntuacion en uno
			choque = true;
		}


		// devolvemos el valor de choque
		return (choque);
	}

	//mueve el cursor siguiendo la posici�n del rat�n
	public void mouseMoved (MouseEvent evento){
		if( (evento.getX()+ANCHO_CURSOR) <= ANCHO_PANTALLA){
			cursor.setLocation(evento.getX(),cursor.getY());
		}
	}


}
