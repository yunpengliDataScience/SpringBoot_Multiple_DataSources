package org.dragon.yunpeng.thymeleaf.datasource1.repositories;

import java.util.List;

import org.dragon.yunpeng.thymeleaf.datasource1.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByName(String name);
}
