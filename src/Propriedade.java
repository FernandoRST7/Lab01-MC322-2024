
public class Propriedade {
	private int id;
	private static int id_count = 0;
	private String nome;
	private String proprietario;
	private int preco;
	private Float aluguel;
	
	//construtor
	public Propriedade (String nome, String proprietario, int preco) {
		this.nome = nome;
		this.proprietario = proprietario;
		this.preco = preco;
		//talvez o id seja do proprietario, ai as 2 linhas a seguir serao apagadas, n entendi direito
		id_count++;
		this.id = id_count;
	}
		
	//Getters e setters
	public int getId () {
		return id;
	}
	
	public void setId(int id) { //n entendi direito pra q serve, o id é do proprietario, e n da propriedade?
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
	
	
	public int calcularAluguel() {
		
		return 0; //se n sei q tipo de propriedade é, n sei como calcular o aluguel
	}
}
