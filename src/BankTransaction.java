import java.time.LocalDate;

public class BankTransaction {
	
	private LocalDate date;
	private Double amount;
	private String information;
	
	public BankTransaction(LocalDate date, Double amount, String information) {
		this.date = date;
		this.amount = amount;
		this.information = information;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public Double getAmount() {
		return amount;
	}
	
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public String getInformation() {
		return information;
	}
	
	public void setInformation(String information) {
		this.information = information;
	}
}
