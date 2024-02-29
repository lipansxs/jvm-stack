package com.lipanre.jvm.stack.cloud.alibaba.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lipanre.jvm.stack.cloud.alibaba.provider.domain.Stock;
import com.lipanre.jvm.stack.cloud.alibaba.provider.mapper.StockMapper;
import com.lipanre.jvm.stack.cloud.alibaba.provider.service.StockService;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements StockService {
    @Override
    public void desc(Long id) {
        getBaseMapper().descCount(id);
    }
}
