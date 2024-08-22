package data;

import java.util.ArrayList; // Import ArrayList
import java.util.List; // Import List interface

import input.ReceiptInfoAppender;
import input.ReceiptInfoAppenderHTML;
import input.ReceiptInfoAppenderTXT;
import input.ReceiptInfoAppenderXML;

public class SalesReport {
    private String name;
    private String afm;
    private List<Receipt> allReceipts; // Use List interface instead of Vector
    private ReceiptInfoAppender fileAppender;

    public SalesReport() {
        allReceipts = new ArrayList<>(); // Initialize ArrayList
    }

    public void setFileTypeTXT() {
    	fileAppender = new ReceiptInfoAppenderTXT();
    }
    
    public void setFileTypeXML() {
        fileAppender = new ReceiptInfoAppenderXML();
    }
    
	public void setFileTypeHTML() {
		fileAppender = new ReceiptInfoAppenderHTML();
	}

    public List<Receipt> getReceipts() {
        return allReceipts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
    }

    public double calculateTotalSales() {
        double sumSales = 0;
        for (int i = 0; i < allReceipts.size(); i++) {
            sumSales += allReceipts.get(i).getSales();
        }
        return sumSales;
    }

    public int calculateTotalItems() {
        int sumItems = 0;
        for (int i = 0; i < allReceipts.size(); i++) {
            sumItems += allReceipts.get(i).getItems();
        }
        return sumItems;
    }

    public float calculateSalesByKind(String clothingType) {
        float sum = 0;
        for (int i = 0; i < allReceipts.size(); i++) {
            if (allReceipts.get(i).getKind().equals(clothingType)) {
                sum += allReceipts.get(i).getItems();
            }
        }
        return sum;
    }

    public double calculateCommission() {
        double commission = 0;
        if (this.calculateTotalSales() > 6000 && this.calculateTotalSales() <= 10000) {
            commission = 0.1 * (calculateTotalSales() - 6000);
        } else if (this.calculateTotalSales() > 10000 && this.calculateTotalSales() <= 40000) {
            commission = (((calculateTotalSales() - 10000) * 0.15) + (10000 * 0.1));
        } else if (this.calculateTotalSales() > 40000) {
            commission = 10000 * 0.1 + 30000 * 0.15 + (calculateTotalSales() - 40000) * 0.2;
        }
        return commission;
    }

    public ReceiptInfoAppender getFileAppender() {
        return fileAppender;
    }
}
