package com.example.mysql.data.generator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mysql.data.generator.model.Information;

@Repository
public interface InformationRepository extends JpaRepository<Information, String>{

	@Query("select i from Information i where i.serialNumber = :serialNumber")
	public Information findBySerialNumber(@RequestParam(name="serialNumber") String serialNumber);
	
}
