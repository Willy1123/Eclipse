/*
 * Autor: Guillermo Blasco
 * 
 * En este proyecto creamos el conocido juego del
 * ARKANOID.
 * Que consiste en una pelota que rebota rompiendo ladrillos
 * y tu manejas el cursor impidiendo que la pelota se "caiga"
 */
import acm.program.*;
import acm.util.RandomGenerator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;

import acm.graphics.*;

public class Arcanoid extends GraphicsProgram{

	//Imagenes varias
	GImage fondoIntro = new GImage("imagenes/Fondo_Intro.jpg");
	GImage fondoJuego = new GImage("imagenes/Fondo_Juego.jpg");
	GImage ladrillo_roto = new GImage("imagenes/ladrillo_roto.png");
	GImage ladrillo = new GImage("imagenes/ladrillo.png");
	GImage gameOver1 = new GImage("imagenes/GameOver.png");
	GImage gameWin = new GImage("imagenes/GameWin.png");

	// Pantalla
	private static int ANCHO_PANTALLA = 1024;
	private static int ALTO_PANTALLA = 768;

	// Piramide
	private static final int ANCHO_LADRILLO = 60;
	private static final int ALTO_LADRILLO = 30;
	private static final int LADRILLOS_BASE = 10;
	
	//ladrillos
		int ladrillos = 110;
		int cuentaLadrillos = 0;

	// Cursor
	private static int ANCHO_CURSOR = 150;
	private static int ALTO_CURSOR = 100;
	GImage cursor = new GImage("imagenes/cursor.png");

	// Random
	RandomGenerator aleatorio = new RandomGenerator();

	// pelota
	int ancho_pelota = 28;
	int alto_pelota = 29;
	GImage pelota = new GImage("imagenes/pelota.png");
	double xVelocidad = 5 + aleatorio.nextInt(5); // velocidad de la pelota en el eje x
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
		//1.Defino el tamaño de la pantalla.
		setSize(ANCHO_PANTALLA, ALTO_PANTALLA);
		
		//2. Añado la foto Inicial.
		add(fondoIntro, 0, 0);
		
		//3. Añado un mensaje con una fuente en concreto.
		try{
			fuente = Font.createFont(Font.TRUETYPE_FONT, 
					getClass().getResourceAsStream("CASTELAR.ttf"));
		} catch (Exception e) {}
		GLabel mensaje = new GLabel (" Haz clic con el botón del ratón");
		mensaje.setColor(Color.RED);
		mensaje.setFont(fuente.deriveFont(0, 20));
		mensaje.setLocation(ANCHO_PANTALLA/4 + 40, ALTO_PANTALLA/2 -60);
		add(mensaje);
		
		//4. Espera al Click.
		waitForClick();

		//5. Quito la Foto principal y el mensaje porque ya ha hecho click.
		remove (fondoIntro);
		remove (mensaje);
		
		//6. Añado el Fondo del Juego.
		add(fondoJuego, 0, 0);
		
		//7. Pinto una pirámide con ladrillos rotos, que se situa debajo
		//de la Pirámide Principal.
		pintaPiramideRota();
		
		//8. Pinto la Pirámide Principal.
		pintaPiramide();

		//9. Defino y añado el marcador con una fuente en concreto.
		try{
			fuente = Font.createFont(Font.TRUETYPE_FONT, 
					getClass().getResourceAsStream("CASTELAR.ttf"));
		} catch (Exception e) {}
		
		//Defino el color de mi marcador.
		marcador.setColor(Color.RED);
		//Defino el tamaño de la letra de mi marcador.
		marcador.setFont(fuente.deriveFont(0, 20));
		//Defino la posición de mi marcador.
		marcador.setLocation(ANCHO_PANTALLA - 200, 50);
		//Defino cómo se va a ver mi marcador
		marcador.setLabel("PUNTOS: "+puntos);
		//Añado el marcador
		add(marcador);
		

		//10. Defino y añado el marcador de Vidas con una fuente en concreto
		try{
			fuente = Font.createFont(Font.TRUETYPE_FONT, 
					getClass().getResourceAsStream("CASTELAR.ttf"));
		} catch (Exception e) {}
		//Defino el color del marcador de vidas.
		vidas.setColor(Color.RED);
		//Defino el tamaño de la letra del marcador de vidas.
		vidas.setFont(fuente.deriveFont(0, 20));
		//Defino la posición del marcador de vidas.
		vidas.setLocation(50, 50);
		//Defino cómo se va a ver el marcador de vidas.
		vidas.setLabel("VIDAS: "+vida);
		//Añado el marcador de vidas.
		add(vidas);
		

		//11. Añado el Cursor en una posición en concreto
		cursor.setLocation(ANCHO_PANTALLA/2, ALTO_PANTALLA - 150);
		add(cursor);
		
		//12. Añado la función que escucha al mouse.
		addMouseListeners();
		
		//13. Defino la posición donde va a aparecer la pelota
		pelota.setLocation(aleatorio.nextInt(ANCHO_PANTALLA - 100), ALTO_PANTALLA - 200);
		
		//14. Añado la pelota.
		add(pelota);

	}

	public void run() {
		
		//Mientras no sea GameOver quiero que continue el juego
		while (!gameOver) {
			
			//1. Defino la velocidad de la pelota
			pelota.move(xVelocidad, yVelocidad);
			//cursor.setLocation(pelota.getX() - cursor.getWidth()/2, ALTO_PANTALLA - 150);
			//2. Comprobamos si la pelota choca con alguno de los elementos
			chequeaColision();

			//3. Ponemos una pausa para limitar la velocidad
			pause(20);
			
			//4. Defino como se restan las vidas. Si la pelota se encuentra
			//en una posición mayor que el Alto de la Pantalla
			if(pelota.getY() > ALTO_PANTALLA) {
				//1. Cambio la posición de la pelota para que el juego siga
				pelota.setLocation(ANCHO_PANTALLA/2, ALTO_PANTALLA - 300);
				//2. Le resto una vida al marcador de vidas.
				vida = vida - 1;
				//3. El marcador de vidas se actualiza
				vidas.setLabel("VIDAS: "+vida);
			}
			
			//5. Defino cuándo ganas. Es decir
			//cuando rompes todos los ladrillos
			if(puntos == ladrillos*50){
				//Cuando ocurre esto, te sales del bucle anterior
				gameOver=true;
				//y añado la foto de Win ^_^
				add(gameWin);
			}
			
			//6. Defino cúando pierdes, que es cuando
			//el número de vidas del marcador es < a 0 :(
			if(vida < 0) {
				//Cuando esto ocurre, el bucle se para
				gameOver = true;
				//y añado la foto de GameOver X_X
				add(gameOver1);
			}
		}
	}

	/**
	 * pintaPiramideRota introduce una piramide de ladrillos rotos en la pantalla.
	 */
	private void pintaPiramideRota(){
		//1. Defino la X del inicio desde donde se va a pintar la pirámide rota.
		int x= -(ANCHO_PANTALLA - LADRILLOS_BASE*ANCHO_LADRILLO) /2;
		//2. Defino la Y para dejar un poco de espacio entre el techo y la piramide
		int y= 50;
		
		//3. Creo un bucle for para pintar las filas
		for (int j=0; j<LADRILLOS_BASE; j++){
			//4. Defino la X del primer ladrillo de cada fila
			x = x+ANCHO_LADRILLO/2;
			//5. Creo otro bucle for anidado, para ir pintando la pirámide
			//De tal manera que la siguiente fila tenga un ladrillo menos.
			for (int i=j; i<LADRILLOS_BASE; i++){
				//Defino el ladrillo roto
				GImage ladrillo_roto = new GImage("imagenes/ladrillo_roto.png");
				//Añado el ladrillo roto en cada vuelta al bucle
				add (ladrillo_roto,i*ANCHO_LADRILLO-x,y+j*ALTO_LADRILLO);
				//Le pongo un pause, para ver como se pinta la pirámide.
				pause(20);
			}
		}
	}

	/**
	 * pintaPiramide introduce una piramide de ladrillos en la pantalla.
	 */
	private void pintaPiramide(){
		//1. Defino la X del inicio desde donde se va a pintar la pirámide.
				int x= -(ANCHO_PANTALLA - LADRILLOS_BASE*ANCHO_LADRILLO) /2;
				//2. Defino la Y para dejar un poco de espacio entre el techo y la piramide
				int y= 50;
				
				//3. Creo un bucle for para pintar las filas
				for (int j=0; j<LADRILLOS_BASE; j++){
					//4. Defino la X del primer ladrillo de cada fila
					x = x+ANCHO_LADRILLO/2;
					//5. Creo otro bucle for anidado, para ir pintando la pirámide
					//De tal manera que la siguiente fila tenga un ladrillo menos.
					for (int i=j; i<LADRILLOS_BASE; i++){
						//Defino el ladrillo roto
						GImage ladrillo_roto = new GImage("imagenes/ladrillo_roto.png");
						//Añado el ladrillo roto en cada vuelta al bucle
						add (ladrillo_roto,i*ANCHO_LADRILLO-x,y+j*ALTO_LADRILLO);
						//Le pongo un pause, para ver como se pinta la pirámide.
						pause(20);
			}
		}
	}
	
	/**
	 * chequeaColision es el metodo que se encarga de chequear la colisión
	 * de la pelota con cualquier objeto o pared devolviendo una respuesta.
	 */
	private void chequeaColision(){
		//1. Chequea si toca con la pared
		if (chequeaPared()){
			//2. Chequeo si toca con el cursor
			if(!chequeaCursor()){
				//3. Chequea si toca con los ladrillos
				chequeaLadrillos();
			}
		}
	}
	
	/**
	 * chequeaPared es el metodo qeu se encarga de chequear si la
	 * pelota choca con cualquier pared y hacer que esta rebote.
	 */
	private boolean chequeaPared(){
		//Defino un booleano que me indique cuando se cumple el choque
		boolean auxiliar = true;
		//1. Si toca el techo
		if (pelota.getY() <= 0){
			//la pelota rebota combirtiendo su velocidad en el eje Y
			//a la opuesta, es decir cambiando de signo
			yVelocidad = -yVelocidad;
			auxiliar = false;
		}

		//2. Si toca la pared derecha
		if (pelota.getX() >= ANCHO_PANTALLA - alto_pelota){
			//la pelota rebota combirtiendo su velocidad en el eje X
			//a la opuesta, es decir cambiando de signo.
			xVelocidad = -xVelocidad;
			auxiliar = false;
		}

		//si toca la pared izquierda
		if (pelota.getX() <= 0){
			//la pelota rebota combirtiendo su velocidad en el eje X
			//a la opuesta, es decir cambiando de signo.
			xVelocidad = -xVelocidad;
			auxiliar = false;
		}
		return auxiliar;
	}


	/**
	 * chequeaCursor devolverá true si ha chocado el cursor con la pelota
	 * y false si no ha chocado.
	 */
	private boolean chequeaCursor(){
		if (xVelocidad < 15 && yVelocidad < 15){
			//Chequea la esquina inferior izquierda del cursor
			if (getElementAt(pelota.getX(), pelota.getY()+alto_pelota)==cursor){
				yVelocidad = -yVelocidad;	
			}
			//Chequea la esquina inferior derecha del cursor
			else if (getElementAt(pelota.getX()+ancho_pelota, pelota.getY()+alto_pelota)==cursor){
				yVelocidad = -yVelocidad;	
			}
			//Chequea la esquina superior izquierda del cursor.
			else if (getElementAt(pelota.getX(), pelota.getY())==cursor){
				xVelocidad = -xVelocidad;	
			}
			//Chequea la esquina superior derecha del cursor.
			else if (getElementAt(pelota.getX()+ancho_pelota, pelota.getY())==cursor){
				xVelocidad = -xVelocidad;	
			}

			else {
				return false;
			} 
		}
		return true;
	}

	/**
	 * chequeaLadrillos comprueba chequeaPosicion con las coordenadas de la
	 * pelota
	 * 
	 * P.D
	 * He intentado hacer lo que he podido, pero no he conseguido hacer
	 * que el rebote con los ladrillos sea realista :(
	 */
	private void chequeaLadrillos() {

		int pelotaX = (int) pelota.getX();
		int pelotaY = (int) pelota.getY();
		int alto = alto_pelota;
		int ancho = ancho_pelota;

		// si chequea posicion devuelve false sigue mirando el resto de puntos
		//de la pelota
		
		//chequea los puntos medios de los 4 lados de la pelota
		if( !chequeaPosicion(pelotaX+ancho/2, pelotaY,'y')){
			if( !chequeaPosicion(pelotaX+ancho, pelotaY+alto/2,'x')){
				if( !chequeaPosicion(pelotaX, pelotaY+alto/2,'x')){
					if( !chequeaPosicion(pelotaX+ancho/2, pelotaY+alto,'y')){
						//chequea las 4 esquinas de la pelota
						if( !chequeaPosicion(pelotaX, pelotaY,'y')){
							if( !chequeaPosicion(pelotaX+alto, pelotaY,'y')){
								if( !chequeaPosicion(pelotaX, pelotaY+alto,'x')){
									if( !chequeaPosicion(pelotaX+alto, pelotaY+alto,'y')){

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

		// Chequeamos los ladrillos y si no es ningun elemento azul de la siguiente fila:
		if ((auxiliar != cursor) && (auxiliar != fondoJuego) && (auxiliar != pelota) && (auxiliar != null) && (auxiliar != marcador) && (auxiliar != vidas)) {
			//1. Elimino el ladrillo
			remove(auxiliar);
			//2. Cada vez que rompa un ladrillo se suman 50 puntos al marcador de puntos.
			if(auxiliar.getY() < ALTO_PANTALLA -300){
				puntos = puntos + 50;
			}
			//3. Se actualiza el marcador de puntos.
			marcador.setLabel("PUNTOS: "+puntos);
			
			//4. Defino el rebote al tocar los ladrillos
			if (direccion == 'y') {
				yVelocidad = -yVelocidad;
			} else {
				xVelocidad = -xVelocidad;
			}
			choque = true;
		}

		// devolvemos el valor de choque
		return (choque);
	}

	//mueve el cursor siguiendo la posición del ratón
	public void mouseMoved (MouseEvent evento){
		if( (evento.getX()+ANCHO_CURSOR) <= ANCHO_PANTALLA){
			cursor.setLocation(evento.getX(),cursor.getY());
		}
	}
}
