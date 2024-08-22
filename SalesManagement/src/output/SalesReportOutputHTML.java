package output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import data.SalesReport;

public class SalesReportOutputHTML extends SalesReportOutput{

	private BufferedWriter bufferedWriter = null;

	public SalesReportOutputHTML(SalesReport a, File b){
		salesReport = a;
		file = b;
	}
	@Override
	public void saveFile() {
		try{   	
        	bufferedWriter = new BufferedWriter(new FileWriter(file.getPath()));  
        	bufferedWriter.write("<head> <title>test-html </title></head>");
        	bufferedWriter.write("<body>");
        	writeToBufferTemplate(); 
        	bufferedWriter.write("</body>");
        	bufferedWriter.close();
        }catch (IOException ex){
			JOptionPane.showMessageDialog(null,"������ ������ �������� ���� ��� ���������� ��� �������");
        }			
	}

	@Override
	public void writeToBuffer(String message, String dataToWrite) {
		try{
    		bufferedWriter.write(message + ": " + dataToWrite + " <br>");
    		bufferedWriter.newLine();
    	 }catch (IOException ex){
 			JOptionPane.showMessageDialog(null,"IOException");
         }		
	}
}
