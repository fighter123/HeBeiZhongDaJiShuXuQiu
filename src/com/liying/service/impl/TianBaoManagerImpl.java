package com.liying.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.liying.dao.TianBaoDao;
import com.liying.model.Area;
import com.liying.model.Industry;
import com.liying.model.ShenHeBuMen;
import com.liying.model.Subject;
import com.liying.model.XuQiu;
import com.liying.service.TianBaoManager;
@Component
public class TianBaoManagerImpl implements TianBaoManager
{
	private TianBaoDao tianBaoDao;
	
	@Resource
	public void setTianBaoDao(TianBaoDao tianBaoDao)
	{
		this.tianBaoDao = tianBaoDao;
	}
	public TianBaoDao getTianBaoDao()
	{
		return tianBaoDao;
	}
	
	@Override
	public List<Subject> listSubjects2(String subjectCode1)
	{
		// TODO Auto-generated method stub
		return tianBaoDao.getSubjects2(subjectCode1);
	}
	
	@Override
	public List<Subject> listSubjects1()
	{
		// TODO Auto-generated method stub
		return tianBaoDao.getSubjects1();
	}


	@Override
	public List<Area> listAreas()
	{
		// TODO Auto-generated method stub
		return tianBaoDao.getAreas();
	}

	@Override
	public List<Subject> listSubjects3(String subjectCode2)
	{
		// TODO Auto-generated method stub
		return tianBaoDao.getSubjects3(subjectCode2);
	}
	@Override
	public List<Industry> listIndustries1()
	{
		// TODO Auto-generated method stub
		return tianBaoDao.getIndustries1();
	}
	@Override
	public List<Industry> listIndustries2(String industryCode1)
	{
		// TODO Auto-generated method stub
		return tianBaoDao.getIndustries2(industryCode1);
	}
	@Override
	public List<Industry> listIndustries3(String industryCode2)
	{
		// TODO Auto-generated method stub
		return tianBaoDao.getIndustries3(industryCode2);
	}
	@Override
	public boolean storageXuQiu(XuQiu xuQiu)
	{
		// TODO Auto-generated method stub
		return tianBaoDao.insertXuQiu(xuQiu);
	}
	@Override
	public List<ShenHeBuMen> listShenHeBuMens()
	{
		// TODO Auto-generated method stub
		return tianBaoDao.getShenHeBuMens();
	}


}
