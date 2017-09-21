package com.liying.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.sql.Update;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.liying.dao.ShenHeDao;
import com.liying.model.XuQiu;
@Component
public class ShenHeDaoImpl implements ShenHeDao
{
	private HibernateTemplate hibernateTemplate;
	@Override
	public List<XuQiu> returnAllXuQius1(String state)
	{
		// TODO Auto-generated method stub
		List<XuQiu> xuQius=hibernateTemplate.find("from XuQiu x where x.state='"+state+"'");
		return xuQius;
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

	@Override
	public boolean updateSheHeResult(String xuQiuNum, String state,String reason)
	{
		// TODO Auto-generated method stub
		try
		{
			XuQiu xuQiu = (XuQiu)hibernateTemplate.get(XuQiu.class,xuQiuNum);
			xuQiu.setState(state);
			xuQiu.setReason(reason);
			hibernateTemplate.update(xuQiu);
			return true;
		} catch (DataAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
