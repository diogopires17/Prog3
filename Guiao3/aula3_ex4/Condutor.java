package aula3_ex4;

public class Condutor extends Pessoa {

	private Carta carta1;

	public Condutor(String nome, int cc, Carta carta, Data dataNascimento) {
			super(nome,cc,dataNascimento);
			carta1 = carta;
	}

	
	
	public Carta getCarta() {
		return carta1;
	}
	
	@Override
	
	public String toString(){
	
	return super.toString() + ", Carta: "+ carta1;
	
	}
}