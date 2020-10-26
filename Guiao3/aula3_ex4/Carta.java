package aula3_ex4;
	
public class Carta{

	private final String carta;
	
	public Carta(String carta) {
		
		
		this.carta = carta;
		if(!carta.equals("A") && !carta.equals("B") && !carta.equals("C") && carta.equals("D")) {
			System.out.println("Introduza um tipo válido!");
		}
	}
		
		public boolean equals(Carta c) {
			return carta.equals(c.carta);
		}
		
		public boolean equals(String t) {
			return carta.equals(t);
		}
		
		@Override
		public String toString() {
			return carta;
		
		}
	}
	

