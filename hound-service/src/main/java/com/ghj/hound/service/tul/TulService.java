package com.ghj.hound.service.tul;

import com.ghj.hound.common.model.ReturnModel;
import com.ghj.hound.entity.tul.TuLResponse;

public interface TulService {

    public ReturnModel<TuLResponse> potApi(String info);
}
