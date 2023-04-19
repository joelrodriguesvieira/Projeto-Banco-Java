package questao01;

public class ContaBancaria {
	private String nomeCliente;
	private int numConta;
	private double saldo = 0;
	
	public ContaBancaria(String nomeCliente,int numConta,double saldo) {
		this.nomeCliente = nomeCliente;
		this.numConta = numConta;
		this.saldo = saldo;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void sacar(double valor) {
		if (valor > saldo) {
			System.out.println("Não foi possível realizar o saque! Saldo insuficiente");
			return;
		} else if (valor < 0 ) {
			System.out.println("Não é possível realizar saques negativos!");
			return;
		} else {
			saldo -= valor;
			System.out.println("Saque realizado no valor de R$: "+ valor);
		}
		
	}
	
	public void depositar(double valor) {
		if (valor < 0) {
			System.out.println("Não é possível realizar depósitos com valores negativos");
			return;
		} else {
			saldo += valor;
			System.out.println("Depósito realizado!");
		}
	}
}
