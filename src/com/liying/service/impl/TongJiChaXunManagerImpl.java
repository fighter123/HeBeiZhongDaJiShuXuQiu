package com.liying.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.liying.dao.TongJiChaXunDao;
import com.liying.service.TongJiChaXunManager;
@Component
public class TongJiChaXunManagerImpl implements TongJiChaXunManager
{
	private TongJiChaXunDao tongJiChaXunDao;
	public TongJiChaXunDao getTongJiChaXunDao()
	{
		return tongJiChaXunDao;
	}
	@Resource
	public void setTongJiChaXunDao(TongJiChaXunDao tongJiChaXunDao)
	{
		this.tongJiChaXunDao = tongJiChaXunDao;
	}
	@Override
	public String tongjichudate(String qtype)
	{
		// TODO Auto-generated method stub
		System.out.println("service");
		return tongJiChaXunDao.tongjichudate(qtype);
	}

}
