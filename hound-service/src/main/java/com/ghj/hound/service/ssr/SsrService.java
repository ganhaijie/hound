package com.ghj.hound.service.ssr;

import com.ghj.hound.common.model.ReturnModel;
import com.ghj.hound.entity.ssr.SSR;

public interface SsrService {

    public ReturnModel<SSR> getSsr();

    public ReturnModel<String> updateSsr();

}
