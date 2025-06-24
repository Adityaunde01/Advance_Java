package com.telcom.ticket.entity;

import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ticket")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="phoneNum",unique = true)
	@NotNull(message = "phone no cannot be null")
	private String phoneNum;
	
	@Column(name = "category")
	@Enumerated(EnumType.STRING)
	private Category category;
	
	@Column(name = "issueDetais")
	private String issueDetails;
	
	@Column(name = "resDetails")
	private String resolutionDetails;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status  = Status.OPEN;
	
	@Column(name = "createdDate")
	private Timestamp CreatedDate = new Timestamp(System.currentTimeMillis());
	
	@Column(name = "resDate")
	private Timestamp resuDate= new Timestamp(System.currentTimeMillis());

}
