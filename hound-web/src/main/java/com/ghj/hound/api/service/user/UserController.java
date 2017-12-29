package com.ghj.hound.api.service.user;

import com.ghj.hound.entity.demo.Demo;
import com.ghj.hound.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/*")
public class UserController {

    @Autowired
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