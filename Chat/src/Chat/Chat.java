package Chat;
import java.util.ArrayList;
import java.util.Scanner;

public class Chat {

	public static void main(String[] args) {

		System.out.println("Opções");
		System.out.println("1-Cadastrar Sala");
		System.out.println("2-Enviar Mensagem");
		System.out.println("3-Exibir Conversas da Sala");
		System.out.println("4-Sair");

		int opcao;
		Scanner teclado = new Scanner(System.in);
		Sala sala = null;
		Usuario usuario =null;
		Mensagem msg =null;

		do {
			System.out.println("Qual a opção desejada?");
			opcao = teclado.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("Qual o nome da sala?");
				String nome = teclado.next();

				sala = new Sala(nome);

				System.out.println("Sala criada !! " + sala.getNome());

				break;
			case 2:
				
				System.out.println("Qual o nome do usuário?");
				String nomeUsuario = teclado.next();
				usuario = new Usuario(nomeUsuario);		

				msg = new Mensagem();
				
				
				msg.setUsuario(usuario);
				
				
				System.out.println("Qual a mensagem?");
				String texto = teclado.next();
				
				
				msg.setTexto(texto);

				
				sala.enviarMSG(msg);
				
				
				
				break;
			case 3:
				System.out.println("Lista de mensagens da sala");

				if (sala != null) {
					
					for (Mensagem m : sala.obterMensagens()) {
						System.out.println("Mensagem : " + m.getTexto());
					}	
				}else 
					System.out.println("É preciso criar uma sala primeiro.(Opcao 1)");
				
				break;
			}
			
		} while (opcao > 0 && opcao < 4);

		teclado.close();

	}

}