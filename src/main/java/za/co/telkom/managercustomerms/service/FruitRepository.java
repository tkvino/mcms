package za.co.telkom.managercustomerms.service;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FruitRepository extends CrudRepository<Fruit, Integer> {
  List<Fruit> findAll();

}
