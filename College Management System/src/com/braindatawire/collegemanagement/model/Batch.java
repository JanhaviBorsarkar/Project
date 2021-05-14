package com.braindatawire.collegemanagement.model;

public class Batch 
{
	private int bid;
	private String bname;
	private Faculty faculty;
	
	
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
	
	public void setFaculty(Faculty faculty) 
	{
		this.faculty = faculty;
	}
	public Faculty getFaculty() 
	{
		return faculty;
	}
}
