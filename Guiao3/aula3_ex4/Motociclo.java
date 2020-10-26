package aula3_ex4;

public class Motociclo extends Veiculo{
	
	private boolean atrelado;
	
	public Motociclo(Condutor c, boolean atrelado) {
		
		super(c,atrelado?2:1,125,11,3000,new Carta("A"), "Motociclo");

		this.atrelado = atrelado;
	}
	
	public Motociclo(Condutor c) {
		this(c,false);
	}
	
	public boolean temAtrelado() {
		return atrelado;
	}
	
	@Override
	public String toString() {
		return "MOTOCICLO";
	}
	
	@Override
	public String info() {
		return this+": "+
				"\nCondutor(a) -> "+super.condutor().nome()+
				"\nnumPassageiros -> "+numPassageiros()+
				"\nLotacao -> "+super.getLotacao()+
				"\nCilindrada -> "+getCilindrada()+
				"\nPotencia -> "+getPotencia()+
				"\npesoBruto -> "+getPesoBruto()+
				"\nAtrelado - > "+(atrelado?"Sim":"Não")+"\n";
	}
}