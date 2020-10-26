package aula3_ex1;

public class Estudante extends Pessoa{
	
	
	public  int nmec = 100;
	public  Data dataInscr;
	public  static int nMec = 100;
	
	public Estudante(String nome, Data dataInscr, int cc, Data dataNascimento){
		super (nome, cc, dataNascimento);
		this.nMec  = nMec++;
		this.dataInscr = dataInscr;
		
	}
	public Estudante(String nome, int cc, Data dataNascimento){
		this(nome, dataNascimento, cc, new Data());
	
	}
	public int nMec() { return nmec; }
	public Data dataInscr() { return dataInscr; }
	
	@Override
	public String toString() {
		return super.toString() + ", NMec: " + nmec + ", inscrito em Data: " + dataInscr;	
	}
}
