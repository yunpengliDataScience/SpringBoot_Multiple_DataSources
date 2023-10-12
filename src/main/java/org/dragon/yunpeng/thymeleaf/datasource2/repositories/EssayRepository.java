package org.dragon.yunpeng.thymeleaf.datasource2.repositories;

import java.util.List;

import org.dragon.yunpeng.thymeleaf.datasource2.entities.Essay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EssayRepository extends JpaRepository<Essay, Long> {  //TODO: Why JpaSpecificationExecutor not work?

	List<Essay> findByAuthor(String author);

	@Query("select e from Essay e where e.title like %:titleSegment%")
	List<Essay> findEssays(@Param("titleSegment") String titleSegment);

}
