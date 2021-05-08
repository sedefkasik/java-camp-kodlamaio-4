package day5.core.googleEmail;

import day5.core.EmailService;
import day5.googleMail.GoogleMailManager;

public class GoogleMailManagerAdapter implements EmailService {
private GoogleMailManager googleMailManager;
	
	public GoogleMailManagerAdapter() {
		super();
		this.googleMailManager = new GoogleMailManager();
	}
	@Override
	public void send(String email, String message) {
		googleMailManager.send(email, message);
		
	}
}
