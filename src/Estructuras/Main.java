package Estructuras;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;



public class Main extends JFrame implements KeyListener,MouseListener{
    Tablero table =new Tablero();
    int hx=table.getHx();
    int hy=table.getHy();
    int velocidad=15;
    
	

    public Main(){
        //TITULO
    	JFrame ventana= new JFrame();
    	setTitle("Game of Sorts");
        //permitir cerrar la ventana
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Tamaño de la ventana
    	setSize(1250,706);
        //se coloca la ventata ( CENTRO )
    	setLocationRelativeTo(null);
        //metodo para no cambiar el tamaño de la ventana
    	setResizable(false);
    	addKeyListener(this);
    	addMouseListener(this);
        
        //se agrega un obejeto tablero 
        //QUE HEREDA DE LA CLASE JPANEL DE SWING Y QUE ES DONDE SE DIBUJARA
        //NUESTRO JUEGO

        add(table);
        //add(new hipogrifo());
        
        //HACEMOS VISIBLE NUESTRA VENTANA
        setVisible(true);
    }
    
	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println(e.getKeyChar());		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());

		if (e.getKeyCode()==65) {
			table.setHx(hx-velocidad);
			hx=table.getHx();
			System.out.println("apretandoce"+e.getKeyCode());
			System.out.println(hx);
		}
		if (e.getKeyCode()==83) {
			table.setHy(hy+velocidad);
			hy=table.getHy();
			System.out.println("apretandoce"+e.getKeyCode());
		}
		if (e.getKeyCode()==87) {
			table.setHy(hy-velocidad);
			hy=table.getHy();
			System.out.println("apretandoce"+e.getKeyCode());
		}
		if (e.getKeyCode()==68) {
			table.setHx(hx+velocidad);
			hx=table.getHx();
			System.out.println("apretandoce"+e.getKeyCode());
			System.out.println(hx);
		}
		if (e.getKeyCode()==32) {
			table.tirarbola();
			System.out.println("tirandolavara");
			}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {


		// TODO Auto-generated method stub
}
    public static void main(String args[]){
        new Main();
    }

	@Override
	public void mouseClicked(MouseEvent arg0) {
		table.setRatonx(arg0.getX());
		table.setRatony(arg0.getY());
		System.out.println(arg0.getX()+""+arg0.getY());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}