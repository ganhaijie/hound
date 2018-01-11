package com.ghj.hound.api.wechat;

import com.ghj.hound.entity.demo.Demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wechat/*")
public class WeChatController {

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public List<Demo> test() {
        return null;

    }

}
