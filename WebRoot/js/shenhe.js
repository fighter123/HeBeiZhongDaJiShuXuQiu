

jQuery(function($){	
	$('.buttonblue').click(function ()
		{	
			var state=document.getElementById('state').value;
			var reason="";
			var xuQiuNum=document.getElementById('xuQiuNum').value;
			var p = $(this).attr('value');		
			if(p=="通过")
				{
					if(state=="1")//已提交
						{
							state="4";//形式审核通过
						}
					else
						{
							state="6";//技术审核通过
						}
					
				}
			else
			{
				if(state=="1")//已提交
				{
					state="3";//形式审核未通过
				}
				else
				{
					state="7";//技术审核未通过
				}
				var str=prompt("请输入不通过原因：","");
				//alert(str);
				if(!str)
					{
						//alert("呵呵");
						return;
					}
				else 
					{
						reason=str;
						//alert(reason);
					}
			}
			$.ajax({ 
				 type:"POST",
					 url:"shenHe",
					 async:false,
					 dataType: "text",
					 scriptCharset:'UTF-8',
					 data:{"xuQiuNum":xuQiuNum,"state":state,"reason":reason},
					 success:function(result)
						 { 
						 	if(result==1){
						 		alert("操作成功点击确认继续审核！");
						 		self.location=document.referrer;
						 	    //location.reload();
						 	}
						 	else{
						 		alert("操作失败，请重试！");
						 	}
					 } 
			}); 
		});
});