package entradasaida;

import java.io.File;
import java.util.Scanner;

public class LerArquivoTexto {
	public static void main(String[] args) throws Exception {
		Scanner entrada = new Scanner(new File("arquivo.txt"));
		while (entrada.hasNextLine()) {
			String linha = entrada.nextLine();
			System.out.println(linha);
		}
		entrada.close();
	}
}
