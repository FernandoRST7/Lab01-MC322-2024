public class Estacao extends Propriedade {
	private int tarifa;
	
	//construtores
	public Estacao(String nome, int preco, String descricao, int tarifa) {
		super(nome, preco, descricao);
		this.tarifa = tarifa;
		this.tipo = TipoCarta.ESTACAO;
	}
	
	public Estacao(String nome, int preco, String descricao, Jogador jogador, int tarifa) {
		super(nome, preco, descricao, jogador);
		this.tarifa = tarifa;
		this.tipo = TipoCarta.ESTACAO;
	}
	
	//metodos
	public int calcularAluguel() {
		return tarifa*10; //5% do valor, to chutamdo q a estação vale mais
	}
	
	@Override
    public String toString() {
		String id;
		if (this.getId() <= 0) id = "Sem proprietário";
		else id = Integer.toString(this.getId());
		
		String dono;
		if (this.getDono() == null) dono = "Sem dono";
		else dono = this.getDono().getNome();
		
        return "Estação:" + '\n' + 
                "nome = " + this.getNome() + '\n' +
                "proprietário = " + dono + '\n' +
                "preço = " + this.getPreco() + '\n' +
                "valor do aluguel = " + this.calcularAluguel() + '\n' +
                "id da carta = " + id + '\n' + '\n';
    }
}
