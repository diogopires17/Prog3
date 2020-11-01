package aula4.ex3;
import java.time.LocalDate;

public class Data {
	private int dia;
	private int mes;
	private int ano;
	
	//Construtores
	public Data() {
		LocalDate dataAtual = LocalDate.now();
		this.dia = dataAtual.getDayOfMonth();
		this.mes = dataAtual.getMonthValue();
		this.ano = dataAtual.getYear();
	}
	public Data(int dia, int mes, int ano) {
		//adicionar apenas datas válidas
		if(validDate(dia,mes,ano)) {
			this.dia = dia;
			this.mes = mes;
			this.ano = ano;
		} else throw new IllegalArgumentException("Data Inválida");
	}
	
	//Metodos
	public int dia() {return dia;}
	public int mes() {return mes;}
	public int ano() {return ano;}
	@Override
	public String toString() { return dia+"-"+mes+"-"+ano; }
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Data)) return false;
		Data other = (Data) obj;
		return dia == other.dia() && mes == other.mes() && ano == other.ano();
	}
	private boolean validDate(int dia, int mes, int ano) {
		int[] m = {31,28,31,30,31,30,31,31,30,31,30,31}; //dias de cada mes
		
		if (mes < 13 && mes > 0 && ano > 0) {
			//verificar se o ano é bissexto e o dia é 29
			if (mes == 2 && dia == 29 && ((ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0)))) return true;
			else { //casos normais
				if (dia >= 1 && dia <= m[mes-1]) return true;
			}
		}
		
		return false;
	}
}