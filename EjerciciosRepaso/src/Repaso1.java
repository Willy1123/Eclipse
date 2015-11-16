/*
 * Repaso1: Pinta un rectángulo en la esquina superior izquierda
 */
//importamos la librería acm para los objetos gráficos
import acm.program.*;
import acm.graphics.*;
public class Repaso1 extends GraphicsProgram{
	
	//declaro una variable de instancia para guardar el rectángulo
	GRect rectangulo;
	
	//recuerda qeu el init se ejecuta siempre antes que el run
	public void init() {
		setSize(800, 600);
		//el primer parámetro del rectángulo es el ancho
		//y el segundo el alto
		rectangulo = new GRect(120, 80, 30,30);
	}
	
	public void run() {
		//añado el objeto GRect al lienzo para que se muestre
		//si no especifico la posición, aparece en (0,0)
		add(rectangulo);
	}
}
