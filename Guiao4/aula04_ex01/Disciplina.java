package aula04_ex01;
import java.util.*;

public class Disciplina {

	private final String nomeDiscipl;
	private final String areaC;
	private final int ECTS;
	private  Professor Responsavel;
	private List<Estudante> Alunos;
	
	
	public Disciplina(String nomeDiscipl, String areaC, int ECTS, Pessoa professor){
		
		super();
		this.nomeDiscipl = nomeDiscipl;
		this.areaC = areaC;
		this.ECTS = ECTS;
		this.Responsavel = Responsavel;
		this.Alunos = new ArrayList<>();
	}
	public boolean addAluno(Estudante est) {
		if(Alunos.contains(est))
			return false;
		return Alunos.add(est);
	}
	public boolean delAluno(int nMec) {
		for(Estudante estudante : getAlunos()) {
			if(estudante.nMec() == nMec)
				return Alunos.remove(estudante);
		}
		return false;
	}
	public boolean alunoInscrito(int nMec) {
		for(Estudante estudante : getAlunos()) {
			if(estudante.nMec() == nMec) {
				return true;
			}		
		}
		return false;
	}
	public int numAlunos() {
		return Alunos.size();
		
	}
	@Override
	public String toString(){
		return "\nNome da Disciplina: " + nomeDiscipl + "/n¡rea Cientifica: " +  
			areaC + "ECTS:" + ECTS + "Professor:" + Responsavel;
	}
	public Estudante[] getAlunos() {
		
		return 	Alunos.toArray(new Estudante[0]);
	}
	public Estudante[] getAlunos(String tipo) {
		List<Estudante> tipoest= new ArrayList<>();
			for(Estudante estudante : getAlunos()) {
				if(estudante.getClass().toString().contains(tipo)) {
					tipoest.add(estudante);
				}
			}
		return tipoest.toArray(new Estudante[0]);
	}
	


}
