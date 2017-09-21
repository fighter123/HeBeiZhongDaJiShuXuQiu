package com.liying.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.liying.dao.ShenHeDao;
import com.liying.model.XuQiu;
import com.liying.service.ShenHeManager;
@Component
public class ShenHeManagerImpl implements ShenHeManager
{
	private ShenHeDao shenHeDao;
	
	public ShenHeDao getShenHeDao()
	{
		return shenHeDao;
	}
	@Resource
	public void setShenHeDao(ShenHeDao shenHeDao)
	{
		this.shenHeDao = shenHeDao;
	}
	//返回所有待形式审核结果
	@Override
	public List<XuQiu> returnAllXuQius1(String state)
	{
		// TODO Auto-generated method stub
		return shenHeDao.returnAllXuQius1(state);
	}
	@Override
	public boolean updateSheHeResult(String xuQiuNum, String state,String reason)
	{
		// TODO Auto-generated method stub
		return shenHeDao.updateSheHeResult(xuQiuNum, state,reason);
	}

}
