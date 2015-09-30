package xom.xahiru.happynews.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import xom.xahiru.happynews.entity.Blog;
import xom.xahiru.happynews.entity.Role;
import xom.xahiru.happynews.entity.User;
import xom.xahiru.happynews.repository.BlogRepository;
import xom.xahiru.happynews.repository.ItemRepository;
import xom.xahiru.happynews.repository.RoleRepository;
import xom.xahiru.happynews.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private ItemRepository itemRepository;

	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	public User getOneUser(int id) {
		return userRepository.getOne(id);
	}

	@Transactional
	public User fingUserWithBlogs(int id) {

		User user = userRepository.getOne(id);

		List<Blog> blogs = blogRepository.findByUser(user);

		for (Blog blog : blogs) {

			blog.setItems(itemRepository.findByBlog(blog, new PageRequest(0, 10, Direction.ASC, "publishedDate")));

		}

		user.setBlogs(blogs);

		return user;

	}

	public void save(User user) {

		List<Role> roles = new ArrayList<Role>();
		
		roles.add(roleRepository.findByName("ROLE_USER"));

		user.setRoles(roles);
		user.setEnable(true);
		
		BCryptPasswordEncoder be = new BCryptPasswordEncoder();
		
		user.setPassword(be.encode(user.getPassword()));
		

		userRepository.save(user);

	}
	
	@Transactional
	public User fingUserWithBlogs(String name) {
		return fingUserWithBlogs(userRepository.findByName(name).getId());
	}

	public void delete(int id) {

		userRepository.delete(id);
	}

}
