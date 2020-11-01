package aula4.ex3;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.out;

public class Videoclube {
	
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private static ArrayList<Video> videos = new ArrayList<Video>();
	private static HashMap<Integer,ArrayList<Integer>> videosCliente = new HashMap<>();
	private static HashMap<Integer,ArrayList<Integer>> historicoEmprestimos = new HashMap<>();
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int res = 0;
		while(res != 10) {
			try {
				res = menu(input);
				
				switch (res) {
				case 1:
					out.print("\nEstudante(1) ou Funcionário(2): ");
					int opt = Integer.valueOf(input.nextLine());
					if(opt == 1) addStudent(input);
					else if(opt == 2) addFunc(input);
					else out.println("\nOpção não existe!");
					break;
				
				case 2:
					removeClient(input);
					break;
				
				case 3:
					clientLoans(input);
					break;
				
				case 4:
					addVideo(input);
					break;
				
				case 5:
					removeVideo(input);
					break;
					
				case 6:
					out.print("\nID: ");
					int id = Integer.valueOf(input.nextLine());
					if(checkAvailability(id)) out.println("O vídeo está disponivel!");
					else out.println("O vídeo não está disponível ou não existe!");
					break;
					
				case 7:
					checkout(input);
					break;
					
				case 8:
					checkin(input);
					break;
					
				case 9:
					loanHistory(input);
					break;
				
				case 10:
					break;
					
				default:
					out.println("\nOpção não existe!");
					break;
				}
				
			} catch(NumberFormatException e) {
				out.println("\n"+e);
			}
			catch(IllegalArgumentException e) {
				out.println("\n"+e);
			}
			out.println();
		}
		input.close();
	}
	
	private static int menu(Scanner input) {
		out.println("1 - Adicionar cliente");
		out.println("2 - Remover Cliente");
		out.println("3 - Videos disponibilizados ao utilizador");
		out.println("4 - Adicionar vídeo");
		out.println("5 - Remover video");
		out.println("6 - Verificar Disponibilidade");
		out.println("7 - Check-out");
		out.println("8 - Check-in");
		out.println("9 - Historico de requisições");
		out.println("10 - Fechar programa");
		out.print("Escolha uma opção: ");
		String res = input.nextLine();
		return Integer.valueOf(res);
	}
	private static void addStudent(Scanner input) {
		out.print("Nome: ");
		String nome = input.nextLine();
		
		out.print("CC: ");
		int cc = Integer.valueOf(input.nextLine());
		for (int i = 0; i < clientes.size(); i++)
			if (clientes.get(i).cc() == cc)
				throw new IllegalArgumentException("Já existe um cliente com este CC");
		
		out.print("Dia de Nascimento: ");
		int dia = Integer.valueOf(input.nextLine());
		out.print("Mês de Nascimento: ");
		int mes = Integer.valueOf(input.nextLine());
		out.print("Ano de Nascimento: ");
		int ano = Integer.valueOf(input.nextLine());
		Data data = new Data(dia,mes,ano);
		
		out.print("Número mecanográfico: ");
		int nmec = Integer.valueOf(input.nextLine());
		for (int i = 0; i < clientes.size(); i++) {
			if(clientes.get(i) instanceof Estudante) {
				Estudante other = (Estudante) clientes.get(i);
				if (other.nmec() == cc)
					throw new IllegalArgumentException("Já existe um estudante "
							+ "com este número mecanográfico");
			}
		}
		
		out.print("Curso: ");
		String curso = input.nextLine();
		
		Estudante estudante = new Estudante(nome,cc,data,nmec,curso);
		clientes.add(estudante);
		out.println("\nCliente Adicionado! Número de sócio: " + estudante.nSocio());
	}
	private static void addFunc(Scanner input) {
		out.print("Nome: ");
		String nome = input.nextLine();
	
		out.print("CC: ");
		int cc = Integer.valueOf(input.nextLine());
		for (int i = 0; i < clientes.size(); i++)
			if (clientes.get(i).cc() == cc)
				throw new IllegalArgumentException("Já existe um cliente com este CC");
		
		out.print("Dia de Nascimento: ");
		int dia = Integer.valueOf(input.nextLine());
		out.print("Mês de Nascimento: ");
		int mes = Integer.valueOf(input.nextLine());
		out.print("Ano de Nascimento: ");
		int ano = Integer.valueOf(input.nextLine());
		Data data = new Data(dia,mes,ano);
		
		out.print("Número de Funcionário: ");
		int nFunc = Integer.valueOf(input.nextLine());
		for (int i = 0; i < clientes.size(); i++) {
			if(clientes.get(i) instanceof Funcionario) {
				Funcionario other = (Funcionario) clientes.get(i);
				if (other.nFunc() == nFunc)
					throw new IllegalArgumentException("Já existe um funcionário "
							+ "com este número de funcionário");
			}
		}
		
		out.print("Número Fiscal: ");
		int nFisc = Integer.valueOf(input.nextLine());
		for (int i = 0; i < clientes.size(); i++) {
			if(clientes.get(i) instanceof Funcionario) {
				Funcionario other = (Funcionario) clientes.get(i);
				if (other.nFisc() == nFisc)
					throw new IllegalArgumentException("Já existe um funcionário "
							+ "com este número fiscal");
			}
		}
		
		Funcionario funcionario = new Funcionario(nome,cc,data,nFunc,nFisc); 
		clientes.add(funcionario);
		out.println("\nCliente Adicionado! Número de sócio: " + funcionario.nSocio());
	}
	private static void removeClient(Scanner input) {
		out.print("\nNúmero de Sócio: ");
		int nSocio = Integer.valueOf(input.nextLine());
		for (int i = 0; i < clientes.size(); i++) {
			if(clientes.get(i).nSocio() == nSocio) {
				clientes.remove(i);
				out.println("Cliente removido com sucesso!");
				break;
			}
		}
	}
	private static void clientLoans(Scanner input) {
		out.print("\nNúmero de sócio: ");
		int nSocio = Integer.valueOf(input.nextLine());
		if(!(videosCliente.containsKey(nSocio)))
			out.println("O cliente nunca alugou um video ou existe!");
		else if(videosCliente.get(nSocio).isEmpty())
			out.println("O cliente não deve nenhum video");
		else
			out.println("Videos alugados pelo cliente por IDs:\n" + videosCliente.get(nSocio));
	}
	private static void addVideo(Scanner input) {
		out.print("\nNome: ");
		String nome = input.nextLine();
		out.println("Categorias: \"Ação\", \"Animação\", \"Aventura\", \"Comédia\", \"Documentário\","
				+ " \"Drama\", \"Musical\", \"Romance\", \"Suspence\", \"Terror\"");
		out.print("Categoria: ");
		String categoria = input.nextLine();
		out.println("Idades: \"ALL\", \"M6\", \"M12\", \"M16\", \"M18\"");
		out.print("Idade: ");
		String idade = input.nextLine();
		Video video = new Video(nome,categoria,idade);
		videos.add(video);
		out.println("\nVideo adicionado! ID: " + video.id());
	}
	private static void removeVideo(Scanner input) {
		out.print("\nID: ");
		int id = Integer.valueOf(input.nextLine());
		
		if(!(checkAvailability(id))) {
			out.println("O vídeo não existe ou está emprestado!");
			return;
		}
		
		for (int i = 0; i < videos.size(); i++) {
			if(videos.get(i).id() == id) {
				videos.remove(i);
				out.println("Video removido com sucesso!");
				break;
			}
		}
	}
	private static boolean checkAvailability(int id) {
		for (int i = 0; i < videos.size(); i++) {
			if(videos.get(i).id() == id) return !videos.get(i).emprestado();
		}
		return false;
	}
	private static void checkout(Scanner input) {
		out.print("\nNúmero de sócio: ");
		int nSocio = Integer.valueOf(input.nextLine());
		
		boolean existe = false;
		for (int i = 0; i < clientes.size(); i++) {
			if(clientes.get(i).nSocio() == nSocio) {
				existe = true;
				break;
			}
		}
		if(!existe) {
			out.println("O cliente não existe!");
			return;
		}
		
		out.print("ID: ");
		int id = Integer.valueOf(input.nextLine());
		
		if(!(checkAvailability(id))) {
			out.println("O video não está disponivel ou não existe!");
			return;
		}

		for (int i = 0; i < videos.size(); i++) {
			if(videos.get(i).id() == id) {
				videos.get(i).emprestar();
				break;
			}
		}
		
		if(videosCliente.containsKey(nSocio))
			videosCliente.get(nSocio).add(id);
		else {
			ArrayList<Integer> lista = new ArrayList<Integer>();
			lista.add(id);
			videosCliente.put(nSocio, lista);
		}
		
		out.println("Video emprestado com sucesso!");
	}
	private static void checkin(Scanner input) {
		out.print("\nNúmero de sócio: ");
		int nSocio = Integer.valueOf(input.nextLine());
		out.print("ID: ");
		int id = Integer.valueOf(input.nextLine());
		
		if(checkAvailability(id)) {
			out.println("O video não está emprestado!");
			return;
		}
		
		if(!(videosCliente.containsKey(nSocio))) {
			out.println("Nunca foi emprestado um vídeo ao cliente ou este não está inscrito!");
			return;
		}
		if(!(videosCliente.get(nSocio).contains(id))) {
			out.println("O video não está emprestado ao cliente!");
			return;
		}
		
		videosCliente.get(nSocio).remove(videosCliente.get(nSocio).indexOf(id));
		
		for (int i = 0; i < videos.size(); i++) {
			if(videos.get(i).id() == id) {
				videos.get(i).devolver();
				break;
			}
		}
		
		if(historicoEmprestimos.containsKey(id))
			historicoEmprestimos.get(id).add(nSocio);
		else {
			ArrayList<Integer> lista = new ArrayList<Integer>();
			lista.add(nSocio);
			historicoEmprestimos.put(id, lista);
		}
		out.println("Video devolvido com sucesso!");
	}
	private static void loanHistory(Scanner input) {
		out.print("\nID: ");
		int id = Integer.valueOf(input.nextLine());

		if(!historicoEmprestimos.containsKey(id))
			out.println("Este video nunca foi alugado ou não existe");
		else {
			out.println("Histórico de utilizadores que requesitaram o video por número de sócios:");
			out.println(historicoEmprestimos.get(id));
		}
	}
}
