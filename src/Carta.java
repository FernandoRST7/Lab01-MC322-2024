public abstract class Carta {
	protected int id; //vai ser o id da carta, se eu quiser o id do jogador, puxa de dono
	protected String descricao;
	protected Jogador dono;
	protected static int id_count = 0;
	protected TipoCarta tipo;
	
	//Construtores
	 //versao em que a carta n tem dono, sera atribuida posteriormente e n tem tipo (nem sortre nem reves)
		public Carta (String descricao) {
			this.descricao = descricao;
			id_count++;
			this.id = id_count;
			this.dono = null;
			this.tipo = null;
		}
		  //versao em que a carta ja eh criada com um dono e n tem tipo (nem sortre nem reves)
		public Carta (String descricao, Jogador jogador) {
			this.descricao = descricao;
			id_count++;
			this.id = id_count;
			this.dono = jogador;
			this.tipo = null;
		}
	
	  //versao em que a carta n tem dono e sera atribuida posteriormente mas tem tipo
	public Carta (String descricao, TipoCarta tipo) {
		this.descricao = descricao;
		id_count++;
		this.id = id_count;
		this.dono = null;
		this.tipo = tipo;
	}
	  //versao em que a carta ja eh criada com um dono e com um tipo
	public Carta (String descricao, Jogador jogador, TipoCarta tipo) {
		this.descricao = descricao;
		id_count++;
		this.id = id_count;
		this.dono = jogador;
		this.tipo = tipo;
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
	
	public TipoCarta getTipo() {
		return tipo;
	}
	
	public Jogador getDono() {
		return dono;
	}
	
	public void setDono(Jogador dono) {
		//caso a carta mude de posse
		if (this.dono == null) {//se n tiver dono
			this.dono = dono;
			this.dono.addCarta(this);
		} else if (dono != null) {// se tiver
			this.trocarPosseCarta(dono, this.dono); //dono é o comprador (novo dono), this.dono (dono atual) é o vendedor
		} else if (dono == null){
			this.dono =null;
		}
	}
	
	public void trocarPosseCarta(Jogador comprador, Jogador vendedor) {
		vendedor.removeCarta(this);
		this.setDono(comprador);
	}
}
