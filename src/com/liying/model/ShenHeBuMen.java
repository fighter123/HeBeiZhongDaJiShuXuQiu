package com.liying.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ShenHeBuMen entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "shenhebumen", catalog = "db_hebeixuqiu")
public class ShenHeBuMen implements java.io.Serializable
{

	// Fields

	private String shBuMencode;
	private String buMenName;

	// Constructors

	/** default constructor */
	public ShenHeBuMen()
	{
	}

	/** minimal constructor */
	public ShenHeBuMen(String shBuMencode)
	{
		this.shBuMencode = shBuMencode;
	}

	/** full constructor */
	public ShenHeBuMen(String shBuMencode, String buMenName)
	{
		this.shBuMencode = shBuMencode;
		this.buMenName = buMenName;
	}

	// Property accessors
	@Id
	@Column(name = "shBuMencode", unique = true, nullable = false)
	public String getShBuMencode()
	{
		return this.shBuMencode;
	}

	public void setShBuMencode(String shBuMencode)
	{
		this.shBuMencode = shBuMencode;
	}

	@Column(name = "buMenName")
	public String getBuMenName()
	{
		return this.buMenName;
	}

	public void setBuMenName(String buMenName)
	{
		this.buMenName = buMenName;
	}

}