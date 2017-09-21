package com.liying.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "db_hebeixuqiu")
public class User implements java.io.Serializable
{

	// Fields

	private String username;
	private String password;
	private String realname;
	private String idcard;
	private String compnyname;
	private String belongapartment;
	private String adress;
	private String email;
	private String tell;
	private String phone;
	private String web;
	private String fax;
	private String about;
	private String faren;
	private String youbian;
	private String area;
	private Set<QuanXian> quanXians = new HashSet<QuanXian>(0);

	// Constructors

	/** default constructor */
	public User()
	{
	}

	/** minimal constructor */
	public User(String username, String password, String realname,
			String idcard, String compnyname)
	{
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.idcard = idcard;
		this.compnyname = compnyname;
	}

	/** full constructor */
	public User(String username, String password, String realname,
			String idcard, String compnyname, String belongapartment,
			String adress, String email, String tell, String phone, String web,
			String fax, String about, String faren, String youbian,
			String area, Set<QuanXian> quanXians)
	{
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.idcard = idcard;
		this.compnyname = compnyname;
		this.belongapartment = belongapartment;
		this.adress = adress;
		this.email = email;
		this.tell = tell;
		this.phone = phone;
		this.web = web;
		this.fax = fax;
		this.about = about;
		this.faren = faren;
		this.youbian = youbian;
		this.area = area;
		this.quanXians = quanXians;
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

	@Column(name = "password", nullable = false, length = 100)
	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Column(name = "realname", nullable = false, length = 100)
	public String getRealname()
	{
		return this.realname;
	}

	public void setRealname(String realname)
	{
		this.realname = realname;
	}

	@Column(name = "idcard", nullable = false, length = 100)
	public String getIdcard()
	{
		return this.idcard;
	}

	public void setIdcard(String idcard)
	{
		this.idcard = idcard;
	}

	@Column(name = "compnyname", nullable = false, length = 100)
	public String getCompnyname()
	{
		return this.compnyname;
	}

	public void setCompnyname(String compnyname)
	{
		this.compnyname = compnyname;
	}

	@Column(name = "belongapartment", length = 100)
	public String getBelongapartment()
	{
		return this.belongapartment;
	}

	public void setBelongapartment(String belongapartment)
	{
		this.belongapartment = belongapartment;
	}

	@Column(name = "adress", length = 100)
	public String getAdress()
	{
		return this.adress;
	}

	public void setAdress(String adress)
	{
		this.adress = adress;
	}

	@Column(name = "email", length = 100)
	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@Column(name = "tell", length = 100)
	public String getTell()
	{
		return this.tell;
	}

	public void setTell(String tell)
	{
		this.tell = tell;
	}

	@Column(name = "phone", length = 100)
	public String getPhone()
	{
		return this.phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	@Column(name = "web", length = 100)
	public String getWeb()
	{
		return this.web;
	}

	public void setWeb(String web)
	{
		this.web = web;
	}

	@Column(name = "fax", length = 100)
	public String getFax()
	{
		return this.fax;
	}

	public void setFax(String fax)
	{
		this.fax = fax;
	}

	@Column(name = "about", length = 100)
	public String getAbout()
	{
		return this.about;
	}

	public void setAbout(String about)
	{
		this.about = about;
	}

	@Column(name = "faren", length = 100)
	public String getFaren()
	{
		return this.faren;
	}

	public void setFaren(String faren)
	{
		this.faren = faren;
	}

	@Column(name = "youbian", length = 100)
	public String getYoubian()
	{
		return this.youbian;
	}

	public void setYoubian(String youbian)
	{
		this.youbian = youbian;
	}

	@Column(name = "area", length = 100)
	public String getArea()
	{
		return this.area;
	}

	public void setArea(String area)
	{
		this.area = area;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<QuanXian> getQuanXians()
	{
		return this.quanXians;
	}

	public void setQuanXians(Set<QuanXian> quanXians)
	{
		this.quanXians = quanXians;
	}

}