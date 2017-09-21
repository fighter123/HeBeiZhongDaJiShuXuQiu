package com.liying.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.liying.dao.TianBaoDao;
import com.liying.model.Area;
import com.liying.model.Industry;
import com.liying.model.ShenHeBuMen;
import com.liying.model.Subject;
import com.liying.model.XuQiu;
@Component
public class TianBaoDaoImpl implements TianBaoDao
{
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<Area> getAreas()
	{
		// TODO Auto-generated method stub
		List<Area> areas = hibernateTemplate.find("from Area");
		return areas;
	}
	
	@Override
	public List<Subject> getSubjects1()
	{
		// TODO Auto-generated method stub
		List<Subject> subjects = hibernateTemplate.find("from Subject s where s.subjectCode like '___0000'");
		return subjects;
	}
	
	
	@Override
	public List<Subject> getSubjects2(String subjectCode1)
	{
		// TODO Auto-generated method stub
		List<Subject> subjects = hibernateTemplate.find("from Subject s where s.subjectCode like '"+subjectCode1+"__00'");
		return subjects;
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
	public List<Subject> getSubjects3(String subjectCode2)
	{
		// TODO Auto-generated method stub
		List<Subject> subjects = hibernateTemplate.find("from Subject s where s.subjectCode like '"+subjectCode2+"__'");
		return subjects;
	}

	@Override
	public List<Industry> getIndustries1()
	{
		// TODO Auto-generated method stub
		List<Industry> industries = hibernateTemplate.find("from Industry I where I.industryCode like '_0000'");
		return industries;
	}

	@Override
	public List<Industry> getIndustries2(String industryCode1)
	{
		// TODO Auto-generated method stub
		List<Industry> industries = hibernateTemplate.find("from Industry I where I.industryCode like '"+industryCode1+"__00'");
		return industries;
	}

	@Override
	public List<Industry> getIndustries3(String industryCode2)
	{
		// TODO Auto-generated method stub
		List<Industry> industries = hibernateTemplate.find("from Industry I where I.industryCode like '"+industryCode2+"__'");
		return industries;
	}

	@Override
	public boolean insertXuQiu(XuQiu xuQiu)
	{
		// TODO Auto-generated method stub
		try
		{
			hibernateTemplate.save(xuQiu);
		} catch (DataAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<ShenHeBuMen> getShenHeBuMens()
	{
		// TODO Auto-generated method stub
		List<ShenHeBuMen> shenHeBuMens=hibernateTemplate.find("from ShenHeBuMen");
		return shenHeBuMens;
	}

}
