package input;

import java.io.File;
import data.Receipt;

public abstract class ReceiptInfoAppender {

	protected File fileToAppend;
	protected Receipt receipt;
			
	public abstract void appendFile();
	public abstract void ReceiptInfoAppend(String message, String receiptDataToWrite);
	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}
	
	public Receipt getReceipt() {
		return receipt;	
	}
	
	public ReceiptInfoAppender() {
		super();
	}
	
	public void setFileToAppend(File fileToAppend) {
		this.fileToAppend = fileToAppend;
	}
	
	public void ReceiptInfoAppendTemplate() {
		ReceiptInfoAppend("ReceiptID", receipt.getReceiptID().toString());
        ReceiptInfoAppend("Date", receipt.getDate());
        ReceiptInfoAppend("Kind", receipt.getKind());
        ReceiptInfoAppend("Sales", receipt.getSales().toString());
        ReceiptInfoAppend("Items", receipt.getItems().toString());
        ReceiptInfoAppend("Company", receipt.getCompany().getName());
        ReceiptInfoAppend("Country", receipt.getCompany().getCompanyAddress().getCountry());
        ReceiptInfoAppend("City", receipt.getCompany().getCompanyAddress().getCity());
        ReceiptInfoAppend("Street", receipt.getCompany().getCompanyAddress().getStreet());
        ReceiptInfoAppend("Number", receipt.getCompany().getCompanyAddress().getStreetNumber().toString());
	}
}