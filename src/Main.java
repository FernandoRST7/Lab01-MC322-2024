import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("digite o modo de execução: (automatico/manual)");
		String tipo = scanner.nextLine();

		if (tipo.equals("automatico")) {
			
			System.out.println("---Teste de Jogador---");
			Jogador jogador1 = new Jogador("Fernando", "801.754.450-28", "nokifa2208@ikumaru.com", "https://instagram/foto.com", "preto");
			
			System.out.println(jogador1.toString());
			System.out.println("");
			
			//versão com a biblioteca dedicada:
			//verifica cpf
			if (Biblioteca.validaCPF(jogador1.getCpf())) { 
				System.out.println("CPF válido;");
			} else {
				System.out.println("CPF inválido;");
			}
			
			//verifica o email
			if (Biblioteca.validaEmail(jogador1.getEmail())) {
				System.out.println("email válido;\n");
			} else {
				System.out.println("email inválido;\n");
			}
			
			//teste de peca
			/*System.out.println("---Teste de Peca---");
			Peca peca = new Peca("preto");
			System.out.println(peca.toString());
			System.out.println();*/
			
			//teste de carta
			System.out.println("---Teste de CartaSorte---");
			//no caso essa n move e não tem ação específica, coloquei aquele texto de role play
			CartaSorte carta = new CartaSorte("Recebeu Herança!", 0, 1, 200000.00f, 
					"sua tia rica morreu e voce recebeu a herança", true, "sem restrições", "uma carta que da dinheiro ao jogador");
			System.out.println(carta.toString());
			System.out.println();
			
			System.out.println("---Teste de Propriedades---");
			//instanciação de uma propriedade geral
			Propriedade propriedade = new Propriedade("Mojo Dojo Casa House", 3000000, "A melhor propriedadae possivel");
			System.out.println(propriedade.toString());
			System.out.println();
	
			//instanciacao da estacao
			Estacao estacao = new Estacao("Liberdade", 500000, "carta de estação");
			System.out.println(estacao.toString());
			System.out.println();
			
			//instanciacao ddo terreno
			Terreno terreno = new Terreno("Céu Azul", 200000, 30000, 150000, "carta de terreno");
			System.out.println(terreno.toString());
			System.out.println();
			
			//instanciacao da estacao
			ServicoPublico servicoPublico = new ServicoPublico("Estação de Bombeiros", 300000, "carta de propriedade");
			System.out.println(servicoPublico.toString());
			System.out.println();
			
			//parte do tabuleiro
			Tabuleiro tabuleiro = new Tabuleiro();
			Jogador jogador2 = new Jogador("Eric", "469.369.169-96", "aspas@prodigy-agency.gg", "https://youtu.be/dQw4w9WgXcQ?si=IQWm2jD_LDtZae7w", "azul");
			
			tabuleiro.addJogador(jogador1);
			tabuleiro.addJogador(jogador2);
			
			tabuleiro.addPropriedade(propriedade);
			tabuleiro.addPropriedade(estacao);
			tabuleiro.addPropriedade(terreno);
			tabuleiro.addPropriedade(servicoPublico);
			
			//jogador1 vai comprar a propriedade e a estacao
			//se tiver a grana e a propriedade n tiver dono
			if (jogador1.getDinheiro()>propriedade.getPreco() && propriedade.getId() == 0) {
				jogador1.addDinheiro(-propriedade.getPreco()); //debita
				propriedade.setDono(jogador1); //registra o dono
			}
			//System.out.println(jogador1.toString());
			//System.out.println(propriedade.toString());
			if (propriedade.getDono() == null) {
			System.out.println("n comprou, a Mojo Dojo Casa House n é pra qualquer um\n");
			//no caso n comprou pq n tinha dinheiro, a Mojo Dojo Casa House n é pra qualquer um
			}
			
			//se tiver a grana e a estacao n tiver dono
			if (jogador1.getDinheiro()>estacao.getPreco() && estacao.getId() == 0) {
				jogador1.addDinheiro(-estacao.getPreco()); //debita
				estacao.setDono(jogador1); //registra o dono
			}
			//System.out.println(jogador1.toString() + "\n");
			//System.out.println(estacao.toString());
			
			/*jogador2 vai comprar a propriedade, a estacao do jogador1, o servicoPublico e a propriedade
			  pq a LEV ta pagando*/
			jogador2.addDinheiro(9999999);
			if (jogador2.getDinheiro()>(estacao.getPreco() + propriedade.getPreco() 
									  + terreno.getPreco() + servicoPublico.getPreco())) {
				//adquirindo do jogador1
				//provavelmente farei um metodo pra esse tipo de coisa no futuro
				jogador1.addDinheiro(estacao.getPreco() + 100000); 
				jogador2.addDinheiro(-(estacao.getPreco() + 100000));
				
				estacao.setDono(jogador2); //no futuro pretendo colocar a parte do dinheiro aqui tbm e fzr um metodo de compra
				
				//adquirindo o resto
				
				jogador2.addDinheiro(-terreno.getPreco()); //debita
				terreno.setDono(jogador2); //registra o dono
					
				jogador2.addDinheiro(-servicoPublico.getPreco()); //debita
				servicoPublico.setDono(jogador2); //registra o dono
				
				jogador2.addDinheiro(-propriedade.getPreco()); //debita
				propriedade.setDono(jogador2); //registra o id
				
				/*obs: claramente ta muito repetitivo, mas eu só to testando aqui, em labs sequentes
					   provavelmente vão ter métodos para compra e venda*/
			}
			
			//testes de remove:
			//jogador1 deu ragequit
			tabuleiro.rmvJogador(jogador1);
			
			//Mojo Dojo Casa House confiscada
			tabuleiro.rmvPropriedade(propriedade);
			
			//comprando casas:
			if(jogador2.getId() == terreno.getId()) {
				if (terreno.comprarCasa(jogador2, 1)) {
					System.out.println("cassa(s) comprada(s)");
				} else System.out.println("cassa(s) não comprada(s)");
			} 
			
			if(jogador2.getId() == terreno.getId()) {
				if (terreno.comprarCasa(jogador2, 3)) {
					System.out.println("cassa(s) comprada(s)");
				} else System.out.println("cassa(s) não comprada(s)");
			}
			
			//comprando hotel
			if (jogador2.getId() == terreno.getId()) {
				if (terreno.comprarHotel(jogador2)) {
					System.out.println("hotel comprado");
				} else System.out.println("hotel não comprado");
			}
			
			System.out.println("---Teste de Tabuleiro---");
			System.out.println("Numero de jogadores atuais: " + tabuleiro.getNumeroJogadores());
			System.out.println(tabuleiro.getJogadores().toString() + "\n");
			System.out.println("Numero de propriedades em jogo : " + tabuleiro.getNumeroPropriedades());
			System.out.println(tabuleiro.getPropriedades().toString() + "\n");
			
			System.out.println("O exemplo automático foi concluído, deseja verificar algum status? Sim/Não");
			String resposta = scanner.nextLine();
			if (resposta.equals("Sim")) {
				System.out.println("digite a opção desejada: " + "\n");

			while(true) {
				System.out.println("| Jogadores | Propriedades | Sair |");
				String comando = scanner.nextLine();
				if (comando.equals("Sair")) {
					System.out.println("Fim da simulação.");
					break;
				} else if (comando.equals("Jogadores")) {
					tabuleiro.printJogadores();
					System.out.println("Gostaria de averiguar algum jogador específico? Sim/Todos");
					comando = scanner.nextLine();
					if (comando.equals("Sim")) {
						System.out.println("Digite a posição em que o jogador apareceu no terminal.");
						String posicao = scanner.nextLine();
						int posicaoInt = Integer.parseInt(posicao);
						System.out.println("Oque deseja saber?");
						while(true) {
							System.out.println("| nome | dinheiro | id | cpf | foto | email | cartas | peca | tudo | nada mais |");
							comando = scanner.nextLine();
							if (comando.equals("nada mais")) break;
							else if (comando.equals("nome")) System.out.println(tabuleiro.getJogadores().get(posicaoInt-1).getNome());
							else if (comando.equals("dinheiro")) System.out.println(tabuleiro.getJogadores().get(posicaoInt-1).getDinheiro());
							else if (comando.equals("id")) System.out.println(tabuleiro.getJogadores().get(posicaoInt-1).getId());
							else if (comando.equals("cpf")) System.out.println(tabuleiro.getJogadores().get(posicaoInt-1).getCpf());
							else if (comando.equals("foto")) System.out.println(tabuleiro.getJogadores().get(posicaoInt-1).getDinheiro());
							else if (comando.equals("email")) System.out.println(tabuleiro.getJogadores().get(posicaoInt-1).getEmail());
							else if (comando.equals("cartas")) System.out.println(tabuleiro.getJogadores().get(posicaoInt-1).getCartas().toString());
							else if (comando.equals("peca")) System.out.println(tabuleiro.getJogadores().get(posicaoInt-1).getPeca().toString());
							else if (comando.equals("tudo")) System.out.println(tabuleiro.getJogadores().get(posicaoInt-1).toString());
						}
						
						
					} else {
						System.out.println("Numero de jogadores atuais: " + tabuleiro.getNumeroJogadores());
						System.out.println(tabuleiro.getJogadores().toString() + "\n");
					}
				} else {//Propriedades
					tabuleiro.printPropriedades();
					System.out.println("Gostaria de averiguar alguma propriedade específica? Sim/Todas");
					comando = scanner.nextLine();
					if (comando.equals("Sim")) {
						System.out.println("Digite a posição em que a propriedade apareceu no terminal.");
						String posicao = scanner.nextLine();
						int posicaoInt = Integer.parseInt(posicao);
						System.out.println(tabuleiro.getPropriedades().get(posicaoInt-1).toString());
					} else {
						System.out.println("Numero de propriedades atuais: " + tabuleiro.getNumeroPropriedades());
						System.out.println(tabuleiro.getPropriedades().toString() + "\n");
					}
				}
			}
			
			} else System.out.println("Fim da simulação.");
			
			
			
		} else  {
			/*versão manual: aqui a ideia era fazer tudo manualmente, mas daria muito trabalho e n é o intuito desse lab ainda (eu acho).
			  então a parte de cima (a "automatica") eh a principal. e tem interacoes com o terminal tambem*/
			Tabuleiro tabuleiro = new Tabuleiro();
			
			//no futuro talvez tenham comandos para criar propriedades, mas por enquanto n ta pedindo
			Propriedade propriedade = new Propriedade("Mojo Dojo Casa House", 3000000, "A melhor propriedadae possivel");
			Estacao estacao = new Estacao("Liberdade", 500000, "carta de estação");
			Terreno terreno = new Terreno("Céu Azul", 200000, 30000, 150000, "carta de terreno");
			ServicoPublico servicoPublico = new ServicoPublico("Estação de Bombeiros", 300000, "carta de serviço público");
			
			tabuleiro.addPropriedade(propriedade);
			tabuleiro.addPropriedade(estacao);
			tabuleiro.addPropriedade(terreno);
			tabuleiro.addPropriedade(servicoPublico);

			//parte dos comandos
			while(true) {
				System.out.println("digite o comando");
				String comando = scanner.nextLine();
				if (comando.equals("parar")) {
					System.out.println("Fim da simulação.");
					break;
				} else if (comando.equals("adicionar jogador")) {
					System.out.println("insira os dados no formato: nome, cpf, email, foto, cor");
					String dados = scanner.nextLine();
					String[] partes = dados.split(", ");
					tabuleiro.addJogador(new Jogador(partes[0], partes[1], partes[2], partes[3], partes[4]));
					
				} else if (comando.equals("comprar terreno")) {
					if (tabuleiro.getJogadores().get(0).getDinheiro() > terreno.getPreco()) {
						tabuleiro.getJogadores().get(0).addDinheiro(-terreno.getPreco());
						terreno.setDono(tabuleiro.getJogadores().get(0));
						System.out.println("terreno comprado");
					} else System.out.println("terreno não comprado");
					
				} else if (comando.equals("comprar casa")) {
					if (terreno.comprarCasa(tabuleiro.getJogadores().get(0), 1)) {
						System.out.println("casa comprado");

					} else System.out.println("casa não comprada");
				
			}
			
		}
		}
		scanner.close();
		
		
	}
	
}
