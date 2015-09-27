package xom.xahiru.happynews.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xom.xahiru.happynews.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
