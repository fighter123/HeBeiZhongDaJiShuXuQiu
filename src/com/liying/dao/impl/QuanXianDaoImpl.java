package com.liying.dao.impl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.liying.dao.QuanXianDao;
import com.liying.model.QuanXian;

@Component("quanXianDao")
public class QuanXianDaoImpl implements QuanXianDao
{

	private HibernateTemplate hibernateTemplate;
	@Override
	public QuanXian loadQuanXianByUsername(String username)
	{
		// TODO Auto-generated method stub
		System.out.println("进入quanxian的Dao层！");
		QuanXian quanxian=(QuanXian) hibernateTemplate.get(QuanXian.class, username);
		return quanxian;
	}
	public HibernateTemplate getHibernateTemplate()
	{
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate)
	{
		this.hibernateTemplate = hibernateTemplate;
	}
}
