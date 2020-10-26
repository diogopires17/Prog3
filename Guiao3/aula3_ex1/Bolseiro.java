package aula3_ex1;

public class Bolseiro extends Estudante {

	public int montanteBolsa;

	public Bolseiro (String nome, int cc, Data dataNascimento, Data dataInscr ) {
		super(nome, dataNascimento, cc, dataInscr);
		
	}
	public Bolseiro(String nome, int cc, Data dataNascimento) {
		super(nome, cc, dataNascimento);
		
	}
	public int bolsa (){
		return montanteBolsa;
	}
	public void setBolsa(int montanteBolsa) {
		this.montanteBolsa = montanteBolsa;
		
	}
	@Override
	public String toString() {
		return super.toString() + ", Bolsa: " + montanteBolsa;
	}
	
}
