package aula3_ex4;



public class PesadoPassageiros extends Veiculo{
	
	private final String[] paragens = {"Viseu", "Macedo de Cavaleiros", "Mirandela", "Vila Real", "Porto", "Aveiro", "Lisboa", "Beja"};
	
	public PesadoPassageiros(Condutor c) {
		
		super(c,20,50,300,5000,new Carta("D"), "Pesado de Passageiros");
	}
	
	
	public void saidaPassageiros(Pessoa[] pessoas) throws Exception{ 
		for(Pessoa pessoa : pessoas) {
			removePassageiro(pessoa);
		}
	}
	
	public void anunciarParagem(String paragem) throws Exception {
	
		for(String p : paragens) {
			if(p.equals(paragem)) {
				System.out.println("Proxima paragem: "+paragem);
				return;
			}
		}
		throw new Exception("A paragem '"+paragem+"' nao existe!");
	}

	@Override
	public String toString() {
		return "PESADO PASSAGEIROS";
	}
	
	@Override
	public String info() {
		return this+": "+
				"\nCondutor(a) -> "+super.condutor().nome()+
				"\nnumPassageiros -> "+numPassageiros()+
				"\nLotacao -> "+super.getLotacao()+
				"\nCilindrada -> "+getCilindrada()+
				"\nPotencia -> "+getPotencia()+
				"\npesoBruto -> "+getPesoBruto()+"\n";
	}
	
}
