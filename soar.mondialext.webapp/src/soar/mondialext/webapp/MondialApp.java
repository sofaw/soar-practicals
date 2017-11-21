package soar.mondialext.webapp;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MondialApp {
	
	public static void main(String[] args) throws Exception {
		new MondialApp().run();
	}
	
	public void run() throws Exception {
		//System.out.println(getCountries("Oceania"));
		System.out.println(getNeighbours("Andorra"));
	}
	
	public String getNeighbours(String country) throws Exception {
		String api = "https://www-users.cs.york.ac.uk/~dkolovos/apps/mondial";
		String countryUrl = api + "/country/" + country;
		
		Document countryDocument = parse(countryUrl);
		Element countryElement = countryDocument.getDocumentElement();
		
		Document countryWithNeighboursDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		Element countryRoot = countryWithNeighboursDocument.createElement("country");
		countryRoot.setAttribute("name", country);
		countryWithNeighboursDocument.appendChild(countryRoot);
		
		Element neighboursRoot = countryWithNeighboursDocument.createElement("neighbours");
		countryRoot.appendChild(neighboursRoot);
		
		ArrayList<Element> neighbours = toElementList(countryDocument.getDocumentElement().getElementsByTagName("neighbour"));
		for(Element neighbour : neighbours) {
			String neighbourUrl = api + "/country/" + neighbour.getAttribute("country");
			Document neighbourDocument = parse(neighbourUrl);
			Element neighbourSrc = neighbourDocument.getDocumentElement();
			Element neighbourSink = countryWithNeighboursDocument.createElement("country");
			neighbourSink = copyElement(neighbourSrc, neighbourSink);
			neighboursRoot.appendChild(neighbourSink);
		}
		return toXml(countryWithNeighboursDocument);
	}
	
	public Element copyElement(Element src, Element sink) {
		NamedNodeMap atts = src.getAttributes();
		for(int i = 0; i < atts.getLength(); i++) {
			String attName = atts.item(i).getNodeName();
			sink.setAttribute(attName, src.getAttribute(attName));
		}
		return sink;
	}
	
	/**
	 * Returns an XML-formatted string containing the countries encompassed in the specified continent
	 * @param continent The name of the continent (e.g. Europe, Asia)
	 * @return An XML-formatted string
	 * @throws Exception
	 */
	public String getCountries(String continent) throws Exception {
		
		String api = "https://www-users.cs.york.ac.uk/~dkolovos/apps/mondial";
		//String api = "http://localhost/~dkolovos/apps/mondial"; //Local copy of the API
		
		String continentUrl = api + "/continent/" + continent;
		String countriesUrl = api + "/countries/";
		
		// Parse the response of the continentUrl into an XML document
		Document continentDocument = parse(continentUrl);
		
		// Get the <continent> element
		Element continentElement = continentDocument.getDocumentElement();
		
		// Get the id of the continent
		String continentId = continentElement.getAttribute("id");
		
		// Parse the response of the countriesUrl into an XML document
		Document countriesDocument = parse(countriesUrl);
		
		// Create a new document where we will collect all the countries in the continent
		Document countriesInContinentDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		Element countriesInContinentDocumentRoot = countriesInContinentDocument.createElement("countries");
		countriesInContinentDocument.appendChild(countriesInContinentDocumentRoot);
		
		for (Element countryElement : toElementList(countriesDocument.getDocumentElement().getElementsByTagName("country"))) {
			
			// System.out.println("Checking country " + countryElement.getAttribute("name"));
			
			String countryUrl = api + "/country/" + countryElement.getAttribute("name");
			
			// Parse the response of the countryUrl into an XML document
			Document countryDocument = parse(countryUrl);
			
			List<Element> continents = toElementList(countryDocument.getElementsByTagName("encompassed"));
			
			boolean encompassedInContinent = false;
			for (Element encompassed : continents) {
				if (encompassed.getAttribute("continent").equals(continentId)) {
					encompassedInContinent = true;
				}
			}
			
			if (encompassedInContinent) {
				Element countryDocumentElement = countryDocument.getDocumentElement();
				
				// We are going to move the <country> element to the countriesInContinent document
				countriesInContinentDocument.adoptNode(countryDocumentElement);
				countriesInContinentDocumentRoot.appendChild(countryDocumentElement);
			}
			
		}
		
		return toXml(countriesInContinentDocument);
		
	}

	protected Document parse(String url) throws Exception {
		
		return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new URL(url.replace(" ", "%20")).openStream());
	}

	protected String toXml(Node node) throws Exception {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		DOMSource source = new DOMSource(node);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		StreamResult result = new StreamResult(baos);
		transformer.transform(source, result);
		return baos.toString();
	}
	
	protected ArrayList<Element> toElementList(NodeList nodeList) {
		ArrayList<Element> list = new ArrayList<Element>();
		for (int i=0;i<nodeList.getLength();i++) {
			list.add((Element)nodeList.item(i));
		}
		return list;
	}
	
}
