
public class Terreno extends Propriedade{
	private int numeroCasas;
	private int valorCasa;
	private int valorHotel;
	private boolean hotel; //se tem ou n hotel (max 1 por propriedade)
	
	public Terreno(String nome, String proprietario, int preco, int valorCasa, int valorHotel) {
		super(nome, proprietario, preco);
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
	}
	
	
	//metodos
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
		return 0; //vou fzr ainda
	}
}
