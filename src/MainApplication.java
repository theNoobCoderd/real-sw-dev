import java.io.IOException;

public class MainApplication {
	public static void main(String[] args) throws IOException {
		BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();

		BankStatementParser csvParser = new BankStatementCSVParser();

		bankStatementAnalyzer.analyze(csvParser);
	}
}