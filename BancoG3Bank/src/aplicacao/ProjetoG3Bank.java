package aplicacao;

import java.util.Scanner;

import entidades.ContaCorrente;
import entidades.ContaEmpresa;
import entidades.ContaEspecial;
import entidades.ContaEstudante;
import entidades.ContaPoupanca;

public class ProjetoG3Bank {
//FAZER CONTA ESPECIAL

//PROJETO BANCO - PRODUZIDO NO PRIMEIRO M�DULO
//POR: 
// CLARA MONTANHEZ, GUSTAVO AUGUSTO, JAQUELINE CANTARINO, WESLEY LUAN;
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);

		String menu[] = { "Conta Poupan�a", "Conta Corrente", "Conta Especial", "Conta Empresa", "Conta Estudante",
				"Sair" };
		System.out.println("G3 Bank");
		System.out.println("Se dinheiro em desenvolvimento!\n");

		int opcao;
		char continuar;
		char voltaMenu;
		double saldoPoup = 0; // teste de saldo armazenado, por�m deu errado.
		int numero = 0;

		numero = (int) (Math.random() * 10001);

		for (int x = 0; x < 6; x++) {
			System.out.println((x + 1) + "-" + menu[x] + "\n");
		}

		System.out.println("\nEscolha a op��o desejada:");
		opcao = leia.nextInt();

		if (opcao <= 0 || opcao > 6) {
			System.out.println("Op��o inv�lida.");
			System.out.println("Deseja voltar ao Menu? S-Sim ou N-N�o");
			voltaMenu = leia.next().toUpperCase().charAt(0);
			if (voltaMenu == 'S') {
				System.out.println(new String(new char[50]).replace("\0", "\r\n"));
				main(args);
			} else if (voltaMenu == 'N') {
				System.out.println(new String(new char[50]).replace("\0", "\r\n"));
				System.out.println("Volte Sempre!");
				System.out.println("Banco G3");
				System.out.println("Seu dinheiro em desenvolvimento!\n");
			}

		}
		// CONTA POUPAN�A - CLARA.
		else if (opcao == 1) {
			int interacao = 1;
			ContaPoupanca poupanca = new ContaPoupanca(numero, saldoPoup, 14); // instanciando a conta poupan�a
			poupanca.inicial();
			poupanca.inicioPoupanca();

			for (int x = 0; x <= 9; x++) {
				System.out.println("Movimento " + (x + 1));
				System.out.println("Qual opera��o voc� deseja efetuar? C-Cr�dito ou D-D�bito");
				char op = leia.next().toUpperCase().charAt(0);
				System.out.println("Qual valor da opera��o?");
				double valorOperacao = leia.nextDouble();

				poupanca.opcoes(op, valorOperacao);

				System.out.println("Saldo Atual: " + poupanca.getSaldoPoup());

				interacao++;
				System.out.println("\nDeseja continuar? S-Sim ou N-N�o");
				continuar = leia.next().toUpperCase().charAt(0);
				if (continuar == 'N') {
					break;
				}
			}
			if (interacao > 10) {
				System.out.println("Limite de intera��o atingido!\n");
			}

			System.out.println("\nQual � o dia de hoje?");
			int dia = leia.nextInt();
			poupanca.calculoAniversario(dia);
			System.out.println("Saldo Atual: " + poupanca.getSaldoPoup());

			System.out.println("\nDeseja voltar ao Menu? S-Sim ou N-N�o");
			voltaMenu = leia.next().toUpperCase().charAt(0);
			if (voltaMenu == 'S') {
				System.out.println(new String(new char[50]).replace("\0", "\r\n"));
				main(args);
			} else if (voltaMenu == 'N') {
				System.out.println(new String(new char[50]).replace("\0", "\r\n"));
				poupanca.sair();
			}
		}

		// CONTA CORRENTE
		else if (opcao == 2) {
			int interacao = 1;
			ContaCorrente corrente = new ContaCorrente(numero, 0.00, 3);
			corrente.inicial();
			corrente.inicioCorrente();

			for (int x = 0; x <= 9; x++) {
				System.out.println("Movimento " + (x + 1));
				System.out.println("Qual opera��o voc� deseja efetuar? C-Cr�dito ou D-D�bito");
				char op = leia.next().toUpperCase().charAt(0);
				System.out.println("Qual valor da opera��o?");
				double valorOperacao = leia.nextDouble();

				corrente.opcoes(op, valorOperacao);

				System.out.println("Saldo Atual: " + corrente.getSaldo());

				interacao++;
				System.out.println("Deseja continuar? S-Sim ou N-N�o");
				continuar = leia.next().toUpperCase().charAt(0);
				if (continuar == 'N') {
					break;
				}
			}
			if (interacao > 10) {
				System.out.println("Limite de intera��o atingido!\n");
			}

			System.out.println("\nDeseja um tal�o de cheque? S-Sim ou N-N�o ");
			char cheque = leia.next().toUpperCase().charAt(0);
			if (cheque == 'S') {
				System.out.printf("Voc� ainda tem %d tal�es disponiveis, qual quantidade voc� deseja solicitar? ",
						corrente.getTalao());
				int qtaCheque = leia.nextInt();
				corrente.pedirTalao(qtaCheque);
			} else if (cheque != 'N') {
				System.out.println("Op��o inv�lida!");
				System.out.println("Deseja continuar? S-Sim ou N-N�o");
				continuar = leia.next().toUpperCase().charAt(0);
				if (continuar == 'S') {
					System.out.printf("Voc� ainda tem %d tal�es disponiveis, qual quantidade voc� deseja solicitar? ",
							corrente.getTalao());
					int qtaCheque = leia.nextInt();
					corrente.pedirTalao(qtaCheque);
				}
			}

			System.out.println("\nDeseja voltar ao Menu? S-Sim ou N-N�o");
			voltaMenu = leia.next().toUpperCase().charAt(0);
			if (voltaMenu == 'S') {
				System.out.println(new String(new char[50]).replace("\0", "\r\n"));
				main(args);
			} else if (voltaMenu == 'N') {
				System.out.println(new String(new char[50]).replace("\0", "\r\n"));
				corrente.sair();
			}

		}
		//// CONTA ESPECIAL
		else if (opcao == 3) {
			int interacao = 1;
			ContaEspecial especial = new ContaEspecial(numero, 0, 1000);

			especial.inicial();
			especial.inicioLimite();

			for (int x = 0; x <= 9; x++) {
				System.out.println("Movimento " + (x + 1));
				System.out.println("Qual opera��o voc� deseja efetuar? C-Cr�dito ou D-D�bito");
				char op = leia.next().toUpperCase().charAt(0);
				System.out.println("Qual valor da opera��o?");
				double valorOperacao = leia.nextDouble();

				especial.opcoes(op, valorOperacao);

				System.out.println("Saldo Atual: " + especial.getSaldo());
				System.out.println("Saldo de Limite Atual: " + especial.getLimite());

				interacao++;
				System.out.println("Deseja continuar? S-Sim ou N-N�o");
				continuar = leia.next().toUpperCase().charAt(0);
				if (continuar == 'N') {
					break;
				}
			}
			if (interacao > 10) {
				System.out.println("Limite de intera��o atingido!\n");
			}

			System.out.println("\nDeseja voltar ao Menu? S-Sim ou N-N�o");
			voltaMenu = leia.next().toUpperCase().charAt(0);
			if (voltaMenu == 'S') {
				System.out.println(new String(new char[50]).replace("\0", "\r\n"));
				main(args);
			} else if (voltaMenu == 'N') {
				System.out.println(new String(new char[50]).replace("\0", "\r\n"));
				especial.sair();
			}

		}

		// CONTA EMPRESA
		else if (opcao == 4) {
			int interacao = 1;
			ContaEmpresa empresa = new ContaEmpresa(numero, 0.00, 10000.00);
			empresa.inicial();
			empresa.inicioEmpresa();

			for (int x = 0; x <= 9; x++) {
				System.out.println("Movimento " + (x + 1));
				if (empresa.getEmprestimo() > 0) {
					System.out.printf("Gostaria de um emprestimo? S-Sim ou N-N�o");
					char emp = leia.next().toUpperCase().charAt(0);
					if (emp == 'S') {
						System.out.printf("Seu limite atual de emprestimo �: R$ %.2f. Qual valor deseja solicitar?",
								empresa.getEmprestimo());
						double valorEmprestimo = leia.nextDouble();
						empresa.emprestimo(valorEmprestimo);
						System.out.println("Saldo Atual: " + empresa.getSaldo());
						System.out.println("Limite de Empr�stimo Atual: " + empresa.getEmprestimo());
					}
				}
				System.out.println("\nQual opera��o voc� deseja efetuar? C-Cr�dito ou D-D�bito");
				char op = leia.next().toUpperCase().charAt(0);
				System.out.println("Qual valor da opera��o?");
				double valorOperacao = leia.nextDouble();

				empresa.opcoes(op, valorOperacao);

				System.out.println("Saldo Atual: " + empresa.getSaldo());
				System.out.println("Limite de Empr�stimo Atual: " + empresa.getEmprestimo());

				interacao++;
				System.out.println("\nDeseja continuar? S-Sim ou N-N�o");
				continuar = leia.next().toUpperCase().charAt(0);
				if (continuar == 'N') {
					break;
				}
			}
			if (interacao > 10) {
				System.out.println("Limite de intera��o atingido!\n");
			}

			System.out.println("\nDeseja voltar ao Menu? S-Sim ou N-N�o");
			voltaMenu = leia.next().toUpperCase().charAt(0);
			if (voltaMenu == 'S') {
				System.out.println(new String(new char[50]).replace("\0", "\r\n"));
				main(args);
			} else if (voltaMenu == 'N') {
				System.out.println(new String(new char[50]).replace("\0", "\r\n"));
				empresa.sair();
			}

		}
		// CONTA ESTUDANTE
		else if (opcao == 5) {
			int interacao = 1;
			ContaEstudante estudante = new ContaEstudante(numero, 0.00, 5000.00);
			estudante.inicial();
			estudante.inicioEstudante();

			for (int x = 0; x <= 9; x++) {
				System.out.println("Movimento " + (x + 1));
				if (estudante.getEmprestimo() > 0) {
					System.out.printf("Gostaria de um emprestimo? S-Sim ou N-N�o");
					char emp = leia.next().toUpperCase().charAt(0);
					if (emp == 'S') {
						System.out.printf("Seu limite atual de emprestimo �: R$ %.2f. Qual valor deseja solicitar?",
								estudante.getEmprestimo());
						double valorEmprestimo = leia.nextDouble();
						estudante.emprestimo(valorEmprestimo);
						System.out.println("Saldo Atual: " + estudante.getSaldo());
						System.out.println("Limite de Empr�stimo Atual: " + estudante.getEmprestimo());
					}
				}
				System.out.println("\nQual opera��o voc� deseja efetuar? C-Cr�dito ou D-D�bito");
				char op = leia.next().toUpperCase().charAt(0);
				System.out.println("Qual valor da opera��o?");
				double valorOperacao = leia.nextDouble();

				estudante.opcoes(op, valorOperacao);

				System.out.println("Saldo Atual: " + estudante.getSaldo());
				System.out.println("Limite de Empr�stimo Atual: " + estudante.getEmprestimo());
				
				interacao++;
				System.out.println("\nDeseja continuar? S-Sim ou N-N�o");
				continuar = leia.next().toUpperCase().charAt(0);
				if (continuar == 'N') {
					break;
				}
			}
			if (interacao > 10) {
				System.out.println("Limite de intera��o atingido!\n");
			}

			System.out.println("\nDeseja voltar ao Menu? S-Sim ou N-N�o");
			voltaMenu = leia.next().toUpperCase().charAt(0);
			if (voltaMenu == 'S') {
				System.out.println(new String(new char[50]).replace("\0", "\r\n"));
				main(args);
			} else if (voltaMenu == 'N') {
				System.out.println(new String(new char[50]).replace("\0", "\r\n"));
				estudante.sair();
			}

		}

		else if (opcao == 6) {
			System.out.println(new String(new char[50]).replace("\0", "\r\n"));
			System.out.println("Volte Sempre!");
			System.out.println("Banco G3");
			System.out.println("Seu dinheiro em desenvolvimento!\n");
		}

	}
}