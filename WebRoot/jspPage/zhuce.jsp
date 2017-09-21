<%@page import="java.awt.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.sql.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/zhucestyle.css" rel="stylesheet" type="text/css" />
<style type="text/css">

div#user { float: right; color: blue; }/*--用户名提示格式 --*/

div#pwd1 { float: right; color: blue; }/*--密码错误提示格式 --*/

div#pwd { float: right; color: blue; }/*--密码错误提示格式 --*/

div#mes{ float: right; color: blue; } /*--邮编错误提示格式 --*/

div#card{ float: right; color: blue; } /*--身份证号错误提示格式 --*/

</style>
<style type="text/css">
		.nice-select input{
			cursor: pointer;
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
			display: none;
			border: 1px solid #d5d5d5;
			width: 14.6em;
			position: absolute;
			/* top: 1.8em; */
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
		}
		
		.nice-select ul li.on{background-color:  	#FFFFFF;}
		
	</style>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>用户注册</title>
<style type="text/css">
            input[type = "text"], input[type = "password"] {
	width: 270px;
	height: 25px;
            }
        #last {
	width: auto;
}
</style>
</head> 
    <body>
    <div class="formbody">
    <div class="formtitle"><span>用户注册</span></div>
  	<ul class="forminfo">
            <form action="" method="post" id="form">
            <br/>
                           <table width="304" border="1" width="50%"  style="border-collapse:collapse" align="center" cellpadding="5" cellspacing="1">
                    <tr>
                        <td width="18%">
                            用户名:
                        </td>
                        <td width="82%">
                            <input onblur="userjiaoyan()" type="text" name="userName"  id="username"  required><span id="usernameSpan">
                            <label><div id="user" nowrap>请输入用户名!</div></label></span></span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            密码:
                        </td>
                        <td>
                            <input onblur="pwdjiaoyan()" type="password" name="passWord" id="password" required><span id="passwordSpan">
                            <label><div id="pwd1" nowrap>请 输 入 密码!</div></label></span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            验证密码:
                        </td>
                        <td>
                            <input onblur="jiaoyan()" type="password" name="confirm" id="confirm" required><span id="confirmSpan">
                            <label><div id="pwd" nowrap>重复输入密码!</div></label></span>
                        </td>
                    </tr>
                    <tr>
                        <td>真实姓名:</td>
                      <td>
                            <input type="text" name="realname" id="realname" required><span id="emailSpan"></span>
                        </td>
                    </tr>
                    <tr>
                        <td>身份证号:</td>
                        <td>
                        <input onblur="cardyanzheng()" type="text" name="IDcard" id="people" required>
                        <label><div id="card" nowrap>请输入身份证号!</div></label></span>
                        </td>
                    </tr>
                    <tr>
                        <td>机构全称:</td>
                        <td>
                            <input type="text" name="jgname" id="jgname" required><span id="birthdaySpan"></span>
                        </td>
                    </tr>
                    <tr>
                    <td>归口管理部门</td>
      <td colspan="3"> 
      		<div class="nice-select">
				<input id="gkbm" name="gkbm" type="text" oninput="searchList(this.value)" />
				<ul>
					<s:iterator value="guikoubumens">
					<li><s:property value="department"/></li>
					</s:iterator>
				</ul>
			</div>
		</td>
                    </tr>
                    <tr>
                        <td>通讯地址:</td>
                        <td><input type="text" name="adress" id="adress"></td>
                    </tr>
                    <tr>
                        <td> 邮箱: </td>
                        <td colspan="3"><input onblur="verifyAddress()" name="email" type="text" style="" id="email" size="18"  tabindex="4">
        				<label><div id="mes" nowrap>填写邮箱!</div></label>
        				</td>    	
                    </tr>
                    <tr>
                      <td>固定电话：</td>
                      <td><input type="text" name="call" id="call"></td>
                    </tr>
                    <tr>
                      <td >手机：</td>
                      <td ><input type="text" name="phone" id="phone"></td>
                    </tr>
                    <tr>
                      <td >单位网址：</td>
                      <td ><input type="text" name="web" id="web"></td>
                    </tr>
                    <tr>
                      <td >传真：</td>
                      <td ><input type="text" name="fax" id="fax"></td>
                    </tr>
                    <tr>
                      <td colspan="2" ><p>机构简介：</p>
                       <label><textarea placeholder="*机构简介（单位基本情况，研究基础等，限200字）" style="font-size: 18px; font-family:宋体;" name="jianjie" id="jianjie" cols="65" rows="5" oninput="textCounter(jianjie,remLen,200);" onpropertychange="textCounter1(jianjie,remLen,200);"></textarea>
   					    <p></p>
        				您还可以输入:<input name="remLen" type="text" id="last" style="background-color: transparent;border-style: none;" value="200" size="1" readonly> 个字符</label></td>
                      </tr>
                </table>
                           <center><p>
                           <br/>
                             <input name="submit" type="submit" style= "height:40px;width:120px " value="注册" onclick="checkButton()">
                             <input type="reset" style= "height:40px;width:120px " value="重置">
              </p>
              </center>
      </form>
         </ul>
        </div>
    </body>
<script type="text/javascript" src="js/loginAndRegister/md5.js"></script>
<script type="text/javascript" src="js/loginAndRegister/RegisterForm.js"></script>
<script src="./js/jquery-1.7.js"></script>
<script type="text/javascript"> 
//测试函数****
/* function tanchu2(){
	alert("1111");
	var  myselect=document.getElementById("gkbm");
	alert(myselect.value);
} */
//获取输入内容并智能筛选下拉列表框(归口管理部门)********************************************************************
$(function(){
	$(".nice-select").click(function(e){
		$(this).find("ul").show();
		e.stopPropagation();
	});
	
	$(".nice-select ul li").hover(function(e){
		$(this).toggleClass("on");
		e.stopPropagation();
	});
	
	$(".nice-select ul li").click(function(e){
		var val = $(this).text();
		/* val = val.substring(0, val.indexOf('--')); */
		$(".nice-select").find("input").val(val);
		$(".nice-select").find("ul").hide();
		e.stopPropagation();
	});
	
	$(document).click(function(){
		$(".nice-select").find("ul").hide();
	});
});

function searchList(strValue) {
	var count = 0;
	if (strValue != "") {
		$(".nice-select ul li").each(function(i) {
			var contentValue = $(this).text();
			if (contentValue.toLowerCase().indexOf(strValue.toLowerCase()) < 0) {
				$(this).hide();
				count++;
			} else {
				$(this).show();
			}
			if (count == (i + 1)) {
				$(".nice-select").find("ul").hide();
			} else {
				$(".nice-select").find("ul").show();
			}
		});
	} else {
		$(".nice-select ul li").each(function(i) {
			$(this).show();
		});
	}
}
</script>
</html>