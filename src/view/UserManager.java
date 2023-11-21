package view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entities.User;

public class UserManager {

	private List<User> newUser;

	public UserManager() {
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

	public List<User> searchUser(String targetName) {
		List<User> equalsNames = newUser.stream()
				.filter(user -> user.getName().contains(targetName))
				.collect(Collectors.toList());
		equalsNames.forEach(user -> System.out.println(user));
		return equalsNames;
	}

}
