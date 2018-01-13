package com.ghj.hound.mapper.coin;

import com.ghj.hound.entity.coin.Coin;

import java.util.Date;
import java.util.List;

public interface CoinMapper {

    public List<Coin> getCoins();

    public void insertCoin(Coin Coin);

/*    public Coin getLast(String currency,Date date);

    public Coin getBefore(String currency, Date date);*/
}
