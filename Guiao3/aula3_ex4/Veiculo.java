package aula3_ex4;

import java.util.ArrayList;

public class Veiculo {
	private String tipo;
	private double lotacao ;
	private double  Cilindrada;
	private double Potencia;
	private double PesoBruto;
	private Condutor condutor;
	private Carta cartaNecessaria;
	private ArrayList<Pessoa> passageiros;
	private Carta cartacerta;
	
	

	public Veiculo(Condutor condutor, int lotacao, int Cilindrada, int Potencia, int PesoBruto, Carta carta, String tipo) {
		this.tipo  = tipo;
		this.condutor = condutor;
		this.lotacao = lotacao;
		this.Cilindrada = Cilindrada;
		this.Potencia = Potencia;
		this.PesoBruto = PesoBruto;
		this.cartacerta = carta;
		passageiros = new ArrayList();
		
		
	}
	public boolean cartaValida() {
		return cartacerta.equals(condutor.getCarta());
	}
	
	public  void addPassageiro(Pessoa p) throws Exception  { 
			if(passageiros.size() < lotacao - 1  ) {
				passageiros.add(p);
			
		}else {
		
			throw new Exception("Lotação Máxima atingida!");
	}

}
	public void removePassageiro(Pessoa pessoa) throws Exception{
		if(numPassageiros() > 0) {
			passageiros.remove(pessoa);
		}else {
			throw new Exception("Veiculo vazio. Nao e possivel remover passageiros");
		}
	}
	public String info() {
	
	return  "\nNome:" + condutor.nome() +
			"\nCC:"+ condutor.cc() + 
			"\nVeiculo"+ tipo + 
			"\nCilindrada" + Cilindrada +
			"\nPotencia" + Potencia + 
			"\nPesoBruto" + PesoBruto+ 
			"\nCarta Necessária para conduzir o Veículo: " +  cartacerta;
			
			
			
			
	}
	@Override
	public String toString() {
		return "VEICULO";
	}
	
	
	

	public int numPassageiros() {
		return passageiros.size();
	}
	
	public Condutor condutor() {
		return condutor;
	}
	
	public void mudarCondutor(Condutor p) {
		condutor = p;
	}
	
	
	public double getLotacao() {
		return passageiros.size();
	}
	
	public double getCilindrada() {
		return Cilindrada;
	}

	public double getPotencia() {
		return Potencia;
	}

	public double getPesoBruto() {
		return PesoBruto;
	}
	public String getTipo() {
		return tipo;
	}


	
}
