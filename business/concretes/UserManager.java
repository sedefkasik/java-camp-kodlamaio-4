package day5.business.concretes;

import java.util.List;

import day5.business.abstracts.UserService;
import day5.core.EmailService;
import day5.core.googleEmail.GoogleMailManagerAdapter;
import day5.dataAccess.abstracts.UserDao;
import day5.dataAccess.concretes.InMemoryUserDao;
import day5.entities.concretes.LoginDto;
import day5.entities.concretes.User;


public class UserManager implements UserService {

	private UserDao userDao; 
	private EmailService emailService;
	public UserManager(UserDao userDao,EmailService emailService) {
		super();
		this.userDao = userDao;
		this.emailService=emailService;
	}

	public UserManager(InMemoryUserDao inMemoryUserDao, GoogleMailManagerAdapter emailService2) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(User user) {
		
		if(userValidate(user)) {
			userDao.add(user);
			
			emailService.send(user.getEmail(), "Kayýt Olundu");
		}
		
		
	}

	@Override
	public void update(User user) {
		if(userValidate(user)) {
			userDao.update(user);
		}
		
	}

	@Override
	public void delete(int userId) {
		userDao.delete(userId);
		
	}

	@Override
	public User get(String email) {
		
		return userDao.get(email);
	}

	@Override
	public List<User> getAll() {
		for (User user : userDao.getAll()) {
			System.out.println(user.getFirstName() + " "+ user.getLastName() + " "+ user.getEmail());
		}
		return userDao.getAll();
	}
	
	public boolean userValidate(User user) {
		
		if(user.getFirstName().length()>2 && user.getLastName().length()>2) {
			return true;
		}
		System.out.println("Ad ve soyad en az 2 karakter olmalıdır.");
		return false;
	}


	

}
