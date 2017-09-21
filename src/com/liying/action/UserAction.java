package com.liying.action;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.liying.model.Guikoubumen;
import com.liying.model.User;
import com.liying.service.UserManage;
import com.opensymphony.xwork2.ActionSupport;

@Component("userAction")		//将UserAction交给spring管理并命名为userAction
@Scope("prototype")				//每接收到一个请求创建一个action对象
public class UserAction extends ActionSupport
{
	//变量***********************************************************************
	private String userName;    			//用户名(登录注册)
	private String passWord;				//密码    (登录注册)
	private String randCode;				//验证码(登录)
	private String realname;				//用户真实姓名(注册)
	private String IDcard;					//用户身份证号(注册)
	private String jgname;					//机构全称(注册)
	private String gkbm;					//归口管理部门(注册)
	private String adress;					//通信地址(注册)
	private String email;					//邮箱(注册)
	private String call;					//固定电话(注册)
	private String phone;					//手机(注册)
	private String web;						//单位网址(注册)
	private String fax;						//传真(注册)
	private String jianjie;					//机构简介(注册)
	private List<Guikoubumen> guikoubumens = new ArrayList<Guikoubumen>();; //归口部门集guikoubumens
	
	private UserManage userManage;  //注入userManage（记得在set方法上添加@resource）
	private User user;				//user对象
	
	//flag返回给客户端
	 String flag="";				//返回用户登录状态码
	 String flag2="";				//返回用户名是否存在（注册时）
	 String flag3="";				//返回用户注册是否成功
	 
	 HttpServletRequest request=ServletActionContext.getRequest();//获得session
     HttpSession session=request.getSession();          
     String trueRand = (String) session.getAttribute("rand");


     //String rd=(String)session.getAttribute("rand");  

	//登录***********************************************************************
	public String login() throws IOException
	{	
        user = new User();
		user.setUsername(userName);
		user.setPassword(passWord);
		System.out.println(user.getUsername()+";"+user.getPassword());
		System.out.println(trueRand);
		
		if(randCode.equals(trueRand))
		{
			if(userManage.exists(user))
			{
				if(userManage.logincheck(user))
				{
					ServletActionContext.getRequest().getSession().setAttribute("user", userName);//设置session
					flag="1";
				}
				else
				{
					flag="4";
				}
			}
			else
			{			
				flag="3";
			}
		}
		else 
		{
			flag="2";
		}
		return "success";
		
	}
	
	//注册信息（得到注册页面的下拉列表值）*******************************************************
	public String registerInfo()
	{		
		this.guikoubumens =userManage.listGuikoubumens();
		return "success";
	}
	//判断用户名是否已经存在（注册时用到）*******************************************************
	public String userNameExist()
	{
		//System.out.println(userName);
		user = new User();
		user.setUsername(userName);
		if(userManage.exists(user))
		{
			flag2="1";
		}
		else
		{
			flag2="0";
		}
		//System.out.println(flag2);
		return "success";
	}
	//用户注册（将用户填写的注册信息添加到数据库）***************************************************
	public String register()
	{
		//System.out.println(realname);
		user = new User();
		user.setUsername(userName);
		user.setPassword(passWord);
		user.setRealname(realname);
		user.setIdcard(IDcard);
		user.setCompnyname(jgname);
		user.setBelongapartment(gkbm);
		user.setAdress(adress);
		user.setEmail(email);
		user.setTell(call);
		user.setPhone(phone);
		user.setWeb(web);
		user.setFax(fax);
		user.setAbout(jianjie);
		//System.out.println(user.getRealname());
		if(userManage.addUser(user))
		{
			flag3="1";
		}
		return "success";
	}
	
	public String getFlag3()
	{
		return flag3;
	}

	public void setFlag3(String flag3)
	{
		this.flag3 = flag3;
	}

	//set和get******************************************************************
	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return passWord;
	}

	public void setPassword(String password)
	{
		this.passWord = password;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public String getPassWord()
	{
		return passWord;
	}

	public void setPassWord(String passWord)
	{
		this.passWord = passWord;
	}
	
	public UserManage getUserManage()
	{
		return userManage;
	}
	
	@Resource
	public void setUserManage(UserManage userManage)
	{
		this.userManage = userManage;
	}
	public String getFlag()
	{
		return flag;
	}

	public void setFlag(String flag)
	{
		this.flag = flag;
	}
	public String getRandCode()
	{
		return randCode;
	}

	public void setRandCode(String randCode)
	{
		this.randCode = randCode;
	}

	public List<Guikoubumen> getGuikoubumens()
	{
		return guikoubumens;
	}

	public void setGuikoubumens(List<Guikoubumen> guikoubumens)
	{
		this.guikoubumens = guikoubumens;
	}

	public String getRealname()
	{
		return realname;
	}

	public void setRealname(String realname)
	{
		this.realname = realname;
	}

	public String getIDcard()
	{
		return IDcard;
	}

	public void setIDcard(String iDcard)
	{
		IDcard = iDcard;
	}

	public String getJgname()
	{
		return jgname;
	}

	public void setJgname(String jgname)
	{
		this.jgname = jgname;
	}

	public String getFlag2()
	{
		return flag2;
	}

	public void setFlag2(String flag2)
	{
		this.flag2 = flag2;
	}

	public String getGkbm()
	{
		return gkbm;
	}

	public void setGkbm(String gkbm)
	{
		this.gkbm = gkbm;
	}

	public String getAdress()
	{
		return adress;
	}

	public void setAdress(String adress)
	{
		this.adress = adress;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getCall()
	{
		return call;
	}

	public void setCall(String call)
	{
		this.call = call;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getWeb()
	{
		return web;
	}

	public void setWeb(String web)
	{
		this.web = web;
	}

	public String getFax()
	{
		return fax;
	}

	public void setFax(String fax)
	{
		this.fax = fax;
	}

	public String getJianjie()
	{
		return jianjie;
	}

	public void setJianjie(String jianjie)
	{
		this.jianjie = jianjie;
	}

		
}
