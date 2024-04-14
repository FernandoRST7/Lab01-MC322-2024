
public class Terreno extends Propriedade{
	private int numeroCasas;
	private int valorCasa;
	private int valorHotel;
	private boolean hotel; //se tem ou n hotel (max 1 por propriedade)
	
	public Terreno(String nome, int preco, int valorCasa, int valorHotel) {
		super(nome, preco);
		this.numeroCasas = 0; //comeca com 0
		this.valorCasa = valorCasa; //permite cada propriedade a casa ter um valor diferente
		this.valorHotel = valorHotel; //msm ideia
		this.hotel = false; //a principio comeca sem hotel
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
	public boolean comprarCasa(Jogador jogador, int n) {
		if((this.getNumeroCasas() + n) < 4) {

			if (jogador.getDinheiro() >= n*this.getValorCasa()) {
				jogador.addDinheiro(-(n*this.getValorCasa()));
				this.addNumeroCasas(n);
				return true;
			} else return false;
		} else return false;
	}
	
	public boolean comprarCasa(int dinheiro) {
		if (dinheiro >= this.valorCasa) return true;
		/*ai a ideia seria contar o numero de casas e debitar o 
		 * dinheiro fora desse metodo, tipo:
		 * if (terreno.comprarCasa(jogador.dinheiro) && !(terreno.getNumeroCasas() < 4)) { //ter dinheiro e menos q 4 casas
		 * 		terreno.addNumeroCasas(1);
		 * 		jogador.setDinheiro(-terreno.getValorCasa());
		 * }*/
		else return false;
	}
	
	public boolean comprarHotel(Jogador jogador) {
		if(!this.getHotel()) {

			if (jogador.getDinheiro() >= this.getValorHotel()) {
				jogador.addDinheiro(-(this.getValorHotel()));
				this.setHotel(1);
				return true;
			} else return false;
		} else return false;
	}
	
	public boolean comprarHotel(int dinheiro) {
		if (dinheiro >= this.valorHotel) return true;
		/*ai a ideia seria contar o numero de casas/hoteis e debitar o 
		 * dinheiro fora desse metodo, tipo:
		 * if (terreno.comprarHotel(jogador.dinheiro) && !terreno.getHotel()) { //se tiver dinheiro e n tiver 1 hotel
		 * 		terreno.setNumeroCasas(0);
		 * 		terreno.setHotel(1);
		 * 		jogador.setDinheiro(-terreno.getValorHotel());
		 * }*/
		else return false;
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
		
        return "Dados do Terreno:" + '\n' + '\n' +
                "[nome = " + this.getNome() + '\n' +
                "proprietário = " + this.getProprietario() + '\n' +
                "preço = " + this.getPreco() + '\n' +
                "valor do aluguel = " + this.calcularAluguel() + '\n' +
                "id do proprietário = " + id + '\n' +
                "Número de Casas = " + this.numeroCasas + '\n' +
                "Valor de uma Casa = " + this.valorCasa + '\n' +
                "Valor de um Hotel = " + this.valorHotel + '\n' +
                "Tem Hotel? = " + hotel + ']';
    }
}
