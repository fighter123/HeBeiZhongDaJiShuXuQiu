package com.liying.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Industry entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "industry", catalog = "db_hebeixuqiu")
public class Industry implements java.io.Serializable
{

	// Fields

	private Integer id;
	private String industryCode;
	private String industryTitle;

	// Constructors

	/** default constructor */
	public Industry()
	{
	}

	/** full constructor */
	public Industry(String industryCode, String industryTitle)
	{
		this.industryCode = industryCode;
		this.industryTitle = industryTitle;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	@Column(name = "industryCode")
	public String getIndustryCode()
	{
		return this.industryCode;
	}

	public void setIndustryCode(String industryCode)
	{
		this.industryCode = industryCode;
	}

	@Column(name = "industryTitle")
	public String getIndustryTitle()
	{
		return this.industryTitle;
	}

	public void setIndustryTitle(String industryTitle)
	{
		this.industryTitle = industryTitle;
	}

}