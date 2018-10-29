
package Estructuras;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class LecturaXML {
    
    public static void main(String[] args) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(Linked_List.class); 
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Linked_List listadragones = (Linked_List) unmarshaller.unmarshal(new File("listadragones.xml"));
    }
    
        
    
}
