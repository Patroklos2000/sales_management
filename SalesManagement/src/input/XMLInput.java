package input;

import java.io.File;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import data.Receipt;

public class XMLInput extends Input {
 
	private NodeList receiptsNodeList;
	private int receiptsNodeListLength;
	private int receiptReadIndex;
	
	public XMLInput(File receiptFileXML ){
		inputFile = receiptFileXML;
		
	}
    public void readFile() {
        try {
        	DocumentBuilderFactory docBuilderFactory 
			= DocumentBuilderFactory.newInstance();
        	DocumentBuilder docBuilder
			= docBuilderFactory.newDocumentBuilder();
        	Document doc = docBuilder.parse(inputFile);
        	 
        	doc.getDocumentElement().normalize();
            NodeList nodeLst = doc.getElementsByTagName("Agent");
			
        	name = ((Element) nodeLst.item(0)).getElementsByTagName("Name").
			item(0).getChildNodes().item(0).getNodeValue().trim();
			
        	afm = ((Element) nodeLst.item(0)).getElementsByTagName("AFM").
			item(0).getChildNodes().item(0).getNodeValue().trim();
        	addAgent();
        	receiptsNodeList = ((Element) nodeLst.item(0)).getElementsByTagName("Receipt");
			
        	receiptsNodeListLength = receiptsNodeList.getLength();
            for(receiptReadIndex = 0; receiptReadIndex<receiptsNodeListLength; receiptReadIndex++){
            	readReceipt();
            }
            
        } catch (Exception e) {
        	JOptionPane.showMessageDialog
			(null,"�������� ������ �������� ���� �� �������� ��� �������");
		} 
    }
	@Override
	public void readReceipt() {
		receipt = new Receipt();
		receipt.setReceiptID(Integer.parseInt(((Element) receiptsNodeList.item(receiptReadIndex)).
				getElementsByTagName("ReceiptID").item(0).getChildNodes().item(0).getNodeValue().trim()));
            	
		receipt.setDate(((Element) receiptsNodeList.item(receiptReadIndex)).
				getElementsByTagName("Date").item(0).getChildNodes().item(0).getNodeValue().trim());
				
		receipt.setKind (((Element) receiptsNodeList.item(receiptReadIndex))
				.getElementsByTagName("Kind").item(0).getChildNodes().item(0).getNodeValue().trim());
				
		receipt.setSales(Double.parseDouble(((Element) receiptsNodeList.item(receiptReadIndex)).
				getElementsByTagName("Sales").item(0).getChildNodes().item(0).getNodeValue().trim()));
            	
		receipt.setItems(Integer.parseInt(((Element) receiptsNodeList.item(receiptReadIndex))
				.getElementsByTagName("Items").item(0).getChildNodes().item(0).getNodeValue().trim()));
            	
		receipt.getCompany().setName(((Element) receiptsNodeList.item(receiptReadIndex)).
				getElementsByTagName("Company").item(0).getChildNodes().item(0).getNodeValue().trim());
            	
		receipt.getCompany().getCompanyAddress().setCountry(((Element) receiptsNodeList.item(receiptReadIndex)).
				getElementsByTagName("Country").item(0).getChildNodes().item(0).getNodeValue().trim());
            	
		receipt.getCompany().getCompanyAddress().setCity(((Element) receiptsNodeList.item(receiptReadIndex)).
				getElementsByTagName("City").item(0).getChildNodes().item(0).getNodeValue().trim());
            	
		receipt.getCompany().getCompanyAddress().setStreet(((Element) receiptsNodeList.item(receiptReadIndex)).
				getElementsByTagName("Street").item(0).getChildNodes().item(0).getNodeValue().trim());
            	
		receipt.getCompany().getCompanyAddress().setStreetNumber(Integer.parseInt(((Element) receiptsNodeList.item(receiptReadIndex)).
				getElementsByTagName("Number").item(0).getChildNodes().item(0).getNodeValue().trim()));
            	
				addReceipt();		
	} 
}
