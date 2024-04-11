public class Estacao extends Propriedade {
	
	public Estacao(String nome, int preco) {
		super(nome, preco);
	}
	
	public int calcularAluguel() {
		return this.getPreco()*5/100; //5% do valor, to chutamdo q a estação vale mais
	}
	
	@Override
    public String toString() {
		String id;
		if (this.getId() <= 0) id = "Sem proprietário";
		else id = Integer.toString(this.getId());
		
        return "Dados da Estação:" + '\n' + '\n' +
                "[nome = " + this.getNome() + '\n' +
                "proprietário = " + this.getProprietario() + '\n' +
                "preço = " + this.getPreco() + '\n' +
                "valor do aluguel = " + this.calcularAluguel() + '\n' +
                "id do proprietário = " + id + ']';
    }
}
