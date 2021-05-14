package com.models;

import javax.persistence.*;

@Entity
public class Faculty 
{
	@Id
	private int fid;
	private String fname;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "f")
	@JoinColumn(name = "cno")
	private Course c;

	public void setFid(int fid) 
	{
		this.fid = fid;
	}
	public int getFid() 
	{
		return fid;
	}

	public void setFname(String fname) 
	{
		this.fname = fname;
	}
	public String getFname() 
	{
		return fname;
	}

	public void setC(Course c) 
	{
		this.c = c;
	}
	public Course getC() 
	{
		return c;
	}
}