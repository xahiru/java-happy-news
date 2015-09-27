package xom.xahiru.happynews.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xom.xahiru.happynews.entity.User;
import xom.xahiru.happynews.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}

}
