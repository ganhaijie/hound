package com.ghj.hound.api.user;

import com.ghj.hound.entity.demo.Demo;
import com.ghj.hound.service.user.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user/*")
public class UserController {

    @Resource
    UserService userService;

   @RequestMapping(value = "list",method = RequestMethod.GET)
    public List<Demo> list() {
        try {
            return userService.getUser();
        } catch (Exception e) {
            return null;
        }

    }

}