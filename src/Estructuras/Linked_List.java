
package Estructuras;

import static java.lang.Math.pow;

import java.util.concurrent.ThreadLocalRandom;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *Clase Linked_List donde los dragones se almacenan en una lista
 * @author PC
 */
@XmlRootElement(name= "listadragones") 
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(propOrder={"lenght","listadragones"})
public class Linked_List{
    
        /**Atributos de las clase Linked_List*/
	private Dragon root;
	private int lenght = 0;
        //@XmlAttribute(name = "Dragon")
        private Linked_List listadragones;
        
        /**Metodo append que mete a un dragon dentro de la lista de dragones*/
	public void append(Dragon dragon) {
		if(root == null) {  //si la lista sta vacia, el dragon entra como el root de la lista/
			root = dragon;
			root.setNext(null);
			++this.lenght;
			return;
		}
		Dragon last = root;
		while(last.getNext() != null) { //recorre la lista hasta que este vacia/
			last = last.getNext();
		}
		dragon.setNext(null);
		last.setNext(dragon);   //añade el dragon al final de la lista/
		++this.lenght;
		return;
	}
        
        /**Metodo que imprime la lista por los nombres de los dragones*/
	public void printList() {
		Dragon n = root;
		for(int i = 0 ; i<this.lenght;i++) {    //Recorre la lista y va imprimiendo los nombres de los dragones en consola
			System.out.println(n.getNombre());
			n = n.getNext();
		}
	}
        /**Metodo que imprime la lista por la posicion de los dragones*/
        public void printEdad() {
		Dragon n = root;
		for(int i = 0 ; i<this.lenght;i++) {    //Recorre y la lista e imprime en consola la coordenada x y la coordenada y en consola
			System.out.println(n.getEdad());
			n = n.getNext();
		}
	}
        /**Metodo que retorna el dragon que se encuentra en el indice que le entra como parametro
     * @param n
     * @return Dragon*/
	public Dragon getNodeinIndex(int n){
		Dragon current = this.root;
		int counter = 0;
		while(counter != n) {
			current = current.getNext();
			++counter;
		}
		return current;
	}
        /**Metodo que retorna la edad del dragon que se encuentra en el indice que le entra como parametro a la funcion
     * @param n
     * @return int edad de Dragon */
        public int getEdadinIndex(int n){
		Dragon current = this.root;
		int counter = 0;
		while(counter != n) {
			current = current.getNext();
			++counter;
		}
		return current.getEdad();
	}
        /**Metodo que elimina el dragon que se encuentra en el indice que le entra como parametr
     * @param n*/
	public void deleteNodeinIndex(int n) {
		Dragon temp = root;
		if (lenght==1) {    //Si la lista posee solo un elemento, lo elimina
			root=null;
		}
		else{
                    if (n>=lenght) { //Valida la resticcion que el indice no sea mayor que el largo de la lista
			throw new IllegalArgumentException("No puede ser mayor que el largo de la lista");
		}
		else {
			if (n==0) {
				root = root.getNext();
				lenght = lenght-1;
			}
			else {
				if (n==lenght-1) {  //Si el elemento es el ultimo, lo elimina de la lista
					int counter=0;
					while(counter!=n-1) {
						temp= temp.getNext();
						counter+=1;
					}
					temp.setNext(null);
					lenght = lenght-1;
				}
				else {  //Recorre la lista hasta llegar al indice n y elimina el nodo
						int counter=0;
						while(counter != n-1) {
							temp = temp.getNext();
							counter+=1;
						}
						temp.setNext(temp.getNext().getNext());
						lenght = lenght-1;
					}
				}
			}
		}
	}
        
        /**Metodo que intercambia la posicion en lista de un dragon y su suceso
     * @param lista
     * @param a
     * @param b
     * @return */
        public Linked_List switchDragon(Linked_List lista,int a,int b) {
            
            Dragon Dragon1 = lista.getNodeinIndex(a);
            Dragon Dragon2 = lista.getNodeinIndex(b);
            Dragon temp;
            temp = new Dragon(Dragon1.getNombre(),Dragon1.getVelocidadRecarga(),Dragon1.getEdad(),
                    Dragon1.getResistencia(),Dragon1.getClase(),Dragon1.getPadre(),Dragon1.getPos());
            
            lista.append(temp);
                                 
            Dragon1.setNombre(Dragon2.getNombre());
            Dragon1.setVelocidadRecarga(Dragon2.getVelocidadRecarga());
            Dragon1.setEdad(Dragon2.getEdad());
            Dragon1.setResistencia(Dragon2.getResistencia());
            Dragon1.setClase(Dragon2.getClase());
            Dragon1.setPadre(Dragon2.getPadre());
            Dragon1.setPos(Dragon2.getPos());
            
            Dragon2.setNombre(temp.getNombre());
            Dragon2.setVelocidadRecarga(temp.getVelocidadRecarga());
            Dragon2.setEdad(temp.getEdad());
            Dragon2.setResistencia(temp.getResistencia());
            Dragon2.setClase(temp.getClase());
            Dragon2.setPadre(temp.getPadre());
            Dragon2.setPos(temp.getPos());
            
            lista.deleteNodeinIndex(lista.lenght-1);

            return lista;
        }
        
        public Linked_List moverDragon(Linked_List lista, int a, int b){
            
            Dragon Dragon1 = lista.getNodeinIndex(a);
            Dragon Dragon2 = lista.getNodeinIndex(b);
            Dragon temp;
            temp = new Dragon(Dragon1.getNombre(),Dragon1.getVelocidadRecarga(),Dragon1.getEdad(),
                    Dragon1.getResistencia(),Dragon1.getClase(),Dragon1.getPadre(),Dragon1.getPos());
            
            Dragon1.setNombre(Dragon2.getNombre());
            Dragon1.setVelocidadRecarga(Dragon2.getVelocidadRecarga());
            Dragon1.setEdad(Dragon2.getEdad());
            Dragon1.setResistencia(Dragon2.getResistencia());
            Dragon1.setClase(Dragon2.getClase());
            Dragon1.setPadre(Dragon2.getPadre());
            Dragon1.setPos(Dragon2.getPos());
            
            lista.deleteNodeinIndex(lista.lenght-1);        
                   
               
            return lista;
        }
            
            
        
        
        

        /**Metodo que elimina un nodo especifico dentro de la lista de dragones*/
        public void delete(Dragon dragon,Linked_List lista){
            for(int i = 0; i < lista.lenght; i++){  //Recorre la lista de dragones buscando el dragon y lo elimina
                if(lista.getNodeinIndex(i).getEdad()== dragon.getEdad()){
                    lista.deleteNodeinIndex(i);
                }lenght = lenght-1;
                    
            }System.out.println("Done");
        }
        
        /**Metodo que ordena la lista de Dragones por Selection Sort de menor a Mayor usando el atributo edad de los dragone
     * @param listaDragones
     * @return listaDragones ordenada*/
        public Linked_List SelectionSortporEdadmM(Linked_List listaDragones){
            for (int i = 0; i < listaDragones.getLenght() - 1; i++){
                int index = i;
                for (int j = i + 1; j < listaDragones.getLenght(); j++)
                    if (listaDragones.getNodeinIndex(j).getEdad() < listaDragones.getNodeinIndex(index).getEdad())
                        index = j;
                int smallerNumber = listaDragones.getNodeinIndex(index).getEdad();
                listadragones = listadragones.moverDragon(listaDragones, index, i);
                listadragones = listadragones.moverDragon(listaDragones, i, smallerNumber);
                //listaDragones.getNodeinIndex(index).setEdad(listaDragones.getNodeinIndex(i).getEdad());
                //listaDragones.getNodeinIndex(i).setEdad(smallerNumber);
            }
            return listaDragones;
        }
        
        /**Metodo que ordena la lista de Dragones por Selection Sort de Mayor a menor usando el atributo edad de los dragone
     * @param listaDragones
     * @return listaDragones ordenada*/
        public Linked_List SelectionSortporEdadMm(Linked_List listaDragones){
            for (int i = 0; i < listaDragones.getLenght() - 1; i++){
                int index = i;
                for (int j = i + 1; j < listaDragones.getLenght(); j++)
                    if (listaDragones.getNodeinIndex(j).getEdad() > listaDragones.getNodeinIndex(index).getEdad())
                        index = j;
                int smallerNumber = listaDragones.getNodeinIndex(index).getEdad();
                listadragones = listadragones.moverDragon(listaDragones, index, i);
                listadragones = listadragones.moverDragon(listaDragones, i, smallerNumber);
                //listaDragones.getNodeinIndex(index).setEdad(listaDragones.getNodeinIndex(i).getEdad());
                //listaDragones.getNodeinIndex(i).setEdad(smallerNumber);
            
            }
            return listaDragones;
        }
        
        /**Metodo que ordena la lista de Dragones por Insertion Sort de menor a Mayor usando el atributo edad de los dragone
     * @param listaDragones
     * @return listaDragones ordenada*/
    
        public Linked_List InsertionSortporVelocidadRecargamM(Linked_List listaDragones){
            int temp = 0;
            for (int i = 1; i < listaDragones.getLenght(); i++) {
                for(int j = i ; j > 0 ; j--){
                    if(listaDragones.getNodeinIndex(j-1).getVelocidadRecarga() > listaDragones.getNodeinIndex(j).getVelocidadRecarga()){
                        listadragones = listadragones.moverDragon(listaDragones, j, temp);
                        listadragones = listadragones.moverDragon(listaDragones, j, listaDragones.getNodeinIndex(j-1).getVelocidadRecarga());
                        listadragones = listadragones.moverDragon(listaDragones, j-1, temp);
                        

                        //listaDragones.getNodeinIndex(j).setVelocidadRecarga(temp);
                        //listaDragones.getNodeinIndex(j).setVelocidadRecarga(listaDragones.getNodeinIndex(j-1).getVelocidadRecarga());
                        //listaDragones.getNodeinIndex(j-1).setVelocidadRecarga(temp);                    
                    }
                }

            }
            return listaDragones;
        }
        
        /**Metodo que ordena la lista de Dragones por Insertion Sort de Mayor a menor usando el atributo edad de los dragone
         * @param listaDragones
         * @return listaDragones ordenada*/
        public Linked_List InsertionSortporVelocidadRecargaMm(Linked_List listaDragones){
            int temp = 0;
            for (int i = 1; i < listaDragones.getLenght(); i++) {
                for(int j = i ; j > 0 ; j--){
                    if(listaDragones.getNodeinIndex(j-1).getVelocidadRecarga() < listaDragones.getNodeinIndex(j).getVelocidadRecarga()){
                        listadragones = listadragones.switchDragon(listaDragones, j, temp);
                        listadragones = listadragones.switchDragon(listaDragones, j, listaDragones.getNodeinIndex(j-1).getVelocidadRecarga());
                        listadragones = listadragones.switchDragon(listaDragones, j-1, temp);
                        //listaDragones.getNodeinIndex(j).setVelocidadRecarga(temp);
                        //listaDragones.getNodeinIndex(j).setVelocidadRecarga(listaDragones.getNodeinIndex(j-1).getVelocidadRecarga());
                        //listaDragones.getNodeinIndex(j-1).setVelocidadRecarga(temp);                    
                    }
                }
            }
            return listaDragones;
        }
        
        public Linked_List QuickSortporEdadmM(Linked_List listaDragones){
            return listaDragones;
        }
        
        public Linked_List QuickSortporEdadMm(Linked_List listaDragones){
            return listaDragones;
        }
            
            
        
        /**Metodo que da la posicion a cada Dragon para que al graficarlos en la interfaz, simule un arbol binario por familia
        * @param listadragones*/
        //Aun no funciona*
        public void arbolFamilia(Linked_List listadragones){
            int x = 25;
            int y = 200;
            int n;
            int e = 0;
            Dragon temp;
            temp = listadragones.root;
            while (temp.getNext()!= null){
                n = (int) pow(2,e);
                temp.setPos(x, y);
                while (n > 0){
                    temp.setPos(x, y);
                    n = n-1;
                    temp = temp.getNext();
                    temp.setPos(x, y);
                }
                x = x + 25;
                e++;           
            }
        }
        /**Metodo que asigna que tipo de ordenamiento sigue despues de que maten a cada Drago
        * @param listadragones
        * @param ord*/
        public void nextSort(Linked_List listadragones, int ord){
            switch (ord) {
                case 1:
                    listadragones.SelectionSortporEdadMm(listadragones);
                    listadragones.graficoSort(listadragones);
                    break;
                case 2:
                    listadragones.arbolFamilia(listadragones);
                    break;
                case 3:
                    listadragones.InsertionSortporVelocidadRecargaMm(listadragones);
                    listadragones.graficoSort(listadragones);
                    break;
                case 4:
                    listadragones.QuickSortporEdadMm(listadragones);
                    listadragones.graficoSort(listadragones);
                    break;
                case 5:
                    listadragones.InsertionSortporVelocidadRecargamM(listadragones);
                    listadragones.graficoSort(listadragones);
                    break;
                case 6:     
                    listadragones.SelectionSortporEdadmM(listadragones);
                    listadragones.graficoSort(listadragones);
                    break;
                case 7:
                    listadragones.QuickSortporEdadmM(listadragones);
                    listadragones.graficoSort(listadragones);
                    break;
                case 8:
                    listadragones.arbolFamilia(listadragones);
                    break;
                default:
                    break;
            }
        }

        /** Metodo que elimina de la lista de dragones el dragon que murio y llama a la funcion que ordena los dragones cada vez que muere un dragon
        * @param listadragones
        * @param dragon*/
        public void dragondisparado(Linked_List listadragones, Dragon dragon){
            int ord = 1;
            dragon.setResistencia(dragon.getResistencia()-1);     
                if (dragon.getResistencia()== 0){
                    listadragones.delete(dragon, listadragones);
                    ord++;
                    if (ord > 8){
                        ord = 1;
                    }
                }
                //listadragones.nextSort(listadragones, ord);
                
        }
        //Variables min y max para definir el parametro para generar numeros aleatorios
        int min;
        int max;
        /**Metodo que genera dos numeros aleatorios dentro de un parametro especifico*/
        private int getNumeroRandom(){
            this.min = 0;
            this.max = 100;
            return ThreadLocalRandom.current().nextInt(min, max);
        }
        /**Metodo que asigna la posicion de los dragones para graficarlos en pantall
        *@param listadragones*/
        public void graficoSort(Linked_List listadragones){
            int x = 100;
            Dragon current;
            current = listadragones.root;
            while(current.getNext()!= null){
                current.setPos(x,getNumeroRandom());
                current  = current.getNext();
                x = x + 25;     
            }       
        }
    
        /**Getters y Setters de los atributos de Linked_List*/
            @XmlElement(name = "Dragon")
            private Linked_List getListadragones() {
                return listadragones;
            }
            public void setListadragones(Linked_List listadragone) {
                this.listadragones = listadragone;
            }
            public void setRoot(Dragon root) {
		this.root = root;
            }
            @XmlElement(name = "lenght")
            public int getLenght() {
		return lenght;
            }
            public void setLenght(int lenght) {
		this.lenght = lenght;
            }       
    }

