package com.liying.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.liying.model.Area;
import com.liying.model.Guikoubumen;
import com.liying.model.ShenHeBuMen;
import com.liying.model.Subject;
import com.liying.model.Industry;
import com.liying.model.User;
import com.liying.model.XuQiu;
import com.liying.service.TianBaoManager;
import com.liying.service.UserManage;
import com.mysql.fabric.xmlrpc.base.Data;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;
@Component("tianBaoAction")
@Scope("prototype")	
public class TianBaoAction extends ActionSupport 
{
	//变量***********************************************************************
	private String subjectCode1; //用于接收客户端发来的一级学科代码											
	private String subjectCode2; //用于接收客户端发来的二级学科代码	
	private String industryCode1;//用于接收客户端发来的一级行业代码											
	private String industryCode2;//用于接收客户端发来的二级行业代码	
	private UserManage userManage;
	private TianBaoManager tianBaoManager;
	private User user;           //用户基本信息
	private List<Guikoubumen> guikoubumens = new ArrayList<Guikoubumen>();//归口部门集guikoubumens
	private List<Area> areas = new ArrayList<Area>();					  //地域集
	private List<Subject> subjects = new ArrayList<Subject>();			  //一级学科类别集
	private List<Subject> subjects2 = new ArrayList<Subject>();			  //二级学科类别集
	private List<Subject> subjects3 = new ArrayList<Subject>();			  //三级学科类别集
	private List<Industry> industries = new ArrayList<Industry>();		  //一级行业类别集
	private List<Industry> industries2 = new ArrayList<Industry>();		  //二级行业类别集
	private List<Industry> industries3 = new ArrayList<Industry>();		  //三级行业类别集
	private List<ShenHeBuMen> shenHeBuMens= new ArrayList<ShenHeBuMen>(); //审核部门
	
	//用于接收需求填报表单提交数据的变量
	private XuQiu xuQiu;
	
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
	private String shbm;
	
	private String guanjianzi1;
	private String guanjianzi2;
	private String guanjianzi3;
	private String guanjianzi4;
	private String guanjianzi5;
	
	private int commitResult;//用于返回提交是否成功的结果给客户端
	
	//方法**************************************************************************
	//需求表单数据插入数据库
	public String commitXuQiuForm()
	{
		xuQiu=new XuQiu();
		Date d = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	    xuQiuNum=sdf.format(d);
	    guanJianZi=guanjianzi1+guanjianzi2+guanjianzi3+guanjianzi4+guanjianzi5;
	    username=(String) ServletActionContext.getRequest().getSession().getAttribute("user");  
	    System.out.println("当前用户：" + username);
	    System.out.println("当前时间：" + sdf.format(d));
	    
		xuQiu.setXuQiuNum(xuQiuNum);
		xuQiu.setUsername(username);
		xuQiu.setCompanyAllname(companyAllname);
		xuQiu.setBelongApartment(belongApartment);
		xuQiu.setCompanyAdrss(companyAdrss);
		xuQiu.setArea(area);
		xuQiu.setWeb(web);
		xuQiu.setEmail(email);
		xuQiu.setFaRen(faRen);
		xuQiu.setLianXiRen(lianXiRen);
		xuQiu.setTell(tell);
		xuQiu.setPhone(phone);
		xuQiu.setFax(fax);
		xuQiu.setJiGouShuXing(jiGouShuXing);
		xuQiu.setJiGouJianJie(jiGouJianJie);
		xuQiu.setXuQiuName(xuQiuName);
		xuQiu.setStartYear(startYear);
		xuQiu.setEndYear(endYear);
		xuQiu.setGaiShu1(gaiShu1);
		xuQiu.setGaiShu2(gaiShu2);
		xuQiu.setGaiShu3(gaiShu3);
		xuQiu.setGuanJianZi(guanJianZi);
		xuQiu.setSumMoney(sumMoney);
		xuQiu.setWay(way);
		xuQiu.setHeZuoDanWei(heZuoDanWei);
		xuQiu.setHuoDongLeiXing(huoDongLeiXing);
		xuQiu.setSuoShuLingYu(suoShuLingYu);
		xuQiu.setYingYongHangYe(yingYongHangYe);
		xuQiu.setXueKeFenLei(xueKeFenLei);
		xuQiu.setState(state);
		xuQiu.setShenHeBuMen(shbm);
		System.out.println("123");
		if(username==null)//登录超时
		{
			commitResult=2;
		}
		else if(tianBaoManager.storageXuQiu(xuQiu)){//提交成功
			commitResult=1;
		}
		else{
			System.out.println("123");
			commitResult=0;
		}
		return "success";
	}
	//加载main.jsp所需要的基本信息
	@Override
	public String execute() throws Exception
	{
		System.out.println(username);
		// TODO Auto-generated method stub
		this.user= userManage.loadUser(username);
		this.guikoubumens =userManage.listGuikoubumens();
		this.areas =tianBaoManager.listAreas();
		this.subjects=tianBaoManager.listSubjects1();
		this.industries=tianBaoManager.listIndustries1();
		this.shenHeBuMens=tianBaoManager.listShenHeBuMens();
		return "success";
	}
	
	//获得二级学科信息
	public String forSubjects2()
	{
		this.subjects2=tianBaoManager.listSubjects2(subjectCode1);
		return "success";
	}
	
	//获得三级学科信息
	public String forSubjects3()
	{
		this.subjects3=tianBaoManager.listSubjects3(subjectCode2);
		return "success";
	}
	
	//获得二级行业信息
	public String forIndustries2()
	{
		this.industries2=tianBaoManager.listIndustries2(industryCode1);
		return "success";
	}
	
	//获得三级行业信息
	public String forIndustries3()
	{
		this.industries3=tianBaoManager.listIndustries3(industryCode2);
		return "success";
	}
	
	//setter()和getter()
	public List<Guikoubumen> getGuikoubumens()
	{
		return guikoubumens;
	}

	public void setGuikoubumens(List<Guikoubumen> guikoubumens)
	{
		this.guikoubumens = guikoubumens;
	}

	public UserManage getUserManage()
	{
		return userManage;
	}
	@Resource
	public void setUserManage(UserManage userManage)
	{
		this.userManage = userManage;
	}

	public List<Area> getAreas()
	{
		return areas;
	}

	public void setAreas(List<Area> areas)
	{
		this.areas = areas;
	}
	
	public List<Subject> getSubjects()
	{
		return subjects;
	}

	public void setSubjects(List<Subject> subjects)
	{
		this.subjects = subjects;
	}

	public TianBaoManager getTianBaoManager()
	{
		return tianBaoManager;
	}
	@Resource
	public void setTianBaoManager(TianBaoManager tianBaoManager)
	{
		this.tianBaoManager = tianBaoManager;
	}

	public List<Subject> getSubjects2()
	{
		return subjects2;
	}

	public void setSubjects2(List<Subject> subjects2)
	{
		this.subjects2 = subjects2;
	}

	public String getSubjectCode1()
	{
		return subjectCode1;
	}

	public void setSubjectCode1(String subjectCode1)
	{
		this.subjectCode1 = subjectCode1;
	}

	public List<Subject> getSubjects3()
	{
		return subjects3;
	}

	public void setSubjects3(List<Subject> subjects3)
	{
		this.subjects3 = subjects3;
	}

	public String getSubjectCode2()
	{
		return subjectCode2;
	}

	public void setSubjectCode2(String subjectCode2)
	{
		this.subjectCode2 = subjectCode2;
	}

	public List<Industry> getIndustries()
	{
		return industries;
	}

	public void setIndustries(List<Industry> industries)
	{
		this.industries = industries;
	}

	public String getIndustryCode1()
	{
		return industryCode1;
	}

	public String getIndustryCode2()
	{
		return industryCode2;
	}

	public void setIndustryCode1(String industryCode1)
	{
		this.industryCode1 = industryCode1;
	}

	public void setIndustryCode2(String industryCode2)
	{
		this.industryCode2 = industryCode2;
	}

	public List<Industry> getIndustries2()
	{
		return industries2;
	}

	public List<Industry> getIndustries3()
	{
		return industries3;
	}

	public void setIndustries2(List<Industry> industries2)
	{
		this.industries2 = industries2;
	}

	public void setIndustries3(List<Industry> industries3)
	{
		this.industries3 = industries3;
	}

	public String getXuQiuNum()
	{
		return xuQiuNum;
	}

	public String getUsername()
	{
		return username;
	}

	public String getCompanyAllname()
	{
		return companyAllname;
	}

	public String getBelongApartment()
	{
		return belongApartment;
	}

	public String getCompanyAdrss()
	{
		return companyAdrss;
	}

	public String getArea()
	{
		return area;
	}

	public String getWeb()
	{
		return web;
	}

	public String getEmail()
	{
		return email;
	}

	public String getFaRen()
	{
		return faRen;
	}

	public String getYouBian()
	{
		return youBian;
	}

	public String getLianXiRen()
	{
		return lianXiRen;
	}

	public String getTell()
	{
		return tell;
	}

	public String getPhone()
	{
		return phone;
	}

	public String getFax()
	{
		return fax;
	}

	public String getJiGouShuXing()
	{
		return jiGouShuXing;
	}

	public String getJiGouJianJie()
	{
		return jiGouJianJie;
	}

	public String getXuQiuName()
	{
		return xuQiuName;
	}

	public String getStartYear()
	{
		return startYear;
	}

	public String getEndYear()
	{
		return endYear;
	}

	public String getGaiShu1()
	{
		return gaiShu1;
	}

	public String getGaiShu2()
	{
		return gaiShu2;
	}

	public String getGaiShu3()
	{
		return gaiShu3;
	}

	public String getGuanJianZi()
	{
		return guanJianZi;
	}

	public String getSumMoney()
	{
		return sumMoney;
	}

	public String getWay()
	{
		return way;
	}

	public String getHeZuoDanWei()
	{
		return heZuoDanWei;
	}

	public String getHuoDongLeiXing()
	{
		return huoDongLeiXing;
	}

	public String getSuoShuLingYu()
	{
		return suoShuLingYu;
	}

	public String getYingYongHangYe()
	{
		return yingYongHangYe;
	}

	public String getXueKeFenLei()
	{
		return xueKeFenLei;
	}

	public String getState()
	{
		return state;
	}

	public void setXuQiuNum(String xuQiuNum)
	{
		this.xuQiuNum = xuQiuNum;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public void setCompanyAllname(String companyAllname)
	{
		this.companyAllname = companyAllname;
	}

	public void setBelongApartment(String belongApartment)
	{
		this.belongApartment = belongApartment;
	}

	public void setCompanyAdrss(String companyAdrss)
	{
		this.companyAdrss = companyAdrss;
	}

	public void setArea(String area)
	{
		this.area = area;
	}

	public void setWeb(String web)
	{
		this.web = web;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public void setFaRen(String faRen)
	{
		this.faRen = faRen;
	}

	public void setYouBian(String youBian)
	{
		this.youBian = youBian;
	}

	public void setLianXiRen(String lianXiRen)
	{
		this.lianXiRen = lianXiRen;
	}

	public void setTell(String tell)
	{
		this.tell = tell;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public void setFax(String fax)
	{
		this.fax = fax;
	}

	public void setJiGouShuXing(String jiGouShuXing)
	{
		this.jiGouShuXing = jiGouShuXing;
	}

	public void setJiGouJianJie(String jiGouJianJie)
	{
		this.jiGouJianJie = jiGouJianJie;
	}

	public void setXuQiuName(String xuQiuName)
	{
		this.xuQiuName = xuQiuName;
	}

	public void setStartYear(String startYear)
	{
		this.startYear = startYear;
	}

	public void setEndYear(String endYear)
	{
		this.endYear = endYear;
	}

	public void setGaiShu1(String gaiShu1)
	{
		this.gaiShu1 = gaiShu1;
	}

	public void setGaiShu2(String gaiShu2)
	{
		this.gaiShu2 = gaiShu2;
	}

	public void setGaiShu3(String gaiShu3)
	{
		this.gaiShu3 = gaiShu3;
	}

	public void setGuanJianZi(String guanJianZi)
	{
		this.guanJianZi = guanJianZi;
	}

	public void setSumMoney(String sumMoney)
	{
		this.sumMoney = sumMoney;
	}

	public void setWay(String way)
	{
		this.way = way;
	}

	public void setHeZuoDanWei(String heZuoDanWei)
	{
		this.heZuoDanWei = heZuoDanWei;
	}

	public void setHuoDongLeiXing(String huoDongLeiXing)
	{
		this.huoDongLeiXing = huoDongLeiXing;
	}

	public void setSuoShuLingYu(String suoShuLingYu)
	{
		this.suoShuLingYu = suoShuLingYu;
	}

	public void setYingYongHangYe(String yingYongHangYe)
	{
		this.yingYongHangYe = yingYongHangYe;
	}

	public void setXueKeFenLei(String xueKeFenLei)
	{
		this.xueKeFenLei = xueKeFenLei;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public XuQiu getXuQiu()
	{
		return xuQiu;
	}

	public void setXuQiu(XuQiu xuQiu)
	{
		this.xuQiu = xuQiu;
	}
	public int getCommitResult()
	{
		return commitResult;
	}
	public void setCommitResult(int commitResult)
	{
		this.commitResult = commitResult;
	}
	public String getGuanjianzi1()
	{
		return guanjianzi1;
	}
	public String getGuanjianzi2()
	{
		return guanjianzi2;
	}
	public String getGuanjianzi3()
	{
		return guanjianzi3;
	}
	public String getGuanjianzi4()
	{
		return guanjianzi4;
	}
	public String getGuanjianzi5()
	{
		return guanjianzi5;
	}
	public void setGuanjianzi1(String guanjianzi1)
	{
		this.guanjianzi1 = guanjianzi1;
	}
	public void setGuanjianzi2(String guanjianzi2)
	{
		this.guanjianzi2 = guanjianzi2;
	}
	public void setGuanjianzi3(String guanjianzi3)
	{
		this.guanjianzi3 = guanjianzi3;
	}
	public void setGuanjianzi4(String guanjianzi4)
	{
		this.guanjianzi4 = guanjianzi4;
	}
	public void setGuanjianzi5(String guanjianzi5)
	{
		this.guanjianzi5 = guanjianzi5;
	}
	public User getUser()
	{
		return user;
	}
	public void setUser(User user)
	{
		this.user = user;
	}
	public List<ShenHeBuMen> getShenHeBuMens()
	{
		return shenHeBuMens;
	}
	public void setShenHeBuMens(List<ShenHeBuMen> shenHeBuMens)
	{
		this.shenHeBuMens = shenHeBuMens;
	}
	public String getShbm()
	{
		return shbm;
	}
	public void setShbm(String shbm)
	{
		this.shbm = shbm;
	}
	
}
