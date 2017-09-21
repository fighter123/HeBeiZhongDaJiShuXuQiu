package com.liying.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "guikoubumen", catalog = "db_hebeixuqiu")
public class Guikoubumen implements java.io.Serializable
{

	private String department;

	public Guikoubumen()
	{
	}
	
	public Guikoubumen(String department)
	{
		this.department = department;
	}

	@Id
	@Column(name = "Department", unique = true, nullable = false)
	public String getDepartment()
	{
		return this.department;
	}

	public void setDepartment(String department)
	{
		this.department = department;
	}

}