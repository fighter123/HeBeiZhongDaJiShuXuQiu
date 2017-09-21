package com.liying.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.liying.service.TongJiChaXunManager;
import com.opensymphony.xwork2.ActionSupport;
@Component("tongJiChaXun")
@Scope("prototype")
public class TongJiChaXunAction extends ActionSupport
{
	//变量***********************************************************************
	//注入变量
	private TongJiChaXunManager tongJiChaXunManager;
	//接受变量
	private String qtype;
	//返回变量
	private String name;
	private String namecount;
	//业务方法***********************************************************************
	public String tongJiTuData()
	{
		System.out.println(qtype);
		this.namecount=tongJiChaXunManager.tongjichudate(qtype);
		return "success";
	}
	
	//set和get方法****************************************************************
	public String getQtype()
	{
		return qtype;
	}
	public String getName()
	{
		return name;
	}
	public String getNamecount()
	{
		return namecount;
	}
	public void setQtype(String qtype)
	{
		this.qtype = qtype;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setNamecount(String namecount)
	{
		this.namecount = namecount;
	}

	public TongJiChaXunManager getTongJiChaXunManager()
	{
		return tongJiChaXunManager;
	}
	@Resource
	public void setTongJiChaXunManager(TongJiChaXunManager tongJiChaXunManager)
	{
		this.tongJiChaXunManager = tongJiChaXunManager;
	}
}
