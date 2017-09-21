package com.liying.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.liying.dao.XuQiuGuanLiDao;
import com.liying.model.XuQiu;
import com.liying.service.XuQiuGuanLiManager;
@Component
public class XuQiuGuanLiManagerImpl implements XuQiuGuanLiManager
{

	private XuQiuGuanLiDao xuQiuGuanLiDao;
	@Override
	public List<XuQiu> returnQius(String username)
	{
		// TODO Auto-generated method stub
		return xuQiuGuanLiDao.returnQius(username);
	}
	public XuQiuGuanLiDao getXuQiuGuanLiDao()
	{
		return xuQiuGuanLiDao;
	}
	@Resource
	public void setXuQiuGuanLiDao(XuQiuGuanLiDao xuQiuGuanLiDao)
	{
		this.xuQiuGuanLiDao = xuQiuGuanLiDao;
	}
	@Override
	public boolean deleteXuqiu(String xuqiuNum)
	{
		// TODO Auto-generated method stub
		return xuQiuGuanLiDao.deleteXuqiu(xuqiuNum);
	}
	@Override
	public XuQiu returnMyQiu(String xuqiuNum)
	{
		// TODO Auto-generated method stub
		return xuQiuGuanLiDao.returnMyQiu(xuqiuNum);
	}

}
