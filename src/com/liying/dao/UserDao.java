package com.liying.dao;

import java.util.List;

import com.liying.model.Guikoubumen;
import com.liying.model.User;


public interface UserDao {
	public boolean save(User user);
	public boolean checkUserExistsWithName(String username);
	public boolean checkUserByNamePass(User user);
	public List<User> getUsers();
	public User loadById(String username);
	public void deleteUserById(String username);
	public void updateUser(User user);
	public List<Guikoubumen> getGuikoubumens();
}
