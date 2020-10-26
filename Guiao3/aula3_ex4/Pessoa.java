package aula3_ex4;

public class Pessoa {
	
	protected String nome;
	protected int cc;
	protected  Data dataNascimento;
	
	public Pessoa(String nome, int cc, Data dataNascimento) {
		this.nome = nome;
		this.cc = cc;
		this.dataNascimento = dataNascimento;
		
	}
	
	public int cc() {return cc;}
	public String nome(){return nome;}
	public Data dataNascimento(){return dataNascimento;}
	
	public boolean pessoaIgual(Pessoa p){
		if(this.cc == p.cc ) {return true;}
		return false;
		
	}
	@Override 
	public String toString() {
		return nome + "CC:" + cc +"Data Nascimento:"+ dataNascimento;
	}

}


