import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/*
 * Esta lleva todo lo que tiene que ver con el juego
 */

public class Game extends JPanel{
	//Defino el tama�o de la ventana donde va a estar el juego
	private Dimension gameField = new Dimension(400, 300); 
	private Player player;

	public Game(Frame container) {
		//Define que la barra del jugador se va a mover con el rat�n
		
		addMouseListener(new MouseAdapter() {
			public void mouseMoved( MouseEvent e) {
				container.setLocation(e.getX(), getY());
				
			}
		});




		//		container.addKeyListener(new KeyAdapter() {
		//			public void keyPressed(KeyEvent e) {
		//				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
		//					player.moveOnXAxis(10);
		//				}
		//				
		//				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
		//					player.moveOnXAxis(-10);
		//				}
		//				
		//				repaint();
		//			}
		//		});
		player = new Player((int) ((gameField.getWidth() - Player.standartPlayerWidth)/2),
				gameField.height-Player.standartPlayerHeigh, Player.standartPlayerWidth, Player.standartPlayerHeigh);
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPLayer() {
		return this.player;
	}

	public void setSize(Dimension size) {
		super.setSize(size);
		//Define el tama�o de la ventana del Juego
		gameField = new Dimension(size.width-200, size.height-100);
		//Coloca la barra de jugador abajo, donde tiene que est�
		player.setY(gameField.height-Player.standartPlayerHeigh);
	}

	public void paint(Graphics g) {
		//Pinta la ventana del juego
		super.paint(g);

		//Te centra siempre el juego, independientemente del tama�o de la pantalla
		g.translate((getWidth() - gameField.width)/2, (getHeight() - gameField.height)/2);

		//A�ade propiedades a la ventana del juego, como el color de la ventana,
		//el borde y el tama�o de la ventana
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, gameField.width, gameField.height);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, gameField.width, gameField.height);

		//A�ade la barra del jugador
		player.render(g);
	}

}
