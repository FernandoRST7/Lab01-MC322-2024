import java.util.ArrayList;

public class Tabuleiro {
	public ArrayList<Jogador> jogadores; //no pdf era ArrayList<int>, mas n faz muito sentido isso pra mim
	public ArrayList<Propriedade> propriedades;
	//public static int jogando = 0; -> só dar.size
	//public static int existindo = 0;
	
	public Tabuleiro() {
		this.jogadores = new ArrayList<Jogador>();
		this.propriedades = new ArrayList<Propriedade>();
	}
	
	//Getters and setters
	public int getNumeroJogadores() {
		return this.jogadores.size();
	}
	
	public int getNumeroPropriedades() {
		return this.propriedades.size();
	}
	
	//nesses aqui tava falando pra passar um int e retornar um bool, mas tbm n faz sentido pra mim iso
	public void addJogador(Jogador jogador) {
		jogadores.add(jogador);
		//jogando++;
	}
	
	public void rmvJogador(Jogador jogador) {
		jogadores.remove(jogador);
		//jogando--;
	}
	
	
	public void addPropriedade(Propriedade propriedade) {
		propriedades.add(propriedade);
	}
	
	public void rmvPropriedade(Propriedade propriedade) {
		propriedades.remove(propriedade);
	}
}
