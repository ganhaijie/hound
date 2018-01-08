package com.ghj.hound.api.coin;

import com.ghj.hound.common.model.Message;
import com.ghj.hound.common.model.ResultModel;
import com.ghj.hound.service.coin.CoinDetaiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/coin/*")
public class CoinDetailController {


    @Resource
    CoinDetaiService coinDetaiService;

    @RequestMapping(value = "v1/getCoinInfo",method = RequestMethod.GET)
    public Message getCoinInfo(){
        ResultModel r=coinDetaiService.getCoinInfo();
        return r.toMessage();
    }

}
