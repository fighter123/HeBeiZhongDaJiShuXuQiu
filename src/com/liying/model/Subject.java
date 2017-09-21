package com.liying.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Subject entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "subject", catalog = "db_hebeixuqiu")
public class Subject implements java.io.Serializable
{

	// Fields

	private String subjectCode;
	private String subjectTitle;

	// Constructors

	/** default constructor */
	public Subject()
	{
	}

	/** minimal constructor */
	public Subject(String subjectCode)
	{
		this.subjectCode = subjectCode;
	}

	/** full constructor */
	public Subject(String subjectCode, String subjectTitle)
	{
		this.subjectCode = subjectCode;
		this.subjectTitle = subjectTitle;
	}

	// Property accessors
	@Id
	@Column(name = "subjectCode", unique = true, nullable = false)
	public String getSubjectCode()
	{
		return this.subjectCode;
	}

	public void setSubjectCode(String subjectCode)
	{
		this.subjectCode = subjectCode;
	}

	@Column(name = "subjectTitle")
	public String getSubjectTitle()
	{
		return this.subjectTitle;
	}

	public void setSubjectTitle(String subjectTitle)
	{
		this.subjectTitle = subjectTitle;
	}

}