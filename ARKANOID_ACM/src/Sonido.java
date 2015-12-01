//Reproducir un MP3 en Java 

import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Sonido extends acm.program.GraphicsProgram {


	public void run() {

		try {
			Player reproductor = new Player(new FileInputStream("rayo.mp3"));
			reproductor.play();
		} catch (Exception e) {
			println("NO FUNCIONA!");
		}
	}
}
