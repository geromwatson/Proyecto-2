
package Estructuras;


/**
 *
 * @author PC
 */
public class Position {
    
    public int x;
    public int y;
    
    
    public Position(){
        this.x = 0;
        this.y = 0;
               
    }
    public Position(int x, int y){
        this.x = x;
        this.y = y;
                
    }
    public Position(Position position){
        this.x = position.x;
        this.y = position.y;
        
    }

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
