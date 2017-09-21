package com.liying.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * QuanXian entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "userquanxian", catalog = "db_hebeixuqiu")
public class QuanXian implements java.io.Serializable
{

	// Fields

	private String username;
	private User user;
	private String xuQiuZhengJi;
	private String xuQiuGuanLi;
	private String yongHuGuanLi;
	private String xingShiShenHe;
	private String buMenShenHe;
	private String tongJiChaXun;
	private String suoShuBuMen;
	private String power;

	// Constructors

	/** default constructor */
	public QuanXian()
	{
	}

	/** minimal constructor */
	public QuanXian(String username, User user)
	{
		this.username = username;
		this.user = user;
	}

	/** full constructor */
	public QuanXian(String username, User user, String xuQiuZhengJi,
			String xuQiuGuanLi, String yongHuGuanLi, String xingShiShenHe,
			String buMenShenHe, String tongJiChaXun, String suoShuBuMen,
			String power)
	{
		this.username = username;
		this.user = user;
		this.xuQiuZhengJi = xuQiuZhengJi;
		this.xuQiuGuanLi = xuQiuGuanLi;
		this.yongHuGuanLi = yongHuGuanLi;
		this.xingShiShenHe = xingShiShenHe;
		this.buMenShenHe = buMenShenHe;
		this.tongJiChaXun = tongJiChaXun;
		this.suoShuBuMen = suoShuBuMen;
		this.power = power;
	}

	// Property accessors
	@Id
	@Column(name = "username", unique = true, nullable = false, length = 100)
	public String getUsername()
	{
		return this.username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username", unique = true, nullable = false, insertable = false, updatable = false)
	public User getUser()
	{
		return this.user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	@Column(name = "xuQiuZhengJi", length = 10)
	public String getXuQiuZhengJi()
	{
		return this.xuQiuZhengJi;
	}

	public void setXuQiuZhengJi(String xuQiuZhengJi)
	{
		this.xuQiuZhengJi = xuQiuZhengJi;
	}

	@Column(name = "xuQiuGuanLi", length = 10)
	public String getXuQiuGuanLi()
	{
		return this.xuQiuGuanLi;
	}

	public void setXuQiuGuanLi(String xuQiuGuanLi)
	{
		this.xuQiuGuanLi = xuQiuGuanLi;
	}

	@Column(name = "yongHuGuanLi", length = 10)
	public String getYongHuGuanLi()
	{
		return this.yongHuGuanLi;
	}

	public void setYongHuGuanLi(String yongHuGuanLi)
	{
		this.yongHuGuanLi = yongHuGuanLi;
	}

	@Column(name = "xingShiShenHe", length = 10)
	public String getXingShiShenHe()
	{
		return this.xingShiShenHe;
	}

	public void setXingShiShenHe(String xingShiShenHe)
	{
		this.xingShiShenHe = xingShiShenHe;
	}

	@Column(name = "buMenShenHe", length = 10)
	public String getBuMenShenHe()
	{
		return this.buMenShenHe;
	}

	public void setBuMenShenHe(String buMenShenHe)
	{
		this.buMenShenHe = buMenShenHe;
	}

	@Column(name = "tongJiChaXun", length = 10)
	public String getTongJiChaXun()
	{
		return this.tongJiChaXun;
	}

	public void setTongJiChaXun(String tongJiChaXun)
	{
		this.tongJiChaXun = tongJiChaXun;
	}

	@Column(name = "suoShuBuMen", length = 10)
	public String getSuoShuBuMen()
	{
		return this.suoShuBuMen;
	}

	public void setSuoShuBuMen(String suoShuBuMen)
	{
		this.suoShuBuMen = suoShuBuMen;
	}

	@Column(name = "power", length = 10)
	public String getPower()
	{
		return this.power;
	}

	public void setPower(String power)
	{
		this.power = power;
	}

}