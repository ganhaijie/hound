package com.ghj.hound.schedule;

import com.alibaba.fastjson.JSON;
import com.ghj.hound.common.coin.EncryDigestUtil;
import com.ghj.hound.common.coin.HttpUtilManager;
import com.ghj.hound.common.coin.MapSort;
import com.ghj.hound.common.set.CoinSet;
import com.ghj.hound.entity.coin.TickerResp;
import com.ghj.hound.service.coin.CoinDetaiService;
import org.apache.http.HttpException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
@Configurable
@EnableScheduling
public class CoinSchedule {
    private static final Logger logger = LogManager.getLogger(CoinSchedule.class);

    public final String ACCESS_KEY = "";
    public final String SECRET_KEY = "";

    private static final String API_DOMAIN = "http://api.zb.com";

    @Autowired
    private  CoinDetaiService coinDetaiService;

    public  void coinPatch() {
        System.out.println("start");
        Date date = new Date();
        for (String market : CoinSet.markets) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //请求一次行情
            try {
                String currency = market;
                // 请求地址
                String url = API_DOMAIN + "/data/v1/ticker?market=" + currency;
                // 请求测试
                String callback = get(url, "UTF-8");

                TickerResp tickerResp= JSON.parseObject(callback,TickerResp.class);
                coinDetaiService.insert(currency,date,tickerResp);
            } catch (Exception ex) {
                ex.printStackTrace();
            }


            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

/*

    */
/**
     * 获取json内容(统一加密)
     *
     * @param params
     * @return
     *//*

    private String getJsonPost(Map<String, String> params) {
        params.put("accesskey", ACCESS_KEY);// 这个需要加入签名,放前面
        String digest = EncryDigestUtil.digest(SECRET_KEY);

        String sign = EncryDigestUtil.hmacSign(MapSort.toStringMap(params), digest); // 参数执行加密
        String method = params.get("method");

        // 加入验证
        params.put("sign", sign);
        params.put("reqTime", System.currentTimeMillis() + "");
        String url = "请求地址:" + URL_PREFIX + method + " 参数:" + params;
        System.out.println(url);
        String json = "";
        try {
            json = HttpUtilManager.getInstance().requestHttpPost(URL_PREFIX, method, params);
        } catch (HttpException | IOException e) {
            logger.error("获取交易json异常", e);
        }
        return json;
    }
*/


    /**
     *
     * @param urlAll
     *            :请求接口
     * @param charset
     *            :字符编码
     * @return 返回json结果
     */
    private static  String get(String urlAll, String charset) {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";// 模拟浏览器
        try {
            URL url = new URL(urlAll);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(30000);
            connection.setConnectTimeout(30000);
            connection.setRequestProperty("User-agent", userAgent);
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, charset));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
