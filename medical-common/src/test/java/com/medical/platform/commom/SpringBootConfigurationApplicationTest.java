package com.medical.platform.commom;


import com.medical.platform.utils.JwtTokenUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringBootConfigurationApplicationTest.class)
public class SpringBootConfigurationApplicationTest {

    @Test
    public  void  testToken()
    {
        System.out.println(JwtTokenUtil.getToken());
    }
}
