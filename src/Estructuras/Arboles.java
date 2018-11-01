
package Estructuras;


public class Arboles {
    
    private Dragon root;

    public Dragon getRoot() {
        return root;
    }

    public void setRoot(Dragon root) {
        this.root = root;
    }

    public void addFamiliar(Dragon dragon){
        Dragon current;
        current = root;
        if (current == null){
            this.setRoot(dragon);
        }else{    
            while (current != null){
                
                if (current.getNombre() == dragon.getPadre()){
                dragon.setFather(current);
                if (current.getLeftson() == null){
                    current.setLeftson(dragon);
                }else{
                    current.setRightSon(dragon);
                }
            }else{
                if (current.getLeftson() == null){
                    current = current.getLeftson();
            }else{
                current = current.getRightSon();
                }
            }
            }    
            if (current.getLeftson() == null){
                current = current.getLeftson();
            }else{
                current = current.getRightSon();
            }   
            }
 
        }
    
    
    
    
    
    }

