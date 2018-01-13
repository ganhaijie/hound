package com.ghj.hound.service.coin;

import com.ghj.hound.common.model.ReturnModel;
import com.ghj.hound.entity.coin.CoinSimple;
import com.ghj.hound.entity.coin.TickerResp;

import java.util.Date;
import java.util.List;

public interface CoinDetaiService {

    public ReturnModel<List<CoinSimple>> getCoinInfo();


    public ReturnModel<String> insert(String currency, Date date,TickerResp tickerResp);

}
