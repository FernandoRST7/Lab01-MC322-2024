
public class Main {

	public static void main(String[] args) {
		System.out.println("---Teste de Jogador---");
		Jogador jogador = new Jogador("Fernando", "801.754.450-28", "nokifa2208@ikumaru.com", "https://instagram/foto.com");
		
		//verifica o cpf
		if (jogador.validaCPF()) { 
			System.out.println("CPF válido;");
		} else {
			System.out.println("CPF inválido;");
		}
		
		//verifica o email
		
		if (jogador.validaEmail()) {
			System.out.println("email válido;\n");
		} else {
			System.out.println("email inválido;\n");
		}
		System.out.println(jogador.toString());
		System.out.println("");
		
		//teste de peca
		System.out.println("---Teste de Peca---");
		Peca peca = new Peca("preto", 0);
		System.out.println(peca.getCor());
		System.out.println(peca.getPosicao());
		System.out.println();
		
		//teste de carta
		System.out.println("---Teste de CartaSorte---");
		//no caso essa n move e não tem ação específica, coloquei aquele texto de role play
		CartaSorte carta = new CartaSorte(1, "Recebeu Herança!", 0, 1, 200000, 
				"sua tia rica morreu e voce recebeu a herança", true, "sem restrições");
		/*System.out.println(carta.getAcaoEspecifica());
		System.out.println(carta.getEfeito());
		System.out.println(carta.getId());
		System.out.println(carta.getMovimento());
		System.out.println(carta.getNome());
		System.out.println(carta.getUsoEspecifico());
		System.out.println(carta.getValor());
		System.out.println(carta.getUsoImediato());*/
		
		System.out.println(carta.toString());
		
	}
	
}
