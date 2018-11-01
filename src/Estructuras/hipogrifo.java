package Estructuras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class hipogrifo extends JPanel implements Runnable{
	private Image imghipogrifo =new ImageIcon("C:\\Users\\Aaron\\eclipse-workspace\\Proyecto2\\src\\img\\hipogrifo.gif").getImage();
    private Thread hilo;
    int x=200;
    int y=200;
    
    
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
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
        g2.drawImage(imghipogrifo,x,y, null);

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    
    public void ciclo(){

       
    }
    
    @Override
    public void run() {
        while(true){
            ciclo();
            repaint();
            try{
                Thread.sleep(5);
            }catch(InterruptedException err){
                System.out.println(err);
            }
        }
    }
}

