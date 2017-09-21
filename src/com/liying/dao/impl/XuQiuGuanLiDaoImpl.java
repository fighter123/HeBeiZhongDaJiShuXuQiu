package com.liying.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.liying.dao.XuQiuGuanLiDao;
import com.liying.model.XuQiu;
@Component
public class XuQiuGuanLiDaoImpl implements XuQiuGuanLiDao
{
	private HibernateTemplate hibernateTemplate;
	//注入
	public HibernateTemplate getHibernateTemplate()
	{
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate)
	{
		this.hibernateTemplate = hibernateTemplate;
	}
	@Override
	public List<XuQiu> returnQius(String username)
	{
		// TODO Auto-generated method stub
		List<XuQiu> xuQius = hibernateTemplate.find("from XuQiu x where x.username='"+username+"'");
		return xuQius;
	}
	@Override
	public boolean deleteXuqiu(String xuqiuNum)
	{
		// TODO Auto-generated method stub
		try
		{
			XuQiu xuQiu=(XuQiu)hibernateTemplate.get(XuQiu.class, xuqiuNum);
			hibernateTemplate.delete(xuQiu);
			return true;
		} catch (DataAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public XuQiu returnMyQiu(String xuqiuNum)
	{
		// TODO Auto-generated method stub
		XuQiu xuQiu = (XuQiu)hibernateTemplate.get(XuQiu.class, xuqiuNum);
		return xuQiu;
	}

}
