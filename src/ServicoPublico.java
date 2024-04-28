public class ServicoPublico extends Propriedade {
	
	ServicoPublico(String nome, int preco, String descricao) {
		super(nome, preco, descricao);
	}
	
	ServicoPublico(String nome, int preco, String descricao, Jogador jogador) {
		super(nome, preco, descricao, jogador);
	}
	
	public int calcularAluguel(int dado) {
		return this.getPreco()*5/100*dado; /*5% do valor multiplicado pelo dado tirado pra chegar ali 
												em vez de ter caracteristicas muito especificas*/
	}
	
	public int calcularAluguel() {
		return this.getPreco()*5/100*1; //se n passar nada vou assumir o mínimo q é 1
	}
	
	@Override
    public String toString() {
		String id;
		if (this.getId() <= 0) id = "Sem proprietário";
		else id = Integer.toString(this.getId());
		
		String dono;
		if (this.getDono() == null) dono = "Sem dono";
		else dono = this.getDono().getNome();
		
        return "ServiçoPúblico:" + '\n' +
                "nome = " + this.getNome() + '\n' +
                "proprietário = " + dono + '\n' +
                "preço = " + this.getPreco() + '\n' +
                "valor do aluguel = " + this.calcularAluguel() + '\n' +
                "id da carta = " + id + '\n' + '\n';
    }
}

