package com.ghj.hound.service.coin.impl;

import com.ghj.hound.common.model.ReturnModel;
import com.ghj.hound.entity.coin.Coin;
import com.ghj.hound.entity.coin.CoinSimple;
import com.ghj.hound.mapper.coin.CoinMapper;
import com.ghj.hound.service.coin.CoinDetaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
}
