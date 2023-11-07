package com.example.mysql.data.generator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mysql.data.generator.model.Information;
import com.example.mysql.data.generator.repository.InformationRepository;

@Service
public class InformationService {

	@Autowired
	private InformationRepository repo;
	
	public Information findBySerialNumber(String serialNumber){
		return repo.findBySerialNumber(serialNumber);
	}
	
	public List<Information> findAll(){
		return repo.findAll();
	}
	
	public Long countAll() {
		return repo.count();
	}
	
	public void saveAll(List<Information> informations) {
		repo.saveAll(informations);
	}
	
}
