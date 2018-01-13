package com.ghj.hound.service.coin.impl;

import com.ghj.hound.common.model.ReturnModel;
import com.ghj.hound.common.set.CoinSet;
import com.ghj.hound.entity.coin.Coin;
import com.ghj.hound.entity.coin.CoinSimple;
import com.ghj.hound.entity.coin.TickerResp;
import com.ghj.hound.mapper.coin.CoinMapper;
import com.ghj.hound.service.coin.CoinDetaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CoinDetaiServiceImpl implements CoinDetaiService {


    @Autowired
    CoinMapper coinMapper;

    @Override
    public ReturnModel<List<CoinSimple>> getCoinInfo() {
        ReturnModel<List<CoinSimple>> returnModel = new ReturnModel<List<CoinSimple>>();

        List<Coin> coins = coinMapper.getCoins();

        List<CoinSimple> coinSimples = new ArrayList<CoinSimple>();

        for (Coin coin : coins) {
            CoinSimple c = new CoinSimple();
            c.setPlatform(coin.getBourse());
            c.setCoinType(coin.getCurrency());
            c.setPrice(100.11);
            c.setRange(19.9);
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
