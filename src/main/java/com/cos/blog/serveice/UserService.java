package com.cos.blog.serveice;


import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLOutput;

//스프링 컴포넌트 스캔을 통해 Bean에 등록을 해줌. Ioc 를 해줌
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional //회원가입전체가 트랜젝션으로 묶어줌
    public int 회원가입(User user) {
        try {
            userRepository.save(user);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UserSevice:회원가입():" + e.getMessage());
        }
        return -1;
    }

}
