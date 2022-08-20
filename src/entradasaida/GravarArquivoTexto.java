package entradasaida;

import java.io.PrintWriter;

public class GravarArquivoTexto {
	public static void main(String[] args) throws Exception {
		// abrindo um arquivo para escrita
		PrintWriter saida = new PrintWriter("arquivo.txt");
		
		for (int i = 0; i < 1000; i++) {
			saida.println("Hello World ! - Linha " + (i+1));
		}
		
		// fechar o arquivo
		saida.close();
	}
}
