package com.example.demo.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Center {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String centername;
	private String centercity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCentername() {
		return centername;
	}
	public void setCentername(String centername) {
		this.centername = centername;
	}
	public String getCentercity() {
		return centercity;
	}
	public void setCentercity(String centercity) {
		this.centercity = centercity;
	}

}