
public class SaldoNegativo extends Exception {
	public SaldoNegativo(String mensagem) {
		super("Saldo insuficiente");
	}
}
