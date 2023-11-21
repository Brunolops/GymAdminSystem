package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Form {

	private static int count = 4;

	private File file = new File("c:\\Windows\\Temp\\formulario.txt");

	public String fileReader() throws IOException {

		StringBuilder content = new StringBuilder();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				content.append(line).append("\n");
			}
		}
		return content.toString();
	}

	public String addNewQuestion(String question) throws IOException {
		count++;
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
			bw.newLine();
			bw.write(count + " - " + question);
		}
		return question;
	}

	public int removeQuestion(int lineNumber) throws IOException {
		Path path = Paths.get("c:\\Windows\\Temp\\formulario.txt");
		List<String> lines = Files.readAllLines(path);
		if (lineNumber > 4 && lineNumber <= lines.size()) {
			lines.remove(lineNumber - 1);
			Files.write(path, lines, StandardOpenOption.TRUNCATE_EXISTING);
			return lineNumber;
		} else {
			System.out.println("Não é possivel excluir as 4 primeiras perguntas, por favor digite um numero de 5 em diante");
			return -1;
		}
	}
}
