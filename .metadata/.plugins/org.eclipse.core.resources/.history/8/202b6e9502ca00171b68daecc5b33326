import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XSDApp {
	
	public void run() throws Exception {
		
		String xmlFileName = "order.xml";
		
        //Create a factory for XML Schemas
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        
        //Read the XML Schema
        Schema schema = factory.newSchema(new File("order.xsd"));
    
        //Create a validator from the schema
        Validator validator = schema.newValidator();
        
        //Parse the XML file
        Source source = new StreamSource(xmlFileName);
        
        try {
            validator.validate(source);
            System.out.println(xmlFileName + " is valid.");
        }
        catch (SAXException ex) {
            System.out.println(ex.getMessage());
        } 
		
	}
	
	public static void main(String[] args) throws Exception {
		new XSDApp().run();
	}
	
}
