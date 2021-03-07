package com.coorp.rob.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "exam")
public class Exam {
	@Id
	private String id;
	
	private int voto;
	
	private String materia;
	
	public Exam() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	@Override
	public String toString() {
		return "Exam [id=" + id + ", voto=" + voto + ", materia=" + materia + "]";
	}

}
