package day5;

import day5.business.concretes.AuthManager;
import day5.business.concretes.UserManager;
import day5.core.AmazonMailManagerAdapter;
import day5.core.googleEmail.GoogleMailManagerAdapter;
import day5.dataAccess.concretes.HibernateUserDao;
import day5.dataAccess.concretes.InMemoryUserDao;
import day5.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		InMemoryUserDao inMemoryUserDao = new InMemoryUserDao();
		AuthManager authManager = new AuthManager(new UserManager(inMemoryUserDao, 
				new AmazonMailManagerAdapter()));
			
		User test=new User(4,"test","test","test@gmail.com","123456",true);
		User test1=new User(2,"test1","test1","test1@gmail.com","123456",true);
		
		
		authManager.register(test1);
		
		UserManager userManager=new UserManager(inMemoryUserDao, new GoogleMailManagerAdapter());
		//userManager.update(test);
		//userManager.delete(3);
		//userManager.getAll();
	}

}
