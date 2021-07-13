package entidades;

public class ContaEstudante extends Conta {
	private double emprestimo;

	public ContaEstudante(int numero, double saldo, double emprestimo) {
		super(numero, saldo);
		this.emprestimo = emprestimo;
	}
	
	public double getEmprestimo() {
		return emprestimo;
	}

	public void inicioEstudante() {
		System.out.println("Bem vinde sua Conta Estudante!");
		System.out.println("Invista no seu futuro, temos um limite de emprestimo de até R$ 5.000! Aproveite!");
		System.out.println("Saldo Atual: "+saldo);
		System.out.println("Saldo Emprestimo: "+emprestimo);
	}
	
	public double emprestimo(double valorEmprestimo){
		emprestimo=5000.00;
		if(valorEmprestimo <= 0 ) {
			System.out.println("Valor invalido!\n");
		}
		else if (valorEmprestimo>emprestimo) {
			System.out.printf("Saldo insulficiente! Ainda restam R$ %.2f de limite de emprestimo!",emprestimo);
		} else if(valorEmprestimo <= emprestimo){
			this.emprestimo = this.emprestimo - valorEmprestimo;
			super.saldo = super.saldo + valorEmprestimo;
			System.out.println("Emprestimo realizado!");
		}
		
		return emprestimo;
	}

}