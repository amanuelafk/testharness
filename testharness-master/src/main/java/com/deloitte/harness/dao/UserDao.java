package com.deloitte.harness.dao;

import com.deloitte.harness.model.Login;
import com.deloitte.harness.model.User;

public interface UserDao {

  int register(User user);

  User validateUser(Login login);
}
