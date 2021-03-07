package com.coorp.rob.model;


import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.coorp.rob.annotation.CascadeSave;

@Document(collection  = "student")
public class Student {

	@Id
	private String id;

	private String matricola;

	@DBRef
	@CascadeSave
	private List<Exam> esami = new ArrayList<Exam>();

	public Student() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public List<Exam> getEsami() {
		return esami;
	}

	public void setEsami(List<Exam> esami) {
		this.esami = esami;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", matricola=" + matricola + "]";
	}

}
