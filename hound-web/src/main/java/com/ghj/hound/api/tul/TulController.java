package com.ghj.hound.api.tul;

import com.alibaba.fastjson.JSONObject;
import com.ghj.hound.api.tul.vo.Info;
import com.ghj.hound.common.model.Message;
import com.ghj.hound.common.model.ResultModel;
import com.ghj.hound.service.tul.TulService;
import okhttp3.OkHttpClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@RequestMapping("/tul/**")
public class TulController {


    @Resource
    TulService tulService;

    @RequestMapping(value = "postAPI",method = RequestMethod.POST)
    public Message postAPI(@RequestBody Info info){

        ResultModel r =tulService.potApi(info.value);
        return r.toMessage();
    }

}
