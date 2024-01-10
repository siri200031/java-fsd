package com.ecommerce.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table
(name = "feedback") 
public class Feedback 
{ 
	@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id; 
	@Column
	(nullable = false) 
	private String name;
	@Column
	(nullable = false) 
	private String email; 
	@Column
	(nullable = false) 
	private int rating; 
	@Column 
	private String comment; 
	public Feedback() 
	{
		
	} 
	public Feedback(String name, String email, int rating, String comment) 
	{
		this.name = name; 
		this.email = email; 
		this.rating = rating; 
		this.comment = comment; 
		} 
	public Long getId() 
	{ 
		return id; 
		} 
	public void setId(Long id) 
	{ 
		this.id = id; 
		} 
	public String getName() 
	{ 
		return name;
		} 
	public void setName(String name) 
	{ 
		this.name = name; 
		} 
	public String getEmail() 
	{ 
		return email; 
		} 
	public void setEmail(String email) 
	{ 
		this.email = email;
		}
	public int getRating() 
	{
		return rating;
		} 
	public void setRating(int rating)
	{
		this.rating = rating; 
		}
	public String getComment()
	{
		return comment;
} 
	public void setComment(String comment) 
	{
		this.comment = comment;
		}
	}