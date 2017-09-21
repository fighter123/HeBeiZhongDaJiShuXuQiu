package com.liying.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.liying.model.XuQiu;
import com.liying.service.ShenHeManager;
import com.opensymphony.xwork2.ActionSupport;
@Component("shenHeAction")
@Scope("prototype")
public class ShenHe extends ActionSupport
{
	//变量***********************************************************************
	//注入变量
	private ShenHeManager shenHeManager;
	//接受数据
	private String state;
	private String xuQiuNum;
	private String reason;
	//发送数据
	private List<XuQiu> xuQius = new ArrayList<XuQiu>();
	private int result;
	//方法***********************************************************************
	public String lookShenHe()
	{
		System.out.println(state);
		this.xuQius=shenHeManager.returnAllXuQius1(state);
		System.out.println(xuQius);
		return "success";
	}
	//处理客户端发来的审核结果改变需求状态
	public String shenHeResult()
	{
		if(shenHeManager.updateSheHeResult(xuQiuNum, state,reason))
		{
			result=1;
		}
		else {
			result=0;
		}
		return "success";
	}
	//set和get******************************************************************
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}

	public ShenHeManager getShenHeManager()
	{
		return shenHeManager;
	}

	public List<XuQiu> getXuQius()
	{
		return xuQius;
	}
	@Resource
	public void setShenHeManager(ShenHeManager shenHeManager)
	{
		this.shenHeManager = shenHeManager;
	}

	public void setXuQius(List<XuQiu> xuQius)
	{
		this.xuQius = xuQius;
	}
	public int getResult()
	{
		return result;
	}
	public void setResult(int result)
	{
		this.result = result;
	}
	public String getXuQiuNum()
	{
		return xuQiuNum;
	}
	public void setXuQiuNum(String xuQiuNum)
	{
		this.xuQiuNum = xuQiuNum;
	}
	public String getReason()
	{
		return reason;
	}
	public void setReason(String reason)
	{
		this.reason = reason;
	}
}
