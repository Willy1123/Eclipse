import acm.program.*;
import acm.graphics.*;
import acm.util.*;
/*
 * este programa sirve para hacer pruebas de declaraci�n
 * de distintas viariables
 * 
 * y para el primer contacto con el depurador de c�digo
 */

public class PruebasDeVariables extends GraphicsProgram{

	int numeroEntero = 42;
	int numero2 = 13;

	double numeroDecimal = 0.5;

	boolean mentiroso = false;

	char caracter = 'a';

	String palabra = "Hola amigos de Yutub";
	
	public void run() {

		numeroEntero = 12;
		ejemploAmbitoVariables();

	}

	private void ejemploAmbitoVariables() {
		int numero3 = numeroEntero;
		numero3 = numero2;
	}
}
