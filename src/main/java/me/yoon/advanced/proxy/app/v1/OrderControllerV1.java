package me.yoon.advanced.proxy.app.v1;

import org.springframework.web.bind.annotation.*;

//@RequestMapping     //스프링 3.0 이하는 @Controller 또는 @RequestMapping 이 있어야 스프링 컨트롤러로 인식
//@ResponseBody
@RestController //스프링 3.0 이상은 @Controller, @RestController가 있어야 스프링 컨트롤러로 인식
public interface OrderControllerV1 {

    @GetMapping("/proxy/v1/request")
    String request(@RequestParam("itemId") String itemId);

    @GetMapping("/proxy/v1/no-log")
    String noLog();
}
