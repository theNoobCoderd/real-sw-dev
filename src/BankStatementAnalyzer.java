import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
	private static final String RESOURCES = "src/bank-statement.csv";

	public void analyze(BankStatementParser bankStatementParser) throws IOException {
		// getting resource / file
		final Path path = Paths.get(RESOURCES);
		// reading from file
		final List<String> lines = Files.readAllLines(path);

		// parsing data from file
		List<BankTransaction> transactions = bankStatementParser.parseLinesFrom(lines);

		// print data
		BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(transactions);
		collectSummary(bankStatementProcessor);
	}

	private static void collectSummary(BankStatementProcessor bankStatementProcessor) {

		System.out.println("total amount: " + bankStatementProcessor.calculateTotalAmount());
		System.out.println("total amount for " + Month.JANUARY + ": " + bankStatementProcessor.selectInMonth(Month.JANUARY));
		System.out.println("total amount for category: " + bankStatementProcessor.calculateTotalPerCategory("Salary"));
	}
}
