
package Estructuras;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


public class EscrituraXML {
    
    
    public static void main(String[] args) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(Linked_List.class);
        Marshaller marshaller = context.createMarshaller();
        
        Linked_List listadragones = new Linked_List();
        Niveles nivel = new Niveles();

        listadragones.setListadragones(nivel.Nivel1());
        
        marshaller.marshal(listadragones,System.out);
        
        
        
    }
    
    
}
