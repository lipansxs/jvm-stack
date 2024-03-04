package com.lipanre.jvm.stack.spring.security.advice;


import com.lipanre.jvm.stack.spring.security.exception.BizException;
import com.lipanre.jvm.stack.spring.security.http.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author LiPan
 */
@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(BizException.class)
    public Response<String> bizException(BizException bizException) {
        return Response.error(bizException.getMessage());
    }
}
