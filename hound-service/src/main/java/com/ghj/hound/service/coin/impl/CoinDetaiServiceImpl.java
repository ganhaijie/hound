package com.ghj.hound.service.coin.impl;

import com.ghj.hound.common.model.ReturnModel;
import com.ghj.hound.entity.coin.CoinSimple;
import com.ghj.hound.service.coin.CoinDetaiService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoinDetaiServiceImpl implements CoinDetaiService {


    @Override
    public ReturnModel<List<CoinSimple>> getCoinInfo() {
        ReturnModel<List<CoinSimple>> returnModel = new  ReturnModel<List<CoinSimple>>();

        List<CoinSimple> coinSimples = new ArrayList<CoinSimple>();
        CoinSimple c = new CoinSimple();
        c.setPlatform("火币");
        c.setCoinType("btc");
        c.setPrice(100.11);
        c.setRange(19.9);

        coinSimples.add(c);
        returnModel.setObj(coinSimples);

        return returnModel;
    }
}
