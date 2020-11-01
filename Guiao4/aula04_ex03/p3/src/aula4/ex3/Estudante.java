package aula4.ex3;

public class Estudante extends Cliente{
	private int nSocio, cc, nmec;
	private Data dataInsc, dataNasc;
	private String nome, curso;
	
	//Construtores
	public Estudante(String nome, int cc, Data dataNasc, int nmec, String curso) {
		this.nome = nome;
		this.cc = cc;
		this.nmec = nmec;
		this.dataNasc = dataNasc;
		this.curso = curso;
		dataInsc = new Data();
		nSocio = totalSocios++;
	}
	public Estudante(String nome, int cc, int dia, int mes, int ano, int nmec, String curso) {
		this(nome,cc,new Data(dia,mes,ano),nmec,curso);
	}
	
	public String nome() { return nome; }
	public String curso() { return curso; }
	public int nSocio() { return nSocio; }
	public int cc() { return cc; }
	public int nmec() { return nmec; }
	public Data dataInsc() { return dataInsc; }
	public Data dataNasc() { return dataNasc; }
	public String toString() {
		return "Estudante: " + nome + " nSocio: " + nSocio;
	}
	public boolean equals(Object obj) {
		if(!(obj instanceof Estudante))
			return false;
		Estudante other = (Estudante) obj;
		return nSocio == other.nSocio();
	}
}
