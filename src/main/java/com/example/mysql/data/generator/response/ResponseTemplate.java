package com.example.mysql.data.generator.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplate {

	private String status;
	private String message;
	private Object data;
	
	
}
