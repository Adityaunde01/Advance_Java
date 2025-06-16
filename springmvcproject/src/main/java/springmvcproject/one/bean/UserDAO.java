package springmvcproject.one.bean;

import org.springframework.stereotype.Component;

@Component
public interface UserDAO {
	
	public User getUser();
}
