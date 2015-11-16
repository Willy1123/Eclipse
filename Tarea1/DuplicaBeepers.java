
public class DuplicaBeepers extends KarelMejorada{

	public void run(){

		//mueve Karel al monton
		move();
		move();
		//duplica el monton

		duplica();
		//trae el monton de vuelta 

		traeMontonDeVuelta();

		vuelveACasa();
	}

	private void vuelveACasa(){
		turnAround();
		while (frontIsClear()){
			move();
		}
		turnAround();
	}

	private void traeMontonDeVuelta(){
		move();
		while(beepersPresent()){
			pickBeeper();
			turnAround();
			move();
			putBeeper();
			turnAround();
			move();
		}
	}

	private void duplica(){
		while(beepersPresent()){
			pickBeeper();
			move();
			putBeeper();
			putBeeper();
			turnAround();
			move();
			turnAround();
		}

	}
}
