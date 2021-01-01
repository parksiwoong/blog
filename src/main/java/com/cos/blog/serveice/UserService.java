package com.cos.blog.serveice;


import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLOutput;

//스프링 컴포넌트 스캔을 통해 Bean에 등록을 해줌. Ioc 를 해줌
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional //회원가입전체가 트랜젝션으로 묶어줌 //트렌젝션 뜻 : 일이 처리되기 위한 가장 작은 단위
    public void 회원가입(User user) {
        userRepository.save(user);
    }
    @Transactional(readOnly = true) //select만 할거면 트랜젝션이 필요없음,//select할때 트랜잭션 시작, 서비스종료시에 트랜잭셩 종료(정합성)
    public User 로그인(User user) {
      return userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());

    }
}
