import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {

	private final List<BankTransaction> transactions;

	public BankStatementProcessor(List<BankTransaction> transactions) {
		this.transactions = transactions;
	}

	public double calculateTotalAmount() {
		double total = 0d;
		for (BankTransaction bankTransaction: transactions) {
			total += bankTransaction.getAmount();
		}

		return total;
	}

	public double selectInMonth(Month month) {
		double total = 0d;
		for (BankTransaction bankTransaction: transactions) {
			if (month == bankTransaction.getDate().getMonth()) {
				total += bankTransaction.getAmount();
			}
		}
		return total;
	}

	public double calculateTotalPerCategory(String category) {
		double total = 0d;
		for (BankTransaction bankTransaction: transactions) {
			if(category.equals(bankTransaction.getInformation())) {
				total += bankTransaction.getAmount();
			}
		}
		return total;
	}

}
