package com.example.mysql.data.generator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mysql.data.generator.model.Information;

@Repository
public interface InformationRepository extends JpaRepository<Information, String>{

}
