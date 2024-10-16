import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class Main {
	private static final String RESOURCES = "src/bank-statement.csv";
	private static final BankStatementParser bankStatementParser = new BankStatementParser();
	
	public static void main(String[] args) throws IOException {
		// getting resource / file
		final Path path = Paths.get(RESOURCES);
		// reading from file
		final List<String> lines = Files.readAllLines(path);
		
		// parsing data from file
		List<BankTransaction> transactions = bankStatementParser.parseLinesFromCsv(lines);
		
		// printing an output
		System.out.println("The total for all transactions is " + calculateTotalAmount(transactions));
		
		System.out.println("Transactions in January " + selectInMonth(transactions, Month.JANUARY));
	}
	
	private static double calculateTotalAmount(List<BankTransaction> bankTransactions) {
		double total = 0d;
		for (BankTransaction bankTransaction: bankTransactions) {
			total += bankTransaction.getAmount();
		}
		
		return total;
	}
	
	private static double selectInMonth(List<BankTransaction> bankTransactions, Month month) {
		double total = 0d;
		for (BankTransaction bankTransaction: bankTransactions) {
			if (month == bankTransaction.getDate().getMonth()) {
				total += bankTransaction.getAmount();
			}
		}
		return total;
	}
}