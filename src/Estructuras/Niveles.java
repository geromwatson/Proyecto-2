
package Estructuras;

/*Importo biblioteca para importar un numero random dentro de un parametro especifico*/
import java.util.concurrent.ThreadLocalRandom;


/*Clase Niveles donde se generan las oleadas de los Dragones*/
public class Niveles  {
    /**Numeros que sirven como parametros para definir el numero random generado */
    int min;
    int max;
    //Instanciacion de la clase Linked_List 
    Linked_List listadragones = new Linked_List(); 
    
    /*Crea un numero aleatoria que va de 1 a 100*/
    private int getNumeroRandomX(){
        this.min = 700;
        this.max = 1000;
        return ThreadLocalRandom.current().nextInt(min, max);
    }
    private int getNumeroRandomY(){
        this.min = 0;
        this.max = 680;
        return ThreadLocalRandom.current().nextInt(min, max);
    }
    
    /**Pruebas para revisar listas y metodos
      *Acordar borrar*/
    //public static void main(String[] args) {
       // Linked_List prueba = new Linked_List();
       // Niveles nivel = new Niveles();
        //prueba = nivel.Nivel6();
       // prueba.printList();  
   // }

    /**Crea el nivel 1 donde hay 15 dragones con sus respectivos atributos y posiciones aleatoria
     * @return */
    public Linked_List Nivel1(){
             
        Position posdragon1 = new Position(700,getNumeroRandomY());
        Dragon dragon1 = new Dragon("Zu", 1,989,3,3,"none",posdragon1);
        listadragones.append(dragon1);
        
        Position posdragon2 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon2 = new Dragon("Draco", 1,877,2,2,"Zu",posdragon2);
        listadragones.append(dragon2);
        
        Position posdragon3 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon3 = new Dragon("Ragnar", 1,813,2,2,"Zu",posdragon3);
        listadragones.append(dragon3);
        
        Position posdragon4 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon4 = new Dragon("Grifin", 1,801,2,2,"Draco",posdragon4);
        listadragones.append(dragon4);
        
        Position posdragon5 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon5 = new Dragon("Hydra", 1,777,2,2,"Draco",posdragon5);
        listadragones.append(dragon5);
        
        Position posdragon6 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon6 = new Dragon("Ra", 2,789,2,2,"Ragnar",posdragon6);
        listadragones.append(dragon6);
        
        Position posdragon7 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon7 = new Dragon("Wawel", 2,712,2,2,"Ragnar",posdragon7);
        listadragones.append(dragon7);
        
        Position posdragon8 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon8 = new Dragon("Jormunand", 2,602,2,2,"Grifin",posdragon8);
        listadragones.append(dragon8);
        
        Position posdragon9 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon9 = new Dragon("Ryu", 3,698,2,2,"Grifin",posdragon9);
        listadragones.append(dragon9);
        
        Position posdragon10 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon10 = new Dragon("Sirush", 3,654,1,1,"Hydra",posdragon10);
        listadragones.append(dragon10);
        
        Position posdragon11 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon11 = new Dragon("Smaug", 3,598,1,1,"Hydra",posdragon11);
        listadragones.append(dragon11);
        
        Position posdragon12 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon12 = new Dragon("Tarasque", 3,530,1,1,"Ra",posdragon12);
        listadragones.append(dragon12);
        
        Position posdragon13 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon13 = new Dragon("Tiamat", 3,555,1,1,"Ra",posdragon13);
        listadragones.append(dragon13);
        
        Position posdragon14 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon14 = new Dragon("Leviatan", 3,532,1,1,"Wawel",posdragon14);
        listadragones.append(dragon14);
        
        Position posdragon15 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon15 = new Dragon("Quetza", 3,502,1,1,"Wawel",posdragon15);
        listadragones.append(dragon15);
        
        
        //listadragones.printList();
        //System.out.println("SORT APLICADO");
        //listadragones.SSmM(listadragones);
        //listadragones.printList();
        //System.out.print("Se deberia de estar imprimendo");
        //listadragones.printList();
        //listadragones.SelectionSortporEdadmM(listadragones);
        //listadragones.printList();
        if (listadragones.getLenght()==0){
            Niveles nextNivel = new Niveles();
            listadragones = nextNivel.Nivel2();   
        }

        return listadragones; 
    }
    
    /**Crea el nivel 2 donde hay 18 dragones con sus respectivos atributos y posiciones aleatoria
     * @return */
    public Linked_List Nivel2(){
        
        Niveles nivel = new Niveles();
        listadragones =nivel.Nivel1();
        
        Position posdragon16 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon16 = new Dragon("Raw", 3,489,1,1,"Jormunand",posdragon16);
        listadragones.append(dragon16);
        
        Position posdragon17 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon17 = new Dragon("Exter", 3,453,1,1,"Jormunand",posdragon17);
        listadragones.append(dragon17);
        
        Position posdragon18 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon18 = new Dragon("Merr", 3,432,1,1,"Ryu",posdragon18);
        listadragones.append(dragon18);
        
        //listadragones.printList();
        //listadragones.SelectionSortporEdadmM(listadragones);
        //listadragones.printList();
        if (listadragones.getLenght()==0){
            Niveles nextNivel = new Niveles();
            listadragones = nextNivel.Nivel3();   
        }

        return listadragones; 
    }
    
    /**Crea el nivel 3 donde hay 22 dragones con sus respectivos atributos y posiciones aleatoria
     * @return */
    public Linked_List Nivel3(){
        
        Niveles nivel = new Niveles();
        listadragones =nivel.Nivel2();
        
        Position posdragon19 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon19 = new Dragon("Cas", 3,412,1,1,"Ryu",posdragon19);
        listadragones.append(dragon19);
        
        Position posdragon20 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon20 = new Dragon("Tosk", 3,402,1,1,"Sirush",posdragon20);
        listadragones.append(dragon20);
        
        Position posdragon21 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon21 = new Dragon("Meleck", 3,387,1,1,"Sirush",posdragon21);
        listadragones.append(dragon21);
        
        Position posdragon22 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon22 = new Dragon("Torus", 3,367,1,1,"Smaug",posdragon22);
        listadragones.append(dragon22);
        
        
        //listadragones.printList();
        //listadragones.SelectionSortporEdadmM(listadragones);
        //listadragones.printList();
        if (listadragones.getLenght()==0){
            Niveles nextNivel = new Niveles();
            listadragones = nextNivel.Nivel4();   
        }

        return listadragones; 
    }
    
    /**Crea el nivel 4 donde hay 27 dragones con sus respectivos atributos y posiciones aleatoria
     * @return */
    public Linked_List Nivel4(){
        
        Niveles nivel = new Niveles();
        listadragones =nivel.Nivel3();
        
        Position posdragon23 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon23 = new Dragon("Amaru", 3,321,1,1,"Smaug",posdragon23);
        listadragones.append(dragon23);
        
        Position posdragon24 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon24 = new Dragon("Messi", 3,320,1,1,"Tarasque",posdragon24);
        listadragones.append(dragon24);
        
        Position posdragon25 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon25 = new Dragon("Cristiano", 3,312,1,1,"Tarasque",posdragon25);
        listadragones.append(dragon25);
        
        Position posdragon26 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon26 = new Dragon("Totem", 3,309,1,1,"Tiamat",posdragon26);
        listadragones.append(dragon26);
        
        Position posdragon27 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon27 = new Dragon("Chandl", 3,300,1,1,"Tiamat",posdragon27);
        listadragones.append(dragon27);
        
        //listadragones.printList();
        //listadragones.SelectionSortporEdadmM(listadragones);
        //listadragones.printList();
        if (listadragones.getLenght()==0){
            Niveles nextNivel = new Niveles();
            listadragones = nextNivel.Nivel5();   
        }

        return listadragones; 
    }
    /**Crea el nivel 5 donde hay 34 dragones con sus respectivos atributos y posiciones aleatoria
     * @return */
    public Linked_List Nivel5(){
        
        Niveles nivel = new Niveles();
        listadragones =nivel.Nivel4();
                     
        Position posdragon28 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon28 = new Dragon("Crack", 3,297,1,1,"Leviatan",posdragon28);
        listadragones.append(dragon28);
        
        Position posdragon29 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon29 = new Dragon("Hal", 3,299,1,1,"Leviatan",posdragon29);
        listadragones.append(dragon29);
        
        Position posdragon30 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon30 = new Dragon("Opor", 3,256,1,1,"Quetza",posdragon30);
        listadragones.append(dragon30);
        
        Position posdragon31 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon31 = new Dragon("Perl", 3,234,1,1,"Quetza",posdragon31);
        listadragones.append(dragon31);
        
        Position posdragon32 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon32 = new Dragon("Dex", 3,222,1,1,"Raw",posdragon32);
        listadragones.append(dragon32);
        
        Position posdragon33 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon33 = new Dragon("Ragnar", 3,200,1,1,"Raw",posdragon33);
        listadragones.append(dragon33);
        
        Position posdragon34 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon34 = new Dragon("Faz", 3,212,1,1,"Exter",posdragon34);
        listadragones.append(dragon34);
        
        //listadragones.printList();
        //listadragones.SelectionSortporEdadmM(listadragones);
        //listadragones.printList();
        if (listadragones.getLenght()==0){
            Niveles nextNivel = new Niveles();
            listadragones = nextNivel.Nivel6();   
        }

        return listadragones; 
    }
    /**Crea el nivel 6 donde hay 40 dragones con sus respectivos atributos y posiciones aleatoria
     * @return */
    public Linked_List Nivel6(){
        
        Niveles nivel = new Niveles();
        listadragones =nivel.Nivel5();
 
        Position posdragon35 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon35 = new Dragon("Gecto", 3,212,1,1,"Exter",posdragon35);
        listadragones.append(dragon35);
        
        Position posdragon36 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon36 = new Dragon("Lope", 3,212,1,1,"Merr",posdragon36);
        listadragones.append(dragon36);
        
        Position posdragon37 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon37 = new Dragon("Qilt", 3,212,1,1,"Merr",posdragon37);
        listadragones.append(dragon37);
        
        Position posdragon38 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon38 = new Dragon("Astro", 3,212,1,1,"Cas",posdragon38);
        listadragones.append(dragon38);
        
        Position posdragon39 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon39 = new Dragon("Cole", 3,212,1,1,"Cas",posdragon39);
        listadragones.append(dragon39);
        
        Position posdragon40 = new Position(getNumeroRandomX(),getNumeroRandomY());
        Dragon dragon40 = new Dragon("Bren", 3,212,1,1,"Tosk",posdragon40);
        listadragones.append(dragon40);
        
        
        



        return listadragones; 
    }
    
    
    

 

}
