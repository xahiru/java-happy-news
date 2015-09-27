package xom.xahiru.happynews.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xom.xahiru.happynews.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
