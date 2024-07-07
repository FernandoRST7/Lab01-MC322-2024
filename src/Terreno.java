
public class Terreno extends Propriedade{
	private int numeroCasas;
	private int valorCasa;
	private int valorHotel;
	private boolean hotel; //se tem ou n hotel (max 1 por propriedade)
	
	public Terreno(String nome, int preco, int valorCasa, int valorHotel, String descricao) {
		super(nome, preco, descricao);
		this.numeroCasas = 0; //comeca com 0
		this.valorCasa = valorCasa; //permite cada propriedade a casa ter um valor diferente
		this.valorHotel = valorHotel; //msm ideia
		this.hotel = false; //a principio comeca sem hotel
		this.tipo = TipoCarta.TERRENO;
	}
	
	//Getters and setters
	public int getNumeroCasas() {
		return numeroCasas;
	}
	
	public void setNumeroCasas(int numero) {
		this.numeroCasas = numero;
	}
	
	public void addNumeroCasas(int numero) {
		this.numeroCasas += numero;
	}
	
	public int getValorCasa() {
		//retorna quanto vale a casa no terreno
		return valorCasa;
	}
	
	public void setValorCasa(int valor) {
		//caso seja nescessario mudar o valor da casa (acho q n vai)
		this.valorCasa = valor;
	}
	
	public int getValorHotel() {
		//retorna quanto vale a casa no terreno
		return valorHotel;
	}
	
	public void setValorHotel(int valor) {
		//caso seja nescessario mudar o valor do hotel (acho q n vai)
		this.valorHotel = valor;
	}
	
	public boolean getHotel() {
		return hotel;
	}
	
	public void setHotel(int quantidade) {
		if (quantidade > 0) this.hotel = true;
		else this.hotel = false;
	} //se tiver mais q 0 hoteis significa q tem hotel
	
	
	//metodos
	public void comprarCasa(Jogador jogador) throws SaldoNegativo {
		//se n puder comprar casa, seja por estar no maximo de casas ou por ter hotel nem entra aqui
		
			if (jogador.getDinheiro() >= this.valorCasa) {
				jogador.addDinheiro(-this.valorCasa);
				this.addNumeroCasas(1);
				System.out.println("Casa adquirida com sucesso!");
			} else { //se for negativo
				throw new SaldoNegativo("Saldo Insuficiente.");
			}
		
	}
	
	public void comprarHotel(Jogador jogador) throws SaldoNegativo{
		//se n puder comprar hotel, seja por n ter 4 casas ou por ja ter um hotel nem entra aqui
	
			if (jogador.getDinheiro() >= this.getValorHotel()) {
				jogador.addDinheiro(-(this.getValorHotel()));
				this.setHotel(1);
				System.out.println("Hotel adquirido com sucesso!");
			} else {
				throw new SaldoNegativo("Saldo insuficiente.");
			}
		
	}
	
	
	public int calcularAluguel() {
		/*int abc = 0;
		abc = this.getAluguel();*/
		int aluguel = this.getPreco()/100;
		
		if (this.hotel) aluguel += 2*this.valorHotel; //n sei se realmente eh assim q vai funcionar, mas por enquanto vai ser
		else aluguel += (this.valorCasa*2*this.numeroCasas); //por casa ta valorizando d+, Q isso (Hotel tbm)
		
		return aluguel; //vou fzr ainda
	}
	
	@Override
    public String toString() {
		String id;
		if (this.getId() <= 0) id = "Sem proprietário";
		else id = Integer.toString(this.getId());
		
		String hotel;
		if (this.hotel) hotel = "Sim";
		else hotel = "Não";
		
		String dono;
		if (this.getDono() == null) dono = "Sem dono";
		else dono = this.getDono().getNome();
		
        return "Terreno:" + '\n' + 
                "nome = " + this.getNome() + '\n' +
                "proprietário = " + dono + '\n' +
                "preço = " + this.getPreco() + '\n' +
                "valor do aluguel = " + this.calcularAluguel() + '\n' +
                "id da carta = " + id + '\n' +
                "Número de Casas = " + this.numeroCasas + '\n' +
                "Valor de uma Casa = " + this.valorCasa + '\n' +
                "Valor de um Hotel = " + this.valorHotel + '\n' +
                "Tem Hotel? = " + hotel + '\n' + '\n';
    }
}
