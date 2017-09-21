

function deleteXuqiu(xuqiuNum)
{
	var con=confirm("确认删除吗?"); //在页面上弹出对话框
	if(con==false)return;
	$.ajax({ 
		 type:"POST",
			 url:"deleteXuqiu",
			 async:false,
			 dataType: "text",
			 scriptCharset:'UTF-8',
			 data:{"xuqiuNumer":xuqiuNum},
			 success:function(result)
				 { 
				 	if(result==1){
				 		alert("删除成功点击确认继续！");
				 		//window.location.href="tianbao";
				 	    location.reload();
				 	}
				 	else{
				 		alert("删除失败请重试！");
				 	}
			 } 
	}); 
}