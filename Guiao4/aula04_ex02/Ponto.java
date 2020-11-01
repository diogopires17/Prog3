package aula04_ex02;



public class Ponto {
	
	private final double x;
	private final double y;
	
	public Ponto(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public Ponto() {
		this.x = 0;
		this.y = 0;
	}

	public double x(){ return x; }
	public double y(){ return y; }
	public String toString(){ return "("+x+","+y+")"; }

	public double distanceTo(Ponto Ponto){
		return Math.sqrt(Math.pow(Ponto.x()-x,2)+Math.pow(Ponto.y()-y,2));
	}
	
	public boolean equals(Ponto p) { return x == p.x && y ==p.y; }
	
}