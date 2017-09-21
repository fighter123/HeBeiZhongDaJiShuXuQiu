package com.liying.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * XuQiu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "xuqiu")
public class XuQiu implements java.io.Serializable
{

	// Fields

	private String xuQiuNum;
	private String username;
	private String companyAllname;
	private String belongApartment;
	private String companyAdrss;
	private String area;
	private String web;
	private String email;
	private String faRen;
	private String youBian;
	private String lianXiRen;
	private String tell;
	private String phone;
	private String fax;
	private String jiGouShuXing;
	private String jiGouJianJie;
	private String xuQiuName;
	private String startYear;
	private String endYear;
	private String gaiShu1;
	private String gaiShu2;
	private String gaiShu3;
	private String guanJianZi;
	private String sumMoney;
	private String way;
	private String heZuoDanWei;
	private String huoDongLeiXing;
	private String suoShuLingYu;
	private String yingYongHangYe;
	private String xueKeFenLei;
	private String state;
	private String reason;
	private String shenHeBuMen;
	private int locker;

	// Constructors

	/** default constructor */
	public XuQiu()
	{
	}

	/** minimal constructor */
	public XuQiu(String xuQiuNum, String username, String belongApartment,
			String companyAdrss, String area, String email, String faRen,
			String jiGouShuXing, String xuQiuName, String startYear,
			String endYear, String gaiShu1, String gaiShu2, String gaiShu3,
			String guanJianZi, String way, String huoDongLeiXing,
			String suoShuLingYu, String yingYongHangYe)
	{
		this.xuQiuNum = xuQiuNum;
		this.username = username;
		this.belongApartment = belongApartment;
		this.companyAdrss = companyAdrss;
		this.area = area;
		this.email = email;
		this.faRen = faRen;
		this.jiGouShuXing = jiGouShuXing;
		this.xuQiuName = xuQiuName;
		this.startYear = startYear;
		this.endYear = endYear;
		this.gaiShu1 = gaiShu1;
		this.gaiShu2 = gaiShu2;
		this.gaiShu3 = gaiShu3;
		this.guanJianZi = guanJianZi;
		this.way = way;
		this.huoDongLeiXing = huoDongLeiXing;
		this.suoShuLingYu = suoShuLingYu;
		this.yingYongHangYe = yingYongHangYe;
	}

	/** full constructor */
	public XuQiu(String xuQiuNum, String username, String companyAllname,
			String belongApartment, String companyAdrss, String area,
			String web, String email, String faRen, String youBian,
			String lianXiRen, String tell, String phone, String fax,
			String jiGouShuXing, String jiGouJianJie, String xuQiuName,
			String startYear, String endYear, String gaiShu1, String gaiShu2,
			String gaiShu3, String guanJianZi, String sumMoney, String way,
			String heZuoDanWei, String huoDongLeiXing, String suoShuLingYu,
			String yingYongHangYe, String xueKeFenLei, String state,
			String reason, String shenHeBuMen, int locker)
	{
		this.xuQiuNum = xuQiuNum;
		this.username = username;
		this.companyAllname = companyAllname;
		this.belongApartment = belongApartment;
		this.companyAdrss = companyAdrss;
		this.area = area;
		this.web = web;
		this.email = email;
		this.faRen = faRen;
		this.youBian = youBian;
		this.lianXiRen = lianXiRen;
		this.tell = tell;
		this.phone = phone;
		this.fax = fax;
		this.jiGouShuXing = jiGouShuXing;
		this.jiGouJianJie = jiGouJianJie;
		this.xuQiuName = xuQiuName;
		this.startYear = startYear;
		this.endYear = endYear;
		this.gaiShu1 = gaiShu1;
		this.gaiShu2 = gaiShu2;
		this.gaiShu3 = gaiShu3;
		this.guanJianZi = guanJianZi;
		this.sumMoney = sumMoney;
		this.way = way;
		this.heZuoDanWei = heZuoDanWei;
		this.huoDongLeiXing = huoDongLeiXing;
		this.suoShuLingYu = suoShuLingYu;
		this.yingYongHangYe = yingYongHangYe;
		this.xueKeFenLei = xueKeFenLei;
		this.state = state;
		this.reason = reason;
		this.shenHeBuMen = shenHeBuMen;
		this.locker = locker;
	}

	// Property accessors
	@Id
	@Column(name = "xuQiuNum", unique = true, nullable = false, length = 100)
	public String getXuQiuNum()
	{
		return this.xuQiuNum;
	}

	public void setXuQiuNum(String xuQiuNum)
	{
		this.xuQiuNum = xuQiuNum;
	}

	@Column(name = "username", nullable = false, length = 100)
	public String getUsername()
	{
		return this.username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	@Column(name = "companyAllname", length = 100)
	public String getCompanyAllname()
	{
		return this.companyAllname;
	}

	public void setCompanyAllname(String companyAllname)
	{
		this.companyAllname = companyAllname;
	}

	@Column(name = "belongApartment", nullable = false, length = 100)
	public String getBelongApartment()
	{
		return this.belongApartment;
	}

	public void setBelongApartment(String belongApartment)
	{
		this.belongApartment = belongApartment;
	}

	@Column(name = "companyAdrss", nullable = false, length = 100)
	public String getCompanyAdrss()
	{
		return this.companyAdrss;
	}

	public void setCompanyAdrss(String companyAdrss)
	{
		this.companyAdrss = companyAdrss;
	}

	@Column(name = "area", nullable = false, length = 100)
	public String getArea()
	{
		return this.area;
	}

	public void setArea(String area)
	{
		this.area = area;
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

	@Column(name = "email", nullable = false, length = 100)
	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@Column(name = "faRen", nullable = false, length = 100)
	public String getFaRen()
	{
		return this.faRen;
	}

	public void setFaRen(String faRen)
	{
		this.faRen = faRen;
	}

	@Column(name = "youBian", length = 100)
	public String getYouBian()
	{
		return this.youBian;
	}

	public void setYouBian(String youBian)
	{
		this.youBian = youBian;
	}

	@Column(name = "lianXiRen", length = 100)
	public String getLianXiRen()
	{
		return this.lianXiRen;
	}

	public void setLianXiRen(String lianXiRen)
	{
		this.lianXiRen = lianXiRen;
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

	@Column(name = "fax", length = 100)
	public String getFax()
	{
		return this.fax;
	}

	public void setFax(String fax)
	{
		this.fax = fax;
	}

	@Column(name = "jiGouShuXing", nullable = false, length = 100)
	public String getJiGouShuXing()
	{
		return this.jiGouShuXing;
	}

	public void setJiGouShuXing(String jiGouShuXing)
	{
		this.jiGouShuXing = jiGouShuXing;
	}

	@Column(name = "jiGouJianJie", length = 100)
	public String getJiGouJianJie()
	{
		return this.jiGouJianJie;
	}

	public void setJiGouJianJie(String jiGouJianJie)
	{
		this.jiGouJianJie = jiGouJianJie;
	}

	@Column(name = "xuQiuName", nullable = false, length = 100)
	public String getXuQiuName()
	{
		return this.xuQiuName;
	}

	public void setXuQiuName(String xuQiuName)
	{
		this.xuQiuName = xuQiuName;
	}

	@Column(name = "startYear", nullable = false, length = 100)
	public String getStartYear()
	{
		return this.startYear;
	}

	public void setStartYear(String startYear)
	{
		this.startYear = startYear;
	}

	@Column(name = "endYear", nullable = false, length = 100)
	public String getEndYear()
	{
		return this.endYear;
	}

	public void setEndYear(String endYear)
	{
		this.endYear = endYear;
	}

	@Column(name = "gaiShu1", nullable = false, length = 1000)
	public String getGaiShu1()
	{
		return this.gaiShu1;
	}

	public void setGaiShu1(String gaiShu1)
	{
		this.gaiShu1 = gaiShu1;
	}

	@Column(name = "gaiShu2", nullable = false, length = 1000)
	public String getGaiShu2()
	{
		return this.gaiShu2;
	}

	public void setGaiShu2(String gaiShu2)
	{
		this.gaiShu2 = gaiShu2;
	}

	@Column(name = "gaiShu3", nullable = false, length = 1000)
	public String getGaiShu3()
	{
		return this.gaiShu3;
	}

	public void setGaiShu3(String gaiShu3)
	{
		this.gaiShu3 = gaiShu3;
	}

	@Column(name = "guanJianZi", nullable = false, length = 100)
	public String getGuanJianZi()
	{
		return this.guanJianZi;
	}

	public void setGuanJianZi(String guanJianZi)
	{
		this.guanJianZi = guanJianZi;
	}

	@Column(name = "sumMoney", length = 100)
	public String getSumMoney()
	{
		return this.sumMoney;
	}

	public void setSumMoney(String sumMoney)
	{
		this.sumMoney = sumMoney;
	}

	@Column(name = "way", nullable = false, length = 100)
	public String getWay()
	{
		return this.way;
	}

	public void setWay(String way)
	{
		this.way = way;
	}

	@Column(name = "heZuoDanWei", length = 100)
	public String getHeZuoDanWei()
	{
		return this.heZuoDanWei;
	}

	public void setHeZuoDanWei(String heZuoDanWei)
	{
		this.heZuoDanWei = heZuoDanWei;
	}

	@Column(name = "huoDongLeiXing", nullable = false, length = 100)
	public String getHuoDongLeiXing()
	{
		return this.huoDongLeiXing;
	}

	public void setHuoDongLeiXing(String huoDongLeiXing)
	{
		this.huoDongLeiXing = huoDongLeiXing;
	}

	@Column(name = "suoShuLingYu", length = 100)
	public String getSuoShuLingYu()
	{
		return this.suoShuLingYu;
	}

	public void setSuoShuLingYu(String suoShuLingYu)
	{
		this.suoShuLingYu = suoShuLingYu;
	}

	@Column(name = "yingYongHangYe", nullable = false, length = 100)
	public String getYingYongHangYe()
	{
		return this.yingYongHangYe;
	}

	public void setYingYongHangYe(String yingYongHangYe)
	{
		this.yingYongHangYe = yingYongHangYe;
	}

	@Column(name = "xueKeFenLei", length = 100)
	public String getXueKeFenLei()
	{
		return this.xueKeFenLei;
	}

	public void setXueKeFenLei(String xueKeFenLei)
	{
		this.xueKeFenLei = xueKeFenLei;
	}

	@Column(name = "state", length = 100)
	public String getState()
	{
		return this.state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	@Column(name = "reason", length = 100)
	public String getReason()
	{
		return this.reason;
	}

	public void setReason(String reason)
	{
		this.reason = reason;
	}

	@Column(name = "shenHeBuMen", length = 100)
	public String getShenHeBuMen()
	{
		return this.shenHeBuMen;
	}

	public void setShenHeBuMen(String shenHeBuMen)
	{
		this.shenHeBuMen = shenHeBuMen;
	}

	@Column(name = "locker")
	public int getLocker()
	{
		return this.locker;
	}

	public void setLocker(int locker)
	{
		this.locker = locker;
	}

}