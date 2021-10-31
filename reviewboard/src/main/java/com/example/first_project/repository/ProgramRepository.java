package com.example.first_project.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.first_project.model.Program;

public interface ProgramRepository extends JpaRepository<Program, Long>{
	
	@Query(value="select p.*, avg(r.starrating) from program p RIGHT OUTER JOIN reply r ON r.bnum = p.programnum  where p.category=?1 group by r.bnum order by AVG(r.starrating)", nativeQuery = true)
	Page<Program> findByCategory(String category, Pageable pageable);
	
	
}
