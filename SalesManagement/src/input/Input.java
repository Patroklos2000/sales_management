package input;

import java.io.File;

import data.SalesReport;
import data.Receipt;

public abstract class Input {
	
	protected SalesReport salesReport;
	protected File inputFile;
	protected String inputFilePath;
	protected String name;
	protected String afm;
	protected String kind;
	protected Receipt receipt;
	

	public abstract void readFile();
	public abstract  void readReceipt();
	
	public Input() {
		salesReport = new SalesReport();
		kind  = new String("");
	}
	
	public void addAgent() {
		salesReport.setName(name);
		salesReport.setAfm(afm);
	}
	
	public void addReceipt() {			
        salesReport.getReceipts().add(receipt);
	}
	public SalesReport getSalesReport() {
		return salesReport;
	}

	
}
