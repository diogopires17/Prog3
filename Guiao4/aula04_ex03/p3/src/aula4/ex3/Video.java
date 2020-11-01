package aula4.ex3;

import java.util.ArrayList;
import java.util.Arrays;

public class Video {
	private static int idCount = 1;
	private final int id;
	private final String titulo, categoria, idade;
	private boolean emprestado = false;
	
	private static final ArrayList<String> listaCategoria = new ArrayList<String>(
			Arrays.asList("Ação", "Animação", "Aventura", "Comédia", "Documentário",
					"Drama", "Musical", "Romance", "Suspence", "Terror"));
	private static final ArrayList<String> listaIdade = new ArrayList<String>(
			Arrays.asList("ALL", "M6", "M12", "M16", "M18"));

	
	//Construtores
	public Video(String titulo, String categoria, String idade) {
		if(!(listaCategoria.contains(categoria)))
			throw new IllegalArgumentException("Categoria inválida ou mal escrita");
		if(!(listaIdade.contains(idade)))
			throw new IllegalArgumentException("Idade inválida ou mal escrita");
		this.titulo = titulo;
		this.categoria = categoria;
		this.idade = idade;
		id = idCount++;
	}
	
	//Metodos
	public int id() { return id; }
	public String titulo()  { return titulo; }
	public String categoria() { return categoria; }
	public String idade() { return idade; }
	
	public boolean emprestado() { return emprestado; }
	public void emprestar() { emprestado = true; }
	public void devolver() { emprestado = false; }
	@Override
	public String toString() {
		return "Título: " + titulo + " || Categoria: " + categoria + " || Idade: " + idade;
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Video)) return false;
		Video other = (Video) obj;
		return id == other.id();
	}
}
