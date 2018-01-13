package com.ghj.hound.mapper.coin;

import com.ghj.hound.entity.coin.Coin;
import com.sun.tracing.dtrace.ProviderAttributes;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CoinMapper {

    public List<Coin> getCoins();

    public void insertCoin(Coin Coin);

    public  List<Coin> getLast(@Param("currency") String currency, @Param("create_time") Date date);

    public  List<Coin> getBefore(@Param("currency") String currency, @Param("create_time") Date date);
}
