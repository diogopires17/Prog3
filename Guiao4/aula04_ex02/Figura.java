package aula04_ex02;

public abstract class Figura {

	private Ponto centro;
	
	public Figura(Ponto c){
		centro = c;
	}
	
	public Ponto centro() { return centro; }
	public abstract double area();
	public abstract double perimetro();
	
}