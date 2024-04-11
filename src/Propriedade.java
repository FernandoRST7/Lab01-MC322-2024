
public class Propriedade {
	private int id; //do jogador proprietario -> obs1 
	//private static int id_count = 0; -> seria o id da propriedade, mas mudei de ideia
	private String nome;
	private String proprietario;
	private int preco;
	private int aluguel; /*no pdf falava pra usar float em uma parte, mas como todos os outros valores relacionados
	 						a transacoes estavam em int, resolvi usar int por enquanto*/
	
	//construtor
	public Propriedade (String nome, int preco) {
		this.nome = nome;
		this.proprietario = "Sem proprietário"; //ao ser criada ainda n tem dono
		this.preco = preco;
		//this.aluguel = this.calcularAluguel(); n entendi muito o proposito de ter uma variavel do aluguel
		this.id = 0; //ao ser criada ainda n tem id
	}
		
	//Getters e setters
	public int getId () {
		return this.id;
	}
	
	public void setId(int id) { //n entendi direito pra q serve, conclusão: o id é do proprietario, e n da propriedade, obs1
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		//caso precise mudar o nome
		this.nome = nome;
	}
		
	public String getProprietario() {
		return proprietario;
	}
	
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	
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
	
	@Override
    public String toString() {
		String id;
		if (this.getId() <= 0) id = "Sem proprietário";
		else id = Integer.toString(this.id);
		
        return "Dados da Propriedade:" + '\n' + '\n' +
                "[nome = " + this.nome + '\n' +
                "proprietário = " + this.proprietario + '\n' +
                "preço = " + this.preco + '\n' +
                "valor do aluguel = " + this.calcularAluguel() + '\n' +
                "id do proprietário = " + id + ']';
    }
}
