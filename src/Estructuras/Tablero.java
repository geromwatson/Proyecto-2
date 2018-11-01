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
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Tablero extends JPanel implements Runnable{
    private Image background;
    private Image printdragon;
	private Image imghipogrifo;
	private Image imgbola;
	private JTextArea textnombre;
	private String nombrepantalla="";
	private String recargenpantalla="";
	private String edadenpantalla="";
	private String resistenciaenpantalla="";
	private String padreenpantalla="";
	

    private Thread hilo;
    private int x,y;
    private final int DELAY=5;
    private int hx,hy;
    Niveles niveluno = new Niveles();
    Linked_List listad = niveluno.Nivel1();
    hipogrifo hipogrif =new hipogrifo();
    
	bola ataque =new bola();

    
    private int ratonx,ratony;
    
    
    
    
    public int getRatonx() {
		return ratonx;
	}

	public void setRatonx(int ratonx) {
		this.ratonx = ratonx;
	}

	public int getRatony() {
		return ratony;
	}

	public void setRatony(int ratony) {
		this.ratony = ratony;
	}

	public Tablero(){
    	
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
        System.out.println(this.getClass().getResource("/img/background.jpg"));
        background = new ImageIcon("C:\\Users\\Aaron\\eclipse-workspace\\Proyecto2Datos\\src\\img\\fondo.jpg").getImage();
        printdragon = new ImageIcon("C:\\Users\\Aaron\\eclipse-workspace\\Proyecto2Datos\\src\\img\\dragon (2).gif").getImage();
    	imghipogrifo =new ImageIcon("C:\\Users\\Aaron\\eclipse-workspace\\Proyecto2Datos\\src\\img\\hipogrifo.gif").getImage();
    	imgbola = new ImageIcon("C:\\Users\\Aaron\\eclipse-workspace\\Proyecto2Datos\\src\\img\\bola.gif").getImage();
    	nombrepantalla="";
    	recargenpantalla="";
    	edadenpantalla="";
    	resistenciaenpantalla="";
    	padreenpantalla="";
    	
    	
    	ataque.setBolax(1000);
    	ataque.setBolay(1000);
    	
        x=0;
        y=110;
        hx=hipogrif.getX();
        hy=hipogrif.getY();
        
    }
    
    public int getHx() {
		return hx;
	}

	public void setHx(int hx) {
		hipogrif.setX(hx);
		this.hx = hx;
		
	}

	public int getHy() {
		return hy;
	}

	public void setHy(int hy) {
		this.hy = hy;
		hipogrif.setY(hy);
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
        //g2.drawImage(printdragon,x,y, null);
        g2.drawImage(imghipogrifo,hipogrif.getX(),hipogrif.getY(), null);
        g2.drawImage(imgbola,ataque.getBolax(),ataque.getBolay(), null);
     



        
        for(int i=0;i<=listad.getLenght()-1;i++) {
        	
        	g2.drawImage(printdragon,listad.getNodeinIndex(i).getPos().getX(),listad.getNodeinIndex(i).getPos().getY(), null);	
        	//System.out.println("imprimiendo dragon"+i);

        }
        g2.drawString(nombrepantalla, 1190, 270);
        g2.drawString(recargenpantalla, 1190, 310);
        g2.drawString(edadenpantalla, 1190, 350);
        g2.drawString(resistenciaenpantalla, 1200, 395);
        
        g2.drawString(padreenpantalla, 1190, 445);

        

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    
 

       
    
    
    @Override
    public void run() {
    	int cont=0;
        while(true){
            repaint();
            ciclobola();
            
            cont++;
            System.out.println("el contador es"+cont);
        	if (cont>5) {
        	for (int j=0;j<=listad.getLenght()-1;j++) {
        	listad.getNodeinIndex(j).setPos(listad.getNodeinIndex(j).getPos().getX()-1, listad.getNodeinIndex(j).getPos().getY());
        	System.out.println("dragones avanzando");
        	cont=0;
        	}
        	}
            //System.out.println(ratonx+","+ratony);
            for (int i=0;i<=listad.getLenght()-1;i++) {
            	

            	
            	if(ratonx>=listad.getNodeinIndex(i).getPos().getX() && ratony>=listad.getNodeinIndex(i).getPos().getY() &&ratonx<=listad.getNodeinIndex(i).getPosx2() && ratony<=listad.getNodeinIndex(i).getPosy2()) {
            	System.out.println(listad.getNodeinIndex(i).getNombre());
            	nombrepantalla=listad.getNodeinIndex(i).getNombre();
            	recargenpantalla=listad.getNodeinIndex(i).getVelocidadRecarga()+"";
            	edadenpantalla=listad.getNodeinIndex(i).getEdad()+"";
            	resistenciaenpantalla=listad.getNodeinIndex(i).getResistencia()+"";
            	padreenpantalla=listad.getNodeinIndex(i).getPadre();
            	
            	
            	
            	
            	}
            	if(ataque.getBolax()+232>=listad.getNodeinIndex(i).getPos().getX() && ataque.getBolay()+90>=listad.getNodeinIndex(i).getPos().getY() &&ataque.getBolax()+232<=listad.getNodeinIndex(i).getPosx2() && ataque.getBolay()+90<=listad.getNodeinIndex(i).getPosy2()) {
            	System.out.println("se pego a "+listad.getNodeinIndex(i).getNombre());
            	listad.dragondisparado(listad, listad.getNodeinIndex(i),i);
            	ataque.setBolax(10000);
            	ataque.setBolay(10000);
            	
            	}
            	
            	
            }
            
            try{
                Thread.sleep(DELAY);
            }catch(InterruptedException err){
                System.out.println(err);
            }
        }
    }
    private void ciclobola() {
    		ataque.setBolax(ataque.getBolax()+8);
    	
	}

	public void tirarbola() {
    	ataque.setBolax(hipogrif.getX());
    	ataque.setBolay(hipogrif.getY());
        	System.out.println("avanzando");
    		//for (int i=0;i<=listad.getLenght()-1;i++) {
            	//if(ataque.getBolax()>=listad.getNodeinIndex(i).getPos().getX() && ataque.getBolay()>=listad.getNodeinIndex(i).getPos().getY() &&ataque.getBolax()<=listad.getNodeinIndex(i).getPosx2() && ataque.getBolay()<=listad.getNodeinIndex(i).getPosy2()) {
            	//System.out.println("se pego a uno");
            	//}
    	
    		//}
    		

}
}
