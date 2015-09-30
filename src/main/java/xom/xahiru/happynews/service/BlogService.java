package xom.xahiru.happynews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import xom.xahiru.happynews.entity.Blog;
import xom.xahiru.happynews.entity.User;
import xom.xahiru.happynews.repository.BlogRepository;
import xom.xahiru.happynews.repository.UserRepository;

@Service
public class BlogService {
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private UserRepository userRepository;

	public void save(Blog blog, String name) {

		User user = userRepository.findByName(name);
		
		blog.setUser(user);
		
		blogRepository.save(blog);

	}

	@PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("blog") Blog blog) {
		blogRepository.delete(blog);		
	}


	public Blog findOne(int id) {
		return blogRepository.findOne(id);
	}


}
