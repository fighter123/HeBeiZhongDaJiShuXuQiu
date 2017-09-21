package com.liying.dao;

import java.util.List;

import com.liying.model.XuQiu;

public interface XuQiuGuanLiDao
{
	public List<XuQiu> returnQius(String username);//返回用户的所有需求
	public boolean deleteXuqiu(String xuqiuNum);//删除需求
	public XuQiu returnMyQiu(String xuqiuNum);//返回用户的一条需求
}
