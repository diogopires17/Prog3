package aula4.ex3;

public class Funcionario extends Cliente {
	private int nSocio, cc, nFunc, nFisc;
	private Data dataInsc, dataNasc;
	private String nome;
	
	//Construtores
	public Funcionario(String nome, int cc, Data dataNasc, int nFunc, int nFisc) {
		this.nome = nome;
		this.cc = cc;
		this.nFunc = nFunc;
		this.nFisc = nFisc;
		this.dataNasc = dataNasc;
		dataInsc = new Data();
		nSocio = totalSocios++;
	}
	public Funcionario(String nome, int cc, int dia, int mes, int ano, int nFunc, int nFisc) {
		this(nome,cc,new Data(dia,mes,ano),nFunc,nFisc);
	}
	
	public String nome() { return nome; }
	public int nSocio() { return nSocio; }
	public int cc() { return cc; }
	public int nFunc() { return nFunc; }
	public int nFisc() { return nFisc; }
	public Data dataInsc() { return dataInsc; }
	public Data dataNasc() { return dataNasc; }
	public String toString() {
		return "Funcionario: " + nome + " nSocio: " + nSocio;
	}
	public boolean equals(Object obj) {
		if(!(obj instanceof Funcionario))
			return false;
		Funcionario other = (Funcionario) obj;
		return nSocio == other.nSocio();
	}
}
