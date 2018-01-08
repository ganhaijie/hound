package com.ghj.hound.service.coin;

import com.ghj.hound.common.model.ReturnModel;
import com.ghj.hound.entity.coin.CoinSimple;

import java.util.List;

public interface CoinDetaiService {

    public ReturnModel<List<CoinSimple>> getCoinInfo();

}
