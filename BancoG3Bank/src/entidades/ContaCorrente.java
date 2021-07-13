package entidades;

public class ContaCorrente extends Conta {
	private int talao;


	public ContaCorrente(int numero, double saldo, int talao) {
		super(numero, saldo);
		this.talao = talao;
	}
	
	public void inicioCorrente(){
		System.out.println("Bem vinde sua Conta Corrente!");
		System.out.println("Faça um crédito para iniciar sua conta!");
		System.out.println("Saldo Atual: "+saldo);
		System.out.printf("Você possui %d talões disponiveis.\tCusto de R$30 por talão.\n",talao);
	}
	
	public int getTalao() {
		return talao;
	}

	public double pedirTalao(int pedido) {
		talao=3;
		if(pedido<=0) {
			System.out.println("Valor inválido!\n");
		} else if(pedido<=talao && saldo>30.00) {
			saldo = saldo - 30.00;
			talao-=pedido;
			System.out.printf("Seu pedido de talão foi concluído! Ainda restam %d talões",talao);
		} else if(pedido>talao) {
			System.out.println("Você já solicitou todos os talões disponiveis esse mês.");
		} else if(saldo<30.00) {
			System.out.println("Saldo insuficiente!");
		}
		return saldo;
	}
	
	

}
