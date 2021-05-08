package day5.business.concretes;

import day5.business.abstracts.AuthService;
import day5.business.abstracts.UserService;
import day5.entities.concretes.LoginDto;
import day5.entities.concretes.User;
import day5.core.utils.*;
public class AuthManager implements AuthService {
	private UserService userService;

	public AuthManager(UserService userService) {
		super();
		this.userService = userService;
	}








	@Override
	public void register(User user) {
		if (userValidate(user) && passwordValidate(user.getPassword()) && userExists(user.getEmail()) == false
				&& Utils.emailValidate(user.getEmail())) {

			userService.add(user);

		} else {
			System.out.println("Kayıt Başarısız");
		}
	}

	@Override
	public void verify(User user, String token) {
		if (user != null && token.length() > 20) {
			User exitsUser = userService.get(user.getEmail());
			exitsUser.setVerify(true);

			userService.update(exitsUser);
			System.out.println("Doğrulandı.");
		} else {
			System.out.println("Doğrulanmadı");
		}
	}

	@Override
	public boolean userExists(String email) {
		User user = userService.get(email);

		if (user == null) {
			return false;
		} else {
			System.out.println("Email mevcut." + email);
			return true;
		}
	}

	@Override
	public void login(LoginDto dto) {
		User user = userService.get(dto.getEmail());

		if (user != null && user.getPassword().equals(dto.getPassword())) {
			
			System.out.println("Baþarýyla giriþ yaptýnýz.");

		}else {
			System.out.println("Kullanýcý adý veya þifre yanlýþ.");
		}
		

	}

	public boolean userValidate(User user) {
		if (user != null && !user.getFirstName().isEmpty() && !user.getLastName().isEmpty()
				&& !user.getEmail().isEmpty() && !user.getPassword().isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean passwordValidate(String password) {

		if (password.length() >= 6) {
			return true;
		} else {
			System.out.println("Þifreniz en az 6 karakter olmalý");
			return false;
		}
	}
}
