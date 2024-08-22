 package input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import data.Receipt;

public class TXTInput extends Input{
	
	private BufferedReader br = null;
	
	public TXTInput(File recieptFileTXT){
		this.inputFile = recieptFileTXT;
		inputFilePath =  inputFile.getAbsolutePath();		
	}
	
	@Override
	public void readFile()  {
	    try {	            	
			br = new BufferedReader(new FileReader(inputFilePath));
		} catch (FileNotFoundException e1) {
				e1.printStackTrace();
		}
	    String line;
	    try {
			line = br.readLine();		
			name = (line.substring(line.indexOf(":") + 1).trim());				
			line = br.readLine();
			afm = (line.substring(line.indexOf(":") + 1).trim());
			addAgent();			
			skipLines(2);				
			while ((line = br.readLine()) != null) {
				readReceipt();
			}
			br.close();
	    } catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
    public void readReceipt() {
    	try {
    		receipt = new Receipt();
    		String line;
    		line = br.readLine();
    		receipt.setReceiptID(Integer.parseInt(line.substring(line.indexOf(":") + 1).trim()));
			
    		line = br.readLine();								
    		receipt.setDate(line.substring(line.indexOf(":") + 1).trim());
						
    		line = br.readLine();
    		receipt.setKind(line.substring(line.indexOf(":") + 1).trim());

    		line = br.readLine();
    		receipt.setSales(Double.parseDouble(line.substring(line.indexOf(":") + 1).trim()));
	
    		line = br.readLine();
    		receipt.setItems(Integer.parseInt(line.substring(line.indexOf(":") + 1).trim()));
			
    		line = br.readLine();
    		receipt.getCompany().setName(line.substring(line.indexOf(":") + 1).trim());								

    		line = br.readLine();
    		receipt.getCompany().getCompanyAddress().setCountry(line.substring(line.indexOf(":") + 1).trim());
			
    		line = br.readLine();
    		receipt.getCompany().getCompanyAddress().setCity(line.substring(line.indexOf(":") + 1).trim());
			
    		line = br.readLine();
    		receipt.getCompany().getCompanyAddress().setStreet(line.substring(line.indexOf(":") + 1).trim());
			
    		line = br.readLine();
    		receipt.getCompany().getCompanyAddress().setStreetNumber(Integer.parseInt(line.substring(line.indexOf(":") + 1).trim()));
    		addReceipt();
    	 } catch (IOException e) {
 			e.printStackTrace();
 		}
    }
    
    public void skipLines(int n) {
		for (int i =0; i <n; i++) {
			try {
				br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
