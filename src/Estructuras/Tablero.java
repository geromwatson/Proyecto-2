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

/**
 * 
 * @author Aaron
 *
 */
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
	private String sortenpantalla="";
	private int vidas=3;
	private int numsort=1;
	private String vidaenpantalla="";
	

    private Thread hilo;
    private int x,y;
    private final int DELAY=5;
    private int hx,hy;
    Niveles niveluno = new Niveles();
    Linked_List listad = niveluno.Nivel1();
    hipogrifo hipogrif =new hipogrifo();
    
	bola ataque =new bola();

    
    private int ratonx,ratony;
    
    /**
     * Getters y Setters
     * @return
     */
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
	/**
	 * Metodo principal donde se empieza el loop del juego
	 */
	public Tablero(){
    	
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
        //direcciones de carpeta donde estan las imagenes utilizadas en el juego
        System.out.println(this.getClass().getResource("/img/background.jpg"));
        background = new ImageIcon("C:\\Users\\Aaron\\eclipse-workspace\\Proyecto2Datos\\src\\img\\fondo.jpg").getImage();
        printdragon = new ImageIcon("C:\\Users\\Aaron\\eclipse-workspace\\Proyecto2Datos\\src\\img\\dragon (2).gif").getImage();
    	imghipogrifo =new ImageIcon("C:\\Users\\Aaron\\eclipse-workspace\\Proyecto2Datos\\src\\img\\hipogrifo.gif").getImage();
    	imgbola = new ImageIcon("C:\\Users\\Aaron\\eclipse-workspace\\Proyecto2Datos\\src\\img\\bola.gif").getImage();
    	//Strings que guardan la informacion que se va a mostrar en pantalla
    	nombrepantalla="";
    	recargenpantalla="";
    	edadenpantalla="";
    	resistenciaenpantalla="";
    	padreenpantalla="";
    	sortenpantalla="";
    	vidaenpantalla=vidas+"";
    	
    	
    	
    	ataque.setBolax(1000);
    	ataque.setBolay(1000);
    	
        x=0;
        y=110;
        hx=hipogrif.getX();
        hy=hipogrif.getY();
        
    }
    


	@Override
	/**
	 * Metodo que inicia los Threads necesarios para el juego
	 */
    public void addNotify(){
        super.addNotify();
        hilo = new Thread(this);
        hilo.start();
    }
    /**
     * Metodo donde un loop permite que los coponentes del juego esten actualizados
     */
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(background, 0,0, null);
        g2.drawImage(imghipogrifo,hipogrif.getX(),hipogrif.getY(), null);
        g2.drawImage(imgbola,ataque.getBolax(),ataque.getBolay(), null);
     



        //For que permite imprimir todos los dragones en pantalla
        for(int i=0;i<=listad.getLenght()-1;i++) {
        	
        	g2.drawImage(printdragon,listad.getNodeinIndex(i).getPos().getX(),listad.getNodeinIndex(i).getPos().getY(), null);	
        	//System.out.println("imprimiendo dragon"+i);

        }
        //Aqui se posiciona la informacion que se va a imprimir en pantalla
        g2.drawString(nombrepantalla, 1190, 270);
        g2.drawString(recargenpantalla, 1190, 310);
        g2.drawString(edadenpantalla, 1190, 350);
        g2.drawString(resistenciaenpantalla, 1200, 395);
        
        g2.drawString(padreenpantalla, 1190, 445);
        
        g2.drawString(sortenpantalla,1118,130);
        g2.drawString(vidaenpantalla,1118,660);
        

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    
 

       
    
    /**
     * Metodo run
     */
    @Override
    public void run() {
    	int cont=0;
    	//Loop principal del juego
        while(true){
        	if (listad.getLenght()==0) { 
        		listad=niveluno.Nivel2();
        	}
        	if (vidas==0) {
        	nombrepantalla="PERDISTE";
        	edadenpantalla="PERDISTE";
        	
        	}
            repaint();
            ciclobola();
            
            cont++;
            //If que define la velocidad del movimiento de los dragones
        	if (cont>1) {
        	//For que permite que los dragones esten en constante movimiento
        	for (int j=0;j<=listad.getLenght()-1;j++) {
        	listad.getNodeinIndex(j).setPos(listad.getNodeinIndex(j).getPos().getX()-1, listad.getNodeinIndex(j).getPos().getY());
        	//System.out.println("dragones avanzando");
        	cont=0;
        	}
        	//for que verifica que ningun dragon se pase de la meta
        	for (int h=0;h<=listad.getLenght()-1;h++) {
        		if (listad.getNodeinIndex(h).getPos().getX()<0) {
        			vidas=vidas-1;
        			vidaenpantalla=vidas+"";
        			listad.deleteNodeinIndex(h);
        		}
        	}
        	}
            //System.out.println(ratonx+","+ratony);
        	//For que 
        	if (numsort==2) {
        		sortenpantalla="Selection Sort";
        	}
        	else if (numsort==3) {
        		sortenpantalla="Arbol avl";
        	}	
        	else if (numsort==4) {
        		sortenpantalla="Insertion Sort";
        	}	
        	else if (numsort==5) {
        		sortenpantalla="Quick Sort";
        	}	
        	else if (numsort==6) {
        		sortenpantalla="Insertion Sort";
        	}	
        	else if (numsort==7) {
        		sortenpantalla="Selection Sort";
        	}	
        	else if (numsort==8) {
        		sortenpantalla="Quick Sort";
        	}	
        	else if (numsort==9) {	
        		sortenpantalla="Arbol binario ";
        		numsort=0;
        	}
        	
        	
            for (int i=0;i<=listad.getLenght()-1;i++) {
            	

            	//If que mermite mostrar la informacion en pantalla de cada dragon al darle click
            	if(ratonx>=listad.getNodeinIndex(i).getPos().getX() && ratony>=listad.getNodeinIndex(i).getPos().getY() &&ratonx<=listad.getNodeinIndex(i).getPosx2() && ratony<=listad.getNodeinIndex(i).getPosy2()) {
            	//System.out.println(listad.getNodeinIndex(i).getNombre());
            	nombrepantalla=listad.getNodeinIndex(i).getNombre();
            	recargenpantalla=listad.getNodeinIndex(i).getVelocidadRecarga()+"";
            	edadenpantalla=listad.getNodeinIndex(i).getEdad()+"";
            	resistenciaenpantalla=listad.getNodeinIndex(i).getResistencia()+"";
            	padreenpantalla=listad.getNodeinIndex(i).getPadre();
            	
            
            	}
            	//If que verifica que la bola tirada por el hipogrifo le pegue a los dragones
            	if(ataque.getBolax()+232>=listad.getNodeinIndex(i).getPos().getX() && ataque.getBolay()+90>=listad.getNodeinIndex(i).getPos().getY() &&ataque.getBolax()+232<=listad.getNodeinIndex(i).getPosx2() && ataque.getBolay()+90<=listad.getNodeinIndex(i).getPosy2()) {
                int compatac=listad.getLenght();
            	listad.dragondisparado(listad, listad.getNodeinIndex(i), i);
            	if (compatac!=listad.getLenght()) {
            		numsort++;
            	}
            	System.out.println("La lista ahora es: ");
            	listad.printList();
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

    /**
     * ciclo que permite a la bola avanzar constantemente
     */
    private void ciclobola() {
    		ataque.setBolax(ataque.getBolax()+8);
    	
	}
    /**
     * ciclo que le indica a la bola las coordenadas del hipogrifo para que empieze a avanzar
     */
	public void tirarbola() {
    	ataque.setBolax(hipogrif.getX());
    	ataque.setBolay(hipogrif.getY());

    		

}
}
