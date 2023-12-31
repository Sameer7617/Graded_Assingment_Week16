package com.gl.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String ticketTitle;
	String ticketShortDescription;
	Date ticketCreatedOn;
}
