package com.example.mysql.data.generator.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="information")
public class Information {

	@Id
	private String id;
	private String serialNumber;
	private String npwp;
	private String certificate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
}
