package input;

import java.io.FileWriter;
import java.io.IOException;

public class ReceiptInfoAppenderHTML extends ReceiptInfoAppender{

	private FileWriter fileWriter; 
	
	@Override
	public void appendFile() {
		try {			
			fileWriter = new FileWriter(fileToAppend,true);					
			fileWriter.write("\n");
			ReceiptInfoAppendTemplate();
			fileWriter.write("<br>");
//			fileWriter.write("</body>");
			fileWriter.close();		
		} catch (IOException e) {		
			e.printStackTrace();
		}		
	}

	@Override
	public void ReceiptInfoAppend(String message, String receiptDataToWrite) {
		try {
			fileWriter.write("\n");
			fileWriter.write(message + ": ");
			fileWriter.write(receiptDataToWrite);
			fileWriter.write("\n");
			fileWriter.write("<br>");
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
