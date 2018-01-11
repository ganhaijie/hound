package com.ghj.hound.schedule;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Configurable
@EnableScheduling
public class CoinSchedule {
    private static final Logger logger = LogManager.getLogger(CoinSchedule.class);


    private static final List<String> markets = new ArrayList<String>() {{
        add("btc_usdt");
        add("bcc_usdt");
        add("ubtc_usdt");
        add("ltc_usdt");
        add("eth_usdt");
        add("etc_usdt");
        add("bts_usdt");
        add("eos_usdt");
        add("qtum_usdt");
        add("hsr_usdt");
        add("xrp_usdt");
        add("bcd_usdt");
        add("dash_usdt");
        add("sbtc_usdt");
        add("ink_usdt");
        add("tv_usdt");
        add("bcx_usdt");
        add("bth_usdt");
        add("lbtc_usdt");
        add("chat_usdt");
        add("hlc_usdt");
        add("bcw_usdt");
        add("btp_usdt");
        add("topc_usdt");
        add("bat_usdt");
        add("1st_usdt");
        add("safe_usdt");
        add("qun_usdt");
        add("btn_usdt");
    }};


    private static final String tickerUrl = "http://api.zb.com/data/v1/ticker";

    private static final String klineUrl = "http://api.zb.com/data/v1/kline";

    public void coinPatch() {


        for (String market : markets) {


            //请求一次行情



            //请求一次市场


            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
