package com.project.springBoot;

import java.text.DateFormat;
import java.util.Date;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



import com.project.springBoot.entity.User;
import com.project.springBoot.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTests {
	
	@Autowired
    private UserRepository userRepository;
    
    @Test
    public void test() throws Exception{
    	Date date = new Date();
    	DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
    	String formattedDate = dateFormat.format(date);

    	userRepository.save(new User("aa1", "aa123456" , "aa@126.com", "aa", formattedDate));
    	userRepository.save(new User("bb2", "bb123456", "bb@126.com", "bb", formattedDate));
        userRepository.save(new User("cc3", "cc123456", "cc@126.com", "cc",formattedDate));
        
        System.out.println("长度：" + userRepository.findAll().size());
        System.out.println("NickName:" + userRepository.findByUserNameOrEmail("cc3", "cc123456").getNickName());
        userRepository.delete(userRepository.findByUserName("aa1"));
    	
    }
}
