package com.models;

import javax.persistence.*;

@Entity
public class Course 
{
	@Id
	private int cno;
	private String cname;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "c")
	public void setCno(int cno) 
	{
		this.cno = cno;
	}
	public int getCno() 
	{
		return cno;
	}
	
	public void setCname(String cname) 
	{
		this.cname = cname;
	}
	public String getCname() 
	{
		return cname;
	}	
}
