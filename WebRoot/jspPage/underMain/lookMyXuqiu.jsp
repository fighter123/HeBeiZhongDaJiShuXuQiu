<%@page import="java.awt.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.sql.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta charset="utf-8">
<title>填报页面</title>
</head>
<body>
<s:debug></s:debug>
<div id="Layer1" style="position:absolute; width:100%; height:110%; z-index:-1">     
</div> 
<center>
<h1><div style="font-family:宋体;"><font color=blue>河北省重大技术需求征集表</font></div></h1>
<P></P>
<form name="xuQiuForm"  method="post" action=""  id="xuQiuForm">
<table width="820" border="1"  cellpadding="0" cellspacing="0" align="center" style="border-collapse:collapse;">
  <tbody>
  	<tr>
  	<input type="button" value="基础信息开关" onclick="displayJiChu()"/>
  	</tr>
    <tr id="jichuxinxi1" style=" display:none ">
      <td width="135" height="38"><p ><span style="color: red">*</span>机构全称</p></td>   		
      <td colspan="2">
      	<s:property value="xuQiu.companyAllname"/>   		
      </td>
      <td>&nbsp;归口管理部门</td>
      <td colspan="3"> 
      	<s:property value="xuQiu.belongApartment"/>   
      </td>
    </tr>
    <tr id="jichuxinxi2" style=" display:none ">
      <td width="135" height="42"><span style="color: red">*</span>通讯地址</td>
      <td colspan="2"><s:property value="xuQiu.companyAdrss"/></td>
      <td><span style="color: red">*</span>所在地域</td>   
      <td colspan="3">
	      <s:property value="xuQiu.area"/>
      </td>
    </tr>
    <tr id="jichuxinxi3" style=" display:none ">
      <td width="135" height="42">&nbsp;网址</td>
      <td colspan="2" nowrap><s:property value="xuQiu.web"/></td>
      <td width="115"><span style="color: red">*</span>电子信箱</td>
      <td colspan="3">
      	<s:property value="xuQiu.email"/>
      </td>    	
    </tr>
      <tr id="jichuxinxi4" style=" display:none ">
        <td height="42"><span style="color: red">*</span>法人代表</td>
        <td colspan="2"><s:property value="xuQiu.faRen"/></td>
        <td>&nbsp;邮政编码</td>
        <td colspan="4"><s:property value="xuQiu.youBian"/></td>
      </tr>
      <tr id="jichuxinxi8" style=" display:none ">
        <td height="42">&nbsp;联 系 人</td>
        <td width="188" colspan="2">
        	<s:property value="xuQiu.lianXiRen"/>
        </td>
        <td>&nbsp;固定电话</td>
        <td>
        	<s:property value="xuQiu.tell"/>
        </td>
      </tr>
      <tr id="jichuxinxi5" style=" display:none ">
      	<td height="42">&nbsp;手机</td>
        <td width="126" colspan="2"><s:property value="xuQiu.phone"/></td>      
        <td height="31">&nbsp;传真</td>
        <td colspan="4"><s:property value="xuQiu.fax"/></td>
        </tr>
      <tr id="jichuxinxi6" style=" display:none ">
      <td height="45"><span style="color: red">*</span>机构属性</td>
      <td colspan="6"><table width="415">
        <tr>
          <td width="91"><label>
          	 <s:property value="xuQiu.jiGouShuXing"/>
          </td>
        </tr>
      </table></td>
    </tr>
    <tr id="jichuxinxi7" style=" display:none ">
      <td height="69" colspan="7">
       <p ><span style="color: red">*</span>机构简介（单位基本情况，研究基础等，限200字）<strong> </strong></p>
       <s:property value="xuQiu.jiGouJianJie"/> 
      </td>
    </tr>
    <tr>
      <td height="44"><p ><span style="color: red">*</span>技术需求名称</p></td>
      <td colspan="2">&nbsp;<s:property value="xuQiu.xuQiuName"/></td>
      <td><span style="color: red">*</span>需求时限</td>
      <td colspan="3">
      	&nbsp;<s:property value="xuQiu.startYear"/>年&nbsp;至&nbsp;<s:property value="xuQiu.endYear"/>年
      </td>
    </tr>
    <tr>
      <td colspan="7">
          <p ><span style="color: red">*</span>技术需求概述<strong> </strong></p>
          <p ><strong>1、主要问题（需要解决的重大技术问题，</strong><strong>限500字以内</strong><strong>）</strong><strong> </strong></p>
              &#12288;&#12288;<s:property value="xuQiu.gaiShu1"/>  
          <p ><strong>2、技术关键（所需的关键技术、主要指标，</strong><strong>限500字以内</strong><strong>）</strong><strong> </strong></p>
          	  &#12288;&#12288;<s:property value="xuQiu.gaiShu2"/>  
          <p ><strong>3、预期目标（技术创新性、经济社会效益，</strong><strong>限500字以内</strong><strong>）</strong></p>
          	  &#12288;&#12288;<s:property value="xuQiu.gaiShu3"/>  
          <p></p>
   		     <span style="color: red">*</span>关键字:&nbsp;&nbsp;
   		     &nbsp;<s:property value="xuQiu.guanJianZi"/>  
    </tr>
    <tr>
      <td height="41">&nbsp;拟投入资金总额</td>
      <td colspan="6">&nbsp;<s:property value="xuQiu.sumMoney"/> 
        万元</td>
    </tr>
    <tr>
      <td rowspan="2"><p ><span style="color: red">*</span>技术需求解决方式 </p></td>
      <td height="32" colspan="6">
      		&nbsp;<s:property value="xuQiu.way"/> 
      </td>
    </tr>
    <tr>
      <td height="30" colspan="6">合作意向单位：
      	&nbsp;<s:property value="xuQiu.heZuoDanWei"/> 
      </td>
    </tr>
    <tr>
      <td><p ><span style="color: red">*</span>科技活动类型</p></td>
      <td colspan="6">
      	&nbsp;<s:property value="xuQiu.huoDongLeiXing"/> 
      </td>     
    </tr>
<!--------------------------------- 学科分类---------------------------------------------------------------->
<s:if test="xuQiu.xueKeFenLei!=''">
<tr id="xk">
  	<td height="70">&nbsp;学科分类</td>
        <td colspan="6">
        	&nbsp;<s:property value="xuQiu.xueKeFenLei"/>
       	</td>
</tr>
</s:if>
<!------------------------需求技术所属领 --------------------------------------------------------------------------------------->
<s:if test="xuQiu.suoShuLingYu!=''">  
    <tr id="jx">
      <td height="50">&nbsp;需求技术所属领
      <td colspan="6">
      		&nbsp;<s:property value="xuQiu.suoShuLingYu"/>
      </td>
    </tr>
</s:if>
<!------------------------需求技术应用行业--------------------------------------------------------------------------------------->
<s:if test="xuQiu.yingYongHangYe!=''"> 
    <tr id="hy">
     <td height="50">&nbsp;需求技术应用行业</td>
        <td colspan="6">
        	&nbsp;<s:property value="xuQiu.yingYongHangYe"/>
       	</td>
    </tr>
</s:if>
	<tr>
		<td height="50">
		<span style="color: red">*</span>
		审核部门：
		</td>
		<td colspan="6">
		&nbsp;&nbsp;<s:property value="xuQiu.shenHeBuMen"/>
		</td>
	</tr>
<s:if test="xuQiu.state!=0"> 
	<tr>	
		<td height="50">审核状态：</td>
		<td colspan="6">
			<s:if test="xuQiu.state==1">
						等待形式审核！
					</s:if>
					<s:elseif test="xuQiu.state==2">
						形式审核中！
					</s:elseif>
					<s:elseif test="xuQiu.state==3">
						形式审核不通过！
					</s:elseif>
					<s:elseif test="xuQiu.state==4">
						形式审核通过等待技术审核！
					</s:elseif>
					<s:elseif test="xuQiu.state==5">
						技术审核中！
					</s:elseif>
					<s:elseif test="xuQiu.state==6">
						技术审核通过！
					</s:elseif>
					<s:elseif test="xuQiu.state==7">
						形式审核通过但技术审核未通过！
					</s:elseif>
					<s:else>
						未提交！
					</s:else>
		</td>
	</tr>
</s:if>
<s:if test="xuQiu.reason!=''"> 
	<tr>	
		<td height="50">审核意见：</td>
		<td colspan="6">
			&nbsp;&nbsp;<s:property value="xuQiu.reason"/>
		</td>
	</tr>
</s:if>
  </tbody>
</table>
 </form>
</center>
</body>
<script src="./js/jquery-1.7.js"></script>
<script src="./js/tianbao.js"></script>
<script type="text/javascript"> 
//测试函数****
/* function tanchu2(){
	alert("1111");
	layer.msg('hello'); 
} */
</script>
</html>
