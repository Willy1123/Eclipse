import acm.graphics.*;
import acm.program.*;

/*
* Piramide dibuja una pirámide centrada en la base de la pantalla
* tiene LADRILLOS_BASE rectángulos en la base
* cada ladrillo de la pirámide ocupa ANCHO_LADRILLO por ALTO_LADRILLO
*/
public class PiramideDeLadrillos extends GraphicsProgram{
	
	private static final int ANCHO_LADRILLO = 30;
	private static final int ALTO_LADRILLO = 12;
	private static final int LADRILLOS_BASE = 14;
	private static final int ANCHO_PANTALLA = 800;
	private static final int ALTO_PANTALLA = 600;
	
	public void run() {
		setSize(ANCHO_PANTALLA, ALTO_PANTALLA);
		int desplazamiento = (ANCHO_PANTALLA/2) - (LADRILLOS_BASE * ANCHO_LADRILLO/2);
		int x = 0;
		int y = 0;
		for(int j=0; j< LADRILLOS_BASE; j++) {
			desplazamiento = desplazamiento-ANCHO_LADRILLO/2;
			for(int i=j; i< LADRILLOS_BASE; i++) {
				GRect Ladrillo = new GRect(ANCHO_LADRILLO, ALTO_LADRILLO);
				//Ladrillo.setLocation(i*ANCHO_LADRILLO, j*ALTO_LADRILLO);
				
			//	x = desplazamiento+j*ANCHO_LADRILLO;
				//calcula la posición de la coordenada y. Le restamos 40 para ajustar el
				//pequeño trozo de pantalla que se pierde en el applet
			//	y = ALTO_PANTALLA-40 -i*ALTO_LADRILLO;
				
				add(Ladrillo);
				
				
			}
		}
		
	}
}
