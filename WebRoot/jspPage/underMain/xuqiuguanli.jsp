<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.sql.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>需求管理</title>
<link href="css/minestyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.7.js"></script>

<script type="text/javascript">

function dianji() {
	 
	  var flag = document.getElementById("all").checked;
	 
	  //alert(flag)
	 
	  var cks = document.getElementsByName("ck");
	 
	  if (flag) {
	 
	   for ( var i = 0; i < cks.length; i++) {
	 
	    cks[i].checked = true;
	 
	   }
	 
	  } else {
	 
	   for ( var i = 0; i < cks.length; i++) {
	 
	    cks[i].checked = false;
	 
	   }
	 
	  }
	 
	 }
</script>


</head>


<body>
<%-- <s:debug></s:debug> --%>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="huanying.jsp" target="frmright">首页</a></li>
    <li><a href="#">系统菜单</a></li>
    <li><a href="#">需求管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li><a href="tianbao?username=<%=(String)session.getAttribute("user")%>" target="frmright"><span><img src="images/t01.png" /></span>添加</a></li>
        <li ><span><img src="images/t02.png" /></span>修改</li>
        <li><span><img src="images/t03.png" /></span>删除</li>
        <li><a href='tongjitu.jsp' target='frmright'><span><img src="images/t04.png" /></span>统计</a></li>
        </ul>
        
        
        <ul class="toolbar1">
        <li><span><img src="images/t05.png" /></span>设置</li>
        </ul>
    
    </div>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" id="all" value="" onchange="dianji()"/>&nbsp;全选</th>
        <th>需求编号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>需求名称</th>
        <th>提交时间</th>
        <th>需求状态</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody  id="table2">
        	<s:iterator value="xuQius">
        		<tr>
        			<td>
        			<input type="checkbox" name="ck" value="" />
        			</td>
        			<td>
					<s:property value="xuQiuNum"/>
					</td>
					<td>
					<s:property value="xuQiuName"/>
					</td>
					<td>
					<s:property value="xuQiuNum.substring(0, 4)+'年'+xuQiuNum.substring(4, 6)+'月'+xuQiuNum.substring(6, 8)+'日'"/>
					</td>
					<td>
					<%-- <s:property value="state"/> --%>
					<s:if test="state==1">
						等待形式审核！
					</s:if>
					<s:elseif test="state==2">
						形式审核中！
					</s:elseif>
					<s:elseif test="state==3">
						形式审核不通过！
					</s:elseif>
					<s:elseif test="state==4">
						形式审核通过等待技术审核！
					</s:elseif>
					<s:elseif test="state==5">
						技术审核中！
					</s:elseif>
					<s:elseif test="state==6">
						技术审核通过！
					</s:elseif>
					<s:elseif test="state==7">
						形式审核通过但技术审核未通过！
					</s:elseif>
					<s:else>
						未提交！
					</s:else>
					</td>
					<td>
					<a href='lookMyXuqiuJsp?xuqiuNumer=<s:property value="xuQiuNum"/>'class="tablelink">查看</a>&nbsp;&nbsp;
					<s:if test="state<2">
					<a href='#' class="tablelink" onclick="deleteXuqiu(<s:property value="xuQiuNum"/>)">删除</a>&nbsp;&nbsp;
					</s:if>
					<s:if test="state==0">
					<a href='editMyXuqiuJsp?xuqiuNumer=<s:property value="xuQiuNum"/>' class="tablelink">编辑</a>
					</s:if>
					</td>
				</tr>
			</s:iterator>
        </tbody>
    </table>
    
   
   <div class="pagin">
    <br>&nbsp;&nbsp;
    <span id="spanFirst" style="display:inline;">第一页</span> &nbsp;&nbsp;
    <span style="display:inline;" id="spanPre" >上一页</span> &nbsp;&nbsp;
    <span style="display:inline;" id="spanNext">下一页</span>&nbsp;&nbsp;
    <span style="display:inline;" id="spanLast">最后一页</span>&nbsp;&nbsp; 第
    <span style="display:inline;" id="spanPageNum"></span>页/共<span style="display:inline;" id="spanTotalPage"></span>页
    </div>
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
 <script type="text/javascript" src="js/xuqiuguanli.js"></script>   
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script> 
</body>
</html>
<script>
     var theTable = document.getElementById("table2");
     var totalPage = document.getElementById("spanTotalPage");
     var pageNum = document.getElementById("spanPageNum");


     var spanPre = document.getElementById("spanPre");
     var spanNext = document.getElementById("spanNext");
     var spanFirst = document.getElementById("spanFirst");
     var spanLast = document.getElementById("spanLast");


     var numberRowsInTable = theTable.rows.length;
     var pageSize = 8;
     var page = 1;


     //下一页
     function next() {


         hideTable();


         currentRow = pageSize * page;
         maxRow = currentRow + pageSize;
         if (maxRow > numberRowsInTable) maxRow = numberRowsInTable;
         for (var i = currentRow; i < maxRow; i++) {
             theTable.rows[i].style.display = '';
         }
         page++;


         if (maxRow == numberRowsInTable) { nextText(); lastText(); }
         showPage();
         preLink();
         firstLink();
     }


     //上一页
     function pre() {


         hideTable();


         page--;


         currentRow = pageSize * page;
         maxRow = currentRow - pageSize;
         if (currentRow > numberRowsInTable) currentRow = numberRowsInTable;
         for (var i = maxRow; i < currentRow; i++) {
             theTable.rows[i].style.display = '';
         }




         if (maxRow == 0) { preText(); firstText(); }
         showPage();
         nextLink();
         lastLink();
     }


     //第一页
     function first() {
         hideTable();
         page = 1;
         for (var i = 0; i < pageSize; i++) {
             theTable.rows[i].style.display = '';
         }
         showPage();

		 firstText();	
         preText();
         nextLink();
         lastLink();
     }


     //最后一页
     function last() {
         hideTable();
         page = pageCount();
         currentRow = pageSize * (page - 1);
         for (var i = currentRow; i < numberRowsInTable; i++) {
             theTable.rows[i].style.display = '';
         }
         showPage();


         preLink();
         nextText();
         firstLink();
         lastText();
     }


     function hideTable() {
         for (var i = 0; i < numberRowsInTable; i++) {
             theTable.rows[i].style.display = 'none';
         }
     }


     function showPage() {
         pageNum.innerHTML = page;
     }


     //总共页数
     function pageCount() {
         var count = 0;
         if (numberRowsInTable % pageSize != 0) count = 1;
         return parseInt(numberRowsInTable / pageSize) + count;
     }


     //显示链接
     function preLink() { spanPre.innerHTML = "<a href='javascript:pre();'><font color=blue>上一页</font></a>"; }
     function preText() { spanPre.innerHTML = "上一页"; }


     function nextLink() { spanNext.innerHTML = "<a href='javascript:next();'><font color=blue>下一页</font></a>"; }
     function nextText() { spanNext.innerHTML = "下一页"; }


     function firstLink() { spanFirst.innerHTML = "<a href='javascript:first();'><font color=blue>第一页</font></a>"; }
     function firstText() { spanFirst.innerHTML = "第一页"; }


     function lastLink() { spanLast.innerHTML = "<a href='javascript:last();'><font color=blue>最后一页</font></a>"; }
     function lastText() { spanLast.innerHTML = "最后一页"; }


     //隐藏表格
     function hide() {
         for (var i = pageSize; i < numberRowsInTable; i++) {
             theTable.rows[i].style.display = 'none';
         }


         totalPage.innerHTML = pageCount();
         pageNum.innerHTML = '1';

		 if(pageCount()>1)
		 {
		 	nextLink();
         	lastLink();
		 }
     }


     hide();
</script>

