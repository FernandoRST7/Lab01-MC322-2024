public class Estacao extends Propriedade {
	
	public Estacao(String nome, int preco, String descricao) {
		super(nome, preco, descricao);
	}
	
	public Estacao(String nome, int preco, String descricao, Jogador jogador) {
		super(nome, preco, descricao, jogador);
	}
	
	public int calcularAluguel() {
		return this.getPreco()*5/100; //5% do valor, to chutamdo q a estação vale mais
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
