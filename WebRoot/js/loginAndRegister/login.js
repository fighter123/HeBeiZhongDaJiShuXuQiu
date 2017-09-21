/**
 * 
 */
	function IMG1_onclick2() {
		user = document.getElementById("username");
		var pwd = document.getElementById("userpassword");
		var randcode = document.getElementById("randcode");
		if (user.value == "") {
			alert("用户名不能为空");
			user.focus(); 
		}
		else if (user.value.length > 20 || user.value.length < 6) {
			alert("用户名小于6位或大于20位");
			user.focus();
		}
		else if (pwd.value == "") {
			alert("密码不能为空");
			pwd.focus(); 
			
		} 
		 else if (pwd.value.length > 20 || pwd.value.length < 6) {
				alert("密码小于6位或大于20位");
				pwd.focus(); 

		}
		 else if (randcode.value == "") {
			alert("验证码不能为空");
			randcode.focus();
			
		}  else if (!isNum(randcode.value)) {
				alert("验证码只能由数字组成!");
				randcode.value = "";
		} else if (CheckCode(user.value) && CheckCode(pwd.value)
					&& CheckCode(randcode.value)) {
				alert("有特殊字符请重新填写！");
				user.value = "";
				pwd.value = "";
				randcode.value = "";
		}else {
			var pwd = hex_md5(pwd.value);
			//alert(pwd);
			$.ajax({ 
	 			 type:"POST",
	   			 url:"loginAction",
	   			 async:false,
	   			 dataType: "text",
	   			 scriptCharset:'UTF-8',
	   			 data:{"userName":user.value,"passWord":pwd,"randCode":escape(randcode.value)},
	   			 success:function(result)
	   				 { 
	    				 //$("#box").text(result);
	   				 	 result=result.substring(1,result.length-1);
	   				 	 //alert(result);
	   				 	 if(result=="1")
	   				 	 {
	   				 		window.location.href="main.jsp";	
	   				 	 }
	   				 	 else if(result=="2")
	   				 	 {
	   				 		alert("验证码错误！"); 
	   				 		randcode.value = "";
	   				 	 } 
	   				 	 else if(result=="3")
	   				 	 {
	   				 		alert("该用户不存在！"); 
	   				 		user.value = "";
	   				 	 }
	   				 	else
	   				 	 {
	   				 		alert("密码错误！"); 
	   				 		pwd.value = "";
	   				 	 }
	    			 } 
				}); 
		}	
	}
	
	function CheckCode(s) //有特殊字符为true  
	{
		var containSpecial = RegExp(/[(\ )(\~)(\!)(\#)(\$)(\%)(\^)(\&)(\*)(\()(\))(\-)(\_)(\+)(\=)(\[)(\])(\{)(\})(\|)(\\)(\;)(\:)(\')(\")(\,)(\.)(\/)(\<)(\>)(\?)(\)]+/);
		return (containSpecial.test(s));
	}
	function isNum(str){
		for (ilen = 0; ilen < str.length; ilen++) {
                if (str.charAt(ilen) < '0' || str.charAt(ilen) > '9') {
                       return false;
                    }
                }
            return true;
	}
	function test()
	{
		alert("如果丢失密码，请与0311-85813216电话联系！");
		}
