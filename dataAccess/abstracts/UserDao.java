package day5.dataAccess.abstracts;

import java.util.List;

import day5.entities.concretes.User;

public interface UserDao {
	void add(User user);
	void update(User user);
	void delete(int userId);
	List<User> getAll();
	User get(String email);
}
