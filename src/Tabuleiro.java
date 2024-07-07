import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Tabuleiro implements Salvavel{
	private ArrayList<Jogador> jogadores;
	private ArrayList<Propriedade> propriedades;
	private ArrayList<CartaSorte> cartasSorte;
	//public static int jogando = 0; -> só dar.size
	//public static int existindo = 0;
	private File file;
	private ArrayList<Carta> casas;
	
	public Tabuleiro() {
		this.jogadores = new ArrayList<Jogador>();
		this.propriedades = new ArrayList<Propriedade>();
		this.cartasSorte = new ArrayList<CartaSorte>();
		
		for (int i = 0; ; i++) {
            String fileName = "log" + i + ".txt"; //File logFile = new File("D:\\UNICAMP\\3° Semestre\\MC322\\Lab01-\\src\\Log.txt");
            File file = new File(fileName);

            if (!file.exists()) {
                try {
                    Formatter output = new Formatter(file);
                    System.out.println("Arquivo criado: " + fileName);
                    // Faça o que precisa com o arquivo aqui
                    this.file = file;
                    output.close();
                    break; // Saia do loop quando encontrar um nome disponível
                } catch (IOException e) {
                    System.err.println("Erro ao criar o arquivo: " + e.getMessage());
                }
            }
		}
		
		this.addCartaSorte(new CartaSorte("Sorte!", 1, 1, 200000,"Recebeu Heranca!", true, 
				"sem restrições", "uma carta que da dinheiro ao jogador e anda uma casa para frente", TipoCarta.SORTE));
		this.addCartaSorte(new CartaSorte("Reves!", 0, -1, 10000, "Bateu o carro sem seguro!", true, 
			"sem restrições", "uma carta que tira dinheiro do jogador", TipoCarta.REVES));
		this.addCartaSorte(new CartaSorte("Sorte do Destino", 1, 1, 150000, "Encontrou dinheiro na rua!", true,
			    "sem restrições", "uma carta que dá dinheiro ao jogador e avança uma casa", TipoCarta.SORTE));
		this.addCartaSorte(new CartaSorte("Fortuna do Tigre!", 2, 1, 180000, "Ganhou na loteria do cassino!", true,
			    "sem restrições", "uma carta que dá dinheiro ao jogador e avança duas casas", TipoCarta.SORTE));
		this.addCartaSorte(new CartaSorte("Revés Financeiro", 0, -1, 20000, "Despesas inesperadas!", true,
			    "sem restrições", "uma carta que tira dinheiro do jogador", TipoCarta.REVES));
		this.addCartaSorte(new CartaSorte("Revés no Trânsito", 0, -1, 25000, "Multa por excesso de velocidade!", true,
			    "sem restrições", "uma carta que tira dinheiro do jogador", TipoCarta.REVES));
		this.addCartaSorte(new CartaSorte("Revés Financeiro", 0, -1, 20000, "Despesas inesperadas!", true,
			    "sem restrições", "uma carta que tira dinheiro do jogador", TipoCarta.REVES));
		this.addCartaSorte(new CartaSorte("Ganhos compartilhados", 0, 0, 1, "Use a qualquer momento para ganhar metade dos ganhos de outro jogador.", false,
			    "Apenas quando outro jogador ganhar dinheiro atraves de uma carta de sorte", "uma carta que tira dinheiro do jogador", TipoCarta.SORTE));
			
		this.casas = new ArrayList<Carta>(); //fiz 30 casas q acho q ta de bom tamanho
		//null = casas de sorte ou reves
		
		this.casas.add(new Propriedade("Inicio", 2147483647, "casa 0, todos começam aqui e nao pode ser comprada"));
		this.casas.add(new Estacao("Liberdade", 500000, "carta de estação", 1500));
		this.casas.add(new Terreno("Céu Azul", 200000, 30000, 150000, "carta de terreno"));
		this.casas.add(null);
		this.casas.add(new Terreno("Jardim das Flores", 180000, 25000, 130000, "Carta de terreno"));
		this.casas.add(new Terreno("Rua da Amizade", 220000, 28000, 140000, "Carta de terreno"));
		this.casas.add(null);
		this.casas.add(new ServicoPublico("Estação de Bombeiros", 300000, "carta de propriedade"));
		this.casas.add(new Estacao("Estação Central", 400000, "Carta de estação", 1200));
		this.casas.add(new Terreno("Mojo Dojo Casa House", 3000000, 40000, 200000, "A melhor propriedadae possivel"));
		
		this.casas.add(new Terreno("Avenida Principal", 300000, 35000, 180000, "Carta de terreno"));
		this.casas.add(null);
		this.casas.add(new ServicoPublico("Companhia de Água", 250000, "Carta de propriedade"));
		this.casas.add(new Terreno("Rua dos Sonhos", 250000, 32000, 160000, "Carta de terreno"));
		this.casas.add(null);
		this.casas.add(new Terreno("Alameda das Estrelas", 280000, 29000, 150000, "Carta de terreno"));
		this.casas.add(new Estacao("Estação do Norte", 350000, "Carta de estação", 1100));
		this.casas.add(new ServicoPublico("Companhia de Eletricidade", 280000, "Carta de propriedade"));
		this.casas.add(null);
		this.casas.add(new Terreno("Praça do Sol", 260000, 31000, 155000, "Carta de terreno"));
		
		this.casas.add(null);
		this.casas.add(new Terreno("Avenida da Lua", 290000, 33000, 170000, "Carta de terreno"));
		this.casas.add(new ServicoPublico("Companhia de Gás", 270000, "Carta de propriedade"));
		this.casas.add(null);
		this.casas.add(new Terreno("Travessa das Maravilhas", 240000, 27000, 140000, "Carta de terreno"));
		this.casas.add(new Terreno("Largo dos Desejos", 270000, 30000, 165000, "Carta de terreno"));
		this.casas.add(new Estacao("Estação do Sul", 300000, "Carta de estação", 1000));
		this.casas.add(null);
		this.casas.add(new ServicoPublico("Companhia de Telefonia", 260000, "Carta de propriedade"));
		this.casas.add(new Estacao("Estação Oeste", 320000, "Carta de estação", 1050));
		//ficou um tanto repetitivo, mas n vi outro eito de criar o tabuleiro.
	}
	
	//da interface
	public void salvaLog(String registro) {
		/*try {
            Formatter formatter = new Formatter(this.file);
            formatter.format("%s%n", registro); // Escreve a string no arquivo
            formatter.close();
            System.out.println("Registro gravado no arquivo.");
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
        }*/
		
		 try {
		        FileWriter fileWriter = new FileWriter(file, true); // Abre o arquivo em modo de anexação
		        PrintWriter printWriter = new PrintWriter(fileWriter);
		        printWriter.println(registro); // Escreve a string no arquivo seguida de uma nova linha
		        printWriter.close();
		        System.out.println("Registro gravado no arquivo.");
		    } catch (IOException e) {
		        System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
		    }
    }
	
	
	//Getters and setters
	public int getNumeroJogadores() {
		return this.jogadores.size();
	}
	
	
	public int getNumeroPropriedades() {
		return this.propriedades.size();
	}
	
	public int getNumeroCartasSorte() {
		return this.cartasSorte.size();
	}
	
	public int getNumeroCasas() {
		return this.casas.size();
	}
	
	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}
	
	public ArrayList<Propriedade> getPropriedades() {
		return propriedades;
	}
	
	public ArrayList<CartaSorte> getCartasSorte() {
		return cartasSorte;
	}
	
	public ArrayList<Carta> getCasas() {
		return casas;
	}
	
	//nesses aqui tava falando pra passar um int e retornar um bool, mas tbm n faz sentido pra mim iso
	public void addJogador(Jogador jogador) {
		jogadores.add(jogador);
		//jogando++;
	}
	//outros
	public void rmvJogador(Jogador jogador) {
		jogadores.remove(jogador);
		jogadores.trimToSize();
		//jogando--;
	}
	
	public void addPropriedade(Propriedade propriedade) {
		propriedades.add(propriedade);
	}
	
	public void rmvPropriedade(Propriedade propriedade) {
		propriedades.remove(propriedade);
		propriedades.trimToSize();
	}
	
	public void addCartaSorte(CartaSorte carta) {
		cartasSorte.add(carta);
	}
	
	public void rmvCartaSorte(CartaSorte carta) {
		cartasSorte.remove(carta);
		cartasSorte.trimToSize();
	}
	
	public void addCasa(Carta carta) {
		casas.add(carta);
	}
	
	public void rmvCasa(Carta carta) {
		casas.remove(carta);
		casas.trimToSize();
	}
	
	public void printJogadores() {
		for (int i = 0; i < jogadores.size(); i++) {
			System.out.println(jogadores.get(i).getNome());
		}
	}
	
	public void printPropriedades() {
		for (int i = 0; i < propriedades.size(); i++) {
			System.out.println(propriedades.get(i).getNome());
		}
	}
	
	public void distribuirCartas(Jogador jogador) {
		/*n tem nada sobre distribuir cartas para todos os jogadores no monopoly, 
		 * entao oque vai acontecer aqui é o jogador comprar uma carta de sorte ou
		 * reves quando cair na casa de sorte ou reves*/
		Random gerador = new Random();
		int numeroAleatorio = gerador.nextInt(this.cartasSorte.size());
		this.cartasSorte.get(numeroAleatorio).executaAcao(jogador);
		this.salvaLog("Jogador " + jogador.getNome() + " comprou uma carta de " + this.cartasSorte.get(numeroAleatorio).getTipo());
	}
	
	public int girarDado() {
		Random gerador = new Random();
		int dado1 = gerador.nextInt(6)+1;
		int dado2 = gerador.nextInt(6)+1;
		return dado1 + dado2;
	}
	
	public void pagarAluguel(Jogador pagador, Propriedade propriedade, int dado){
		int aluguel = 0;
		if (propriedade.getTipo() == TipoCarta.TERRENO) {
			Terreno terreno = (Terreno) propriedade;
			aluguel = terreno.calcularAluguel();
			
		} else if(propriedade.getTipo() == TipoCarta.ESTACAO) {
			Estacao estacao = (Estacao) propriedade;
			aluguel = estacao.calcularAluguel();
			
		} else {
			ServicoPublico servicoPublico = (ServicoPublico) propriedade;
			aluguel = servicoPublico.calcularAluguel(dado);
		}
		
		try {
			pagador.addDinheiro(-aluguel);
			if (pagador.getDinheiro() >= 0) {
				propriedade.getDono().addDinheiro(aluguel);
				System.out.println("Aluguel de " + aluguel + " pago de " + pagador.getNome() + " para " + propriedade.getDono().getNome() + ".");
				System.out.println("Salddo de " + pagador.getNome() + ":" + pagador.getDinheiro());
				System.out.println("Salddo de " + propriedade.getDono().getNome() + ":" + propriedade.getDono().getDinheiro());
				this.salvaLog("Aluguel de " + aluguel + " pago de " + pagador.getNome() + " para " + propriedade.getDono().getNome() + ".");
			} else {
				throw new SaldoNegativo("Saldo insuficiente, jogador vai a falencia.");
			}
	
		} catch(SaldoNegativo e) {
			//quando falir da todo o dinheiro e libera as propriedade que tinha (n vou fzr o ngc de hipotece nn, mt trampo)
			System.err.println("Erro ao pagar o aluguel: " +e.getMessage());
			int saldo = pagador.getDinheiro();
			pagador.setDinheiro(0);
			propriedade.getDono().addDinheiro(saldo); //paga tudo que tem
			for(Carta carta: pagador.getCartas()) {
				carta.setDono(null); //não é mais dono
				pagador.removeCarta(carta);
			}
			//this.rmvJogador(pagador); //faliu = saiu do jogo // VAI REMOVER AQUI OU NA MAIN??? //na main.
			this.salvaLog("Jogador " + pagador.getNome() + " faliu e será removido no final do turno.");
		}
	}
	
	public void comprarPropriedade(Jogador jogador, Propriedade propriedade){
		
		//verifica se já tem dono
		if (propriedade.getDono() != null) {
			System.out.println("Propriedade já tem dono.");
		} else {
			try {
				//verifica se tem dinheiro
				if (jogador.getDinheiro() >= propriedade.getPreco()) {
					jogador.addDinheiro(-propriedade.getPreco());
					jogador.addCarta(propriedade);
					propriedade.setDono(jogador);
					System.out.println("propriedade comprada com sucesso.");
				} else {
					throw new SaldoNegativo("Saldo insuficiente.");
				}
			} catch (SaldoNegativo e) {
				System.err.println("Erro ao comprar propriedade: " + e.getMessage());
			}
		}
	}
	
	public boolean comprar() {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			try {
				int comando = scanner.nextInt();
				scanner.nextLine();
				if (comando == 2) {
					return false;
				} else if (comando == 1) {
					return true;
				} else {
					System.out.println("Comando invalido, digite apenas apenas o numero 1 ou o numero 2.");
				}
				scanner.close();
			} catch (InputMismatchException e) {
                System.err.println("Entrada inválida. Por favor, insira um número.");
                
                 // Consumir a entrada inválida
            }
				
		}
		
	}
}
