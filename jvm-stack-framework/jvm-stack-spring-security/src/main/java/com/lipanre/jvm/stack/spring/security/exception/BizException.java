package com.lipanre.jvm.stack.spring.security.exception;

import cn.hutool.core.util.StrUtil;

/**
 * @author LiPan
 */
public class BizException extends RuntimeException{

    public BizException(String template, String... param) {
        super(StrUtil.format(template, (Object[]) param));
    }
}
