package questao01;

public class ContaPoupanca extends ContaBancaria{
	
	private int juros;
	
	public ContaPoupanca(String nomeCliente, int numConta, double saldo,int juros) {
		super(nomeCliente, numConta, saldo);
		this.juros = juros;		
	}
	
	public int getJuros() {
		return juros;
	}
	
	public void setJuros(int juros) {
		this.juros = juros;
	}
	
	public void calcularNovoSaldo(int juros) {
		double novo = (this.getSaldo()*this.juros)/100;
		this.setSaldo(novo);
		System.out.println("Seu saldo foi atualizado!" + this.getSaldo());
	}
	
}
