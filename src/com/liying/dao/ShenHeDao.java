package com.liying.dao;

import java.util.List;

import com.liying.model.XuQiu;

public interface ShenHeDao
{
	public List<XuQiu> returnAllXuQius1(String state);//返回待审核的所有需求
	public boolean updateSheHeResult(String xuQiuNum,String state,String reason);//更新需求状态（审核结果）
}
