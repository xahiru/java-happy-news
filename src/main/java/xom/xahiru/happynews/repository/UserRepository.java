package xom.xahiru.happynews.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xom.xahiru.happynews.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
