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
import org.springframework.web.bind.annotation.*;

import javax.jnlp.UnavailableServiceException;
import javax.transaction.Transactional;
import java.nio.channels.IllegalSelectorException;
import java.util.List;
import java.util.function.Supplier;

@RestController
public class DummyControllerTest {

    @Autowired
    private UserRepository userRepository;


    @DeleteMapping("/dummy/user/{id}")
    public String delete(@PathVariable int id){
        try{
        userRepository.deleteById(id);
        }catch (Exception e){  //EmptyResultDataAccessException 이 Exception의 자식오류
            return "삭제에 실패하였습니다. 해당아이디는 DB에 없습니다.";
        }
        return "삭제되었습니다. id" + id;
    }

    //save함수는 id를 전달하지 않으면 insert를 해주고
    //          id를 전달하면 해당 id에 대한 데이터가 있으면 update를 해줌
    @Transactional //@Transactional 이라는 어노테이션의 역할은 "함수 종료 시에 자동 commit 해줌"
    @PutMapping("/dummy/user/{id}")
    public User updateUser(@PathVariable int id,@RequestBody User requestUser){

        System.out.println("id : " + id);
        System.out.println("password : " + requestUser.getPassword());
        System.out.println("email : "+ requestUser.getEmail());
        //  user는 실제 데이터베이스에서 받은 유저 , 지금  user안에는 널이 없음
        User user = userRepository.findById(id).orElseThrow(()->{ //아이디를 찾아서 하는데 만약 실패하면 ElseThrow
           return new IllegalArgumentException("수정에 실패하였습니다.");
        });
        user.setPassword(requestUser.getPassword()); //꽉찬 suer에 변경된 비밀번호
        user.setEmail(requestUser.getEmail());


//        userRepository.save(user);


        //더티체킹  @Transactional(트랜젝션)을 걸면 .save를 하지 않아도 업데이트가 됨
        return user;
    }

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
        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
                                                          //()-> 람다식
            @Override
            public IllegalArgumentException get(){ //잘못된 인수가 들어왔을때 일리걸익섹션을 리턴해줌

                return new IllegalArgumentException(" 맞지않습니다."+id);


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
