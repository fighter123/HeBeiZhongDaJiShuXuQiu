package com.liying.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Area entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "area", catalog = "db_hebeixuqiu")
public class Area implements java.io.Serializable
{

	// Fields

	private String areaCode;
	private String city;

	// Constructors

	/** default constructor */
	public Area()
	{
	}

	/** minimal constructor */
	public Area(String areaCode)
	{
		this.areaCode = areaCode;
	}

	/** full constructor */
	public Area(String areaCode, String city)
	{
		this.areaCode = areaCode;
		this.city = city;
	}

	// Property accessors
	@Id
	@Column(name = "areaCode", unique = true, nullable = false)
	public String getAreaCode()
	{
		return this.areaCode;
	}

	public void setAreaCode(String areaCode)
	{
		this.areaCode = areaCode;
	}

	@Column(name = "city")
	public String getCity()
	{
		return this.city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

}