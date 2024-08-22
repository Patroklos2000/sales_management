package output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import data.SalesReport;

public class SalesReportOutputTXT extends SalesReportOutput{

	private BufferedWriter bufferedWriter = null;
	
	public SalesReportOutputTXT(SalesReport a, File b){
		salesReport = a;
		file = b;
	}
		
	public void saveFile() {
        try{   	
        	bufferedWriter = new BufferedWriter(new FileWriter(file.getPath()));       	
        	writeToBufferTemplate();         
        	bufferedWriter.close();
        }catch (IOException ex){
			JOptionPane.showMessageDialog(null,"������ ������ �������� ���� ��� ���������� ��� �������");
        }		
	}

    public void writeToBuffer(String message, String dataToWrite){
    	try{
    		bufferedWriter.write(message + ": " + dataToWrite);
    		bufferedWriter.newLine();
    	 }catch (IOException ex){
 			JOptionPane.showMessageDialog(null,"IOException");
         }
   }
}
