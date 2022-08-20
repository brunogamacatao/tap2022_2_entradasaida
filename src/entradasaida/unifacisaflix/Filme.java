package entradasaida.unifacisaflix;

public class Filme {
	private String nome;
	private String diretor;
	private int ano;
	
	public Filme(String nome, String diretor, int ano) {
		this.nome = nome;
		this.diretor = diretor;
		this.ano = ano;
	}

	// Métodos para conversão de/para CSV
	public String toCSV() {
		return nome + ";" + diretor + ";" + ano;
	}
	
	public static Filme fromCSV(String linha) {
		String[] campos = linha.split(";");
		
		String nome = campos[0];
		String diretor = campos[1];
		int ano = Integer.parseInt(campos[2]);
		
		return new Filme(nome, diretor, ano);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
}
