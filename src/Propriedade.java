
public class Propriedade extends Carta{
	private String nome;
	private int preco;
	private int aluguel; /*no pdf falava pra usar float em uma parte, mas como todos os outros valores relacionados
	 						a transacoes estavam em int, resolvi usar int por enquanto*/
	//private Jogador dono; --> todas as minhas cartas tem isso já
	
	
	//construtor
	public Propriedade (String nome, int preco, String descricao) {
		super(descricao);
		this.nome = nome;
		this.preco = preco;
		//this.aluguel = this.calcularAluguel(); n entendi muito o proposito de ter uma variavel do aluguel
		this.tipo = TipoCarta.PROPRIEDADE;
	}
	
	public Propriedade (String nome, int preco, String descricao, Jogador jogador) {
		super(descricao, jogador);
		this.nome = nome;
		this.preco = preco;
		this.tipo = TipoCarta.PROPRIEDADE;
	}

		
	//Getters e setters
	
		/*public int getId() {
			return id;
		}
		usa do da superclasse*/
	
	public String getNome() {
		if (nome == null) return "sem dono";
		else return nome;
	}
	
	public void setNome(String nome) {
		//caso precise mudar o nome
		this.nome = nome;
	}
		
	/*public Jogador getProprietario() {
		return this.getDono();
	}
	isso aqui mudou pra getDono da superclasse*/
	
	/* 
	 	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	isso aqui mudou pra setDono da superclasse*/
	
	public int getPreco() {
		return preco;
	}
	
	public void setPreco(int preco) {
		//caso troque o preco
		this.preco = preco;
	}
	
	public int getAluguel() {
		return aluguel;
	} //fiz isso pra acessar, mas n deu certo, ent mudei o aluguel pra protected
		
	public int calcularAluguel() {
		return this.preco/100; //1% do valor do imóvel
	}
	
	public TipoCarta getTipo() {
		return tipo;
	}
	
	@Override
    public String toString() {
		String id;
		if (this.getId() <= 0) id = "Sem proprietário";
		else id = Integer.toString(this.id);
		
		String dono;
		if (this.getDono() == null) dono = "Sem dono";
		else dono = this.getDono().getNome();
		
        return "Propriedade:" + '\n' +
                "nome = " + this.nome + '\n' +
                "proprietário = " + dono + '\n' +
                "preço = " + this.preco + '\n' +
                "valor do aluguel = " + this.calcularAluguel() + '\n' +
                "id da carta = " + id + + '\n' + '\n';
    }
}
