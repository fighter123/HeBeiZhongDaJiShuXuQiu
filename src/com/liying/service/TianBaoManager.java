package com.liying.service;

import java.util.List;

import com.liying.model.Area;
import com.liying.model.Industry;
import com.liying.model.ShenHeBuMen;
import com.liying.model.Subject;
import com.liying.model.XuQiu;

public interface TianBaoManager
{
	public List<Area> listAreas();//获得地域信息
	public List<Subject> listSubjects1();//获得一级学科信息
	public List<Subject> listSubjects2(String subjectCode1);//获得二级学科信息
	public List<Subject> listSubjects3(String subjectCode2);//获得三级学科信息
	
	public List<Industry> listIndustries1();//获得一级行业信息
	public List<Industry> listIndustries2(String industryCode1);//获得二级行业信息
	public List<Industry> listIndustries3(String industryCode2);//获得二级行业信息
	public List<ShenHeBuMen> listShenHeBuMens();//返回审核部门集合
	
	public boolean storageXuQiu(XuQiu xuQiu);//存储需求
}
