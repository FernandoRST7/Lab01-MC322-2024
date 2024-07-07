import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro();
        // Adiciona as cartas de sorte ou reve automaticamente
        // Adiciona as propriedades automaticamente

        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o modo de jogo (apenas o numero): \n1.Automatico \n2.Manual");

        int tipo = 0;
        while (true) {
            try {
                tipo = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha
                break; // Sai do loop se a entrada for válida
            } catch (InputMismatchException e) {
                System.err.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine(); // Consumir a entrada inválida
            }
        }

        while (true) {
            if (tipo == 1) {
                // Adiciona 2 jogadores para teste
                tabuleiro.addJogador(new Jogador("Fernando", "801.754.450-28", "nokifa2208@ikumaru.com", "https://instagram/foto.com", "preto"));
                tabuleiro.addJogador(new Jogador("Eric", "469.369.169-96", "aspas@prodigy-agency.gg", "https://youtu.be/dQw4w9WgXcQ?si=IQWm2jD_LDtZae7w", "azul"));
                break;
            } else if (tipo == 2) {
                while (true) {
                    System.out.println("Digite o comando (apenas o numero): \n1.Adicionar jogador \n2.Parar");
                    int comando = 0;
                    try {
                        comando = scanner.nextInt();
                        scanner.nextLine(); // Consumir a quebra de linha
                    } catch (InputMismatchException e) {
                        System.err.println("Entrada inválida. Por favor, insira um número.");
                        scanner.nextLine(); // Consumir a entrada inválida
                        continue;
                    }

                    if (comando == 2) {
                        System.out.println("Fim das configurações.");
                        break;
                    } else if (comando == 1) {
                        System.out.println("Insira os dados no formato: nome, cpf, email, foto, cor");
                        String dados = scanner.nextLine();
                        String[] partes = dados.split(", ");

                        while (partes.length < 5 || !Biblioteca.validaCPF(partes[1])) {
                            System.out.println("CPF inválido, digite um novo cpf.");
                            partes[1] = scanner.nextLine();
                        }
                        System.out.println("CPF válido.");

                        while (!Biblioteca.validaEmail(partes[2])) {
                            System.out.println("Email inválido, digite um novo email.");
                            partes[2] = scanner.nextLine();
                        }
                        System.out.println("Email válido.");

                        tabuleiro.addJogador(new Jogador(partes[0], partes[1], partes[2], partes[3], partes[4]));
                    }
                }
                break;
            } else {
                System.out.println("Comando inválido, digite apenas o número 1 ou o número 2.");
            }
        }

        // Começa o jogo
        while (true) {
            if (tabuleiro.getNumeroJogadores() == 1) {
            	System.out.println("Jogador " + tabuleiro.getJogadores().get(0).getNome() + " venceu!!!");
            	tabuleiro.salvaLog("Jogador " + tabuleiro.getJogadores().get(0).getNome() + " venceu!!!");
                break;
            }

            for (int i = 0; i < tabuleiro.getNumeroJogadores(); i++) {
                Jogador jogador = tabuleiro.getJogadores().get(i);
                System.out.println("Turno de " + jogador.getNome());

                int dado = tabuleiro.girarDado();
                System.out.println("Tirou " + dado + " nos dados!");
                jogador.getPeca().move(dado);
                tabuleiro.salvaLog("Jogador" + jogador.getId() + " andou " + dado);

                int posicao = jogador.getPeca().getPosicao();
                if (posicao >= 30) {
                    posicao -= 30;
                    jogador.getPeca().setPosicao(posicao);
                }

                Carta casa = tabuleiro.getCasas().get(posicao);

                if (casa != null) {
                    Propriedade propriedade = (Propriedade) casa;
                    tabuleiro.salvaLog("Jogador" + (i + 1) + " está na propriedade " + propriedade.getNome());

                    if (propriedade.getDono() != null) {
                        if (propriedade.getDono() == jogador) {
                            System.out.println("Propriedade já pertence ao jogador.");
                            if (propriedade.getTipo() == TipoCarta.TERRENO) {
                                Terreno terreno = (Terreno) propriedade;
                                if (terreno.getNumeroCasas() < 4 && !terreno.getHotel()) {
                                    System.out.println("Está na propriedade " + propriedade.getNome() + ", deseja comprar uma casa? Digite \n1.Sim \n2.Não.");
                                    if (tabuleiro.comprar()) {
                                        try {
                                            terreno.comprarCasa(jogador);
                                            tabuleiro.salvaLog("Jogador" + (i + 1) + " comprou uma casa.");
                                        } catch (SaldoNegativo e) {
                                            System.err.println("Erro ao comprar casa: " + e.getMessage());
                                        }
                                    }
                                } else if (terreno.getNumeroCasas() == 4 && !terreno.getHotel()) {
                                    System.out.println("Está na propriedade " + propriedade.getNome() + ", deseja comprar um hotel? Digite \n1.Sim \n2.Não.");
                                    if (tabuleiro.comprar()) {
                                        try {
                                            terreno.comprarHotel(jogador);
                                            tabuleiro.salvaLog("Jogador" + (i + 1) + " comprou um hotel.");
                                        } catch (SaldoNegativo e) {
                                            System.err.println("Erro ao comprar hotel: " + e.getMessage());
                                        }
                                    }
                                }
                            }
                        } else {
                            tabuleiro.pagarAluguel(jogador, propriedade, dado);
                        }
                    } else if (!(propriedade.getNome().equals("Inicio"))){
                        System.out.println("Está na propriedade " + propriedade.getNome() + ", deseja comprá-la? Digite \n1.Sim \n2.Não.");
                        if (tabuleiro.comprar()) tabuleiro.comprarPropriedade(jogador, propriedade);
                    }
                } else {
                    tabuleiro.distribuirCartas(jogador);
                }

                System.out.println("A rodada foi concluída, deseja verificar algum status? Digite \n1.Sim \n2.Não.");
                //int resposta = 0;
                
                /*while (true) {
                    try {
                        resposta = scanner.nextInt();
                        scanner.nextLine(); // Consumir a quebra de linha
                        break;
                    } catch (InputMismatchException e) {
                        System.err.println("Entrada inválida. Por favor, insira um número.");
                        scanner.nextLine(); // Consumir a entrada inválida
                    }
                }*/
                int resposta = scanner.nextInt();

                //scanner.nextLine(); // Consumir a quebra de linha

               

                if (resposta == 1) {
                    while (true) {
                        System.out.println("Digite o número da opção desejada: \n1.Jogadores \n2.Propriedades \n3.Sair");
                        int comando = 0;
                        try {
                            comando = scanner.nextInt();
                            scanner.nextLine(); // Consumir a quebra de linha
                        } catch (InputMismatchException e) {
                            System.err.println("Entrada inválida. Por favor, insira um número.");
                            scanner.nextLine(); // Consumir a entrada inválida
                            continue;
                        }

                        if (comando == 3) {
                            break;
                        } else if (comando == 1) {
                            
                            System.out.println("Gostaria de averiguar algum jogador específico? Digite \n1.Sim \n2.Não.");

                            int opcaoJogador = 0;
                            try {
                                opcaoJogador = scanner.nextInt();
                                scanner.nextLine(); // Consumir a quebra de linha
                            } catch (InputMismatchException e) {
                                System.err.println("Entrada inválida. Por favor, insira um número.");
                                scanner.nextLine(); // Consumir a entrada inválida
                                continue;
                            }

                            if (opcaoJogador == 1) {
                                System.out.println("Digite o número referente à ordem em que o jogador apareceu no terminal.");
                                tabuleiro.printJogadores();
                                int posicaoJogador = 0;
                                try {
                                    posicaoJogador = scanner.nextInt();
                                    scanner.nextLine(); // Consumir a quebra de linha
                                } catch (InputMismatchException e) {
                                    System.err.println("Entrada inválida. Por favor, insira um número.");
                                    scanner.nextLine(); // Consumir a entrada inválida
                                    continue;
                                }
                                

                                while (true) {
                                	System.out.println("Digite o número do que deseja saber: \n1.Nome \n2.Dinheiro \n3.ID \n4.CPF \n5.Foto \n6.Email \n7.Cartas \n8.Peça \n9.Tudo \n10.Nada mais");
                                    int opcaoDetalhe = 0;
                                    try {
                                        opcaoDetalhe = scanner.nextInt();
                                        scanner.nextLine(); // Consumir a quebra de linha
                                    } catch (InputMismatchException e) {
                                        System.err.println("Entrada inválida. Por favor, insira um número.");
                                        scanner.nextLine(); // Consumir a entrada inválida
                                        continue;
                                    }

                                    if (opcaoDetalhe == 10) break;
                                    else if (opcaoDetalhe == 1) System.out.println(tabuleiro.getJogadores().get(posicaoJogador - 1).getNome());
                                    else if (opcaoDetalhe == 2) System.out.println(tabuleiro.getJogadores().get(posicaoJogador - 1).getDinheiro());
                                    else if (opcaoDetalhe == 3) System.out.println(tabuleiro.getJogadores().get(posicaoJogador - 1).getId());
                                    else if (opcaoDetalhe == 4) System.out.println(tabuleiro.getJogadores().get(posicaoJogador - 1).getCpf());
                                    else if (opcaoDetalhe == 5) System.out.println(tabuleiro.getJogadores().get(posicaoJogador - 1).getFoto());
                                    else if (opcaoDetalhe == 6) System.out.println(tabuleiro.getJogadores().get(posicaoJogador - 1).getEmail());
                                    else if (opcaoDetalhe == 7) System.out.println(tabuleiro.getJogadores().get(posicaoJogador - 1).getCartas().toString());
                                    else if (opcaoDetalhe == 8) System.out.println(tabuleiro.getJogadores().get(posicaoJogador - 1).getPeca().toString());
                                    else if (opcaoDetalhe == 9) System.out.println(tabuleiro.getJogadores().get(posicaoJogador - 1).toString());
                                    else System.out.println("Comando inválido, digite um número de 1 até 10.");
                                }
                            } else if (opcaoJogador == 2) {
                                System.out.println("Número de jogadores atuais: " + tabuleiro.getNumeroJogadores());
                                System.out.println(tabuleiro.getJogadores().toString() + "\n");
                            } else {
                                System.out.println("Comando inválido, digite apenas 1 ou 2.");
                            }
                        } else if (comando == 2) {
                            tabuleiro.printPropriedades();
                            System.out.println("Gostaria de averiguar alguma propriedade específica? Digite \n1.Sim \n2.Não.");

                            int opcaoPropriedade = 0;
                            try {
                                opcaoPropriedade = scanner.nextInt();
                                scanner.nextLine(); // Consumir a quebra de linha
                            } catch (InputMismatchException e) {
                                System.err.println("Entrada inválida. Por favor, insira um número.");
                                scanner.nextLine(); // Consumir a entrada inválida
                                continue;
                            }

                            if (opcaoPropriedade == 1) {
                                System.out.println("Digite a posição em que a propriedade apareceu no terminal.");
                                int posicaoPropriedade = 0;
                                try {
                                    posicaoPropriedade = scanner.nextInt();
                                    scanner.nextLine(); // Consumir a quebra de linha
                                } catch (InputMismatchException e) {
                                    System.err.println("Entrada inválida. Por favor, insira um número.");
                                    scanner.nextLine(); // Consumir a entrada inválida
                                    continue;
                                }
                                System.out.println(tabuleiro.getPropriedades().get(posicaoPropriedade - 1).toString());
                            } else if (opcaoPropriedade == 2) {
                                System.out.println("Número de propriedades atuais: " + tabuleiro.getNumeroPropriedades());
                                System.out.println(tabuleiro.getPropriedades().toString() + "\n");
                            } else {
                                System.out.println("Comando inválido, digite apenas 1 ou 2.");
                            }
                        } else {
                            System.out.println("Comando inválido, digite um número de 1 até 3.");
                        }
                    }
                } else if (resposta == 2) {
                    
                } else {
                    System.out.println("Comando inválido, digite apenas 1 ou 2.");
                }

                if (jogador.getDinheiro() <= 0) {
                	tabuleiro.salvaLog("Jogador" + jogador.getId() + " faliu e foi removido do jogo.");
                	System.out.println("Jogador" + jogador.getId() + ", " + jogador.getNome() + " faliu e foi removido do jogo.");
                    tabuleiro.rmvJogador(jogador);
                }
            System.out.println("Fim do turno.");
            System.out.println();
            }

            
        }

        scanner.close();
    }
}