package com.deloitte.harness.service;

import com.deloitte.harness.model.Login;
import com.deloitte.harness.model.User;

public interface UserService {

  int register(User user);

  User validateUser(Login login);
}
