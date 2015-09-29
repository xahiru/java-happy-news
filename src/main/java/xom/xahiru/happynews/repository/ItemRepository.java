package xom.xahiru.happynews.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import xom.xahiru.happynews.entity.Blog;
import xom.xahiru.happynews.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	public List<Item> findByBlog(Blog blog, Pageable pageable);

}
