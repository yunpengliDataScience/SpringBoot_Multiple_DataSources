package org.dragon.yunpeng.thymeleaf.datasource1.repositories;

import java.util.List;

import org.dragon.yunpeng.thymeleaf.datasource1.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	//@RestResource(rel = "findByName", path="findByName")
	List<User> findByName(String name);

}
