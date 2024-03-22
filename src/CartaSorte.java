public class CartaSorte {
	private int id;
	private String nome;
	private int movimento; //0 se não movimentar;
	private int efeito; //-1:neg, 0:neu, 1:pos;
	private int valor; //valor>0: recebimento, valor<0: pagamento;
	private String acaoEspecifica; //descreve a ação;
	private boolean usoImediato; //true usa false não
	private String usoEspecifico; //descreve:
	/*as strings de especificidade com explicação em texto ainda
	 * preciso pensar melhor se vai ser texto msm, pq parece
	 * um tanti impratico*/
	
	//Construtor
	public CartaSorte (int id, String nome, int movimento, int efeito, int valor, String acaoEspecifica, boolean usoImediato, String usoEspecifico) {
		this.id = id;
		this.nome = nome;
		this.movimento = movimento;
		this.efeito = efeito;
		this.valor = valor;
		this.acaoEspecifica = acaoEspecifica;
		this.usoImediato = usoImediato;
		this.usoEspecifico = usoEspecifico;
	}
	
	//Getters e setters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
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
	
	public int getValor() {
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public String getAcaoEspecifica() {
		return acaoEspecifica;
	}
	
	public void setAcaoEspecufifica(String acaoEspecifica) {
		this.acaoEspecifica = acaoEspecifica;
	}
	
	public boolean getUsoImediato() {
		return usoImediato;
	}
	
	public void setUsoImediato(boolean usoImediato) {
		this.usoImediato = usoImediato;
	}
	
	public String getUsoEspecifico() {
		return usoEspecifico;
	}
	
	public void setUsoEspecufifico(String usoEspecifico) {
		this.usoEspecifico = usoEspecifico;
	}
	
	@Override
    public String toString() {
        return "Dados da Carta de Sorte:" + '\n' +
                "[id = " + this.id + '\n' +
                "nome = " + this.nome + '\n' +
                "movimento = " + this.movimento + '\n' +
                "efeito = " + this.efeito + '\n' +
                "valor = " + this.valor + '\n' +
                "ação específica = " + this.acaoEspecifica + '\n' +
                "uso imediato = " + this.usoImediato + '\n' +
                "uso específico = " + this.usoEspecifico + ']';
	}
}
