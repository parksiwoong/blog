package com.cos.blog.test;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test/hello")
    public String hello(){
        System.out.println();
        return "<h1>hello spring boot</h1>";
    }


}
