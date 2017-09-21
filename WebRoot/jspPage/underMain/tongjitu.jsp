<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script type="text/javascript" src="../../js/ichart.1.2.min.js"></script>
    <script type="text/javascript" src="../../js/jquery-1.7.js"></script>
    <script type="text/javascript">
    	jQuery(function($){	
			$('#submit').click(function (){
				qtype=document.getElementById('tongjileixing').value;
				$.ajax({ 
				 type:"POST",
					 url:"../../tongjitudata",
					 async:false,
					 dataType: "text",
					 scriptCharset:'UTF-8',
					 data:{"qtype":qtype},
					 success:function(result)
						 { 
							//alert(result);
							result=result.split("?");
			    			var name=result[0];
			    			name=name.substring(1);
			    			var count=result[1];
							var n=name.split("$");
							var nc=count.split("$");
							var data=[];
							for(var i=0;i<n.length-1;i++)
							{
							var a={};
							a.name=n[i];
							a.value=nc[i];
							a.color="#6A5ACD";
							data.push(a);
							}
							new iChart.Pie2D({
							render : 'canvasDiv',
							data: data,
							title : '统计图(有空项可能该字段在需求表中为非必填项)',
							legend : {
							enable : true
							},
							sub_option : {
							label : {
							background_color:null,
							sign:false,//设置禁用label的小图标
							padding:'0 4',
							border:{
							enable:false,
							color:'#666666'
							},
							fontsize:11,
							fontweight:600,
							color : '#4572a7'
							},
							border : {
							width : 2,
							color : '#ffffff'
							}
							},
							animation:true,
							showpercent:true,
							decimalsnum:2,
							width : 800,
							height : 400,
							radius:140
							}).draw();		
					 	 } 
				});
		   	});
		});
    
		</script>
		
</head>
<body>
<form name="form1"  method="post" action=""  id="form1">
<table>
		<tr>
		<td>请选择统计类型：</td>
		<td>
		<select style="width:25;" name="tongjileixing" id="tongjileixing">
      			<option value="belongApartment">归口管理部门</option>
      			<option value="area">所在地域</option>
      			<option value="jiGouShuXing">机构属性</option>
      			<option value="username">提交者</option>
      			<option value="companyAllname">提交机构</option>
      			<option value="startYear">起始年份</option>
      			<option value="endYear">结束年份</option>
      			<option value="huoDongLeiXing">科技活动类型</option>
      			<option value="suoShuLingYu">需求技术所属领</option>
      	</select>
      	</td>
      	<td><input type="button" name="submit" id="submit" value="确认"></td>
      	</tr>
      	</table>
</form>
<div id='canvasDiv'></div>
</body>
</html>