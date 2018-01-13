package com.ghj.hound.service.coin.impl;

import com.ghj.hound.common.model.ReturnModel;
import com.ghj.hound.common.set.CoinSet;
import com.ghj.hound.entity.coin.Coin;
import com.ghj.hound.entity.coin.CoinSimple;
import com.ghj.hound.entity.coin.TickerResp;
import com.ghj.hound.mapper.coin.CoinMapper;
import com.ghj.hound.service.coin.CoinDetaiService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Service
public class CoinDetaiServiceImpl implements CoinDetaiService {


    private static final Logger logger = LogManager.getLogger(CoinDetaiServiceImpl.class);

    @Autowired
    CoinMapper coinMapper;

    @Override
    public ReturnModel<List<CoinSimple>> getCoinInfo() {
        ReturnModel<List<CoinSimple>> returnModel = new ReturnModel<List<CoinSimple>>();

        List<CoinSimple> coinSimples = new ArrayList<CoinSimple>();

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateLast=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateLast);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date dateBefore  = calendar.getTime();

        System.out.println(dateLast);
        System.out.println(dateBefore);

        for (String market:CoinSet.markets){
            String currency = market;

            List<Coin> coinsLast=coinMapper.getLast(currency,dateLast);
            List<Coin> coinsBefore=coinMapper.getBefore(currency,dateBefore);

            if(coinsLast.size()!=1 || coinsBefore.size()!=1){
                logger.info("异常");
            }

            CoinSimple c = new CoinSimple();
            c.setPlatform(CoinSet.ZB);

            String[] C=currency.split("_");

            c.setCoinType(C[0].toUpperCase());
            c.setPrice(coinsLast.get(0).getPrice());

            Double range =(coinsLast.get(0).getPrice()-coinsBefore.get(0).getPrice())/coinsBefore.get(0).getPrice();
            c.setRange(range*100);
            coinSimples.add(c);
        }

        returnModel.setObj(coinSimples);

        return returnModel;
    }

    @Override
    public ReturnModel<String> insert(String currency, Date date,TickerResp tickerResp) {
        ReturnModel<String> returnModel = new ReturnModel<String>();

        Coin coin = new Coin();

        coin.setBourse(CoinSet.ZB);
        coin.setCurrency(currency);
        coin.setCreateTime(date);
        coin.setPrice(tickerResp.getTicker().getLast());

        coinMapper.insertCoin(coin);

        returnModel.setObj("success");
        return returnModel;
    }
}
