package com.lipanre.jvm.stack.cloud.alibaba.provider.controller;

import com.lipanre.jvm.stack.cloud.alibaba.provider.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stock")
public class StockController {

    private final StockService stockService;

    @PostMapping("/desc/{id}")
    public void desc(@PathVariable Long id) {
        stockService.desc(id);
    }

}
