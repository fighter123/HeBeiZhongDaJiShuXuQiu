/**
 * 
 */
//显示基础信息
function displayJiChu()
{
	var jichuxinxi1=document.getElementById('jichuxinxi1');
	var jichuxinxi2=document.getElementById('jichuxinxi2');
	var jichuxinxi3=document.getElementById('jichuxinxi3');
	var jichuxinxi4=document.getElementById('jichuxinxi4');
	var jichuxinxi5=document.getElementById('jichuxinxi5');
	var jichuxinxi6=document.getElementById('jichuxinxi6');
	var jichuxinxi7=document.getElementById('jichuxinxi7');
	var jichuxinxi8=document.getElementById('jichuxinxi8');
	if(jichuxinxi1.style.display=="none")
		{
			jichuxinxi1.style.display ="";
			jichuxinxi2.style.display ="";
			jichuxinxi3.style.display ="";
			jichuxinxi4.style.display ="";
			jichuxinxi5.style.display ="";
			jichuxinxi6.style.display ="";
			jichuxinxi7.style.display ="";
			jichuxinxi8.style.display ="";
		}
	else
		{
			jichuxinxi1.style.display ="none";
			jichuxinxi2.style.display ="none";
			jichuxinxi3.style.display ="none";
			jichuxinxi4.style.display ="none";
			jichuxinxi5.style.display ="none";
			jichuxinxi6.style.display ="none";
			jichuxinxi7.style.display ="none";
			jichuxinxi8.style.display ="none";
		}
	
}
//保存并提交************************************************************************
jQuery(function($){	
	$('.buttonblue').click(function ()
		{	
			var state="state=0";
			var p = $(this).attr('value');
			if(p=="保存并提交")
				{
					state="state=1";
				}
			//alert(state);
			var jgname=document.getElementById('jgname').value;
			var companyAdrss=document.getElementById('companyAdrss').value;
			var area=document.getElementById('area').value;
			var email=document.getElementById('email').value;
			var faren=document.getElementById('faren').value;
			var jiGouShuXing=$("input[name='jiGouShuXing'][type='radio']:checked").val();
			var xuQiuName=document.getElementById('xuQiuName').value;
			var start=document.getElementById('start').value;
			var end=document.getElementById('end').value;
			var gaiShu1=$("textarea[name='gaiShu1']").val();
			var gaiShu2=$("textarea[name='gaiShu2']").val();
			var gaiShu3=$("textarea[name='gaiShu3']").val();
			var guanjianzi1=document.getElementById('guanjianzi1').value;
			var way=$("input[name='way'][type='radio']:checked").val();
			var huoDongLeiXing=$("input[name='huoDongLeiXing'][type='radio']:checked").val();
			var shbm=document.getElementById('shbm').value;
			//alert(jgname+";"+companyAdrss+";"+faren+";"+jiGouShuXing+";"+xuQiuName+";"+gaiShu1+gaiShu2+gaiShu3+";"+guanjianzi1+";"+way+";"+huoDongLeiXing);
			//必填项非空验证
			if(area==null||email==null||start==null||end==null||jgname==null||faren==null||companyAdrss==null||jiGouShuXing==null||xuQiuName==null||gaiShu1==null||gaiShu2==null||gaiShu3==null||guanjianzi1==null||way==null||huoDongLeiXing==null||shbm==null)
			{
				alert("必填项填写完整才可以提交呦！");
				return;
			}
			//获取所有radio类型的input选中值
			var str_data1=$("#xuQiuForm input[type='radio']").map(function(){
				if($(this).attr('checked'))//将被选中的radio值返回
					{
					 	return ($(this).attr("name")+'='+$(this).val());
					}
				else
					{
						return;
					}
			 
			}).get().join("&");
			//alert(str_data1);
			//获取所有checkbox类型的input选中值
			var str_data2=$("#xuQiuForm input[type='checkbox']").map(function(){
				if($(this).attr('checked'))//将被选中的radio值返回
					{
					 	return ($(this).attr("name")+'='+$(this).val());
					}
				else
					{
						return;
					}			 
			}).get().join("&");
			//alert(str_data2);
			//获取所有text类型的input选中值
			var str_data3=$("#xuQiuForm input[type='text']").map(function(){
				return ($(this).attr("name")+'='+$(this).val());
			 }).get().join("&");
			//alert(str_data3);
			//获取所有select值
			var str_data4=$("#xuQiuForm select").map(function(){
				  return ($(this).attr("name")+'='+$(this).val());
				}).get().join("&") ;
			//alert(str_data4);
			//获取所有textarea值
			var str_data5=$("#xuQiuForm textarea").map(function(){
				  return ($(this).attr("name")+'='+$(this).val());
				}).get().join("&") ;
			//alert(str_data5);
			var str_data=str_data1+"&"+str_data2+"&"+str_data3+"&"+str_data4+"&"+str_data5+"&"+state;
			/*alert(str_data);
			alert("可以发请求了");*/
			$.ajax({ 
	 			 type:"POST",
	   			 url:"commitXuQiuForm",
	   			 async:false,
	   			 dataType: "text",
	   			 scriptCharset:'UTF-8',
	   			 data:str_data,
	   			 success:function(result)
	   				 { 
	   				 	if(result==1){
	   				 		alert("提交成功点击确认继续！");
	   				 		//window.location.href="tianbao";
	   				 	    location.reload();
	   				 	}
	   				 	else if(result==2){
	   				 		alert("登录超时，请重新的登录！");
	   				 	}
	   				 	else{
	   				 		alert("提交失败原因未知！");
	   				 	}
	    			 } 
			}); 
	   });
	});
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
//需求时限校验******************************************************************************
function schange()
	{
		end.disabled=false;
	}
function selectchange()
	{
		var a = document.getElementById('start').value;
		var b = document.getElementById('end').value;
		if(a>b)
			{
				start.value="";
				end.value="";
				alert("结束年份必须大于等于起始年份,请重新输入！");
				end.disabled=true;
			}
	}
//三级联动列表*******************************************************************************
//学科
var subjectCode1=null;
var subjectCode2=null;
 function changeSubjectCode1(subjectCode1){

    if (subjectCode1.value=="0000000") return;
    //alert(subjectCode1.value);
    var subjectTempCode1=subjectCode1.value;
    subjectTempCode1=subjectTempCode1.substring(0,subjectTempCode1.length-4);
    //alert(subjectTempCode1);
    $.ajax({ 
		 type:"POST",
			 url:"subjectCode2",
			 async:false,
			 dataType: "text",
			 scriptCharset:'UTF-8',
			 data:{"subjectCode1":subjectTempCode1},
			 success:function(result)
				 { 
				 	 var data = eval('('+ result +')');
				 	 var secondSunject = document.getElementById('secondSunject');
				 	 secondSunject.options.length=0;
				 	 secondSunject.options[secondSunject.length] = new Option();
				 	 secondSunject.options[0].value = "0";
				 	 secondSunject.options[0].text = "=二级学科=";
				 	 for(var i=1;i<data.length;i++)
				 		 {
				 		 	 secondSunject.options[secondSunject.length] = new Option();
				 		 	 secondSunject.options[i].value = data[i].subjectCode;
				 		 	 secondSunject.options[i].text = data[i].subjectTitle;
				 		 }
				 	 
				 }
				 	
		});
 }
 function changeSubjectCode2(subjectCode2){
	    if (subjectCode2.value=="0") return;
	    //alert(subjectCode2.value);
	    var subjectTempCode2=subjectCode2.value;
	    subjectTempCode2=subjectTempCode2.substring(0,subjectTempCode2.length-2);
	    //alert(subjectTempCode2);
	    $.ajax({ 
			 type:"POST",
				 url:"subjectCode3",
				 async:false,
				 dataType: "text",
				 scriptCharset:'UTF-8',
				 data:{"subjectCode2":subjectTempCode2},
				 success:function(result)
					 { 
					 	 var data = eval('('+ result +')');
					 	 //alert(data.length);
					 	 var thirdSubject = document.getElementById('thirdSubject');
					 	 thirdSubject.options.length=0;
					 	 thirdSubject.options[thirdSubject.length] = new Option();
					 	 thirdSubject.options[0].value = "0";
					 	 thirdSubject.options[0].text = "=三级学科=";
					 	 for(var i=1;i<=data.length;i++)
					 		 {
					 		 	 thirdSubject.options[thirdSubject.length] = new Option();
					 		 	 thirdSubject.options[i].value = data[i-1].subjectTitle;
					 		 	 thirdSubject.options[i].text = data[i-1].subjectTitle;
					 		 }
					 	 
					 }
					 	
			});
	 }
 //应用行业************************************************************************
 function changeIndustries1(fristIndustries)
 {
	 if (fristIndustries.value=="0") return;
	 //alert(fristIndustries.value);
	 var industry=fristIndustries.value;
	 industry=industry.substring(0,1);
	 //alert(industry);
	 $.ajax({ 
		 type:"POST",
			 url:"industryCode2",
			 async:false,
			 dataType: "text",
			 scriptCharset:'UTF-8',
			 data:{"industryCode1":industry},
			 success:function(result)
				 { 
				 	 var data = eval('('+ result +')');
				 	 var secondIndustries = document.getElementById('secondIndustries');
				 	 secondIndustries.options.length=0;
				 	 secondIndustries.options[secondIndustries.length] = new Option();
				 	 secondIndustries.options[0].value = "0";
				 	 secondIndustries.options[0].text = "=二级分类=";
				 	 for(var i=1;i<data.length;i++)
				 		 {
				 		 	 secondIndustries.options[secondIndustries.length] = new Option();
				 		 	 secondIndustries.options[i].value = data[i].industryCode;
				 		 	 secondIndustries.options[i].text = data[i].industryTitle;
				 		 }
				 	 
				 }
				 	
		});
	 
 }
 function changeIndustries2(secondIndustries)
 {
	 //alert(secondIndustries.value);
	 if (secondIndustries.value=="0") return;
	 //alert(fristIndustries.value);
	 var industry=secondIndustries.value;
	 industry=industry.substring(0,3);
	 //alert(industry);
	 $.ajax({ 
		 type:"POST",
			 url:"industryCode3",
			 async:false,
			 dataType: "text",
			 scriptCharset:'UTF-8',
			 data:{"industryCode2":industry},
			 success:function(result)
				 { 
				     var data = eval('('+ result +')');
				 	 var thirdIndustries = document.getElementById('thirdIndustries');
				 	 thirdIndustries.options.length=0;
				 	 thirdIndustries.options[thirdIndustries.length] = new Option();
				 	 thirdIndustries.options[0].value = "0";
				 	 thirdIndustries.options[0].text = "=三级分类=";
				 	 for(var i=1;i<=data.length;i++)
				 		 {
						 		thirdIndustries.options[thirdIndustries.length] = new Option();
						 		thirdIndustries.options[i].value = data[i-1].industryTitle;
						 		thirdIndustries.options[i].text = data[i-1].industryTitle;
				 		 }
				 	 
				 }
				 	
		});
 }

//控件状态（显示是否能够点击）***********************************************************************
     function radio_click1(){
       var huoDongLeiXing = $("input[name='huoDongLeiXing']:checked").val();;
       //alert(huoDongLeiXing);
       if(huoDongLeiXing=="基础研究")
    	   {
    	    xk.style.display ="";
     	 	jx.style.display = "none";
     	 	hy.style.display ="none";  
    	   }
       else
    	   {
    	   xk.style.display ="none";
       	   jx.style.display = "";
       	   hy.style.display ="";
    	   }
	  }
     function radio_click2()
     {
    	 xk.style.display ="";
    	 jx.style.display = "none";
    	 hy.style.display ="none";
     }
//关键字input控件
function iptdisplay()
 {
	 var aa = document.getElementById('guanjianzi1').value;
	 var bb = document.getElementById('guanjianzi2').value;
	 var cc = document.getElementById('guanjianzi3').value;
	 var dd = document.getElementById('guanjianzi4').value;
	 var g5 = document.getElementById("guanjianzi5");  
	 var g2 = document.getElementById("guanjianzi2");
	 var g3 = document.getElementById("guanjianzi3");
	 var g4 = document.getElementById("guanjianzi4");
	 
	 if(aa!="")
	 {
		 g2.disabled=false;
	 }
	 if(bb!="")
	 {
		 g3.disabled=false;
	 }
	 if(cc!="")
	 {
		 g4.disabled=false;
	 }
	 if(dd!="")
	 {
		 g5.disabled=false;
	 }
	 
 }
//空值验证*********************************************************************************
//联系人
function PeopleYanzheng()
{
	var a = document.getElementById('People').value; 
	if(a=="")
	{
	    document.getElementById("mesPeople").innerHTML="<font color='red'>联系人不能为空!</font>";
      return false;
	}
	else
	{
		
		   document.getElementById("mesPeople").innerHTML="<font color='red'></font>";
 	     return true;
	}
}
//邮箱验证*********************************************************************************
function verifyAddress()    
{    
var email = document.getElementById('email').value;    
var pattern = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;    
flag = pattern.test(email);    
if(flag)    
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
//邮编验证*********************************************************************************
function youbiantest()    
{ 
	 var youbian = document.getElementById('youbian').value;  
	 var pattern = /^[1-9]{1}[0-9]{5}$/;
	 flag = pattern.test(youbian);
	 if(youbian=="")return;
	 if(flag)    
	 {    
		 document.getElementById("yb").innerHTML="<font color='red'></font>";
	   	 return true;    
	 }    
	 else    
	 {    
	  document.getElementById("yb").innerHTML="<font color='red'>邮编格式有误!</font>";
	  return false;    
	 }  
}
//文本域计数及限制字数***************************************************************************
function textCounter(field, countfield, maxlimit) {
//函数，3个参数，表单名字，表单域元素名，限制字符；
if (field.value.length > maxlimit)
{
	//如果元素区字符数大于最大字符数，按照最大字符数截断；
	field.value = field.value.substring(0, maxlimit);
	alert("输入字符已达上限！");
}
else
{
	//在记数区文本框内显示剩余的字符数；
	countfield.value = maxlimit - field.value.length;
}

}