public abstract class Carta {
	protected int id; //vai ser o id da carta, se eu quiser o id do jogador, puxa de dono
	protected String descricao;
	protected Jogador dono;
	protected static int id_count = 0;
	
	//Construtores
	  //versao em que a carta n tem dono e sera atribuida posteriormente
	public Carta (String descricao) {
		this.descricao = descricao;
		id_count++;
		this.id = id_count;
		this.dono = null;
	}
	  //versao em que a carta ja eh criada com um dono
	public Carta (String descricao, Jogador jogador) {
		this.descricao = descricao;
		id_count++;
		this.id = id_count;
		this.dono = jogador;
	}
	
	//getters e setters
	public int getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
		//se por algum motivo for necessario alterar a descricao
	}
	
	public Jogador getDono() {
		return dono;
	}
	
	public void setDono(Jogador dono) {
		//caso a carta mude de posse
		if (this.dono == null) {//se n tiver dono
			this.dono = dono;
			this.dono.addCarta(this);
		} else {// se tiver
			this.trocarPosseCarta(dono, this.dono); //dono é o comprador (novo dono), this.dono (dono atual) é o vendedor
		}
	}
	
	public void trocarPosseCarta(Jogador comprador, Jogador vendedor) {
		vendedor.removeCarta(this);
		this.setDono(comprador);
	}
}
