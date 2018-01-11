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


    private static final List<String> markets = new ArrayList<String>(){{
       add("");
    }};


    public void coinPatch(){
        while (true){
            System.out.println(11);
            logger.info(222);
        }
    }
}
