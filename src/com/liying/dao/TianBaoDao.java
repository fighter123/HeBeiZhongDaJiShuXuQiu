package com.liying.dao;

import java.util.List;

import com.liying.model.Area;
import com.liying.model.Industry;
import com.liying.model.ShenHeBuMen;
import com.liying.model.Subject;
import com.liying.model.XuQiu;

public interface TianBaoDao
{
	public List<Area> getAreas();//获得地域信息
	
	public List<Subject> getSubjects1();//获得一级学科信息
	public List<Subject> getSubjects2(String subjectCode1);//获得二级学科信息
	public List<Subject> getSubjects3(String subjectCode2);//获得三级学科信息
	
	public List<Industry> getIndustries1();//获得一级行业信息
	public List<Industry> getIndustries2(String industryCode1);//获得二级行业信息
	public List<Industry> getIndustries3(String industryCode2);//获得三级行业信息
	public List<ShenHeBuMen> getShenHeBuMens();//获得审核部门集合
	
	public boolean insertXuQiu(XuQiu xuQiu);//保存需求
}
