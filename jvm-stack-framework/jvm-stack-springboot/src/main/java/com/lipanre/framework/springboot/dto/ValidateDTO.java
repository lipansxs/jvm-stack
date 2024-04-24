package com.lipanre.framework.springboot.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * @author LiPan
 */
@Data
public class ValidateDTO {

    @NotEmpty(message = "data不能为空")
    private String data;

}
