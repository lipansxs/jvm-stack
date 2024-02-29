package com.lipanre.jvm.stack.cloud.alibaba.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lipanre.jvm.stack.cloud.alibaba.provider.domain.Stock;

public interface StockMapper extends BaseMapper<Stock> {


    void descCount(Long id);
}
