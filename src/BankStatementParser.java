import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementParser {
	private static final DateTimeFormatter DATE_PATTERN
			= DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	public List<BankTransaction> parseLinesFromCsv(List<String> lines) {
		List<BankTransaction> transactions = new ArrayList<>();
		
		for(final String line: lines) {
			BankTransaction transaction = parseLineFromCsv(line);
			transactions.add(transaction);
		}
		
		return transactions;
	}
	
	private BankTransaction parseLineFromCsv(String line) {
		// splitting columns by commas
		final String[] columns = line.split(",");
		
		// extracting the amount
		final double amount = Double.parseDouble(columns[1]);
		final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
		final String info = columns[2];
		
		return new BankTransaction(date, amount, info);
	}
}
