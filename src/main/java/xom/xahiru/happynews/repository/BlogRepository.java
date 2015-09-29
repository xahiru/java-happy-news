package xom.xahiru.happynews.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import xom.xahiru.happynews.entity.Blog;
import xom.xahiru.happynews.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

	public List<Blog> findByUser(User user);

}
