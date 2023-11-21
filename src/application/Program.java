package application;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import controller.Form;
import controller.WriterFile;
import entities.User;
import view.Management;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Form form = new Form();

		boolean continueProgram = true;

		Management management = new Management();

		while (continueProgram) {

			System.out.println("----- Welcome to the System DevGym -----");
			System.out.println("1 - Cadastrar o usuário");
			System.out.println("2 - Listar todos usuários cadastrados");
			System.out.println("3 - Cadastrar nova pergunta no formulário");
			System.out.println("4 - Deletar pergunta do formulário");
			System.out.println("5 - Pesquisar usuário por nome ou idade ou email");
			System.out.println("0 - Sair do programa");
			System.out.println();
			System.out.println();

			System.out.print("Selecione uma opção: ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				try {

					System.out.println(form.fileReader());
					System.out.println();
					System.out.println("Favor inserir conforme ordem solicitada:");
					System.out.println();
					System.out.print("Full Name: ");
					String fullName = sc.nextLine();
					System.out.print("Email: ");
					String email = sc.nextLine();
					System.out.print("Age: ");
					int age = sc.nextInt();
					System.out.print("Height: ");
					double height = sc.nextDouble();

					System.out.println();
					System.out.println("Dados do usuario:");
					System.out.println();

					User newUser = new User(fullName, email, age, height);
					management.newUser(newUser);

					management.listUsers();
					WriterFile write = new WriterFile(newUser);
					write.fileWrite(newUser.toString());

				} catch (IOException e) {

					e.printStackTrace();
				}

				break;

			case 2: {
				management.listNames();
				break;
			}

			case 3: {
				System.out.print("Digite a nova pergunta: ");
				String question = sc.nextLine();
				try {
					form.addNewQuestion(question);
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				break;
			}
			case 4: {
				try {
					System.out.println(form.fileReader());
					System.out.print("Numero da pergunta a ser excluida: ");
					int question = sc.nextInt();
					form.removeQuestion(question);
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				break;
			}

			case 0:
				continueProgram = false;
				System.out.println("Encerrando o programa");
				break;

			}

		}
		sc.close();
	}

}
