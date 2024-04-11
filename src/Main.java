
public class Main {

	public static void main(String[] args) {
		System.out.println("---Teste de Jogador---");
		Jogador jogador1 = new Jogador("Fernando", "801.754.450-28", "nokifa2208@ikumaru.com", "https://instagram/foto.com");
		
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
		System.out.println("---Teste de Peca---");
		Peca peca = new Peca("preto", 0);
		System.out.println(peca.toString());
		System.out.println();
		
		//teste de carta
		System.out.println("---Teste de CartaSorte---");
		//no caso essa n move e não tem ação específica, coloquei aquele texto de role play
		CartaSorte carta = new CartaSorte(1, "Recebeu Herança!", 0, 1, 200000.00f, 
				"sua tia rica morreu e voce recebeu a herança", true, "sem restrições");
		System.out.println(carta.toString());
		System.out.println();
		
		System.out.println("---Teste de Propriedades---");
		//instanciação de uma propriedade geral
		Propriedade propriedade = new Propriedade("Mojo Dojo Casa House", 3000000);
		System.out.println(propriedade.toString());
		System.out.println();

		//instanciacao da estacao
		Estacao estacao = new Estacao("Liberdade", 500000);
		System.out.println(estacao.toString());
		System.out.println();
		
		//instanciacao da estacao
		Terreno terreno = new Terreno("Céu Azul", 200000, 30000, 150000);
		System.out.println(terreno.toString());
		System.out.println();
		
		//instanciacao da estacao
		ServicoPublico servicoPublico = new ServicoPublico("Estação de Bombeiros", 300000);
		System.out.println(servicoPublico.toString());
		System.out.println();
		
		//parte do tabuleiro
		Tabuleiro tabuleiro = new Tabuleiro();
		Jogador jogador2 = new Jogador("Eric", "469.369.169-96", "aspas@prodigy-agency.gg", "https://youtu.be/dQw4w9WgXcQ?si=IQWm2jD_LDtZae7w");
		
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
			propriedade.setId(jogador1.getId()); //registra o id
			propriedade.setProprietario(jogador1.getNome()); //registra o nome
		}
		//System.out.println(jogador1.toString());
		//System.out.println(propriedade.toString());
		if (propriedade.getId() == 0) {
		System.out.println("n comprou, a Mojo Dojo Casa House n é pra qualquer um\n");
		//no caso n comprou pq n tinha dinheiro, a Mojo Dojo Casa House n é pra qualquer um
		}
		
		//se tiver a grana e a estacao n tiver dono
		if (jogador1.getDinheiro()>estacao.getPreco() && estacao.getId() == 0) {
			jogador1.addDinheiro(-estacao.getPreco()); //debita
			estacao.setId(jogador1.getId()); //registra o id
			estacao.setProprietario(jogador1.getNome()); //registra o nome
		}
		//System.out.println(jogador1.toString() + "\n");
		//System.out.println(estacao.toString());
		
		/*jogador2 vai comprar a propriedade, a estacao do jogador1, o servicoPublico e a propriedade
		  pq a LEV ta pagando*/
		jogador2.addDinheiro(9999999);
		if (jogador2.getDinheiro()>(estacao.getPreco() + propriedade.getPreco() 
								  + terreno.getPreco() + servicoPublico.getPreco())) {
			//adquirindo do jogador1
			jogador1.addDinheiro(estacao.getPreco() + 100000); 
			jogador2.addDinheiro(-(estacao.getPreco() + 100000));
			
			estacao.setId(jogador2.getId()); //registra o id
			estacao.setProprietario(jogador2.getNome()); //registra o nome
			
			//adquirindo o resto
			
			jogador2.addDinheiro(-terreno.getPreco()); //debita
			terreno.setId(jogador2.getId()); //registra o id
			terreno.setProprietario(jogador2.getNome()); //registra o nome
				
			jogador2.addDinheiro(-servicoPublico.getPreco()); //debita
			servicoPublico.setId(jogador2.getId()); //registra o id
			servicoPublico.setProprietario(jogador2.getNome()); //registra o nome
			
			jogador2.addDinheiro(-propriedade.getPreco()); //debita
			propriedade.setId(jogador2.getId()); //registra o id
			propriedade.setProprietario(jogador2.getNome()); //registra o nome
			
			/*obs: claramente ta muito repetitivo, mas eu só to testando aqui, em labs sequentes
				   provavelmente vão ter métodos para compra e venda*/
		}
		
		//testes de remove:
		//jogador1 deu ragequit
		tabuleiro.rmvJogador(jogador1);
		
		//Mojo Dojo Casa House confiscada
		tabuleiro.rmvPropriedade(propriedade);
		
		System.out.println("---Teste de Tabuleiro---");
		System.out.println("Numero de jogadores atuais: " + tabuleiro.getNumeroJogadores());
		System.out.println(tabuleiro.jogadores.toString() + "\n");
		System.out.println("Numero de propriedades em jogo : " + tabuleiro.getNumeroPropriedades());
		System.out.println(tabuleiro.propriedades.toString());
	}
	
}
