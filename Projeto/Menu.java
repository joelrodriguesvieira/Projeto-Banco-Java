package questao01;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<ContaBancaria> lista = new ArrayList<>();
	
	public static void main(String[] args) {
		
		while (true) {
			System.out.println("=======MENU=======");
			System.out.println("1) Incluir dados relativos a conta de um cliente");
			System.out.println("2) Sacar um determinado valor de uma conta");
			System.out.println("3) Depositar um determinado valor na sua conta");
			System.out.println("4) Mostrar o novo saldo do cliente");
			System.out.println("5) Mostrar os dados de todas as contas");
			System.out.println("0) Sair");
			int opcao = sc.nextInt();
			
			switch(opcao) {
			case 1:
				cadastrarConta();
				break;
			case 2:
				sacar();
				break;
			case 3:
				depositar();
				break;
			case 4:
				mostrarNovoSaldo();
				break;
			case 5:
				mostrarContas();
				break;
			case 0:
				System.out.println("Encerrando programa...");
				System.exit(0);
			default:
				System.out.println("Resposta inválida!");
				break;
			}
			if (lista.size() == 5) {
				System.out.println("O número limite de contas cadastradas está em 5 já");
				break;
			}
		}
	}
	
	private static void cadastrarConta() {
		System.out.println("====ESCOLHA O TIPO DE CONTA=====");
		System.out.println("====(1) - Conta Bancária====");
		System.out.println("====(2) - Conta Poupança====");
		System.out.println("====(3) - Conta Especial====");
		int resposta = sc.nextInt();
		
		switch(resposta) {
		case 1:
			contaBancaria();
			break;
		case 2:
			contaPoupanca();
			break;
		case 3:
			contaEspecial();
			break;
		default:
			System.out.println("Resposta inválida!");
			break;
		}		
	}
	
	private static void contaBancaria() {
		sc.nextLine();
		System.out.println("Digite o nome do cliente: ");
		String nomeCliente = sc.nextLine().toUpperCase();
		
		System.out.println("Digite o número da conta: ");
		int numConta = sc.nextInt();
		
		lista.add(new ContaBancaria(nomeCliente,numConta,0));
		System.out.println("Conta Cadastrada! Saldo inicial R$: 0,00" );
	}
	
	private static void contaPoupanca() {
		sc.nextLine();
		System.out.println("Digite o nome do cliente: ");
		String nomeCliente = sc.nextLine().toUpperCase();
		
		System.out.println("Digite o número da conta: ");
		int numConta = sc.nextInt();
		
		System.out.println("Digite o valor dos juros do rendimento: ");
		int juros = sc.nextInt();
		
		lista.add(new ContaPoupanca(nomeCliente,numConta,0,juros));
		System.out.println("Conta Cadastrada! Saldo inicial R$: 0,00");
	}
	
	private static void contaEspecial() {
		sc.nextLine();
		System.out.println("Digite o nome do cliente: ");
		String nomeCliente = sc.nextLine().toUpperCase();
		
		System.out.println("Digite o número da conta: ");
		int numConta = sc.nextInt();
		
		System.out.println("Digite o limite da conta: ");
		double limite = sc.nextDouble();
		
		lista.add(new ContaEspecial(nomeCliente,numConta,0,limite));
		System.out.println("Conta Cadastrada! Saldo inicial R$: 0,00");
	}
	
	private static void sacar() {
		System.out.println("Digite o número da conta: ");
		int numConta = sc.nextInt();
		
		ContaBancaria conta = buscarConta(numConta);
		if (conta == null) {
			System.out.println("Conta não encontrada!");
			return;
		} else {
			System.out.println("Digite o valor do saque: ");
			double valor = sc.nextDouble();
			if ((conta instanceof ContaBancaria) || (conta instanceof ContaPoupanca)) {
				conta.sacar(valor);
			} else {
				((ContaEspecial) conta).sacar(valor);
			}
		}
		
	}
	
	private static ContaBancaria buscarConta(int numConta) {
		for (ContaBancaria conta: lista) {
			if (conta.getNumConta() == numConta) {
				return conta;
			}
		}
		return null;
	}
	
	private static void depositar() {
		System.out.println("Digite o número da conta: ");
		int numConta = sc.nextInt();
		
		ContaBancaria conta = buscarConta(numConta);
		if (conta == null) {
			System.out.println("Conta não encontrada!");
			return;
		} else {
			System.out.println("Digite o valor do deposito: ");
			double valor = sc.nextDouble();
			conta.depositar(valor);			
		}
	}
	private static void mostrarNovoSaldo() {
		System.out.println("Digite o número da conta: ");
		int numConta = sc.nextInt();
		
		ContaBancaria conta = buscarConta(numConta);
		
		if (conta instanceof ContaPoupanca){
			int juros = ((ContaPoupanca) conta).getJuros();
			((ContaPoupanca) conta).calcularNovoSaldo(juros);		
		} else {
			System.out.println("Sua conta não é do tipo Poupança!");
			return;
		}
	}
	
	private static void mostrarContas() {
		if (lista.isEmpty()) {
			System.out.println("Não há nenhuma conta cadastrada!");
			return;
		}
		for (ContaBancaria conta: lista) {
			System.out.println("====TIPO=== " + conta.getClass());
			System.out.println("Cliente: " + conta.getNomeCliente());
			System.out.println("Número da conta: " + conta.getNumConta());
		}
	}
	
}
