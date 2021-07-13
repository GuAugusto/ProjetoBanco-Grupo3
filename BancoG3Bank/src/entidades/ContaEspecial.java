package entidades;

public class ContaEspecial extends Conta{
	private double limite=1000;

	public ContaEspecial(int numero, double saldo, double limite) {
		super(numero, saldo);
		this.limite=limite;
	}

	public double getLimite() {
		return limite;
	}

	public void inicioLimite(){
		System.out.println("Bem vinde sua Conta Especial!");
		System.out.println("Uma conta com limite extra para sua facilidade.");
		System.out.println("Saldo Atual: "+saldo);
		System.out.println("Limite Especial: "+limite);
	}
	
	@Override
	public void opcoes(char opcao, double valorOperacao){
		if (opcao == 'C' ) {
			if(valorOperacao <= 0) {
				System.out.println("Valor invalido.");
			} else if (valorOperacao > 0) {
			this.saldo = this.saldo + valorOperacao;
			}	
			
		} else if (opcao == 'D') {
			if(valorOperacao <= 0 ) {
				System.out.println("Valor invalido!\n");
			}			
			else if (valorOperacao>saldo+limite) {
				System.out.println("Saldo insulficiente\n");
				
			} else if(saldo> valorOperacao){
				this.saldo = this.saldo - valorOperacao;
				System.out.println("Debito realizado do seu saldo!\n");
				
			} else if(saldo==0 && limite>valorOperacao) {
				limite = limite - valorOperacao;
				System.out.println("Debito realizado do seu saldo de limite!\n");
				
			} else if (saldo<valorOperacao) {
				double extra = valorOperacao - saldo;
				limite = limite - extra;
				saldo =0;
			}
		}
	}
	
	
	
	

}
