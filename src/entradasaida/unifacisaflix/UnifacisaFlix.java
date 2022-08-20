package entradasaida.unifacisaflix;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class UnifacisaFlix {
	public static final String ARQUIVO_FILMES = "filmes.csv";
	
	public static ArrayList<Filme> carregarFilmes() throws Exception {
		ArrayList<Filme> filmes = new ArrayList<>();
		
		File arquivo = new File(ARQUIVO_FILMES);
		if (arquivo.exists()) {
			Scanner entrada = new Scanner(arquivo);
			while (entrada.hasNextLine()) {
				filmes.add(Filme.fromCSV(entrada.nextLine()));
			}
			entrada.close();
		}
		
		return filmes;
	}
	
	public static void salvarFilmes(ArrayList<Filme> filmes) throws Exception {
		PrintWriter saida = new PrintWriter(ARQUIVO_FILMES);
		
		for (Filme f : filmes) {
			saida.println(f.toCSV());
		}
		
		saida.close();
	}
	
	public static void main(String[] args) throws Exception {
		Scanner teclado = new Scanner(System.in);
		
		// No início => carregar os filmes do arquivo
		ArrayList<Filme> filmes = carregarFilmes();
		
		while (true) {
			System.out.println("MENU DE OPÇÕES");
			System.out.println("1. Adicionar filme");
			System.out.println("2. Listar filmes");
			System.out.println("3. Sair");
			System.out.print("Digite sua opção: ");
			
			int opcao = Integer.parseInt(teclado.nextLine());
			
			if (opcao == 1) { // adicionar um filme
				System.out.print("Digite o nome: ");
				String nome = teclado.nextLine();
				System.out.print("Digite o diretor: ");
				String diretor = teclado.nextLine();
				System.out.print("Digite o ano: ");
				int ano = Integer.parseInt(teclado.nextLine());
				
				Filme f = new Filme(nome, diretor, ano);
				filmes.add(f);
				salvarFilmes(filmes);
				System.out.println("Filme adicionado com sucesso!");
			} else if (opcao == 2) { // listar os filmes
				System.out.println(filmes.size() + " filmes cadastrados:");
				for (Filme f : filmes) {
					System.out.println(f.getNome() + " - " + f.getDiretor() + " - " + f.getAno());
				}
			} else if (opcao == 3) { // sair
				break;
			} else { // opção inválida
				System.out.println("OPÇÃO INVÁLIDA !");
			}
		}
	}
}
