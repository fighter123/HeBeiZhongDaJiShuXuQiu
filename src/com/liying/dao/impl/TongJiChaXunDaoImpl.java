package com.liying.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.liying.dao.TongJiChaXunDao;
@Component
public class TongJiChaXunDaoImpl implements TongJiChaXunDao
{
	private HibernateTemplate hibernateTemplate;
	
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
	public String tongjichudate(String qtype)
	{
		// TODO Auto-generated method stub
		String name="";
		String count="";
		String nameAndCount="";
		Session session=this.getHibernateTemplate().getSessionFactory().openSession();
		String sql="select "+qtype+",count(*) from XuQiu x where x.state!='0' group by "+qtype+"";
	    Query query = session.createQuery(sql); 
	    System.out.println(query.list());
	    List<Object[]> list = query.list();
	    for (Object[] objects:list)
		{
	    	System.out.println(objects[0]);
	    	System.out.println(objects[1]);
	    	name=name+objects[0]+"$";
	    	count=count+objects[1]+"$";
		}
	    nameAndCount=name+"?"+count;
		return nameAndCount;
	}

}
