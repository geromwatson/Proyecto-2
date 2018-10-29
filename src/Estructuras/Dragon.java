
package Estructuras;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *Clase Dragon donde se definen los atributos de cada Dragon para su creacion y manipulacion
 * @author All
 */
@XmlRootElement(name = "dragon")
@XmlType(propOrder = {"nombre","velocidadRecarga", "edad", "resistencia","clase","padre", "pos"})
 

public class Dragon {
    /**Atributos que tienen todos los Dragones*/
    public String nombre;
    public int velocidadRecarga;
    public int edad;
    public int resistencia;
    public int clase;
    public String padre;
    public Position pos;
    /**Atributo Next para estructura de las listas*/ 
    public Dragon next;
    /**Atributos para crear el Arbol binario por familias*/
    public Dragon father;
    public Dragon leftson;
    public Dragon rightSon;
    /**Atributos para crear el Arbol AVL por edad*/
    int numMat;
    Dragon izqda, drcha;

    /**Constructor clase Dragon donde inicializa los atributos de Dr
     * @param nombre
     * @param velocidad
     * @param edad
     * @param resistencia
     * @param clase
     * @param padre
     * @param pos*/
    public Dragon(String nombre, int velocidad, int edad, int resistencia, int clase, String padre, Position pos){
        this.nombre = nombre;
        this.velocidadRecarga = velocidad;
        this.edad = edad;
        this.resistencia = resistencia;
        this.clase = clase;
        this.padre = padre;
        this.pos = pos;
        
    }
    /**Getters y Setter
     * @return s*/
    public Dragon getNext() {
        return next;
    }
    public void setNext(Dragon next) {
        this.next = next;
    }
    @XmlAttribute(name = "nombre")
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @XmlAttribute(name = "velocidadRecarga")
    public int getVelocidadRecarga() {
        return velocidadRecarga;
    }
    public void setVelocidadRecarga(int velocidadRecarga) {
        this.velocidadRecarga = velocidadRecarga;
    }
    @XmlAttribute(name = "edad")
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    @XmlAttribute(name = "resistencia")
    public int getResistencia() {
        return resistencia;
    }
    public void setResistencia(int Resistencia) {
        this.resistencia = Resistencia;
    }
    @XmlAttribute(name = "clase")
    public int getClase() {
        return clase;
    }
    public void setClase(int clase) {
        this.clase = clase;
    }
    @XmlAttribute(name = "padre")
    public String getPadre() {
        return padre;
    }
    public void setPadre(String padre) {
        this.padre = padre;
    }
    @XmlAttribute(name = "pos")
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

