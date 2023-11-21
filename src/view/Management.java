package view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entities.User;

public class Management {

	private List<User> newUser;

	public Management() {
		this.newUser = new ArrayList<>();
	}

	public List<User> getNewUser() {
		return newUser;
	}

	public void newUser(User list) {
		newUser.add(list);
	}

	public void listUsers() {
		for (User user : newUser) {
			System.out.println(user);
		}
	}

	public void listNames() {
		for (User user : newUser) {
			System.out.println(newUser.indexOf(user) + 1 + " - " + user.getName());
		}
	}

	public void searchUser(List<User> users, String targetName) {
		List<User> equalsNames = users.stream().filter(user -> user.getName().equals(targetName))
				.collect(Collectors.toList());
	}

}