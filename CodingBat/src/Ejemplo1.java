import acm.program.*;
public class Ejemplo1 extends ConsoleProgram{
	
	//sleepIn recibe dos parametros booleanos
	//el primero es weekday y vale true si es un día laborable
	//el segundo es vacation y vale true si es un día festivo
	//Devuelve true si es un día no laborable o estamos de vacaciones
	
	public boolean sleepIn(boolean weekday, boolean vacation) {
		  if(!weekday || vacation) {
			  return true;
		  }
		  return false;
		}
	
	//monkeyTrouble recibe dos parámetros booleanos
	//el primero indica si sonrie el mono A
	//el segundo indica si sonrie el mono B
	
	//tienes que devolver true si los dos sonrien o ninguno sonrie
	
	public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
		  if(aSmile && bSmile) {
			  return true;
		  }
		  if(!aSmile && !bSmile) {
			  return true;
		  }
		  return false;
	}
	
	//Dados dos valores int devuelve su suma
	//Al menos que los dos valores sean iguales
	//que devuelven el doble de su suma
	
	public int sumDouble(int a, int b) {
		  if(a != b) {
			  return (a+b);
		  }
		  else {
			  return (a+b)*2;
		  }
	}
	
	//Tenemos un loro que habla
	//El parámetro hora
	

	
	public void run() {
		println(sleepIn(false, false));
	}
	
}
