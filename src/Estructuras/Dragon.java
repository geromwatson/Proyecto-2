
package Estructuras;


public class Dragon {
    
    public String nombre;
    public int velocidadRecarga;
    public int edad;
    public int resistencia;
    public int clase;
    public String padre;
    public Dragon next;
    public Dragon father;
    public Dragon leftson;
    public Dragon rightSon;
    
    public Position pos;

    public Dragon getNext() {
        return next;
    }

    public void setNext(Dragon next) {
        this.next = next;
    }
    
    
    public Dragon(String nombre, int velocidad, int edad, int resistencia, int clase, String padre, Position pos){
        this.nombre = nombre;
        this.velocidadRecarga = velocidad;
        this.edad = edad;
        this.resistencia = resistencia;
        this.clase = clase;
        this.padre = padre;
        this.pos = pos;
        
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVelocidadRecarga() {
        return velocidadRecarga;
    }

    public void setVelocidadRecarga(int velocidadRecarga) {
        this.velocidadRecarga = velocidadRecarga;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int Resistencia) {
        this.resistencia = Resistencia;
    }

    public int getClase() {
        return clase;
    }

    public void setClase(int clase) {
        this.clase = clase;
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }

    public Dragon getFather() {
        return father;
    }

    public void setFather(Dragon father) {
        this.father = father;
    }

    public Dragon getLeftson() {
        return leftson;
    }

    public void setLeftson(Dragon leftson) {
        this.leftson = leftson;
    }

    public Dragon getRightSon() {
        return rightSon;
    }

    public void setRightSon(Dragon rightSon) {
        this.rightSon = rightSon;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }
    public void setPos(int x, int y){
        this.pos = new Position(x,y);
    }


    
    
    
}
