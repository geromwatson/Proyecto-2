package Estructuras;
import javax.swing.JFrame;



public class Main extends JFrame{
    public Main(){
        //TITULO
        setTitle("Game of Sorts");
        //permitir cerrar la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Tamaño de la ventana
        setSize(900,506);
        //se coloca la ventata ( CENTRO )
        setLocationRelativeTo(null);
        //metodo para no cambiar el tamaño de la ventana
        setResizable(false);
        
        //se agrega un obejeto tablero 
        //QUE HEREDA DE LA CLASE JPANEL DE SWING Y QUE ES DONDE SE DIBUJARA
        //NUESTRO JUEGO
        add(new Tablero());
        //add(new hipogrifo());
        
        //HACEMOS VISIBLE NUESTRA VENTANA
        setVisible(true);
    }
    
    //METODO PRINCIPAL - SERA BUSCADO AL EJECUTAR UN PROGRAMA EN JAVA
    public static void main(String args[]){
        new Main();
    }
}
