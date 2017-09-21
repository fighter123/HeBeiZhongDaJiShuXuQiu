package com.liying.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.liying.dao.QuanXianDao;
import com.liying.model.QuanXian;
import com.liying.service.QuanXianManager;

@Component("quanxianManager")
public class QuanXianManagerImpl implements QuanXianManager
{
	private QuanXianDao quanXianDao;
	@Override
	public QuanXian loadQuanXian(String username)
	{
		// TODO Auto-generated method stub
		System.out.println("进入service层！");
		return quanXianDao.loadQuanXianByUsername(username);
	}
	
	public QuanXianDao getQuanXianDao()
	{
		return quanXianDao;
	}
	@Resource
	public void setQuanXianDao(QuanXianDao quanXianDao)
	{
		this.quanXianDao = quanXianDao;
	}

}
