package output;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import data.SalesReport;

public class SalesReportOutputXML extends SalesReportOutput{

	private Document document;
	private Element agentElem;
	
	public SalesReportOutputXML(SalesReport a, File b){
			salesReport = a;
			file = b;
	}	
	
	public void saveFile() {		
        try {
        	 DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        	 DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        	 document = documentBuilder.newDocument();
        	 agentElem = document.createElement("Agent");
        	 document.appendChild(agentElem);      	 
        	 writeToBufferTemplate();
        	 TransformerFactory transformerFactory = TransformerFactory.newInstance();
        	 Transformer transformer = transformerFactory.newTransformer();
        	 transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        	 transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        	 DOMSource domSource = new DOMSource(document);
        	 StreamResult streamResult = new StreamResult(file.getPath());
        	 transformer.transform(domSource, streamResult);
          		
        } catch (Exception ex) {
            ex.printStackTrace();
        }  		
	}

	@Override
	public void writeToBuffer(String message, String dataToWrite) {
		Element element = document.createElement(message);
		element.appendChild(document.createTextNode(dataToWrite));
		agentElem.appendChild(element);		
	}
}