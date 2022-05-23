package com.sample.nace.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sample.nace.entity.Nace;

@Repository
public interface NaceRepo extends JpaRepository<Nace, Long>{

	Nace findByOrderNumber(String order);
	
}
