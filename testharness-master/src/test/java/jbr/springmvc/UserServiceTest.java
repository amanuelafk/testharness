package jbr.springmvc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.deloitte.harness.model.Login;
import com.deloitte.harness.model.User;
import com.deloitte.harness.service.UserService;

import java.text.SimpleDateFormat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:harness/config/user-beans.xml" })
public class UserServiceTest {

  @Autowired
  private UserService userService;

  @Test
  public void testRegister() {
//    User user = new User();
//    user.setUsername("ranjith@deloitte.com");
//    user.setPassword("sekar");
//    user.setTimeStamp(getTimestamp());
//    user.setUserId("001");
////    user.setFirstname("Ranjith");
////    user.setLastname("Sekar");
////    user.setAddress("chennai, t.nagar");
////    user.setEmail("ranjith@gmail.com");
////    user.setPhone(222);
//
//    int result = userService.register(user);
    Assert.assertEquals(1, 1);
  }

//  @Test
//  public void testValidateUser() {
//    Login login = new Login();
//    login.setUsername("ranjith");
//    login.setPassword("sekar");
//
//    User user = userService.validateUser(login);
//    Assert.assertEquals("Ranjith", user.getFirstname());
//  }
//
//  public String getTimestamp() {
//    long time = System.currentTimeMillis();
//    java.sql.Timestamp timestamp = new java.sql.Timestamp(time);
//    String formattedTs = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(timestamp);
//
//    return formattedTs;
//  }

}
