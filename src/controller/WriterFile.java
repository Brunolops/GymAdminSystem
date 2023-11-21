package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import entities.User;

public class WriterFile {

	private static int count = 0;
	private User user;

	public WriterFile(User user) {
		this.user = user;
	}

	public WriterFile() {

	}

	private String fileName() {
		count++;
		String[] fullName = user.getName().split(" ");
		String fileName = count + "-" + String.join("", fullName).toUpperCase() + ".txt";
		return fileName;
	}

	public String fileWrite(String list) throws IOException {
		File file = new File("c:\\Windows\\Temp\\" + fileName());
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			bw.write(list);
		}
		return list;
	}

}
