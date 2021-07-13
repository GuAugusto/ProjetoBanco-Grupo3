package entidades;

abstract class  Conta {
		
		//atributos.
		private int numero;
		protected double saldo=0;
		private char opcoes;
		
		//construtor
		public Conta(int numero, double saldo) {
			super();
			this.numero = numero;
		}
		
		//construtor vazio
		public Conta() {
			super();
		}



		//ENCAPSULAMENTO - GETTERS AND SETTERS
		public int getNumero() {
			return numero;
		}
		
		public double getSaldo() {
			return saldo;
		}
	
		//METODOS		
		public void inicial() {
			System.out.println("Banco G3");
			System.out.println("Seu dinheiro em desenvolvimento!");
			System.out.println();
			System.out.println("Número: "+numero+"-0\n");
		}
		
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
					
					else if (valorOperacao>saldo) {
						System.out.println("Saldo insulficiente\n");
					} else {
						this.saldo = this.saldo - valorOperacao;
						System.out.println("Debito realizado!\n");
					}
				}
			}
		
		public void sair() {
			System.out.println("Volte Sempre!");
			System.out.println("Banco G3");
			System.out.println("Seu dinheiro em desenvolvimento!\n");
		}
}
		
		//crédito.
		/*public void credito(double valorCredito) {
			if(valorCredito <= 0) {
				System.out.println("Valor invalido.");
			} else if (valorCredito > 0) {
			this.saldo = this.saldo + valorCredito;
			}
		}*/
		
		//debito.
		/*public void debito(double valorDebito) {
			if(valorDebito <= 0 ) {
				System.out.println("Valor invalido.");
			}
			
			else if (valorDebito>saldo) {
				System.out.println("Saldo insulficiente....");
			} else {
				this.saldo = this.saldo - valorDebito;
				System.out.println("Debito realizado!!!");
			}
		}*/
