
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
		if(root == null) {  //si la lista esta vacia, el dragon entra como el root de la lista/
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
			System.out.println(n.getNombre()+" Edad "+n.getEdad()+" Resistencia "+n.getResistencia()+" velocidad Recarga "+n.getVelocidadRecarga()+" Padre "+n.getPadre());
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
        
        public void switchDragon1(Linked_List lista,int a,int b) {
            
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
        public void arbolFamilia(Linked_List listadragones,int X){
    		int cont=0;
    		while (cont!=listadragones.getLenght()) {
        	for (int i=0;i<=listadragones.getLenght()-1;i++) {
        		X=X+25;
        		int dist=(int) (708/(pow(2,i)+1));
        		int ref=0;
        		while(ref<700) {
        			ref=ref+dist;
        			listadragones.getNodeinIndex(cont).setPos(X,ref);
        			cont++;

        		}
        	}
    		}
            
        }
        /**Metodo que asigna que tipo de ordenamiento sigue despues de que maten a cada Drago
        * @param listadragones
        * @param ord*/
        public void nextSort(Linked_List listadragones, int ord){
        	String sort = null;
            switch (ord) {
                case 1:
                    listadragones.SSmM(listadragones);
                    listadragones.graficoSort(listadragones,listadragones.getNodeinIndex(0).getPos().getX());
                    break;
                case 2:
                    listadragones.arbolFamilia(listadragones,listadragones.getNodeinIndex(0).getPos().getX());
                    sort="arbol Familia";
                    break;
                case 3:
                    listadragones.InsertionSortporVelocidadRecargaMm(listadragones);
                    listadragones.graficoSort(listadragones,listadragones.getNodeinIndex(0).getPos().getX());
                    sort="Insertion Sort";
                    break;
                case 4:
                    listadragones.QuickSortporEdadMm(listadragones);
                    listadragones.graficoSort(listadragones,listadragones.getNodeinIndex(0).getPos().getX());
                    sort="Quick Sort";
                    break;
                case 5:
                    listadragones.InsertionSortporVelocidadRecargamM(listadragones);
                    listadragones.graficoSort(listadragones,listadragones.getNodeinIndex(0).getPos().getX());
                    sort="Insertion Sort Velocidad de Recarga";
                    break;
                case 6:     
                    listadragones.SelectionSortporEdadmM(listadragones);
                    listadragones.graficoSort(listadragones,listadragones.getNodeinIndex(0).getPos().getX());
                    sort="Selection Sort";
                    break;
                case 7:
                    listadragones.QuickSortporEdadmM(listadragones);
                    listadragones.graficoSort(listadragones,listadragones.getNodeinIndex(0).getPos().getX());
                    sort="Quick Sort";
                    break;
                case 8:
                	listadragones.QuickSortporEdadMm(listadragones);
                    listadragones.arbolFamilia(listadragones,listadragones.getNodeinIndex(0).getPos().getX());
                    sort="Quick Sort";
                    break;
                default:
                    break;
            }
        }

        /** Metodo que elimina de la lista de dragones el dragon que murio y llama a la funcion que ordena los dragones cada vez que muere un dragon
        * @param listadragones
        * @param dragon*/
public Linked_List dragondisparado(Linked_List listadragones, Dragon dragon,int indic){
        int ord = 0;
        dragon.setResistencia(dragon.getResistencia()-1);
            if (dragon.getResistencia()== 0){
                listadragones.deleteNodeinIndex(indic);
                ord++;
                listadragones.nextSort(listadragones, ord);
                if (ord > 8){
                    ord = 1;
                }
            }
			return listadragones;
           
    }

        //Variables min y max para definir el parametro para generar numeros aleatorios
        int min;
        int max;
        /**Metodo que genera dos numeros aleatorios dentro de un parametro especifico*/
        private int getNumeroRandom(){
            this.min = 05;
            this.max = 670;
            return ThreadLocalRandom.current().nextInt(min, max);
        }
        /**Metodo que asigna la posicion de los dragones para graficarlos en pantall
        *@param listadragones*/
        public void graficoSort(Linked_List listadragones,int x){
            Dragon current;
            current = listadragones.root;
            while(current.getNext()!= null){
                current.setPos(x,getNumeroRandom());
                current  = current.getNext();
                x = x + 97;     
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
            public void SSmM(Linked_List list){
                int n = list.getLenght();
                //Linked_List result = new Linked_List();
                for(int i = 0;i <n-1;i++){
                    int min_idx = i;
                    for(int j = i+1;j<n;j++){
                        if(list.getNodeinIndex(j).getEdad() < list.getNodeinIndex(min_idx).getEdad()){
                            min_idx = j;
                        }
                    }
                    list.switchDragon(list, min_idx, i);
                    //result.append(list.getNodeinIndex(min_idx));
                    //list.deleteNodeinIndex(min_idx);
                }
               // return result;
            }
    
    
    /* This function takes last element as pivot, 
       places the pivot element at its correct 
       position in sorted array, and places all 
       smaller (smaller than pivot) to left of 
       pivot and all greater elements to right 
       of pivot */
    int partition(Linked_List arr, int low, int high) 
    { 
        int pivot = arr.getNodeinIndex(high).getEdad();  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than or 
            // equal to pivot 
            if (arr.getNodeinIndex(j).getEdad() <= pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                switchDragon(arr, i, j);
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        switchDragon(arr, i+1, high);
        
  
        return i+1; 
    } 
  
  
    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    void quicksort(Linked_List arr, int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            quicksort(arr, low, pi-1); 
            quicksort(arr, pi+1, high); 
        } 
    } 
  
    /* A utility function to print array of size n */
    void printArrayq(Linked_List arr) 
    { 
        int n = arr.getLenght(); 
        for (int i=0; i<n; ++i) 
            System.out.print(arr.getNodeinIndex(i).getEdad()+arr.getNodeinIndex(i).getNombre()+" "); 
        System.out.println(); 
    }
     void insertionsort(Linked_List arr) 
    { 
        int n = arr.getLenght(); 
        for (int i=1; i<n; ++i) 
        { 
            int j = i-1; 
  
            /* Move elements of arr[0..i-1], thatg are 
               greater than key, to one position ahead 
               of their current position */
            while (j>=0 && arr.getNodeinIndex(j).getEdad() > arr.getNodeinIndex(i).getEdad()) 
            { 
                switchDragon(arr, j+1, j);
               
                j = j-1; 
            } 
            switchDragon1(arr, i, j+1);
            //switchDragon(arr, j+1, i);
        } 
    } 
  
    /* A utility function to print array of size n*/
    static void printArrayi(Linked_List arr) 
    { 
        int n = arr.getLenght(); 
        for (int i=0; i<n; ++i) 
            System.out.print(arr.getNodeinIndex(i).getEdad()+arr.getNodeinIndex(i).getNombre()+" "); 
        System.out.println(); 
    } 
        }
    

