package com.cos.blog.test;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jnlp.UnavailableServiceException;
import java.nio.channels.IllegalSelectorException;
import java.util.List;
import java.util.function.Supplier;

@RestController
public class DummyControllerTest {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("dummy/users")
    public List<User> list(){
        return userRepository.findAll();
    }
    //한페이지당 2건의 데이터를 리턴받아 볼 예정
    @GetMapping("dummy/user")
    public List<User> pageList(
            @PageableDefault(size=2,sort = "id",direction= Sort.Direction.DESC) Pageable pageable){
      Page<User> pagingUser =  userRepository.findAll(pageable); //,getContent 를 쓰면 밑에 쓰잘때기없는것들을 없애줌
        List<User> users = pagingUser.getContent();
    return users;
    }

    //{id}주소로 파라메터를 전달 받을 수 있음
    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id){ // 타입을 인트로 적으면 정수로 받아짐,
                                              // id그래도 적어야 맵핑에꺼가 쏙 들어옴
        //user/4를 찾으면 데이터베이스에서 못찾으니 null 이되니 리턴도 null 이 돼 문제가 생길수있으니
        // Optional로 User 객체를 감싸서 가져올테니 null 인지 아닌지 판단해서 리턴해!
        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalSelectorException>() {
                                                          //()-> 람다식
            @Override
            public IllegalSelectorException get(){ //잘못된 인수가 들어왔을때 일리걸익섹션을 리턴해줌

                return new IllegalSelectorException();


            }
    }); //findById 아이디 값만 가져오는거


        return user;

    }

    @PostMapping("/dummy/join")
    public String join(User user){
        System.out.println("ID"+user.getId());
        System.out.println("username"+ user.getUsername());
        System.out.println("password"+user.getPassword());
        System.out.println("email"+user.getEmail());
        System.out.println("role"+user.getRole());
        System.out.println("createDate"+user.getCreateDate());

        user.setRole(RoleType.USER);
        userRepository.save(user);
return "회원가입이 완료 되었습니다.";
    }
}
