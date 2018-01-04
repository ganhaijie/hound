package com.ghj.hound.api.ssr;

import com.ghj.hound.common.model.Message;
import com.ghj.hound.common.model.ResultModel;
import com.ghj.hound.service.ssr.SsrService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/ssr")
public class SsrController {

    @Resource
    SsrService ssrService;

    @RequestMapping(value="/getSsr",method = RequestMethod.GET)
    public Message getSsr(){
        ResultModel r=ssrService.getSsr();
        return r.toMessage();
    }

}
