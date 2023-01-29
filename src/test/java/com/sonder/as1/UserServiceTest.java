package com.sonder.as1;

import com.sonder.as1.repositories.UserRepository;
import com.sonder.as1.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @MockBean
    UserRepository userRepository;
    @Autowired private UserService userService;

    @Test
    public void findAllUser_test(){
        System.out.println(userService.getAll(1,1).getTotalPage());
    }


}
