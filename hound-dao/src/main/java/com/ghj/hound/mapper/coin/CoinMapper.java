package com.ghj.hound.mapper.coin;

import com.ghj.hound.entity.coin.Coin;

import java.util.List;

public interface CoinMapper {

    public List<Coin> getCoins();

    public void insertCoin();

}
