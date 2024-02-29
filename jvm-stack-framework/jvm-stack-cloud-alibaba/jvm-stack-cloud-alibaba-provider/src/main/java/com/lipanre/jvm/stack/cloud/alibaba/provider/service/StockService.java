package com.lipanre.jvm.stack.cloud.alibaba.provider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lipanre.jvm.stack.cloud.alibaba.provider.domain.Stock;

public interface StockService extends IService<Stock> {

    /**
     * 减少指定产品库存
     *
     * @param id 产品id
     */
    void desc(Long id);
}
