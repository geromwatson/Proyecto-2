package Estructuras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Tablero<Niveles> extends JPanel implements Runnable,KeyListener{
    private Image background;
    private Image printdragon;
	private Image imghipogrifo;

    private Thread hilo;
    private int x,y;
    private final int DELAY=5;
    private int hx,hy;
    
    public Tablero(){
    	hipogrifo hipogrif =new hipogrifo();
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
        System.out.println(this.getClass().getResource("/img/background.jpg"));
        background = new ImageIcon("C:\\Users\\Aaron\\eclipse-workspace\\Proyecto2\\src\\img\\fondo.jpg").getImage();
        printdragon = new ImageIcon("C:\\Users\\Aaron\\eclipse-workspace\\Proyecto2\\src\\img\\dragon (2).gif").getImage();
    	imghipogrifo =new ImageIcon("C:\\Users\\Aaron\\eclipse-workspace\\Proyecto2\\src\\img\\hipogrifo.gif").getImage();

        
        x=0;
        y=110;
        hx=hipogrif.getX();
        hy=hipogrif.getY();
        
    }
    
    @Override
    public void addNotify(){
        super.addNotify();
        hilo = new Thread(this);
        hilo.start();
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(background, 0,0, null);
        g2.drawImage(printdragon,x,y, null);
        g2.drawImage(imghipogrifo,hy,hy, null);
        
        

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    
 

       
    
    
    @Override
    public void run() {
        while(true){
            repaint();
            try{
                Thread.sleep(DELAY);
            }catch(InterruptedException err){
                System.out.println(err);
            }
        }
    }
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());

		if (e.getKeyCode()==65) {
			hx=+3;
			System.out.println("apretandoce"+e.getKeyCode());
		}		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
    


}
