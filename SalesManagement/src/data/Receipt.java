package data;

public class Receipt {

	protected Integer receiptID;
	protected String date;
	protected String kind;
	protected Double sales;
	protected Integer items;
	protected Company company;
	protected Address address;


    public Receipt() {
        company = new Company();
    }

    public Company getCompany() {
 		return company;
 	}
  
	public String getDate() {
		return date;			
	}
	
	public Integer getReceiptID() {
		return receiptID;
	}

	public void setReceiptID(Integer receiptID) {
		this.receiptID = receiptID;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public Double getSales() {
		return sales;
	}

	public void setSales(Double sales) {
		this.sales = sales;
	}

	public Integer getItems() {
		return items;
	}

	public void setItems(Integer items) {
		this.items = items;
	}
	
	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public void setCompany(Company company) {
		this.company = company;
	}
	
}