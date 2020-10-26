package aula3_ex4;


import java.util.HashMap;

public class PesadoMercadorias extends Veiculo{
	
	private HashMap<String,Integer> mercadoria;
	
	public PesadoMercadorias(Condutor c) {
		
		super(c,2,50,300,8000,new Carta("C"), "PesadoMerca");
		mercadoria = new HashMap<>();
	}

	public void addMercadoria(String merc) {
		if(!mercadoria.containsKey(merc))
			mercadoria.put(merc,1);
		else {
			mercadoria.put(merc,mercadoria.get(merc)+1);
		}
	}
	
	public void removeMercadoria(String merc) throws Exception {
		if(mercadoria.containsKey(merc)) {
			int stock = mercadoria.get(merc);
			if(stock > 0)
				mercadoria.put(merc,stock-1);
			else throw new Exception("Nao existe o tipo de produto: "+merc);
		}
	}
	
	public int quantidadeDe(String merc) {
		return mercadoria.get(merc);
	}
	
	@Override
	public String toString() {
		return "PESADO MERCADORIA";
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
