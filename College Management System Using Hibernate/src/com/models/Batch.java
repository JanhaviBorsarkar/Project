package com.models;

import javax.persistence.*;

@Entity
public class Batch 
{
	@Id
	private int bid;
	private String bname;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "b")
	@JoinColumn(name = "fid")
	private Faculty f;

	public void setBid(int bid)
	{
		this.bid = bid;
	}
	public int getBid() 	
	{
		return bid;
	}

	public void setBname(String bname) 
	{
		this.bname = bname;
	}
	public String getBname() 
	{
		return bname;
	}

	public void setF(Faculty f) 
	{
		this.f = f;
	}
	public Faculty getF() 
	{
		return f;
	}
}
