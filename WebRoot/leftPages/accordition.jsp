<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.sql.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--框架必需start-->
<link href="./css/import_basic.css" rel="stylesheet" type="text/css" />
<link href="./skins/sky/import_skin.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="./js/jquery-1.4.js">
</script>
<script type="text/javascript" src="./js/framework.js">
</script>
<!--框架必需end-->
<script type="text/javascript" src="./js/nav/ddaccordion.js">	
</script>
<script type="text/javascript" src="./js/text/text-overflow.js">	
</script>
<style>
a {}
.categoryitems span {
	width: 160px;
}
</style>
<body leftFrame="true">
	<div id="scrollContent">
		<div class="arrowlistmenu">
			<div class="menuheader expandable">系统菜单</div>
			<ul class="categoryitems" id="category">		
<script type="text/javascript"> 
var html="";
			var power=${quanXian.power};
			var xqzj_qx=${quanXian.xuQiuZhengJi};
			var xqgl_qx=${quanXian.xuQiuGuanLi};
			var yhxx_qx=${quanXian.yongHuGuanLi};
			var yhxg_qx="1";
			var xssh_qx=${quanXian.xingShiShenHe};
			var bmsh_qx=${quanXian.buMenShenHe};
			var tjcx_qx=${quanXian.tongJiChaXun};
			<%//System.out.println(rs.getString("power"));%>
	if (power == 1) {
		html += "<li><a><span class='text_slice'>用户管理</span></a><ul>"
			    + "<li><a onclick='ccc()' href='../yonghuguanli.jsp' target='frmright'><span class='text_slice'>所有用户</span></a></li>"
				+ "<li><a onclick='ccc()' href='../jsgl.jsp' target='frmright'><span class='text_slice'>角色管理</span></a></li>"
				+ "<li><a href='../xinjuese.jsp' target='frmright'><span class='text_slice'>权限管理</span></a></li></ul><li>"
				
				+ "<li><a><span class='text_slice'>统计查询</span></a><ul>"
				+ "<li><a onclick='ccc()' href='../SynthesizeSearch.jsp' target='frmright'><span class='text_slice'>综合查询</span></a>"
				+ "<li><a onclick='ccc()' href='../templete/tongjitu.jsp' target='frmright'><span class='text_slice'>统计饼图</span></a></ul><li>"
				
				+ "<li><a onclick='ccc()' href='../xuqiuguanli.jsp' target='frmright'><span class='text_slice'>需求管理</span></a></li>"
				+ "<li><a onclick='ccc()' href='../xingshishenhe.jsp' target='frmright'><span class='text_slice'>形式审核</span></a></li>"
				+ "<li><a onclick='ccc()' href='../bumenshenhe.jsp' target='frmright'><span class='text_slice'>部门审核</span></a></li>"
				
				+ "<li><a href='../gaimi.jsp' target='frmright'><span class='text_slice'>修改密码</span></a></li>"
				html += "<li><a href='tianbao?username=<%=(String)session.getAttribute("user")%>' target='frmright'><span class='text_slice'>需求填报</span></a></li>";
				html += "<li><a><span class='text_slice'>关于系统</span></a><ul>";
				html += "<li><a href='../templete/xtjs.html' target='frmright'><span class='text_slice'>系统介绍</span></a></li>";
				html += "<li><a href='../templete/bzwj.html' target='frmright'><span class='text_slice'>帮助文件</span></a></li>";
				html += "<li><a href='../templete/cjwtjd.html' target='frmright'><span class='text_slice'>常见问题解答</span></a></li></ul><li>";			
				//$("#category").html(html);	
	}
	else{
	if (xqzj_qx == 1) {
			html += "<li><a href='tianbao?username=<%=(String)session.getAttribute("user")%>' target='frmright'><span class='text_slice'>需求填报</span></a></li>";
			/* html += "<li><a href='./jspPage/underMain/tianbao.jsp' target='frmright'><span class='text_slice'>需求填报</span></a></li>"; */
	}
	if (xqgl_qx == 1) {
			html += "<li><a href='xuqiuguanli?username=<%=(String)session.getAttribute("user")%>' target='frmright'><span class='text_slice'>需求管理</span></a></li>";
	}
	if (xssh_qx == 1) {
		html += "<li><a onclick='ccc()' href='shenhelist?state=1' target='frmright'><span class='text_slice'>形式审核</span></a></li>";
	}
	if (bmsh_qx == 1) {
		html += "<li><a onclick='ccc()' href='shenhelist?state=4' target='frmright'><span class='text_slice'>部门审核</span></a></li>";
	}
	if (yhxx_qx == 1&&yhxg_qx == 1) {
			html += "<li><a><span class='text_slice'>用户信息</span></a><ul>";
			html += "<li><a href='../updateABC.jsp' target='frmright'><span class='text_slice'>修改基础信息</span></a></li>";
			html += "<li><a href='../gaimi.jsp' target='frmright'><span class='text_slice'>修改密码</span></a></li></ul></li>";
	}
	if (yhxx_qx != 1&&yhxg_qx == 1) {
			html += "<li><a href='../gaimi.jsp' target='frmright'><span class='text_slice'>修改密码</span></a></li>";
	}
	if (tjcx_qx == 1) {
		html += "<li><a onclick='ccc()' href='../ClassfiySearch.jsp' target='frmright'><span class='text_slice'>分类检索</span></a>";
		html += "<li><a onclick='ccc()' href='./jspPage/tongJiChaXun/Zhjs.html' target='frmright'><span class='text_slice'>综合查询</span></a>";
		html += "<li><a onclick='ccc()' href='./jspPage/underMain/tongjitu.jsp' target='frmright'><span class='text_slice'>统计饼图</span></a></ul><li>";
	}
	html += "<li><a><span class='text_slice'>关于系统</span></a><ul>";
	html += "<li><a href='./jspPage/aboutSystem/xtjs.html' target='frmright'><span class='text_slice'>系统介绍</span></a></li>";
	html += "<li><a href='./jspPage/aboutSystem/bzwj.html' target='frmright'><span class='text_slice'>帮助文件</span></a></li>";
	html += "<li><a href='./jspPage/aboutSystem/cjwtjd.html' target='frmright'><span class='text_slice'>常见问题解答</span></a></li></ul><li>";
	}
	document.write(html);	
</script></ul>
</div>
</div>
</body>
</html>
