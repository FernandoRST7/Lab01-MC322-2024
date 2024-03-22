import java.util.ArrayList;
import java.util.List;

public class Jogador {
	private String nome;
	private String cpf;
	private String email;
	private String foto;
	
	 // Construtor
	public Jogador ( String nome , String cpf , String email , String foto) {
	this . nome = nome;
	this . cpf = cpf;
	this . email = email;
	this . foto = foto;
	}
	
	 // Getters e setters
	public String getNome () {
	return nome;
	}
		
	public void setNome ( String nome ) {
	this . nome = nome;
	}
		
	public String getCpf () {
	return cpf;
	}
		
	public void setCpf ( String cpf ) {
	this . cpf = cpf;
	}
		
	public String getEmail () {
	return email;
	}
		
	public void setEmail ( String email ) {
	this . email = email;
	}
		
	public String getFoto () {
	return foto;
	}
		
	public void setFoto ( String foto ) {
	this . foto = foto;
	}
	
	
	public boolean validaCPF() {
		//1. removendo caracteres n numericos
		this.cpf = this.cpf.replaceAll("\\.", "");
		this.cpf = this.cpf.replaceAll("-", "");
		
		//2. tem 11 digitos?
		if (this.cpf.length() != 11) {
			return false;
		}
		
		//3. todos os dígitos são iguais?
		for (int i = 1; i < 11; i++) {
			if (this.cpf.charAt(0) != this.cpf.charAt(i)) {
				break;
			}
			if (i==11) return false;
		}
		
		//4. dígitos verificadores >:(
		List<Integer> Listaint = new ArrayList<>();
		int i = 0;
		while (i <11) {
			Listaint.add((int) cpf.charAt(i) - 48);
			i++;
		}
		
		int resto = (Listaint.get(0)*10 + Listaint.get(1)*9 + Listaint.get(2)*8 + Listaint.get(3)*7 +
						Listaint.get(4)*6 + Listaint.get(5)*5 + Listaint.get(6)*4 + Listaint.get(7)*3 + Listaint.get(8)*2)%11;
		
		int dezena = 0;
		if (!(resto == 0 || resto ==1)) {
			dezena = (dezena + (11-resto))*10;
		}
		
		if (dezena/10 != Listaint.get(9)) return false;
		
		int unidade = 0;
		int resto2 = (Listaint.get(0)*11 + Listaint.get(1)*10 + Listaint.get(2)*9 + Listaint.get(3)*8 +
				Listaint.get(4)*7 + Listaint.get(5)*6 + Listaint.get(6)*5 + Listaint.get(7)*4 + Listaint.get(8)*3 + Listaint.get(9)*2)%11;
		
		if (!(resto2 == 0 || resto2 ==1)) {
			unidade = (unidade + (11-resto2));
		}
		
		if (unidade != Listaint.get(10)) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean validaEmail() {
		//os 2 if a seguir fazem a mesma coisa, mas queria testar os 2 jeitos
		if (this.email.indexOf("!") >= 0) return false;
		if (this.email.contains("&") || this.email.contains("=") || this.email.contains("_") || this.email.contains("_")
				 || this.email.contains("'") || this.email.contains("-") || this.email.contains("+")
				 || this.email.contains(",") || this.email.contains("<") || this.email.contains(">")) return false;
		
		int arrobas = 0;
		for (int i = 0; i <this.email.length(); i++) {
			if (this.email.charAt(i) == '@') arrobas++;
			if (arrobas > 1) return false;
			if (i!=this.email.length()-1) {
				if (this.email.charAt(i) == '.' && this.email.charAt(i+1) == '.') return false;
			}
			if (!(this.email.contains(".com") || this.email.contains(".br"))) return false;
		}
		return true;
	}
	
	@Override
    public String toString() {
        return "Dados do Jogador:" + '\n' +
                "[nome = " + this.nome + '\n' +
                "cpf = " + this.cpf + '\n' +
                "email = " + this.email + '\n' +
                "link da foto = " + this.foto + ']';
    }
}
