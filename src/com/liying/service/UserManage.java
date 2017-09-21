package com.liying.service;

import java.util.List;

import com.liying.model.Guikoubumen;
import com.liying.model.User;

public interface UserManage
{
	public boolean addUser(User user);
	public boolean exists(User user);
	public boolean logincheck(User user);
	public User loadUser(String username);
	public List<User> listUsers();
	public void deleteUser(int id);
	public void updateUser(User user);
	public List<Guikoubumen> listGuikoubumens();
}
