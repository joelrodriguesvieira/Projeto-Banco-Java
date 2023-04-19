package questao01;

public class ContaEspecial extends ContaBancaria{
	private double limite;
	
	public ContaEspecial(String nomeCliente,int numConta,double saldo, double limite) {
		super(nomeCliente,numConta,saldo);
		this.limite = limite;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	@Override
	public void sacar(double valor) {
		if (valor > limite + this.getSaldo()) {
			System.out.println("Não foi possível realizar o saque! Saldo insuficiente");
			return;
		} else {
			this.setSaldo(this.getSaldo() - valor);
			System.out.println("Saque realizado no valor de R$: "+ valor);
		}
	}
}
