package aula4.ex3;

public abstract class Cliente {
	static int totalSocios = 1; //a partir deste valor tiramos o numero de socio de cada cliente
	public abstract String nome();
	public abstract int nSocio();
	public abstract int cc();
	public abstract Data dataNasc();
	public abstract Data dataInsc();
	@Override
	public abstract String toString();
	@Override
	public abstract boolean equals(Object obj);
}
