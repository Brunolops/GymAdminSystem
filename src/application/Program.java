package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import view.Register;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		String pathIn = "c:\\Windows\\Temp\\formulario.txt";

		List<Register> list = new ArrayList<>();

		boolean continueProgram = true;

		while (continueProgram) {
			System.out.println("----- Welcome to the System DevGym -----");
			System.out.println("1 - Cadastrar o usuário");
			System.out.println("2 - Listar todos usuários cadastrados");
			System.out.println("3 - Cadastrar nova pergunta no formulário");
			System.out.println("4 - Deletar pergunta do formulário");
			System.out.println("5 - Pesquisar usuário por nome ou idade ou email");
			System.out.println("0 - Sair do programa");
			System.out.println();

			System.out.print("Select a choice: ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				try (BufferedReader bf = new BufferedReader(new FileReader(pathIn))) {
					String readerTxt = bf.readLine();
					while (readerTxt != null) {
						System.out.println(" " + readerTxt);
						readerTxt = bf.readLine();
					}
					System.out.println();
					System.out.println("Favor inserir conforme ordem solicitada:");
					System.out.println();
					System.out.print("Full Name: ");
					String name = sc.nextLine();
					System.out.print("Email: ");
					String email = sc.nextLine();
					System.out.print("Age: ");

					int age = sc.nextInt();
					System.out.print("Height: ");
					double height = sc.nextDouble();

					Register newUser = new Register(name, email, age, height);
					list.add(newUser);

					System.out.println();
					System.out.println("Dados do usuario:");
					System.out.println();

					System.out.println(newUser);

					int count = list.size();

					String[] fullName = name.split(" ");
					String pathOut = count + "-" + String.join("", fullName).toUpperCase() + ".txt";
					File file = new File("c:\\Windows\\Temp\\" + pathOut);

					try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
						bw.write(newUser.toString());
					}
					count++;

				} catch (IOException e) {
					System.out.println("Error:" + e.getMessage());
				}
				break;

			case 2:
				for (Register register : list) {
					System.out.println(list.indexOf(register) + 1  + " - " + register.getName());
				}
				break;

			case 0:
				continueProgram = false;
				System.out.println("Encerrando o programa");
				break;

			}

		}
	}

}
