package com.ghj.hound.service.ssr.impl;

import com.alibaba.fastjson.JSONObject;
import com.ghj.hound.common.model.ReturnModel;
import com.ghj.hound.common.util.JSONUtil;
import com.ghj.hound.entity.ssr.SSR;
import com.ghj.hound.service.ssr.SsrService;
import org.springframework.stereotype.Service;


@Service
public class SsrServiceImpl implements SsrService {

    @Override
    public  ReturnModel<SSR>  getSsr() {
        String context = JSONUtil.ReadFile("D:\\ghj\\config.json");
        System.out.println(context);

        SSR ssr=JSONObject.parseObject(context, SSR.class);

        ReturnModel<SSR> returnModel=new ReturnModel<SSR>();
        returnModel.setObj(ssr);
        return returnModel;
    }

    @Override
    public ReturnModel<String> updateSsr() {
        return null;
    }

}
