import java.awt.*;

/*
 * Esta clase lleva todo lo que tiene que ver con la barra que mueve
 * el jugador con el rat�n
 */


public class Player {
	public static int standartPlayerWidth = 80;
	public static int standartPlayerHeigh = 20;
	private Rectangle hitBox;

	public Player(int x, int y, int width, int height) {
		hitBox = new Rectangle(x, y, width, height);
	}
	//Mueve la barra del jugador
	public void moveOnXAxis(int speed) {
		hitBox.x += speed;
	}

	public void setY(int y) {
		hitBox.y = y;
	}

	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(hitBox.x, hitBox.y, hitBox.width, hitBox.height);
	}

}
