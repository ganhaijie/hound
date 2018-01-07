package com.ghj.hound.service.tul.impl;

import com.alibaba.fastjson.JSONObject;
import com.ghj.hound.common.model.ReturnModel;
import com.ghj.hound.common.util.HttpUtil;
import com.ghj.hound.entity.tul.TuLRequest;
import com.ghj.hound.entity.tul.TuLResponse;
import com.ghj.hound.service.tul.TulService;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TulServiceImpl implements TulService{

    @Override
    public ReturnModel<TuLResponse> potApi(String info) {
        String url="http://www.tuling123.com/openapi/api";
        String Key="XXXXXX";
        TuLRequest tulReq = new TuLRequest();
        tulReq.setKey(Key);
        tulReq.setInfo(info);
        tulReq.setUserid("hound");

        String json =JSONObject.toJSONString(tulReq);

        RequestBody requestBody = RequestBody.create(HttpUtil.MEDIA_TYPE_JSON, json);


        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url).post(requestBody)
                .build();


        ReturnModel<TuLResponse> r = new ReturnModel<>();


        try {
            Response response = okHttpClient.newCall(request).execute();

            String resp = response.body().string();
            TuLResponse tulResp= JSONObject.parseObject(resp,TuLResponse.class);

            r.setObj(tulResp);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return r;
    }
}
