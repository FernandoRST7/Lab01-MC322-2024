import java.util.ArrayList;
import java.util.List;

public class Jogador {
	private String nome;
	private String cpf;
	private String email;
	private String foto;
	private int dinheiro;
	private static int id_count = 0;
	private int id;
	private ArrayList<Carta> cartas;
	private Peca peca;
	
	
	// Construtor em que se adiciona a peca desde o comeco
	public Jogador ( String nome , String cpf , String email , String foto, String cor) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.foto = foto;
		this.dinheiro = 2558000;
		id_count++;
		this.id = id_count;
		this.cartas = new ArrayList<Carta>();
		this.peca = new Peca(cor);;
		}
	
	 // Getters e setters
	public int getId () {
		return id;
	}
	
	public int getDinheiro () {
		return dinheiro;
	}
	
	public void setDinheiro (int valor) {
		this.dinheiro = valor;
	}
	
	public void addDinheiro (int valor) {
		//se quiser debitar, passar um valor negativo
		this.dinheiro += valor;
	}
	
	public String getNome () {
	return nome;
	}
		
	public void setNome ( String nome ) {
	this . nome = nome;
	}
		
	public String getCpf () {
	return cpf;
	}
		
	public void setCpf ( String cpf ) {
	this . cpf = cpf;
	}
		
	public String getEmail () {
	return email;
	}
		
	public void setEmail ( String email ) {
	this . email = email;
	}
		
	public String getFoto () {
	return foto;
	}
		
	public void setFoto ( String foto ) {
	this . foto = foto;
	}
	
	public void setPeca(Peca peca) {
		this.peca = peca;
		//pro caso de setar depois de construir //[ou caso mude de peca(?)]
	}
	
	public Peca getPeca() {
		return peca;
	}
	
	public ArrayList<Carta> getCartas() {
		return cartas;
	}
	
	/*
	public boolean validaCPF()  e
	
	public boolean validaEmail() foram pra biblioteca dedicada
	*/
	
	@Override
    public String toString() {
        return "Dados do Jogador:" + '\n' + 
                "nome = " + this.nome + '\n' +
                "cpf = " + this.cpf + '\n' +
                "email = " + this.email + '\n' +
                "link da foto = " + this.foto + '\n' +
                "dinheiro = " + this.dinheiro + '\n' + 
                "id = " + this.id + '\n' + 
                "peça: " + this.peca.toString() + '\n' +
                "cartas possuidas:\n" + cartas.toString();
 
    }
	
	//associadores
	public void addCarta(Carta carta) {
		this.cartas.add(carta);
	}
	
	public void removeCarta(Carta carta) {
		this.cartas.remove(carta);
		//se der problema futuramente sobrescrever o metodo equals(Object o) de Carta ou mudar para indices
	}
}
