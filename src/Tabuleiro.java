import java.util.ArrayList;

public class Tabuleiro {
	private ArrayList<Jogador> jogadores;
	private ArrayList<Propriedade> propriedades;
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
	
	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}
	
	public ArrayList<Propriedade> getPropriedades() {
		return propriedades;
	}
	
	//outros
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
	
	public void printJogadores() {
		for (int i = 0; i < jogadores.size(); i++) {
			System.out.println(jogadores.get(i).getNome());
		}
	}
	
	public void printPropriedades() {
		for (int i = 0; i < propriedades.size(); i++) {
			System.out.println(propriedades.get(i).getNome());
		}
	}
}
