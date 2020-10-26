package aula3_ex4;

public class Ligeiro  extends Veiculo{
	public String cor;
	public Ligeiro(Condutor condutor, Condutor c) {
		super(c, 5, 2700, 307, 500 ,new Carta("B"), "Ligeiro");
	
	}

	public void pintarCarro(String novaCor) {
		cor = novaCor;
	}
	
	public String cor() {
		return cor;
	}
	
	@Override
	public String toString() {
		return "LIGEIRO";
	}
	
	@Override
	public String info() {
		return this+": "+
				"\nCondutor(a) -> "+super.condutor().nome()+
				"\nnumPassageiros -> "+numPassageiros()+
				"\nLotacao -> "+ super.getLotacao()+
				"\nCilindrada -> "+getCilindrada()+
				"\nPotencia -> "+getPotencia()+
				"\npesoBruto -> "+getPesoBruto()+
				"\nCor - > "+cor+"\n";
	}
}

	
	

