package com.lipanre.jvm.stack.cloud.alibaba.consumer.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("t_order")
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Long id;

    private Long productId;

    private Integer count;

}
