package com.liying.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.liying.model.QuanXian;
import com.liying.model.User;
import com.liying.service.QuanXianManager;
import com.liying.service.UserManage;
import com.opensymphony.xwork2.ActionSupport;
@Component("quanXianAction")		//将UserAction交给spring管理并命名为userAction
@Scope("prototype")					//每接收到一个请求创建一个action对象
public class QuanxianAction extends ActionSupport
{
	//变量***********************************************************************
	private String username;
	private String xuQiuZhengJi;
	private String xuQiuGuanLi;
	private String yongHuGuanLi;
	private String xingShiShenHe;
	private String buMenShenHe;
	private String tongJiChaXun;
	private String suoShuBuMen;
	private String power;
	
	private QuanXian quanXian;
	private QuanXianManager quanXianManager;
	
	
	//返回包含某一用户权限的对象************************************************************
	public String quanXianInfo()
	{
		System.out.println(username);
		System.out.println("进入quanXianInfo()函数！");
		quanXian = new QuanXian();
		quanXian=(QuanXian)quanXianManager.loadQuanXian(username);
		//System.out.println(quanXian);
		return "success";
	}
	
	//set()和get（）**************************************************************
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getXuQiuZhengJi()
	{
		return xuQiuZhengJi;
	}
	public void setXuQiuZhengJi(String xuQiuZhengJi)
	{
		this.xuQiuZhengJi = xuQiuZhengJi;
	}
	public String getXuQiuGuanLi()
	{
		return xuQiuGuanLi;
	}
	public void setXuQiuGuanLi(String xuQiuGuanLi)
	{
		this.xuQiuGuanLi = xuQiuGuanLi;
	}
	public String getYongHuGuanLi()
	{
		return yongHuGuanLi;
	}
	public void setYongHuGuanLi(String yongHuGuanLi)
	{
		this.yongHuGuanLi = yongHuGuanLi;
	}
	public String getXingShiShenHe()
	{
		return xingShiShenHe;
	}
	public void setXingShiShenHe(String xingShiShenHe)
	{
		this.xingShiShenHe = xingShiShenHe;
	}
	public String getBuMenShenHe()
	{
		return buMenShenHe;
	}
	public void setBuMenShenHe(String buMenShenHe)
	{
		this.buMenShenHe = buMenShenHe;
	}
	public String getTongJiChaXun()
	{
		return tongJiChaXun;
	}
	public void setTongJiChaXun(String tongJiChaXun)
	{
		this.tongJiChaXun = tongJiChaXun;
	}
	public String getSuoShuBuMen()
	{
		return suoShuBuMen;
	}
	public void setSuoShuBuMen(String suoShuBuMen)
	{
		this.suoShuBuMen = suoShuBuMen;
	}
	public String getPower()
	{
		return power;
	}
	public void setPower(String power)
	{
		this.power = power;
	}

	public QuanXian getQuanXian()
	{
		return quanXian;
	}

	public void setQuanXian(QuanXian quanXian)
	{
		this.quanXian = quanXian;
	}
	
	public QuanXianManager getQuanXianManager()
	{
		return quanXianManager;
	}
	@Resource
	public void setQuanXianManager(QuanXianManager quanXianManager)
	{
		this.quanXianManager = quanXianManager;
	}
	
}
