package com.liying.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.liying.dao.UserDao;
import com.liying.model.Guikoubumen;
import com.liying.model.User;

@Component("userDao")
public class UserDaoImpl implements UserDao
{
		
		private HibernateTemplate hibernateTemplate;
		public boolean save(User user) {
			// TODO Auto-generated method stub
			try
			{
				hibernateTemplate.save(user);
			} catch (DataAccessException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("注册失败！");
				return false;
			}
			return true;
		}

		public boolean checkUserExistsWithName(String username) {
			//System.out.println("这里是dao层！");
			try
			{
				List<User> users=  hibernateTemplate.find("from User u where u.username='"+username+"'");
				if(users!=null&&users.size()>0)
				{
					return true;
				}
			} catch (DataAccessException e)
			{
				// TODO Auto-generated catch block
				System.out.println("可能是数据库服务没开；"+e.getMessage());
			}
			return false;
		}
		public boolean checkUserByNamePass(User user) {
			//System.out.println(user.getUsername()+"+"+user.getPassword());
			List<User> users=  hibernateTemplate.find("from User u where u.username='"+user.getUsername()+"' and u.password='"+user.getPassword()+"'");
			if(users!=null&&users.size()>0)
			{
				return true;
			}
			return false;
		}


		public List<User> getUsers() {
			List<User> users=  hibernateTemplate.find("from User");
			return users;
		}

		public void deleteUserById(String username) {
			hibernateTemplate.delete(loadById(username));
		}

		public User loadById(String username) {
			User user=(User) hibernateTemplate.get(User.class, username);
			return user;
		}
		public void updateUser(User user) {
			hibernateTemplate.update(user);
		}
		public List<Guikoubumen> getGuikoubumens() {
			System.out.println("Dao");
			List<Guikoubumen> Guikoubumens=  hibernateTemplate.find("from Guikoubumen");
			return Guikoubumens;
		}
		public HibernateTemplate getHibernateTemplate() {
			return hibernateTemplate;
		}
		@Resource
		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}
}
