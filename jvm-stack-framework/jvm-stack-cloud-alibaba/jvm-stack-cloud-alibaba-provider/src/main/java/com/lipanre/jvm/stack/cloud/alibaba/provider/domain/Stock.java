package com.lipanre.jvm.stack.cloud.alibaba.provider.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_stock")
public class Stock {

    private Long id;

    private Long productId;

    private Integer count;

    private Integer money;

}
