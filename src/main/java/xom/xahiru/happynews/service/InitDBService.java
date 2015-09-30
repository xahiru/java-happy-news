package xom.xahiru.happynews.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import xom.xahiru.happynews.entity.Blog;
import xom.xahiru.happynews.entity.Item;
import xom.xahiru.happynews.entity.Role;
import xom.xahiru.happynews.entity.User;
import xom.xahiru.happynews.repository.BlogRepository;
import xom.xahiru.happynews.repository.ItemRepository;
import xom.xahiru.happynews.repository.RoleRepository;
import xom.xahiru.happynews.repository.UserRepository;
@Transactional
@Service
public class InitDBService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@PostConstruct
	public void init() {
		
		Role userRole = new Role();
		userRole.setName("ROLE_USER");
		roleRepository.save(userRole);
		

		Role adminRole = new Role();
		adminRole.setName("ROLE_ADMIN");
		roleRepository.save(adminRole);
		
		User userAdmin = new User();
		List<Role> roles = new ArrayList<Role>();
		roles.add(adminRole);
		roles.add(userRole);
		userAdmin.setRoles(roles);
		userAdmin.setName("admin");
		userAdmin.setEnable(true);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		userAdmin.setPassword(passwordEncoder.encode("admin"));
		userRepository.save(userAdmin);
		
		Blog javavidsBlog = new Blog();
		javavidsBlog.setName("Java Vids");
		javavidsBlog.setUser(userAdmin);
		javavidsBlog.setUrl("http://feeds.feedburner.com/javavids?format=xml");
		blogRepository.save(javavidsBlog);
		
		Item item1 = new Item();
		item1.setBlog(javavidsBlog);
		item1.setTitle("Fisrt");
		item1.setLink("http://www.javavids.com/");
		item1.setPublishedDate(new Date() );
		itemRepository.save(item1);

		Item item2 = new Item();
		item2.setBlog(javavidsBlog);
		item2.setTitle("Second");
		item2.setLink("http://www.javavids.com/");
		item2.setPublishedDate(new Date() );
		itemRepository.save(item2);
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	

}
