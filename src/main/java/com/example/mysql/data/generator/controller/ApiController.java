package com.example.mysql.data.generator.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mysql.data.generator.response.ResponseTemplate;
import com.example.mysql.data.generator.service.InformationService;
import com.example.mysql.data.generator.util.DataGenerator;

@RestController
@RequestMapping("api")
public class ApiController {
	
	@Autowired
	private InformationService inforService;
	
	@Autowired
	private DataGenerator generator;

	@GetMapping("/run/{count}")
	public ResponseTemplate run(@PathVariable("count") Long count) {
		ResponseTemplate response = new ResponseTemplate();
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					generator.generateData(count);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.submit(r);
		executor.shutdown();
		
		response.setStatus("1");
		response.setMessage("success");
		response.setData(null);

		return response;
	}
	
	@GetMapping("check")
	public ResponseTemplate check() {
		ResponseTemplate response = new ResponseTemplate();
		
		Long records = inforService.countAll();
		
		response.setStatus("1");
		response.setMessage("success");
		response.setData(String.format("We have %s records", records));

		return response;
	}
	
	
}
