public class CartaSorte extends Carta {
	private String nome;
	private int movimento; //0 se não movimentar;
	private int efeito; //-1:neg, 0:neu, 1:pos;
	private float valor; //valor>0: recebimento, valor<0: pagamento;
	private String acao; //descreve a ação; (tava como acaoEspecifica
	private boolean tempo; //true usa false não, no pdf fala pra colocar int, mas acho boolean melhor, tmj (tava como usoImediato)
	private String restricao; //descreve: (tava como usoEspecifico antes)
	/*as strings de especificidade com explicação em texto ainda
	 * preciso pensar melhor se vai ser texto msm, pq parece
	 * um tanto impratico*/
	
	//Construtor
	public CartaSorte (String nome, int movimento, int efeito, float valor, String acao, 
						boolean tempo, String restricao, String descricao) {
		super(descricao);
		this.nome = nome;
		this.movimento = movimento;
		this.efeito = efeito;
		this.valor = valor;
		this.acao = acao;
		this.tempo = tempo;
		this.restricao = restricao;
	}
	
	//Construtor
		public CartaSorte (String nome, int movimento, int efeito, float valor, String acao, 
							boolean tempo, String restricao,
							String descricao, Jogador jogador) {
			super(descricao, jogador);
			this.nome = nome;
			this.movimento = movimento;
			this.efeito = efeito;
			this.valor = valor;
			this.acao = acao;
			this.tempo = tempo;
			this.restricao = restricao;
		}
	
	//Getters e setters
	
	/*public int getId() {
		return id;
	}
	usa o da superclasse*/
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getMovimento() {
		return movimento;
	}
	
	public void setMovimento(int movimento) {
		this.movimento = movimento;
	}
	
	public int getEfeito() {
		return efeito;
	}
	
	public void setEfeito(int efeito) {
		this.efeito = efeito;
	}
	
	public float getValor() {
		return valor;
	}
	
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public String getAcao() {
		return acao;
	}
	
	public void setAcao(String acao) {
		this.acao = acao;
	}
	
	public boolean getTempo() {
		return tempo;
	}
	
	public void setTempo(boolean tempo) {
		this.tempo = tempo;
	}
	
	public String getRestricao() {
		return restricao;
	}
	
	public void setRestricao(String restricao) {
		this.restricao = restricao;
	}
	
	@Override
    public String toString() {
        return "Dados da Carta de Sorte:" + '\n' +
                "[id = " + this.id + '\n' +
                "nome = " + this.nome + '\n' +
                "movimento = " + this.movimento + '\n' +
                "efeito = " + this.efeito + '\n' +
                "valor = " + this.valor + '\n' +
                "ação específica = " + this.acao + '\n' +
                "uso imediato = " + this.tempo + '\n' +
                "uso específico = " + this.restricao + ']';
	}
}
