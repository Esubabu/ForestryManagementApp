package com.cg.fms.service;

import org.springframework.stereotype.Service;

import com.cg.fms.dto.User;

@Service
public interface UserService {
	public boolean login(String username,String password);
	public String logout(User user);
	public boolean addUser(User user);
	public boolean removeUser(User user);

}