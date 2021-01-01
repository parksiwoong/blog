package com.cos.blog.repository;

import com.cos.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//DAO, 자동으로 빈등록
//@Repository 생략가능
public interface UserRepository extends JpaRepository<User, Integer> { //JpaRepository 안에 findAll();
                                                                        // 이라는함수는 유저테이블이 들고있는 모든 행을 리턴하라

//JPA Naming 전략
    // SELETC* FROM user WHERE username = ? AND password= ?;
   User findByUsernameAndPassword(String username, String password);

    //네이티브 쿼리
//    @Query(value = "SELECT * FROM user WHERE username = ? AND password= ?", nativeQuery = true )
//    User login(String username, String password);
}
