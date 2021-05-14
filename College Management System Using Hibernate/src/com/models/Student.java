package com.models;

import javax.persistence.*;

@Entity
public class Student 
{
	@Id
	private int rno;
	private String sname;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bid")
	private Batch b;

	public void setRno(int rno) 
	{
		this.rno = rno;
	}
	public int getRno() 
	{
		return rno;
	}

	public void setSname(String sname) 
	{
		this.sname = sname;
	}
	public String getSname() 
	{
		return sname;
	}

	public void setB(Batch b) 
	{
		this.b = b;
	}
	public Batch getB() 
	{
		return b;
	}
}
