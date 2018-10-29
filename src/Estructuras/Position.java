
package Estructuras;


/**
 *Clase Position la cual da un par de coordenadas para graficar cada dragon en la interfaz grafica
 * @author PC
 */
public class Position {
    /**Atributos de una coordenada de dos dimensiones*/
    public int x;
    public int y;
    
    /**Contructor de Position que da la coordenada en el punto de origen*/
    public Position(){
        this.x = 0;
        this.y = 0;           
    }
    /**Contructor de Position que recibe dos enteros y los convierte en una coordenad
     * @param x
     * @param y*/
    public Position(int x, int y){
        this.x = x;
        this.y = y;        
    }
    /**Constructor de Position que recibe una coordenada y se la asigna al dragon instanciad
     * @param position*/
    public Position(Position position){
        this.x = position.x;
        this.y = position.y; 
    }
    /*Getters y Setters de los atributos de Position*/
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
    public void changeLocation(int x, int y){
        this.x = x;
        this.y = y;   
    }
    


    
 
    

    
    
    
    
        
    
    
    
    
    
}
