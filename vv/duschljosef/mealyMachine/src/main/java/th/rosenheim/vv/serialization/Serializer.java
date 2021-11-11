package th.rosenheim.vv.serialization;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import th.rosenheim.vv.Machine.State;
import th.rosenheim.vv.Machine.Symbol;

import javax.xml.bind.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class Serializer {

    public List<State> xmlDeSerzalizeState(InputStream in) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(StateList.class);
            Unmarshaller u = ctx.createUnmarshaller();
            JAXBElement<StateList> kElement = u.unmarshal(new StreamSource(in), StateList.class);
            StateList liste = kElement.getValue();
            return liste.getStateList();
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // idea Dom parser
    public void xmlSerialize(List<State> kunden, OutputStream out) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(StateList.class);
            Marshaller m = ctx.createMarshaller();
            m.marshal(new StateList(kunden), out);
        }

        catch(JAXBException ex) {
            ex.printStackTrace();
        }
    }

    public void myDeSerializer(String path){
        try {
            File inputFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("stateList");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    //Solution like this. To fill separately this in to symbol , state, to
                    //and so on. to create the state Table. Now i got problems with
                    // the getAttribute. This were my idea.

//                    System.out.println("Student roll no : "
//                            + eElement.getAttribute("rollno"));
//                    System.out.println("First Name : "
//                            + eElement
//                            .getElementsByTagName("firstname")
//                            .item(0)
//                            .getTextContent());
                }

            }
        }
        catch (ParserConfigurationException |IOException | SAXException  e) {
            e.printStackTrace();
        }
    }
}
