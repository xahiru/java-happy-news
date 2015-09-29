package xom.xahiru.happynews.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import xom.xahiru.happynews.entity.Blog;
import xom.xahiru.happynews.entity.User;
import xom.xahiru.happynews.repository.BlogRepository;
import xom.xahiru.happynews.repository.ItemRepository;
import xom.xahiru.happynews.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

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
		userRepository.save(user);
		
	}

}
