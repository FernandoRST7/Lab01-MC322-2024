import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	
	public static boolean validaCPF(String cpf) {
		//1. removendo caracteres n numericos
		cpf = cpf.replaceAll("\\.", "");
		cpf = cpf.replaceAll("-", "");
		
		//2. tem 11 digitos?
		if (cpf.length() != 11) {
			return false;
		}
		
		//3. todos os dígitos são iguais?
		for (int i = 1; i < 11; i++) {
			if (cpf.charAt(0) != cpf.charAt(i)) {
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
	
	public static boolean validaEmail(String email) {
		//os 2 if a seguir fazem a mesma coisa, mas queria testar os 2 jeitos
		if (email.indexOf("!") >= 0) return false;
		if (email.contains("&") || email.contains("=") || email.contains("_") || email.contains("_")
				 || email.contains("'") || email.contains("-") || email.contains("+")
				 || email.contains(",") || email.contains("<") || email.contains(">")) return false;
		
		int arrobas = 0;
		for (int i = 0; i <email.length(); i++) {
			if (email.charAt(i) == '@') arrobas++;
			if (arrobas > 1) return false;
			if (i!=email.length()-1) {
				if (email.charAt(i) == '.' && email.charAt(i+1) == '.') return false;
			}
			if (!(email.contains(".com") || email.contains(".br"))) return false;
		}
		return true;
	}

}
