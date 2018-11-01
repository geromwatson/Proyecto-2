package Estructuras;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class EventoTeclas implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		System.out.println("opimiendoc");
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
