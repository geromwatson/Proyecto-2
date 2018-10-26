
package Estructuras;

import java.util.concurrent.ThreadLocalRandom;


public class Niveles  {
    
    int min;
    int max;
    
    public Linked_List listadragones = new Linked_List();
    
    //*Crea un numero aleatoria que va de 1 a 100
    private int getNumeroRandom(){
        this.min = 0;
        this.max = 100;
        return ThreadLocalRandom.current().nextInt(min, max);
    }
    

    public static void main(String args[]){
    	Niveles nv1=new Niveles();
    	nv1.Nivel1();
    }
    
    //*Crea el nivel 1 donde hay 15 dragones
    public Linked_List Nivel1(){
        
        
        //getNumeroRandom();
    
        
        Position posdragon1 = new Position(100,100);
        Dragon dragon1 = new Dragon("Zu", 1,989,3,3,"none",posdragon1);
        listadragones.append(dragon1);
        
        Position posdragon2 = new Position(getNumeroRandom(),getNumeroRandom());
        Dragon dragon2 = new Dragon("Draco", 1,877,2,2,"Zu",posdragon2);
        listadragones.append(dragon2);
        
        Position posdragon3 = new Position(getNumeroRandom(),getNumeroRandom());
        Dragon dragon3 = new Dragon("Ragnar", 1,813,2,2,"Zu",posdragon3);
        listadragones.append(dragon3);
        
        Position posdragon4 = new Position(getNumeroRandom(),getNumeroRandom());
        Dragon dragon4 = new Dragon("Grifin", 1,801,2,2,"Draco",posdragon4);
        listadragones.append(dragon4);
        
        Position posdragon5 = new Position(getNumeroRandom(),getNumeroRandom());
        Dragon dragon5 = new Dragon("Hydra", 1,777,2,2,"Draco",posdragon5);
        listadragones.append(dragon5);
        
        Position posdragon6 = new Position(getNumeroRandom(),getNumeroRandom());
        Dragon dragon6 = new Dragon("Ra", 2,789,2,2,"Ragnar",posdragon6);
        listadragones.append(dragon6);
        
        Position posdragon7 = new Position(getNumeroRandom(),getNumeroRandom());
        Dragon dragon7 = new Dragon("Wawel", 2,712,2,2,"Ragnar",posdragon7);
        listadragones.append(dragon7);
        
        Position posdragon8 = new Position(getNumeroRandom(),getNumeroRandom());
        Dragon dragon8 = new Dragon("Jormunand", 2,602,2,2,"Grifin",posdragon8);
        listadragones.append(dragon8);
        
        Position posdragon9 = new Position(getNumeroRandom(),getNumeroRandom());
        Dragon dragon9 = new Dragon("Ryu", 3,698,2,2,"Grifin",posdragon9);
        listadragones.append(dragon9);
        
        Position posdragon10 = new Position(getNumeroRandom(),getNumeroRandom());
        Dragon dragon10 = new Dragon("Sirush", 3,654,1,1,"Hydra",posdragon10);
        listadragones.append(dragon10);
        
        Position posdragon11 = new Position(getNumeroRandom(),getNumeroRandom());
        Dragon dragon11 = new Dragon("Smaug", 3,598,1,1,"Hydra",posdragon11);
        listadragones.append(dragon11);
        
        Position posdragon12 = new Position(getNumeroRandom(),getNumeroRandom());
        Dragon dragon12 = new Dragon("Tarasque", 3,530,1,1,"Ra",posdragon12);
        listadragones.append(dragon12);
        
        Position posdragon13 = new Position(getNumeroRandom(),getNumeroRandom());
        Dragon dragon13 = new Dragon("Tiamat", 3,555,1,1,"Ra",posdragon13);
        listadragones.append(dragon13);
        
        Position posdragon14 = new Position(getNumeroRandom(),getNumeroRandom());
        Dragon dragon14 = new Dragon("Leviatan", 3,532,1,1,"Wawel",posdragon14);
        listadragones.append(dragon14);
        
        Position posdragon15 = new Position(getNumeroRandom(),getNumeroRandom());
        Dragon dragon15 = new Dragon("Quetza", 3,502,1,1,"Wawel",posdragon15);
        listadragones.append(dragon15);
        listadragones.printList();
        System.out.println("se deberian de estar printendo los dragones");
        listadragones.switchDragon(listadragones, 1, 2);
        //listadragones.SelectionSortporEdadmM(listadragones);
        listadragones.printList();

        
        return listadragones;
        
        
        
        
        
        
    }

}
