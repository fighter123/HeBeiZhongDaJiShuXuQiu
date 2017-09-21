<%@page import="java.awt.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.sql.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/common.css"/>
<style type="text/css">
	
		.nice-select input{
			cursor: pointer;
			width:186px;
            height:18px;
			background: url(images/uew_icon.png) no-repeat scroll right center ;
			background-color:  	#FFFFFF;
			border-top:solid 1px #a7b5bc; 
			border-left:solid 1px #a7b5bc; 
			border-right:solid 1px #ced9df;
			border-bottom:solid 1px #ced9df;
			padding:2px;
		}
		
		ul{
			list-style: none;
		}
		
		.nice-select{
			list-style: none;
		}
		
		.nice-select ul{
			margin：0;
			padding：0;
			display: none;
			border: 1px solid #d5d5d5;
			width: 14.6em;
			position: absolute;
			top: 8em;
			overflow: hidden;
			background-color: #fff;
			max-height: 300px;
			overflow-y: auto;
			border-top: 0;
			z-index: 10001;
		}
		
		.nice-select ul li{
			height: 25px;
			line-height: 2em;
			overflow: hidden;
			padding: 0 0px;
			cursor: pointer;
			border-top: 1px solid #d5d5d5;
			float: left; 
			text-align:left;
			list-style:none;
		}
		
		.nice-select ul li.on{background-color:  	#FFFFFF;}
		
	</style>
<style>
placeholder {color:    #000000;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<style type="text/css">
/*按钮美化*/
.demo_con{
width: 960px;
margin:40px auto 0;
}
.button{
width: 140px;
line-height: 38px;
text-align: center;
font-weight: bold;
color: #fff;
text-shadow:1px 1px 1px #333;
border-radius: 5px;
margin:0 20px 20px 0;
position: relative;
overflow: hidden;
}
.button:nth-child(6n){
margin-right: 0;
}
.buttonblue{
width: 140px;
line-height: 38px;
text-align: center;
font-weight: bold;
color: #fff;
text-shadow:1px 1px 1px #333;
border-radius: 5px;
margin:0 20px 20px 0;
position: relative;
overflow: hidden;
border:1px solid #1e7db9;
box-shadow: 0 1px 2px #8fcaee inset,0 -1px 0 #497897 inset,0 -2px 3px #8fcaee inset;
background: -webkit-linear-gradient(top,#42a4e0,#2e88c0);
background: -moz-linear-gradient(top,#42a4e0,#2e88c0);
background: linear-gradient(top,#42a4e0,#2e88c0);
}

div#mes { float: right; color: blue; }/*--邮箱错误提示格式 --*/

div#yb { float: right; color: blue; } /*--邮编错误提示格式 --*/

div#mesPeople{ float: right; color: blue; } /*--邮编错误提示格式 --*/

textarea{width:99.2%;height:100px;resize:none;}   /*--文本域格式设置--*/

select{width:100px}
</style>
<meta charset="utf-8">
<title>填报页面</title>
</head>
<body onload="radio_click1()">
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
      <td colspan="2"><input type="text"  style="width: 80% ; border-style: 1; margin-left:1px "  tabindex="1" name="companyAllname" id="jgname" value=<s:property value="xuQiu.companyAllname"/>  required>   		
      </td>
      <td>&nbsp;归口管理部门</td>
      <td colspan="3"> 
      		<div class="nice-select">
				<input id="gkbm" name="belongApartment" type="text" oninput="searchList(this.value)" onclick="tanchu2()" value=<s:property value="xuQiu.belongapartment"/>></input>
				<ul>
					<s:iterator value="guikoubumens">
					<li><s:property value="department"/></li>
					</s:iterator>
				</ul>
			</div>
      </td>
    </tr>
    <tr id="jichuxinxi2" style=" display:none ">
      <td width="135" height="42"><span style="color: red">*</span>通讯地址</td>
      <td colspan="2"><input name="companyAdrss" id="companyAdrss" type="text" style="width: 80%; margin-left:1px "textfield" tabindex="2" required autocomplete="off" value=<s:property value="xuQiu.companyAdrss"/>></td>
      <td><span style="color: red">*</span>所在地域</td>   
      <td colspan="3">
	      <select style=" width:188px;margin-left:1px " size="1" name="area" id="area" required>
	      	  <option value=<s:property value="xuQiu.area"/>><s:property value="xuQiu.area"/></option>
		      <s:iterator value="areas">
		         <option><s:property value="city"/></option>
		      </s:iterator>
	      </select>
      </td>
    </tr>
    <tr id="jichuxinxi3" style=" display:none ">
      <td width="135" height="42">&nbsp;网址</td>
      <td colspan="2" nowrap><input type="text" style="width: 80%; margin-left:1px " name="web" id="web"  value=<s:property value="xuQiu.web"/>></td>
      <td width="115"><span style="color: red">*</span>电子信箱</td>
      <td colspan="3"><input onblur="verifyAddress()" name="email" type="text" style=" width:182px;margin-left:1px " id="email" size="18"  tabindex="4" value=<s:property value="xuQiu.email"/> required>
        <label><div id="mes" nowrap>填写邮箱!</div></label>
        </td>    	
    </tr>
      <tr id="jichuxinxi4" style=" display:none ">
        <td height="42"><span style="color: red">*</span>法人代表</td>
        <td colspan="2"><input  type="text" style="width: 80%; margin-left:1px " name="faRen"  id="faren" value=<s:property value="xuQiu.faRen"/> required></td>
        <td>&nbsp;邮政编码</td>
        <td colspan="4"><input onblur="youbiantest()" type="text" style=" width:182px;margin-left:1px " name="youBian" id="youbian" size="18" value=<s:property value="xuQiu.youBian"/>>
        <label><div id="yb" nowrap>填写邮编!</div></label></td>
      </tr>
      <tr id="jichuxinxi8" style=" display:none ">
        <td height="42">&nbsp;联 系 人</td>
        <td width="188" colspan="2"><input  onblur="PeopleYanzheng()" type="text" style="width: 80%; margin-left:1px " name="lianXiRen" id="People"  value=<s:property value="xuQiu.lianXiRen"/>>
        <!-- <div id="mesPeople" nowrap></div> -->
        </td>
        <td>&nbsp;固定电话</td>
        <td><input type="text" style=" width:182px;margin-left:1px " name="tell" id="textfield5"   value=<s:property value="xuQiu.tell"/>></td>
      </tr>
      <tr id="jichuxinxi5" style=" display:none ">
      	<td height="42">&nbsp;手机</td>
        <td width="126" colspan="2"><input type="text"  name="phone" style="width: 80%; margin-left:1px " id="textfield13" size="15"  value=<s:property value="xuQiu.phone"/>></td>      
        <td height="31">&nbsp;传真</td>
        <td colspan="4"><input type="text" style=" width:182px;margin-left:1px " name="fax" id="textfield6" size="18"  value=<s:property value="xuQiu.fax"/>></td>
        </tr>
      <tr id="jichuxinxi6" style=" display:none ">
      <td height="45"><span style="color: red">*</span>机构属性</td>
      <td colspan="6"><table width="415">
        <tr>
          <td width="91"><label>
            <input type="radio" name="jiGouShuXing" value="企业" id="CheckboxGroup1_0" <s:if test="xuQiu.jiGouShuXing=='企业'">checked</s:if> required>
            企业
          </label></td>
          <td width="95"><input type="radio" name="jiGouShuXing" value="高等院校" id="CheckboxGroup1_1" <s:if test="xuQiu.jiGouShuXing=='高等院校'">checked</s:if>>
            高等院校</td>
          <td width="112"><input type="radio" name="jiGouShuXing" value="研究机构" id="CheckboxGroup1_2" <s:if test="xuQiu.jiGouShuXing=='研究机构'">checked</s:if>>
            研究机构</td>
          <td width="97"><input type="radio" name="jiGouShuXing" value="其他" id="CheckboxGroup1_3" <s:if test="xuQiu.jiGouShuXing=='其他'">checked</s:if>>
            其他</td>
        </tr>
      </table></td>
    </tr>
    <tr id="jichuxinxi7" style=" display:none ">
      <td height="69" colspan="7">
       <p ><span style="color: red">*</span>机构简介（单位基本情况，研究基础等，限200字）<strong> </strong></p>
        <label><textarea placeholder="*机构简介（单位基本情况，研究基础等，限200字）" style="font-size: 18px; font-family:宋体;" name="jiGouJianJie" id="jianjie"  cols="28" rows="5" oninput="textCounter(jianjie,remLen,200);" onKeyUp="textCounter1(jianjie,remLen,200);"><s:property value="xuQiu.jiGouJianJie"/></textarea>
        <p></p>
        您还可以输入:<input name="remLen" type="text" style="background-color: transparent;border-style: none;" value="200" size="2" readonly>
        个字符</label>
        </td>
    </tr>
    <tr>
      <td height="44"><p ><span style="color: red">*</span>技术需求名称</p></td>
      <td colspan="2"><input type="text" style="" name="xuQiuName" id="xuQiuName" value=<s:property value="xuQiu.xuQiuName"/> required></td>
      <td><span style="color: red">*</span>需求时限</td>
      <td colspan="3"><select style="width:25%;" name="startYear" id="start" onChange="schange()" required>
      			<option value=<s:property value="xuQiu.startYear"/>><s:property value="xuQiu.startYear"/></option>
      			<%
      			for(int i=0;i<50;i++)
      			{%>
      				<option value=<%=2015+i%>><%=2015+i%></option>
      			<%
      			}
      			%>
				</select>年至
          <select style="width:25%;" name="endYear" id="end" onChange="selectchange()" disabled="disabled" required>
          		<option value=<s:property value="xuQiu.endYear"/>><s:property value="xuQiu.endYear"/></option>
      			<%
      			for(int i=0;i<50;i++)
      			{%>
      				<option value=<%=2015+i%>><%=2015+i%></option>
      			<%
      			}
      			%>
				</select>年
    </td>
    </tr>
    <tr>
      <td colspan="7">
          <p ><span style="color: red">*</span>技术需求概述<strong> </strong></p>
          <p ><strong>1、主要问题（需要解决的重大技术问题，</strong><strong>限500字以内</strong><strong>）</strong><strong> </strong></p>
          <label><br>
            <textarea placeholder="*重大科技需求概述（主要内容，技术指标、预期经济和社会效益等，限500字"  style=";font-size: 18px; font-family:宋体;" name="gaiShu1" id="gaishu1" cols="28" rows="5" oninput="textCounter(gaishu1,jishu,500);" onKeyUp="textCounter(gaishu1,jishu,500);" required><s:property value="xuQiu.gaiShu1"/></textarea>
            <br>    您还可以输入:<input name="jishu" type="text" style="background-color: transparent;border-style: none;" value="500" size="2" readonly>
        个字符
          </label>         
          <p ><strong>2、技术关键（所需的关键技术、主要指标，</strong><strong>限500字以内</strong><strong>）</strong><strong> </strong></p>
          <label><br>
          <textarea placeholder="*重大科技需求概述（主要内容，技术指标、预期经济和社会效益等，限500字"  style=";font-size: 18px; font-family:宋体;" name="gaiShu2" id="gaishu2" cols="28" rows="5" oninput="textCounter(gaishu2,jishu2,500);" required><s:property value="xuQiu.gaiShu2"/></textarea>
            <br>    您还可以输入:<input name="jishu2" type="text" style="background-color: transparent;border-style: none;" value="500" size="2" readonly>
        个字符
          </label>
          <p ><strong>3、预期目标（技术创新性、经济社会效益，</strong><strong>限500字以内</strong><strong>）</strong></p>
          <label>  <br>
            <textarea placeholder="*重大科技需求概述（主要内容，技术指标、预期经济和社会效益等，限500字"  style=";font-size: 18px; font-family:宋体;" name="gaiShu3" id="gaishu3" cols="28" rows="5" oninput="textCounter(gaishu3,jishu3,500);" required><s:property value="xuQiu.gaiShu3"/></textarea>
            <br>    您还可以输入:<input name="jishu3" type="text" style="background-color: transparent;border-style: none;" value="500" size="2" readonly>
        个字符
          </label>
          <p></p>
   		     <span style="color: red">*</span>关键字:&nbsp;&nbsp;
   		     <input onKeyDown="iptdisplay();" onKeyUp="iptdisplay();" type="text" name="guanjianzi1" maxlength="5" id="guanjianzi1" size="9" value=<s:property value="xuQiu.guanJianZi"/> required> ⇨
   		     <input onKeyUp="iptdisplay();" type="text" style="" name="guanjianzi2" maxlength="5" id="guanjianzi2" size="9" disabled="disabled" > ⇨
   		     <input onKeyUp="iptdisplay();" type="text" style="" name="guanjianzi3" maxlength="5" id="guanjianzi3" size="9" disabled="disabled"> ⇨
   		     <input onKeyUp="iptdisplay();" type="text" style="" name="guanjianzi4" maxlength="5" id="guanjianzi4" size="9" disabled="disabled"> ⇨
          	 <input onKeyUp="iptdisplay();" type="text" style="" name="guanjianzi5" maxlength="5" id="guanjianzi5" size="9" disabled="disabled"></td>
    </tr>
    <tr>
      <td height="41">拟投入资金总额</td>
      <td colspan="6"><input type="text" style="" name="sumMoney" id="summoney" value=<s:property value="xuQiu.sumMoney"/>>
        万元</td>
    </tr>
    <tr>
      <td rowspan="2"><p ><span style="color: red">*</span>技术需求解决方式 </p></td>
      <td height="32" colspan="6"><input type="radio" name="way" id="checkbox19" value="独立研发" required <s:if test="xuQiu.way=='独立研发'">checked</s:if>>
        独立研发
        <input type="radio" name="way" id="checkbox21" value="委托研发" <s:if test="xuQiu.way=='委托研发'">checked</s:if>>
委托研发
<input type="radio" name="way" id="checkbox22" value="合作研发" <s:if test="xuQiu.way=='合作研发'">checked</s:if>>
合作研发
          <input type="radio" name="way" id="checkbox23" value="其他" <s:if test="xuQiu.way=='其他'">checked</s:if>>
其他</td>
    </tr>
    <tr>
      <td height="30" colspan="6">合作意向单位：
        <input type="text" style="" name="heZuoDanWei" id="textfield14">
(非必填)</td>
    </tr>
    <tr>
      <td><p ><span style="color: red">*</span>科技活动类型</p></td>
      <td colspan="6"><table width="632" height="60" border="0">
        <tbody>
          <tr>
            <td width="178"><input type="radio" name="huoDongLeiXing" id="checkbox1" value="基础研究" onclick="radio_click1()" <s:if test="xuQiu.huoDongLeiXing=='基础研究'">checked</s:if> required>
基础研究 </td>
            <td width="175"><input type="radio" name="huoDongLeiXing" id="checkbox2" value="应用研究" onclick="radio_click1()" <s:if test="xuQiu.huoDongLeiXing=='应用研究'">checked</s:if>>
应用研究</td>
            <td width="265"><input type="radio" name="huoDongLeiXing" id="checkbox3" value="试验发展" onclick="radio_click1()" <s:if test="xuQiu.huoDongLeiXing=='试验发展'">checked</s:if>>
              试验发展</td>
            </tr>
          <tr>
            <td height="26"><input type="radio" name="huoDongLeiXing" id="checkbox4" value="研究发展与成果应用" onclick="radio_click1()" <s:if test="xuQiu.huoDongLeiXing=='研究发展与成果应用'">checked</s:if>>
研究发展与成果应用</td>
            <td><input type="radio" name="huoDongLeiXing" id="checkbox5" value="技术推广与科技服务" onclick="radio_click1()" <s:if test="xuQiu.huoDongLeiXing=='技术推广与科技服务'">checked</s:if>>
技术推广与科技服务</td>
            <td><input type="radio" name="huoDongLeiXing" id="checkbox16" value="生产性活动" onclick="radio_click1()" <s:if test="xuQiu.huoDongLeiXing=='生产性活动'">checked</s:if>>
              生产性活动</td>
            </tr>
        </tbody>
      </table></td>     
    </tr>
<!--------------------------------- 学科分类三级列表---------------------------------------------------------------->
 <tr id="xk" style=" display:none ">
  	<td height="70">学科分类</td>
        <td colspan="6">
       			 <span style="margin-left:10px;width:18px;overflow:hidden;"></span>
       			 <table width="677" height="73" border="0">
       			   <tbody>
       			     <tr>
       			       <td height="46"><span style="margin-left: 10px; width: 180px; overflow: hidden;">一级学科：
                           <select name="subjectCode1" onchange="changeSubjectCode1(subjectCode1)">
	                           <s:iterator value="subjects">
		                           <option value=<s:property value="subjectCode"/>>                            
										<s:property value="subjectTitle"/>
		                           </option>
	                           </s:iterator>
	                        </select>
                       </span></td>
       			       <td><span style="margin-left:10px;width:18px;overflow:hidden;">二级学科：
                           <select name="subjectCode2" id="secondSunject" onChange="changeSubjectCode2(subjectCode2)">
                             <option>=二级学科=</option>
                           </select>
       			       </span></td>
       			       <td><span style="margin-left:10px;width:18px;overflow:hidden;">三级学科：
                           <select name="xueKeFenLei" id="thirdSubject">
                             <option selected value="">=三级学科=</option>
                           </select>
                       </span></td>
   			         </tr>
       			     <tr>
       			       <td height="21" colspan="3"><span style="margin-left:10px;width:18px;overflow:hidden;">（参加学科分类，限基础研究填写）
                           <label id="datapro">&nbsp;</label>
                       </span></td>
   			         </tr>
   			       </tbody>
	      </table></td>
	      </tr>
<!------------------------需求技术所属领 --------------------------------------------------------------------------------------->
    
    <tr id="jx" style=" display:none ">
      <td height="104"><p align="center" >需求技术所属领</p>
        <p align="center" >(非基础研究填写）</p></td>
      <td colspan="6"><p >
        <input type="checkbox" name="suoShuLingYu" id="checkbox6" value="电子信息技术">
      电子信息技术
      <input type="checkbox" name="suoShuLingYu" id="checkbox7" value="光机电一体化">
      光机电一体化
      <input type="checkbox" name="suoShuLingYu" id="checkbox8" value="软件">
      软件  
      <input type="checkbox" name="suoShuLingYu" id="checkbox9" value="生物制药技术">
      生物制药技术  
      <input type="checkbox" name="suoShuLingYu" id="checkbox10" value="新材料及应用技术">
      新材料及应用技术 </p>
        <p >
          <input type="checkbox" name="suoShuLingYu" id="checkbox11" value="先进制造技术 ">
          先进制造技术   
          <input type="checkbox" name="suoShuLingYu" id="checkbox12" value="现代农业技术 ">
          现代农业技术 
          <input type="checkbox" name="suoShuLingYu" id="checkbox13" value="新能源与高效节能技术 ">
          新能源与高效节能技术  
          <input type="checkbox" name="suoShuLingYu" id="checkbox14" value="资源与环境保护新技术">
          资源与环境保护新技术  </p>
        <p >
  <input type="checkbox" name="lingyu" id="checkbox15" value="其他技术">
          其他技术</p></td>
    </tr>
<!------------------------需求技术应用行业--------------------------------------------------------------------------------------->
    <tr id="hy" style=" display:none  ">
     <td height="70">需求技术应用行业</td>
        <td colspan="6">
       			 <span style="margin-left:10px;width:18px;overflow:hidden;"></span>
       			 <table width="677" height="73" border="0">
       			   <tbody>
       			     <tr>
       			       <td height="46"><span style="margin-left: 10px; width: 180px; overflow: hidden;">一级分类：
                           <select name="fristIndustries" id="fristIndustries" onChange="changeIndustries1(fristIndustries)">
                           		<option value="0">=一级分类=</option>
                           		<s:iterator value="industries">                          		   
		                           <option value=<s:property value="industryCode"/>>                            
										<s:property value="industryTitle"/>
		                           </option>
	                           </s:iterator>
                           </select>
                       </span></td>
       			       <td><span style="margin-left:10px;width:18px;overflow:hidden;">二级分类：
                           <select name="secondIndustries" id="secondIndustries" onChange="changeIndustries2(secondIndustries)">
                             <option selected value="">==二级分类==</option>
                           </select>
       			       </span></td>
       			       <td><span style="margin-left:10px;width:18px;overflow:hidden;">三级分类：
                           <select name="yingYongHangYe" id="thirdIndustries">
                             <option selected value="">==三级分类==</option>
                           </select>
                       </span></td>
   			         </tr>
       			     <tr>
       			       <td height="21" colspan="3"><span style="margin-left:10px;width:18px;overflow:hidden;">（参加学科分类，限基础研究填写）
                           <label id="datapro">&nbsp;</label>
                       </span></td>
   			         </tr>
   			         </tbody>
	      </table></td>
		<tr>
			<td>
			<span style="color: red">*</span>
			审核部门：
			</td>
			<td colspan="6">
			&nbsp;&nbsp;
				<select name="" id="shbm" required value=""/>
							<option></option>
							<s:iterator value="shenHeBuMens">                          		   
		                           <option value=<s:property value="shBuMencode"/>>                            
										<s:property value="buMenName"/>
		                           </option>
	                         </s:iterator>
						</select>
			</td>
		</tr>
  </tbody>
</table>
<p>	 
	 <div class="demo_con">
     <input type="button" class="buttonblue" name="submit" id="saveAndCommit" value="保存并提交">
     <input type="button" class="buttonblue" name="submit" id="justSave" value="保存但不提交">
     </div>	
</p>
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
