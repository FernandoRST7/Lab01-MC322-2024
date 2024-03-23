
public class Peca {
	
	//attributs
	private String cor;
	private int posicao = 0;	
	
	//construtor
	public Peca(String cor, int posicao) {
		this.cor = cor;
		this.posicao = posicao;
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
        return "Dados do Jogador:" + '\n' +
                "[cor = " + this.cor + '\n' +
                "posição = " + this.posicao + '\n' + ']';
	}
}
