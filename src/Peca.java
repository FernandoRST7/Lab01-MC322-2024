
public class Peca {
	
	//attributs
	private String cor;
	private int posicao;	
	
	//construtor
	public Peca(String cor) {
		this.cor = cor;
		this.posicao = 0;
	}
	
	//setter
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	
	//getter
	public String getCor() {
		return cor;
	}
	
	public int getPosicao() {
		return posicao;
	}
	
	@Override
    public String toString() {
        return  "cor = " + this.cor + ", " +
                "posição = " + this.posicao;
	}
}
