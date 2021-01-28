package com.deloitte.harness.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.deloitte.harness.dao.UserDao;
import com.deloitte.harness.model.Login;
import com.deloitte.harness.model.User;

public class UserServiceImpl implements UserService {

  @Autowired
  public UserDao userDao;

  public int register(User user) {
    return userDao.register(user);
  }

  public User validateUser(Login login) {
    return userDao.validateUser(login);
  }

}
