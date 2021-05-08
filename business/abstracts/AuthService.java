package day5.business.abstracts;

import day5.entities.concretes.LoginDto;
import day5.entities.concretes.User;

public interface AuthService {
	void register(User user);
	void verify(User user,String token);
	boolean userExists(String email);
	void login(LoginDto dto);
}
