package input;

import java.io.FileWriter;
import java.io.IOException;

public class ReceiptInfoAppenderTXT extends ReceiptInfoAppender{

	private FileWriter fileWriter; 
	
	public void appendFile(){	
		try {			
			fileWriter = new FileWriter(fileToAppend,true);					
			fileWriter.write("\n");
			ReceiptInfoAppendTemplate();
			fileWriter.close();		
		} catch (IOException e) {		
			e.printStackTrace();
		}
	}

	@Override
	public void ReceiptInfoAppend(String message, String receiptDataToWrite) {
		try {
			fileWriter.write(message + ": ");
			fileWriter.write(receiptDataToWrite);
			fileWriter.write("\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
