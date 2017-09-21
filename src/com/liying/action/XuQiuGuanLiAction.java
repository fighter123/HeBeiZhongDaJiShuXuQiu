package com.liying.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.liying.model.Area;
import com.liying.model.Guikoubumen;
import com.liying.model.Industry;
import com.liying.model.ShenHeBuMen;
import com.liying.model.Subject;
import com.liying.model.XuQiu;
import com.liying.service.TianBaoManager;
import com.liying.service.UserManage;
import com.liying.service.XuQiuGuanLiManager;
import com.opensymphony.xwork2.ActionSupport;

@Component("xuQiuGuanLiAction")
@Scope("prototype")
public class XuQiuGuanLiAction extends ActionSupport
{
	//变量***********************************************************************
	//接收变量
	private String username;
	private String xuqiuNumer;
	//返回变量
	private int state=0;
	private XuQiuGuanLiManager xuQiuGuanLiManager;
	private List<XuQiu> xuQius = new ArrayList<XuQiu>();
	private XuQiu xuQiu;
	private List<Guikoubumen> guikoubumens = new ArrayList<Guikoubumen>();//归口部门集guikoubumens
	private List<Area> areas = new ArrayList<Area>();					  //地域集
	private List<Subject> subjects = new ArrayList<Subject>();			  //一级学科类别集
	private List<Industry> industries = new ArrayList<Industry>();		  //一级行业类别集
	private List<ShenHeBuMen> shenHeBuMens= new ArrayList<ShenHeBuMen>(); //审核部门
	//注入变量
	private UserManage userManage;
	private TianBaoManager tianBaoManager;

	//方法***********************************************************************
	@Override
	public String execute() throws Exception
	{
		// TODO Auto-generated method stub
		//System.out.println(username);
		this.xuQius=xuQiuGuanLiManager.returnQius(username);
		//System.out.println(xuQius);
		return "success";
	}
	//删除需求
	public String deleteXuqiu()
	{
		//System.out.println(xuqiuNumer);
		if(xuQiuGuanLiManager.deleteXuqiu(xuqiuNumer))
		{
			state=1;
		}
		else
		{
			state=0;
		}
		return "success";
	}
	//返回某条需求的所有内容
	public String lookMyXuqiu()
	{
		System.out.println(xuqiuNumer);
		this.guikoubumens =userManage.listGuikoubumens();
		this.areas =tianBaoManager.listAreas();
		this.subjects=tianBaoManager.listSubjects1();
		this.industries=tianBaoManager.listIndustries1();
		this.shenHeBuMens=tianBaoManager.listShenHeBuMens();
		this.xuQiu=xuQiuGuanLiManager.returnMyQiu(xuqiuNumer);
		return "success";
	}
	//set和get******************************************************************
	public String getUsername()
	{
		return username;
	}
	public XuQiuGuanLiManager getXuQiuGuanLiManager()
	{
		return xuQiuGuanLiManager;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	@Resource
	public void setXuQiuGuanLiManager(XuQiuGuanLiManager xuQiuGuanLiManager)
	{
		this.xuQiuGuanLiManager = xuQiuGuanLiManager;
	}
	public List<XuQiu> getXuQius()
	{
		return xuQius;
	}
	public void setXuQius(List<XuQiu> xuQius)
	{
		this.xuQius = xuQius;
	}
	public String getXuqiuNumer()
	{
		return xuqiuNumer;
	}
	public void setXuqiuNumer(String xuqiuNumer)
	{
		this.xuqiuNumer = xuqiuNumer;
	}
	public int getState()
	{
		return state;
	}
	public void setState(int state)
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
	public List<Guikoubumen> getGuikoubumens()
	{
		return guikoubumens;
	}
	public UserManage getUserManage()
	{
		return userManage;
	}
	public void setGuikoubumens(List<Guikoubumen> guikoubumens)
	{
		this.guikoubumens = guikoubumens;
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
	public List<Subject> getSubjects()
	{
		return subjects;
	}
	public List<Industry> getIndustries()
	{
		return industries;
	}
	public List<ShenHeBuMen> getShenHeBuMens()
	{
		return shenHeBuMens;
	}
	public TianBaoManager getTianBaoManager()
	{
		return tianBaoManager;
	}
	public void setAreas(List<Area> areas)
	{
		this.areas = areas;
	}
	public void setSubjects(List<Subject> subjects)
	{
		this.subjects = subjects;
	}
	public void setIndustries(List<Industry> industries)
	{
		this.industries = industries;
	}
	public void setShenHeBuMens(List<ShenHeBuMen> shenHeBuMens)
	{
		this.shenHeBuMens = shenHeBuMens;
	}
	@Resource
	public void setTianBaoManager(TianBaoManager tianBaoManager)
	{
		this.tianBaoManager = tianBaoManager;
	}
	
}
