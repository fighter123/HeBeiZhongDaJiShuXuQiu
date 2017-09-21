
//变量用来判断是否可以提交注册***************************************************************
var checkUser=0;
var checkPwd=0;
var pwd1=0;
var checkID=0;
//点击注册时弹出**********************************************************************
function checkButton()
{
	var userName = document.getElementById('username').value;
	var passWord = document.getElementById('password').value;
	var realname = document.getElementById('realname').value;
	var IDcard = document.getElementById('people').value;
	var jgname = document.getElementById('jgname').value;
	var gkbm = document.getElementById('gkbm').value;
	var adress = document.getElementById('adress').value;
	var email =document.getElementById('email').value;
	var call = document.getElementById('call').value;
	var phone = document.getElementById('phone').value;
	var web = document.getElementById('web').value;
	var fax = document.getElementById('fax').value;
	var jianjie = document.getElementById('jianjie').value;
	var passWord = hex_md5(passWord);
	//alert(passWord);
	//alert("["+userName.value+"]["+passWord.value+"]["+realname.value+"]["+IDcard.value+"]["+jgname.value+"]["+gkbm.value+"]["+adress.value+"]["+email.value+"]["+call.value+"]["+phone.value+"]["+web.value+"]["+fax.value+"]["+jianjie.value+"]");
	//alert(userName.value);userName.value==''||passWord.value==''||realname.value==''||IDcard.value==''||jgname.value==''
	if(checkUser==1&&checkPwd==1&&checkID==1&&pwd1==1&&realname.value!=''&&jgname.value!='') 
	{
		 $.ajax({ 
				 type:"POST",
	  			 url:"register",
	  			 async:false,
	  			 dataType: "text",
	  			 scriptCharset:'UTF-8',
	  			 data:{"userName":userName,"passWord":passWord,"realname":realname,"IDcard":IDcard,"jgname":jgname,"gkbm":gkbm,"adress":adress,"email":email,"call":call,"phone":phone,"web":web,"fax":fax,"jianjie":jianjie},
	  			 success:function(result)
	  				 { 
	  				 	 //alert(result);
	  				 	 result=result.substring(1,result.length-1);
	  				 	 //alert(result);
	  				 	 if(result=="1")
	  				 		 {
	  				 		 	alert("注册成功,点击确认跳转到登录界面！");
	  				 		 	window.open('login.html','_parent');
	  				 		 }
	  				 	 else
	  				 		 {
	  				 		 	alert("注册失败，请重新注册！");	  				 		 
	  				 		 }
	  				 }
	  			 });
	}
	else
	{
		alert("注册信息必填项填写完整无误后方可提交！");
	}
}
//文本域计数及限制字数***************************************************************************
function textCounter(field, countfield, maxlimit) {
// 函数，3个参数，表单名字，表单域元素名，限制字符；
if (field.value.length > maxlimit)
{
//如果元素区字符数大于最大字符数，按照最大字符数截断；
field.value = field.value.substring(0, maxlimit);
alert("输入字符已达上限！");
}
else
//在记数区文本框内显示剩余的字符数；
countfield.value = maxlimit - field.value.length;
}
//用户名校验
function userjiaoyan()
{
	var a = document.getElementById('username').value; 
	if(a=="")
	{
	    document.getElementById("user").innerHTML="<font color='red'>用户名不能为空!</font>";
        return false;
	}
	else if(a.length<6)
	{
		
		   document.getElementById("user").innerHTML="<font color='red'>用户名至少为6位</font>";
   	     return true;
	}
	else
		{
	   			 $.ajax({ 
				 type:"POST",
	  			 url:"userNameExist",
	  			 async:false,
	  			 dataType: "text",
	  			 scriptCharset:'UTF-8',
	  			 data:{"userName":a},
	  			 success:function(result)
	  				 { 
	  				 	 //alert(result);
	  				 	 result=result.substring(1,result.length-1);
	  				 	 //alert(result);
	  				 	 if(result=="0")
	  				 		 {
	  				 		 	document.getElementById("user").innerHTML="<font color='greend'>用户名可以使用！</font>";
	  				 			checkUser=1;
	  				 		 }
	  				 	 else
	  				 		 {
	  				 		 	document.getElementById("user").innerHTML="<font color='red'>该用户名已存在！</font>";
	  				 		 	checkUser=0;
	  				 		 }
	  				 }
	  			 });
		}
}
//密码校验*************************************************************************
function pwdjiaoyan()
{
	var a = document.getElementById('password').value; 
	if(a=="")
	{
	    document.getElementById("pwd1").innerHTML="<font color='red'>密码不能为空!</font>";
        pwd1=0;
        return false;
	}
	else if(a.length<6)
	{
		
		 document.getElementById("pwd1").innerHTML="<font color='red'>密码至少为6位</font>";
   	     pwd1=0;
   	     return true;
	}
	else
	{
		 pwd1=1;
		 document.getElementById("pwd1").innerHTML="<font color='red'></font>";
	}
}
//重复密码校验*******************************************************************************
function jiaoyan()
{
	var a = document.getElementById('password').value; 
	var b = document.getElementById('confirm').value; 
	if(a!=b)
	{
	    document.getElementById("pwd").innerHTML="<font color='red'>两次输入密码不一致!</font>";
        checkPwd=0;
        return false;
	}
	else if(b=="")
	{
		document.getElementById("pwd").innerHTML="<font color='red'>重复输入密码不能为空!</font>";
        checkPwd=0;
        return false;
	}
	else
	{
		document.getElementById("pwd").innerHTML="<font color='greend'>√ 一定要记住密码呦！</font>";
		checkPwd=1;
		return true;
	}
}
//邮箱验证*********************************************************************************
function verifyAddress()    
{    
 var email = document.getElementById('email').value;    
 var pattern = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;    
 flag = pattern.test(email);    
 if(flag||email=="")    
 {    
	 document.getElementById("mes").innerHTML="<font color='red'></font>";
   	 return true;    
 }    
 else    
 {    
  document.getElementById("mes").innerHTML="<font color='red'>邮箱格式有误!</font>";
  document.getElementById("email").focus();
  return false;    
 }    
} 
//身份证号验证*********************************************************************************
function cardyanzheng()
{
	 var p = document.getElementById('people').value;   
	 if(p.length==18)
		 {
		 	document.getElementById("card").innerHTML="<font color='red'></font>";
		 	checkID=1;
		 }
	 else
		 {
		 	document.getElementById("card").innerHTML="<font color='red'>身份证号码格式有误!</font>"; 	
		 	checkID=0;
		 }
}