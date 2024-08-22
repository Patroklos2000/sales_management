package output;

import java.io.File;

import data.SalesReport;

public abstract class SalesReportOutput {

	protected SalesReport salesReport;
	protected File file;
	
	public abstract void saveFile();
	public abstract void writeToBuffer(String message, String dataToWrite);
	public void writeToBufferTemplate() {
		writeToBuffer("Name", salesReport.getName());
    	writeToBuffer("AFM", salesReport.getAfm());
        writeToBuffer("Total_Sales", Double.toString(salesReport.calculateTotalSales()));
        writeToBuffer("Trousers_Sales", Float.toString(salesReport.calculateSalesByKind("Trousers")));
        writeToBuffer("Skirts_Sales", Float.toString(salesReport.calculateSalesByKind("Skirts")));
        writeToBuffer("Shirts_Sales", Float.toString(salesReport.calculateSalesByKind("Shirts")));
        writeToBuffer("Coats_Sales", Float.toString(salesReport.calculateSalesByKind("Coats")));
        writeToBuffer("Commission", Double.toString(salesReport.calculateCommission()));
	}
}
