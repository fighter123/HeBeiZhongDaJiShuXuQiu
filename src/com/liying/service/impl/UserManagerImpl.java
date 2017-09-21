package com.liying.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.liying.dao.UserDao;
import com.liying.model.Guikoubumen;
import com.liying.model.User;
import com.liying.service.UserManage;

@Component("userManage")
public class UserManagerImpl implements UserManage
{

	private UserDao userDao;
	@Override
	public boolean addUser(User user)
	{
		// TODO Auto-generated method stub
		return userDao.save(user);
	}

	@Override
	public boolean exists(User user)
	{
		//System.out.println("这里是service层！");
		return userDao.checkUserExistsWithName(user.getUsername());
	}

	@Override
	public boolean logincheck(User user)
	{
		return userDao.checkUserByNamePass(user);
		//return true;
	}

	@Override
	public User loadUser(String username)
	{
		// TODO Auto-generated method stub
		return userDao.loadById(username);
	}

	@Override
	public List<User> listUsers()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(int id)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(User user)
	{
		// TODO Auto-generated method stub

	}
	
	@Override
	public List<Guikoubumen> listGuikoubumens()
	{
		System.out.println("service");
		return userDao.getGuikoubumens();
	}

	public UserDao getUserDao()
	{
		return userDao;
	}

	@Resource
	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}



}
