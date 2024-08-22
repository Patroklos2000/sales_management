package input;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class ReceiptInfoAppenderXML  extends ReceiptInfoAppender{
	
	private Element receiptElem;
	private Document doc;

	public void appendFile(){			
		try{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			doc = docBuilder.parse(fileToAppend);	
			Node agent = doc.getFirstChild();
			receiptElem = doc.createElement("Receipt");
			agent.appendChild(receiptElem);					
			ReceiptInfoAppendTemplate();    
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	   	 	transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(fileToAppend);
			transformer.transform(source, result);	
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public void ReceiptInfoAppend(String message, String receiptDataToWrite) {
		Element numberElem = doc.createElement(message);
       	numberElem.appendChild(doc.createTextNode(receiptDataToWrite));
       	receiptElem.appendChild(numberElem);
	}
}
